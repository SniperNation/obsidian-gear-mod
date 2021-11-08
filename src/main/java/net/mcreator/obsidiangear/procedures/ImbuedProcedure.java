package net.mcreator.obsidiangear.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.obsidiangear.enchantment.PoisonTouchEnchantment;
import net.mcreator.obsidiangear.ObsidianGearMod;

import java.util.Map;

public class ImbuedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure Imbued!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ObsidianGearMod.LOGGER.warn("Failed to load dependency itemstack for procedure Imbued!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((EnchantmentHelper.getEnchantmentLevel(PoisonTouchEnchantment.enchantment, (itemstack))) == 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON,
						(int) (100 * (EnchantmentHelper.getEnchantmentLevel(PoisonTouchEnchantment.enchantment, (itemstack)))), (int) 1));
		}
	}
}
