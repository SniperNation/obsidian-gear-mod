
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.obsidiangear.world.features.plants.VoidGrassPlantFeature;
import net.mcreator.obsidiangear.world.features.ores.VoidiumOreFeature;
import net.mcreator.obsidiangear.world.features.ores.VoidGrassFeature;
import net.mcreator.obsidiangear.world.features.ores.KyriteOreFeature;
import net.mcreator.obsidiangear.world.features.ores.EnderiumOreFeature;
import net.mcreator.obsidiangear.world.features.ores.EnderiteOreFeature;
import net.mcreator.obsidiangear.world.features.ores.DesolateLogFeature;
import net.mcreator.obsidiangear.world.features.ores.DesolateLeavesFeature;
import net.mcreator.obsidiangear.world.features.lakes.PoisonWaterFeature;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ObsidianGearModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(VoidGrassFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, VoidGrassFeature.GENERATE_BIOMES,
				VoidGrassFeature.CONFIGURED_FEATURE));
		REGISTRY.put(KyriteOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, KyriteOreFeature.GENERATE_BIOMES,
				KyriteOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(VoidiumOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, VoidiumOreFeature.GENERATE_BIOMES,
				VoidiumOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(DesolateLogFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				DesolateLogFeature.GENERATE_BIOMES, DesolateLogFeature.CONFIGURED_FEATURE));
		REGISTRY.put(DesolateLeavesFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				DesolateLeavesFeature.GENERATE_BIOMES, DesolateLeavesFeature.CONFIGURED_FEATURE));
		REGISTRY.put(VoidGrassPlantFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION,
				VoidGrassPlantFeature.GENERATE_BIOMES, VoidGrassPlantFeature.CONFIGURED_FEATURE));
		REGISTRY.put(PoisonWaterFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.LAKES, PoisonWaterFeature.GENERATE_BIOMES, PoisonWaterFeature.CONFIGURED_FEATURE));
		REGISTRY.put(EnderiumOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				EnderiumOreFeature.GENERATE_BIOMES, EnderiumOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(EnderiteOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				EnderiteOreFeature.GENERATE_BIOMES, EnderiteOreFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
