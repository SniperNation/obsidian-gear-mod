package net.mcreator.obsidiangear.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

import net.mcreator.obsidiangear.entity.VoidCubeEntity;

public class VoidCubeRenderer extends MobRenderer<VoidCubeEntity, SlimeModel<VoidCubeEntity>> {
	public VoidCubeRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VoidCubeEntity entity) {
		return new ResourceLocation("obsidian_gear:textures/voidcube.png");
	}
}
