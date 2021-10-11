// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.world.biome;

import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.AbstractFeatureSizeType;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.mcreator.obsidiangear.block.DesolateLeavesBlock;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.mcreator.obsidiangear.block.DesolateLogBlock;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.mcreator.obsidiangear.block.VoidStoneBlock;
import net.mcreator.obsidiangear.block.VoidGrassBlock;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.biome.Biome;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class DesolatePlainsBiome extends ObsidianGearModElements.ModElement
{
    public static Biome biome;
    
    public DesolatePlainsBiome(final ObsidianGearModElements instance) {
        super(instance, 18);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new BiomeRegisterHandler());
    }
    
    @Override
    public void init(final FMLCommonSetupEvent event) {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(RegistryKey.func_240903_a_(Registry.field_239720_u_, WorldGenRegistries.field_243657_i.func_177774_c((Object)DesolatePlainsBiome.biome)), 10));
    }
    
    private static class BiomeRegisterHandler
    {
        @SubscribeEvent
        public void registerBiomes(final RegistryEvent.Register<Biome> event) {
            if (DesolatePlainsBiome.biome == null) {
                final BiomeAmbience effects = new BiomeAmbience.Builder().func_235239_a_(-13434829).func_235246_b_(4159204).func_235248_c_(329011).func_242539_d(-13434829).func_242540_e(10387789).func_242541_f(9470285).func_235244_a_(new ParticleEffectAmbience((IParticleData)ParticleTypes.field_197599_J, 0.005f)).func_235238_a_();
                final BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().func_242517_a(SurfaceBuilder.field_215396_G.func_242929_a((ISurfaceBuilderConfig)new SurfaceBuilderConfig(VoidGrassBlock.block.func_176223_P(), VoidStoneBlock.block.func_176223_P(), VoidStoneBlock.block.func_176223_P())));
                biomeGenerationSettings.func_242516_a(StructureFeatures.field_244145_k);
                biomeGenerationSettings.func_242516_a(StructureFeatures.field_244136_b);
                biomeGenerationSettings.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.func_225566_b_((IFeatureConfig)new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(DesolateLogBlock.block.func_176223_P()), (BlockStateProvider)new SimpleBlockStateProvider(DesolateLeavesBlock.block.func_176223_P()), (FoliagePlacer)new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), (AbstractTrunkPlacer)new StraightTrunkPlacer(7, 2, 0), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236703_a_((List)ImmutableList.of((Object)CustomLeaveVineTreeDecorator.instance, (Object)CustomTrunkVineTreeDecorator.instance)).func_236701_a_(0).func_225568_b_()).func_227228_a_(Features.Placements.field_244001_l).func_227228_a_(Placement.field_242902_f.func_227446_a_((IPlacementConfig)new AtSurfaceWithExtraConfig(2, 0.1f, 1))));
                biomeGenerationSettings.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_((IFeatureConfig)Features.Configs.field_243977_a).func_227228_a_(Features.Placements.field_244002_m).func_227228_a_(Placement.field_242900_d.func_227446_a_((IPlacementConfig)new NoiseDependant(-0.8, 5, 4))));
                biomeGenerationSettings.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)Feature.field_227247_y_.func_225566_b_((IFeatureConfig)Features.Configs.field_243980_d).func_227228_a_(Features.Placements.field_244000_k).func_227228_a_(Features.Placements.field_244001_l).func_242731_b(4));
                DefaultBiomeFeatures.func_243738_d(biomeGenerationSettings);
                DefaultBiomeFeatures.func_243750_j(biomeGenerationSettings);
                DefaultBiomeFeatures.func_243730_an(biomeGenerationSettings);
                final MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().func_242571_a();
                DesolatePlainsBiome.biome = new Biome.Builder().func_205415_a(Biome.RainType.RAIN).func_205419_a(Biome.Category.NONE).func_205421_a(0.0f).func_205420_b(0.1f).func_205414_c(0.5f).func_205417_d(0.5f).func_235097_a_(effects).func_242458_a(mobSpawnInfo.func_242577_b()).func_242457_a(biomeGenerationSettings.func_242508_a()).func_242455_a();
                event.getRegistry().register(DesolatePlainsBiome.biome.setRegistryName("obsidian_gear:desolate_plains"));
            }
        }
    }
    
    private static class CustomLeaveVineTreeDecorator extends LeaveVineTreeDecorator
    {
        public static final CustomLeaveVineTreeDecorator instance;
        public static Codec<LeaveVineTreeDecorator> codec;
        public static TreeDecoratorType tdt;
        
        protected TreeDecoratorType<?> func_230380_a_() {
            return (TreeDecoratorType<?>)CustomLeaveVineTreeDecorator.tdt;
        }
        
        protected void func_227424_a_(final IWorldWriter ww, final BlockPos bp, final BooleanProperty bpr, final Set<BlockPos> sbc, final MutableBoundingBox mbb) {
            this.func_227423_a_(ww, bp, Blocks.field_150395_bd.func_176223_P(), (Set)sbc, mbb);
        }
        
        static {
            instance = new CustomLeaveVineTreeDecorator();
            CustomLeaveVineTreeDecorator.codec = (Codec<LeaveVineTreeDecorator>)Codec.unit(() -> CustomLeaveVineTreeDecorator.instance);
            (CustomLeaveVineTreeDecorator.tdt = new TreeDecoratorType((Codec)CustomLeaveVineTreeDecorator.codec)).setRegistryName("desolate_plains_lvtd");
            ForgeRegistries.TREE_DECORATOR_TYPES.register((IForgeRegistryEntry)CustomLeaveVineTreeDecorator.tdt);
        }
    }
    
    private static class CustomTrunkVineTreeDecorator extends TrunkVineTreeDecorator
    {
        public static final CustomTrunkVineTreeDecorator instance;
        public static Codec<CustomTrunkVineTreeDecorator> codec;
        public static TreeDecoratorType tdt;
        
        protected TreeDecoratorType<?> func_230380_a_() {
            return (TreeDecoratorType<?>)CustomTrunkVineTreeDecorator.tdt;
        }
        
        protected void func_227424_a_(final IWorldWriter ww, final BlockPos bp, final BooleanProperty bpr, final Set<BlockPos> sbc, final MutableBoundingBox mbb) {
            this.func_227423_a_(ww, bp, Blocks.field_150395_bd.func_176223_P(), (Set)sbc, mbb);
        }
        
        static {
            instance = new CustomTrunkVineTreeDecorator();
            CustomTrunkVineTreeDecorator.codec = (Codec<CustomTrunkVineTreeDecorator>)Codec.unit(() -> CustomTrunkVineTreeDecorator.instance);
            (CustomTrunkVineTreeDecorator.tdt = new TreeDecoratorType((Codec)CustomTrunkVineTreeDecorator.codec)).setRegistryName("desolate_plains_tvtd");
            ForgeRegistries.TREE_DECORATOR_TYPES.register((IForgeRegistryEntry)CustomTrunkVineTreeDecorator.tdt);
        }
    }
}
