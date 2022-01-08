package net.mcreator.obsidiangear.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class InfoCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Obsidian Gear Mod"), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("(C) 2021 - 2022 Aashay Ghodgaonkar"), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(
					"Adds a buncha new stuff to MC! This includes new biomes, dimensions, blocks, items, weapons, armor, recipes and so much more!"),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Website: https://github.com/SniperNation/obsidian-gear-mod"), (false));
	}
}
