
package net.mcreator.obsidiangear.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.obsidiangear.procedures.CurseOfTheEndProcedureProcedure;
import net.mcreator.obsidiangear.procedures.ClearTeleportationEffectProcedure;

public class CurseOfTheEndEffectMobEffect extends MobEffect {
	public CurseOfTheEndEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		setRegistryName("curse_of_the_end_effect");
	}

	@Override
	public String getDescriptionId() {
		return "effect.obsidian_gear.curse_of_the_end_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		CurseOfTheEndProcedureProcedure.execute(x, y, z, entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		CurseOfTheEndProcedureProcedure.execute(x, y, z, entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ClearTeleportationEffectProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
