package net.mcreator.obsidiangear.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.obsidiangear.potion.CurseOfTheEndEffectPotionEffect;
import net.mcreator.obsidiangear.ObsidianGearMod;

import java.util.Map;

public class ClearTeleportationEffectProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure ClearTeleportationEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(CurseOfTheEndEffectPotionEffect.potion);
		}
	}
}
