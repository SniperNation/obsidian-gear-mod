package net.mcreator.obsidiangear.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.obsidiangear.init.ObsidianGearModMobEffects;

public class ClearTeleportationEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ObsidianGearModMobEffects.CURSE_OF_THE_END_EFFECT);
	}
}
