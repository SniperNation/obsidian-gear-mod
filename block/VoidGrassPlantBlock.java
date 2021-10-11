// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.block;

import net.minecraftforge.common.PlantType;
import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;
import net.minecraft.block.FlowerBlock;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.World;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class VoidGrassPlantBlock extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:void_grass_plant")
    public static final Block block;
    private static Feature<BlockClusterFeatureConfig> feature;
    private static ConfiguredFeature<?, ?> configuredFeature;
    
    public VoidGrassPlantBlock(final ObsidianGearModElements instance) {
        super(instance, 90);
        MinecraftForge.EVENT_BUS.register((Object)this);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new FeatureRegisterHandler());
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new BlockCustomFlower());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(VoidGrassPlantBlock.block, new Item.Properties().func_200916_a(ItemGroup.field_78031_c));
            return (Item)blockItem.setRegistryName(VoidGrassPlantBlock.block.getRegistryName());
        });
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public void clientLoad(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(VoidGrassPlantBlock.block, RenderType.func_228643_e_());
    }
    
    @SubscribeEvent
    public void addFeatureToBiomes(final BiomeLoadingEvent event) {
        event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> VoidGrassPlantBlock.configuredFeature);
    }
    
    static {
        block = null;
        VoidGrassPlantBlock.feature = null;
        VoidGrassPlantBlock.configuredFeature = null;
    }
    
    private static class FeatureRegisterHandler
    {
        @SubscribeEvent
        public void registerFeature(final RegistryEvent.Register<Feature<?>> event) {
            VoidGrassPlantBlock.feature = (Feature<BlockClusterFeatureConfig>)new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_) {
                public boolean func_241855_a(final ISeedReader world, final ChunkGenerator generator, final Random random, final BlockPos pos, final BlockClusterFeatureConfig config) {
                    final RegistryKey<World> dimensionType = (RegistryKey<World>)world.func_201672_e().func_234923_W_();
                    boolean dimensionCriteria = false;
                    if (dimensionType == RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation("obsidian_gear:the_void"))) {
                        dimensionCriteria = true;
                    }
                    return dimensionCriteria && super.func_241855_a(world, generator, random, pos, config);
                }
            };
            VoidGrassPlantBlock.configuredFeature = (ConfiguredFeature<?, ?>)VoidGrassPlantBlock.feature.func_225566_b_((IFeatureConfig)new BlockClusterFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(VoidGrassPlantBlock.block.func_176223_P()), (BlockPlacer)new SimpleBlockPlacer()).func_227315_a_(10).func_227322_d_()).func_227228_a_(Placement.field_242900_d.func_227446_a_((IPlacementConfig)new NoiseDependant(-0.8, 0, 4)));
            event.getRegistry().register(VoidGrassPlantBlock.feature.setRegistryName("void_grass_plant"));
            Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("obsidian_gear:void_grass_plant"), (Object)VoidGrassPlantBlock.configuredFeature);
        }
    }
    
    public static class BlockCustomFlower extends FlowerBlock
    {
        public BlockCustomFlower() {
            super(Effects.field_76420_g, 5, AbstractBlock.Properties.func_200945_a(Material.field_151585_k).func_200942_a().func_200947_a(SoundType.field_185850_c).func_200948_a(0.0f, 0.0f).func_235838_a_(s -> 0));
            this.setRegistryName("void_grass_plant");
        }
        
        public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
            return 100;
        }
        
        public int getFireSpreadSpeed(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
            return 60;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
        }
        
        public PlantType getPlantType(final IBlockReader world, final BlockPos pos) {
            return PlantType.PLAINS;
        }
    }
}
