package net.mcreator.obsidiangear.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collections;

public class CurseOfTheEndProcedureProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo((x + Math.random() * 10), (y + Math.random() * 10), (z + Math.random() * 10));
			if (_ent instanceof ServerPlayer _serverPlayer) {
				_serverPlayer.connection.teleport((x + Math.random() * 10), (y + Math.random() * 10), (z + Math.random() * 10), _ent.getYRot(),
						_ent.getXRot(), Collections.emptySet());
			}
		}
	}
}
