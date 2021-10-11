// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.mcreator.obsidiangear.ObsidianGearMod;
import java.util.Map;

public class PoisonWaterEntityTouchProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonWaterEntityTouch!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76436_u, 60, 2));
        }
    }
}
