// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.item;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.mcreator.obsidiangear.world.dimension.TheVoidDimension;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;

public class TheVoidItem extends Item
{
    @ObjectHolder("obsidian_gear:the_void")
    public static final Item block;
    
    public TheVoidItem() {
        super(new Item.Properties().func_200916_a(ItemGroup.field_78040_i).func_200918_c(64));
    }
    
    public ActionResultType func_195939_a(final ItemUseContext context) {
        final PlayerEntity entity = context.func_195999_j();
        final BlockPos pos = context.func_195995_a().func_177972_a(context.func_196000_l());
        final ItemStack itemstack = context.func_195996_i();
        final World world = context.func_195991_k();
        if (!entity.func_175151_a(pos, context.func_196000_l(), itemstack)) {
            return ActionResultType.FAIL;
        }
        final int x = pos.func_177958_n();
        final int y = pos.func_177956_o();
        final int z = pos.func_177952_p();
        boolean success = false;
        if (world.func_175623_d(pos)) {
            TheVoidDimension.portal.portalSpawn(world, pos);
            itemstack.func_222118_a(1, (LivingEntity)entity, c -> c.func_213334_d(context.func_221531_n()));
            success = true;
        }
        return success ? ActionResultType.SUCCESS : ActionResultType.FAIL;
    }
    
    static {
        block = null;
    }
}
