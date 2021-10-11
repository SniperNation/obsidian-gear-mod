// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.world.biome;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.mcreator.obsidiangear.block.VoidStoneBlock;
import net.mcreator.obsidiangear.block.VoidGrassBlock;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.biome.Biome;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class ToweringPeaksBiome extends ObsidianGearModElements.ModElement
{
    public static Biome biome;
    
    public ToweringPeaksBiome(final ObsidianGearModElements instance) {
        super(instance, 89);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new BiomeRegisterHandler());
    }
    
    @Override
    public void init(final FMLCommonSetupEvent event) {
    }
    
    private static class BiomeRegisterHandler
    {
        @SubscribeEvent
        public void registerBiomes(final RegistryEvent.Register<Biome> event) {
            if (ToweringPeaksBiome.biome == null) {
                final BiomeAmbience effects = new BiomeAmbience.Builder().func_235239_a_(-10092340).func_235246_b_(4159204).func_235248_c_(329011).func_242539_d(-10092340).func_242540_e(10387789).func_242541_f(9470285).func_235238_a_();
                final BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().func_242517_a(SurfaceBuilder.field_215396_G.func_242929_a((ISurfaceBuilderConfig)new SurfaceBuilderConfig(VoidGrassBlock.block.func_176223_P(), VoidStoneBlock.block.func_176223_P(), VoidStoneBlock.block.func_176223_P())));
                biomeGenerationSettings.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_((IFeatureConfig)Features.Configs.field_243977_a).func_227228_a_(Features.Placements.field_244002_m).func_227228_a_(Placement.field_242900_d.func_227446_a_((IPlacementConfig)new NoiseDependant(-0.8, 5, 4))));
                biomeGenerationSettings.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)Feature.field_227247_y_.func_225566_b_((IFeatureConfig)Features.Configs.field_243980_d).func_227228_a_(Features.Placements.field_244000_k).func_227228_a_(Features.Placements.field_244001_l).func_242731_b(4));
                DefaultBiomeFeatures.func_243738_d(biomeGenerationSettings);
                DefaultBiomeFeatures.func_243750_j(biomeGenerationSettings);
                DefaultBiomeFeatures.func_243730_an(biomeGenerationSettings);
                final MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().func_242571_a();
                ToweringPeaksBiome.biome = new Biome.Builder().func_205415_a(Biome.RainType.RAIN).func_205419_a(Biome.Category.EXTREME_HILLS).func_205421_a(1.6f).func_205420_b(0.7f).func_205414_c(0.3f).func_205417_d(0.5f).func_235097_a_(effects).func_242458_a(mobSpawnInfo.func_242577_b()).func_242457_a(biomeGenerationSettings.func_242508_a()).func_242455_a();
                event.getRegistry().register(ToweringPeaksBiome.biome.setRegistryName("obsidian_gear:towering_peaks"));
            }
        }
    }
}
