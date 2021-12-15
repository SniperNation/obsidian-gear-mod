package net.mcreator.obsidiangear.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.obsidiangear.ObsidianGearMod;

import java.util.Map;
import java.util.Collections;

public class CurseOfTheEndProcedureProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure CurseOfTheEndProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency x for procedure CurseOfTheEndProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency y for procedure CurseOfTheEndProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency z for procedure CurseOfTheEndProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((x + (Math.random() * 10)), (y + (Math.random() * 10)), (z + (Math.random() * 10)));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + (Math.random() * 10)), (y + (Math.random() * 10)),
						(z + (Math.random() * 10)), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
