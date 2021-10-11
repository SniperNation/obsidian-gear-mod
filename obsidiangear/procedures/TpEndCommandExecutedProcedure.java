// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.procedures;

import java.util.Iterator;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.mcreator.obsidiangear.ObsidianGearMod;
import java.util.Map;

public class TpEndCommandExecutedProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                ObsidianGearMod.LOGGER.warn("Failed to load dependency entity for procedure TpEndCommandExecuted!");
            }
            return;
        }
        final Entity _ent;
        final Entity entity = _ent = dependencies.get("entity");
        if (!_ent.field_70170_p.field_72995_K && _ent instanceof ServerPlayerEntity) {
            final RegistryKey<World> destinationType = (RegistryKey<World>)World.field_234920_i_;
            final ServerWorld nextWorld = _ent.func_184102_h().func_71218_a((RegistryKey)destinationType);
            if (nextWorld != null) {
                ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0.0f));
                ((ServerPlayerEntity)_ent).func_200619_a(nextWorld, (double)nextWorld.func_241135_u_().func_177958_n(), (double)(nextWorld.func_241135_u_().func_177956_o() + 1), (double)nextWorld.func_241135_u_().func_177952_p(), _ent.field_70177_z, _ent.field_70125_A);
                ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlayerAbilitiesPacket(((ServerPlayerEntity)_ent).field_71075_bZ));
                for (final EffectInstance effectinstance : ((ServerPlayerEntity)_ent).func_70651_bq()) {
                    ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlayEntityEffectPacket(_ent.func_145782_y(), effectinstance));
                }
                ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlaySoundEventPacket(1032, BlockPos.field_177992_a, 0, false));
            }
        }
    }
}
