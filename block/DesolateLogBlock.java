// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.block;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.World;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.state.properties.BlockStateProperties;
import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Rotation;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.mcreator.obsidiangear.itemgroup.ObsidianGearItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class DesolateLogBlock extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:desolate_log")
    public static final Block block;
    private static Feature<OreFeatureConfig> feature;
    private static ConfiguredFeature<?, ?> configuredFeature;
    private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH;
    
    public DesolateLogBlock(final ObsidianGearModElements instance) {
        super(instance, 63);
        MinecraftForge.EVENT_BUS.register((Object)this);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new FeatureRegisterHandler());
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(DesolateLogBlock.block, new Item.Properties().func_200916_a(ObsidianGearItemGroup.tab));
            return (Item)blockItem.setRegistryName(DesolateLogBlock.block.getRegistryName());
        });
    }
    
    @SubscribeEvent
    public void addFeatureToBiomes(final BiomeLoadingEvent event) {
        boolean biomeCriteria = false;
        if (new ResourceLocation("obsidian_gear:desolate_plains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (!biomeCriteria) {
            return;
        }
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> DesolateLogBlock.configuredFeature);
    }
    
    static {
        block = null;
        DesolateLogBlock.feature = null;
        DesolateLogBlock.configuredFeature = null;
        DesolateLogBlock.CUSTOM_MATCH = null;
    }
    
    public static class CustomBlock extends Block
    {
        public static final EnumProperty<Direction.Axis> AXIS;
        
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151575_d).func_200947_a(SoundType.field_185848_a).func_200948_a(2.0f, 2.0f).func_235838_a_(s -> 0).harvestLevel(0).harvestTool(ToolType.AXE).func_235861_h_());
            this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)CustomBlock.AXIS, (Comparable)Direction.Axis.Y));
            this.setRegistryName("desolate_log");
        }
        
        public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
            return 15;
        }
        
        protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
            builder.func_206894_a(new Property[] { (Property)CustomBlock.AXIS });
        }
        
        public BlockState func_185499_a(final BlockState state, final Rotation rot) {
            if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
                if ((Direction.Axis)state.func_177229_b((Property)CustomBlock.AXIS) == Direction.Axis.X) {
                    return (BlockState)state.func_206870_a((Property)CustomBlock.AXIS, (Comparable)Direction.Axis.Z);
                }
                if ((Direction.Axis)state.func_177229_b((Property)CustomBlock.AXIS) == Direction.Axis.Z) {
                    return (BlockState)state.func_206870_a((Property)CustomBlock.AXIS, (Comparable)Direction.Axis.X);
                }
            }
            return state;
        }
        
        public BlockState func_196258_a(final BlockItemUseContext context) {
            final Direction.Axis axis = context.func_196000_l().func_176740_k();
            return (BlockState)this.func_176223_P().func_206870_a((Property)CustomBlock.AXIS, (Comparable)axis);
        }
        
        public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
            return 5;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
        }
        
        static {
            AXIS = BlockStateProperties.field_208148_A;
        }
    }
    
    private static class CustomRuleTest extends RuleTest
    {
        static final CustomRuleTest INSTANCE;
        static final Codec<CustomRuleTest> codec;
        
        public boolean func_215181_a(final BlockState blockAt, final Random random) {
            final boolean blockCriteria = false;
            return blockCriteria;
        }
        
        protected IRuleTestType<?> func_215180_a() {
            return DesolateLogBlock.CUSTOM_MATCH;
        }
        
        static {
            INSTANCE = new CustomRuleTest();
            codec = Codec.unit(() -> CustomRuleTest.INSTANCE);
        }
    }
    
    private static class FeatureRegisterHandler
    {
        @SubscribeEvent
        public void registerFeature(final RegistryEvent.Register<Feature<?>> event) {
            DesolateLogBlock.CUSTOM_MATCH = (IRuleTestType<CustomRuleTest>)Registry.func_218322_a(Registry.field_218363_D, new ResourceLocation("obsidian_gear:desolate_log_match"), (Object)(() -> CustomRuleTest.codec));
            DesolateLogBlock.feature = (Feature<OreFeatureConfig>)new OreFeature(OreFeatureConfig.field_236566_a_) {
                public boolean func_241855_a(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final OreFeatureConfig config) {
                    final RegistryKey<World> dimensionType = (RegistryKey<World>)world.func_201672_e().func_234923_W_();
                    boolean dimensionCriteria = false;
                    if (dimensionType == RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation("obsidian_gear:the_void"))) {
                        dimensionCriteria = true;
                    }
                    return dimensionCriteria && super.func_241855_a(world, generator, rand, pos, config);
                }
            };
            DesolateLogBlock.configuredFeature = (ConfiguredFeature<?, ?>)((ConfiguredFeature)((ConfiguredFeature)DesolateLogBlock.feature.func_225566_b_((IFeatureConfig)new OreFeatureConfig((RuleTest)CustomRuleTest.INSTANCE, DesolateLogBlock.block.func_176223_P(), 16)).func_242733_d(64)).func_242728_a()).func_242731_b(10);
            event.getRegistry().register(DesolateLogBlock.feature.setRegistryName("desolate_log"));
            Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("obsidian_gear:desolate_log"), (Object)DesolateLogBlock.configuredFeature);
        }
    }
}
