// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.mcreator.obsidiangear.enchantment.LifestealEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.mcreator.obsidiangear.ObsidianGearMod;
import java.util.Map;

public class LifestealProcedureProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure LifestealProcedure!");
            }
            return;
        }
        if (dependencies.get("itemstack") == null) {
            if (!dependencies.containsKey("itemstack")) {
                ObsidianGearMod.LOGGER.warn("Failed to load dependency itemstack for procedure LifestealProcedure!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        final ItemStack itemstack = dependencies.get("itemstack");
        final ItemStack pickaxe = ItemStack.field_190927_a;
        final double EnchtSize = 0.0;
        final double i = 0.0;
        final double j = 0.0;
        final double k = 0.0;
        if (EnchantmentHelper.func_77506_a(LifestealEnchantment.enchantment, itemstack) == 1) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76428_l, 15, 2));
            }
        }
        else if (EnchantmentHelper.func_77506_a(LifestealEnchantment.enchantment, itemstack) == 2) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76443_y, 10, 3));
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76428_l, 10, 4));
            }
        }
    }
}
