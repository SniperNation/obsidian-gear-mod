
package net.mcreator.obsidiangear.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.obsidiangear.world.inventory.AeonForgeGUIMenu;
import net.mcreator.obsidiangear.network.AeonForgeGUIButtonMessage;
import net.mcreator.obsidiangear.ObsidianGearMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AeonForgeGUIScreen extends AbstractContainerScreen<AeonForgeGUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AeonForgeGUIScreen(AeonForgeGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 186;
	}

	private static final ResourceLocation texture = new ResourceLocation("obsidian_gear:textures/aeon_forge_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("obsidian_gear:textures/aeon_forge_gui_arrow.png"));
		this.blit(ms, this.leftPos + 106, this.topPos + 37, 0, 0, 32, 32, 32, 32);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		drawString(poseStack, this.font, "Aeon Forge", 108, 8, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 106, this.topPos + 79, 50, 20, new TextComponent("Craft"), e -> {
			if (true) {
				ObsidianGearMod.PACKET_HANDLER.sendToServer(new AeonForgeGUIButtonMessage(0, x, y, z));
				AeonForgeGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
