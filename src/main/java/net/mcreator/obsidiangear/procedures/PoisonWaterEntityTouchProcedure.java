package net.mcreator.obsidiangear.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.obsidiangear.ObsidianGearMod;

import java.util.Map;

public class PoisonWaterEntityTouchProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonWaterEntityTouch!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 2));
	}
}
