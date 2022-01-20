
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.obsidiangear.client.gui.VoidiumChestGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ObsidianGearModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ObsidianGearModMenus.VOIDIUM_CHEST_GUI, VoidiumChestGUIScreen::new);
		});
	}
}
