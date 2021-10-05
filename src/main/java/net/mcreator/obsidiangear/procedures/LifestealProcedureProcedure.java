package net.mcreator.obsidiangear.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.obsidiangear.enchantment.LifestealEnchantment;
import net.mcreator.obsidiangear.ObsidianGearMod;

import java.util.Map;

public class LifestealProcedureProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure LifestealProcedure!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency itemstack for procedure LifestealProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		ItemStack pickaxe = ItemStack.EMPTY;
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		if (((EnchantmentHelper.getEnchantmentLevel(LifestealEnchantment.enchantment, (itemstack))) == 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 15, (int) 2));
		} else if (((EnchantmentHelper.getEnchantmentLevel(LifestealEnchantment.enchantment, (itemstack))) == 2)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 10, (int) 3));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 4));
		}
	}
}
