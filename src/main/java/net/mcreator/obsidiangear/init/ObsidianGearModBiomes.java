
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.obsidiangear.world.biome.VoidWastesBiome;
import net.mcreator.obsidiangear.world.biome.ToweringPeaksBiome;
import net.mcreator.obsidiangear.world.biome.SpookForestBiome;
import net.mcreator.obsidiangear.world.biome.DesolatePlainsBiome;
import net.mcreator.obsidiangear.ObsidianGearMod;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ObsidianGearModBiomes {
	private static final List<Biome> REGISTRY = new ArrayList<>();
	public static Biome VOID_WASTES = register("void_wastes", VoidWastesBiome.createBiome());
	public static Biome DESOLATE_PLAINS = register("desolate_plains", DesolatePlainsBiome.createBiome());
	public static Biome TOWERING_PEAKS = register("towering_peaks", ToweringPeaksBiome.createBiome());
	public static Biome SPOOK_FOREST = register("spook_forest", SpookForestBiome.createBiome());

	private static Biome register(String registryname, Biome biome) {
		REGISTRY.add(biome.setRegistryName(new ResourceLocation(ObsidianGearMod.MODID, registryname)));
		return biome;
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Biome[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			VoidWastesBiome.init();
			DesolatePlainsBiome.init();
			ToweringPeaksBiome.init();
			SpookForestBiome.init();
		});
	}
}
