package net.mcreator.obsidiangear.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.obsidiangear.init.ObsidianGearModEnchantments;

public class ImbuedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(ObsidianGearModEnchantments.POISON_TOUCH, itemstack) == 1) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON,
						(int) (100 * EnchantmentHelper.getItemEnchantmentLevel(ObsidianGearModEnchantments.POISON_TOUCH, itemstack)), 1));
		}
	}
}
