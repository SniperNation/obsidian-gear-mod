// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.block;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.LakesFeature;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.IBlockDisplayReader;
import java.util.function.BiFunction;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.fluid.FluidState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.IParticleData;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.BucketItem;
import java.util.Map;
import net.mcreator.obsidiangear.procedures.PoisonWaterEntityTouchProcedure;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.fluid.Fluid;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.FlowingFluidBlock;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class PoisonWaterBlock extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:poison_water")
    public static final FlowingFluidBlock block;
    @ObjectHolder("obsidian_gear:poison_water_bucket")
    public static final Item bucket;
    public static FlowingFluid flowing;
    public static FlowingFluid still;
    private ForgeFlowingFluid.Properties fluidproperties;
    private static Feature<BlockStateFeatureConfig> feature;
    private static ConfiguredFeature<?, ?> configuredFeature;
    
    public PoisonWaterBlock(final ObsidianGearModElements instance) {
        super(instance, 91);
        this.fluidproperties = null;
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new FluidRegisterHandler());
        MinecraftForge.EVENT_BUS.register((Object)this);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new FeatureRegisterHandler());
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public void clientLoad(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer((Fluid)PoisonWaterBlock.still, RenderType.func_228645_f_());
        RenderTypeLookup.setRenderLayer((Fluid)PoisonWaterBlock.flowing, RenderType.func_228645_f_());
    }
    
    @Override
    public void initElements() {
        this.fluidproperties = new ForgeFlowingFluid.Properties(() -> PoisonWaterBlock.still, () -> PoisonWaterBlock.flowing, CustomFluidAttributes.builder(new ResourceLocation("obsidian_gear:blocks/minecraft-water-animated-gif-3"), new ResourceLocation("obsidian_gear:blocks/minecraft-water-animated-gif-3")).luminosity(0).density(1000).viscosity(1000).temperature(300).rarity(Rarity.UNCOMMON).color(-13083194)).explosionResistance(100.0f).canMultiply().tickRate(5).levelDecreasePerBlock(1).slopeFindDistance(4).bucket(() -> PoisonWaterBlock.bucket).block(() -> PoisonWaterBlock.block);
        PoisonWaterBlock.still = (FlowingFluid)new CustomFlowingFluid.Source(this.fluidproperties).setRegistryName("poison_water");
        PoisonWaterBlock.flowing = (FlowingFluid)new CustomFlowingFluid.Flowing(this.fluidproperties).setRegistryName("poison_water_flowing");
        this.elements.blocks.add(() -> (Block)new FlowingFluidBlock(PoisonWaterBlock.still, AbstractBlock.Properties.func_200945_a(Material.field_151586_h).func_200943_b(100.0f).func_235838_a_(s -> 0)) {
            public boolean func_200123_i(final BlockState state, final IBlockReader reader, final BlockPos pos) {
                return true;
            }
            
            public void func_196262_a(final BlockState blockstate, final World world, final BlockPos pos, final Entity entity) {
                super.func_196262_a(blockstate, world, pos, entity);
                final int x = pos.func_177958_n();
                final int y = pos.func_177956_o();
                final int z = pos.func_177952_p();
                final Map $_dependencies = new HashMap();
                $_dependencies.put("entity", entity);
                PoisonWaterEntityTouchProcedure.executeProcedure($_dependencies);
            }
        }.setRegistryName("poison_water"));
        final BucketItem bucketItem;
        this.elements.items.add(() -> {
            new BucketItem((Fluid)PoisonWaterBlock.still, new Item.Properties().func_200919_a(Items.field_151133_ar).func_200917_a(1).func_200916_a(ItemGroup.field_78026_f).func_208103_a(Rarity.UNCOMMON));
            return (Item)bucketItem.setRegistryName("poison_water_bucket");
        });
    }
    
    @SubscribeEvent
    public void addFeatureToBiomes(final BiomeLoadingEvent event) {
        event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS).add(() -> PoisonWaterBlock.configuredFeature);
    }
    
    static {
        block = null;
        bucket = null;
        PoisonWaterBlock.flowing = null;
        PoisonWaterBlock.still = null;
        PoisonWaterBlock.feature = null;
        PoisonWaterBlock.configuredFeature = null;
    }
    
    private static class FluidRegisterHandler
    {
        @SubscribeEvent
        public void registerFluids(final RegistryEvent.Register<Fluid> event) {
            event.getRegistry().register((IForgeRegistryEntry)PoisonWaterBlock.still);
            event.getRegistry().register((IForgeRegistryEntry)PoisonWaterBlock.flowing);
        }
    }
    
    public abstract static class CustomFlowingFluid extends ForgeFlowingFluid
    {
        public CustomFlowingFluid(final ForgeFlowingFluid.Properties properties) {
            super(properties);
        }
        
        @OnlyIn(Dist.CLIENT)
        public IParticleData func_204521_c() {
            return (IParticleData)ParticleTypes.field_218425_n;
        }
        
        public static class Source extends CustomFlowingFluid
        {
            public Source(final ForgeFlowingFluid.Properties properties) {
                super(properties);
            }
            
            public int func_207192_d(final FluidState state) {
                return 8;
            }
            
            public boolean func_207193_c(final FluidState state) {
                return true;
            }
        }
        
        public static class Flowing extends CustomFlowingFluid
        {
            public Flowing(final ForgeFlowingFluid.Properties properties) {
                super(properties);
            }
            
            protected void func_207184_a(final StateContainer.Builder<Fluid, FluidState> builder) {
                super.func_207184_a((StateContainer.Builder)builder);
                builder.func_206894_a(new Property[] { (Property)Flowing.field_207210_b });
            }
            
            public int func_207192_d(final FluidState state) {
                return (int)state.func_177229_b((Property)Flowing.field_207210_b);
            }
            
            public boolean func_207193_c(final FluidState state) {
                return false;
            }
        }
    }
    
    public static class CustomFluidAttributes extends FluidAttributes
    {
        protected CustomFluidAttributes(final FluidAttributes.Builder builder, final Fluid fluid) {
            super(builder, fluid);
        }
        
        public static CustomBuilder builder(final ResourceLocation stillTexture, final ResourceLocation flowingTexture) {
            return new CustomBuilder(stillTexture, flowingTexture, (BiFunction<FluidAttributes.Builder, Fluid, FluidAttributes>)CustomFluidAttributes::new);
        }
        
        public int getColor(final IBlockDisplayReader world, final BlockPos pos) {
            return BiomeColors.func_228363_c_(world, pos) | 0xFF000000;
        }
        
        public static class CustomBuilder extends FluidAttributes.Builder
        {
            protected CustomBuilder(final ResourceLocation stillTexture, final ResourceLocation flowingTexture, final BiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> factory) {
                super(stillTexture, flowingTexture, (BiFunction)factory);
            }
        }
    }
    
    private static class FeatureRegisterHandler
    {
        @SubscribeEvent
        public void registerFeature(final RegistryEvent.Register<Feature<?>> event) {
            PoisonWaterBlock.feature = (Feature<BlockStateFeatureConfig>)new LakesFeature(BlockStateFeatureConfig.field_236455_a_) {
                public boolean func_241855_a(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final BlockStateFeatureConfig config) {
                    final RegistryKey<World> dimensionType = (RegistryKey<World>)world.func_201672_e().func_234923_W_();
                    boolean dimensionCriteria = false;
                    if (dimensionType == RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation("obsidian_gear:the_void"))) {
                        dimensionCriteria = true;
                    }
                    return dimensionCriteria && super.func_241855_a(world, generator, rand, pos, config);
                }
            };
            PoisonWaterBlock.configuredFeature = (ConfiguredFeature<?, ?>)PoisonWaterBlock.feature.func_225566_b_((IFeatureConfig)new BlockStateFeatureConfig(PoisonWaterBlock.block.func_176223_P())).func_227228_a_(Placement.field_215006_E.func_227446_a_((IPlacementConfig)new ChanceConfig(5)));
            event.getRegistry().register(PoisonWaterBlock.feature.setRegistryName("poison_water_lakes"));
            Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("obsidian_gear:poison_water_lakes"), (Object)PoisonWaterBlock.configuredFeature);
        }
    }
}
