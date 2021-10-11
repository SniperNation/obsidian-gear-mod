// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.mcreator.obsidiangear.enchantment.PoisonTouchEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.mcreator.obsidiangear.ObsidianGearMod;
import java.util.Map;

public class ImbuedProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure Imbued!");
            }
            return;
        }
        if (dependencies.get("itemstack") == null) {
            if (!dependencies.containsKey("itemstack")) {
                ObsidianGearMod.LOGGER.warn("Failed to load dependency itemstack for procedure Imbued!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        final ItemStack itemstack = dependencies.get("itemstack");
        if (EnchantmentHelper.func_77506_a(PoisonTouchEnchantment.enchantment, itemstack) == 1 && entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76436_u, 100 * EnchantmentHelper.func_77506_a(PoisonTouchEnchantment.enchantment, itemstack), 1));
        }
    }
}
