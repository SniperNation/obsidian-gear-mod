
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.obsidiangear.client.renderer.VoidCubeRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ObsidianGearModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ObsidianGearModEntities.VOID_CUBE, VoidCubeRenderer::new);
	}
}
