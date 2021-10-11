// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.command;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.world.server.ServerWorld;
import net.mcreator.obsidiangear.procedures.TpVoidCommandExecutedProcedure;
import java.util.Arrays;
import java.util.HashMap;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.context.CommandContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.mojang.brigadier.arguments.ArgumentType;
import net.minecraft.command.Commands;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TpVoidCommand
{
    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        event.getDispatcher().register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal("tpvoid").requires(s -> s.func_197034_c(4))).then(Commands.func_197056_a("arguments", (ArgumentType)StringArgumentType.greedyString()).executes(TpVoidCommand::execute))).executes(TpVoidCommand::execute));
    }
    
    private static int execute(final CommandContext<CommandSource> ctx) {
        final ServerWorld world = ((CommandSource)ctx.getSource()).func_197023_e();
        final double x = ((CommandSource)ctx.getSource()).func_197036_d().func_82615_a();
        final double y = ((CommandSource)ctx.getSource()).func_197036_d().func_82617_b();
        final double z = ((CommandSource)ctx.getSource()).func_197036_d().func_82616_c();
        Entity entity = ((CommandSource)ctx.getSource()).func_197022_f();
        if (entity == null) {
            entity = (Entity)FakePlayerFactory.getMinecraft(world);
        }
        final HashMap<String, String> cmdparams = new HashMap<String, String>();
        final int[] index = { -1 };
        final Object o;
        final HashMap<String, String> hashMap;
        final int n;
        Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
            if (o[0] >= 0) {
                hashMap.put(Integer.toString(o[0]), param);
            }
            ++o[n];
            return;
        });
        final Map<String, Object> $_dependencies = new HashMap<String, Object>();
        $_dependencies.put("entity", entity);
        TpVoidCommandExecutedProcedure.executeProcedure($_dependencies);
        return 0;
    }
}
