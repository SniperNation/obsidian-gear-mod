// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.block;

import net.minecraft.state.properties.BlockStateProperties;
import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Rotation;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.mcreator.obsidiangear.itemgroup.ObsidianGearItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class DesolateWoodBlock extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:desolate_wood")
    public static final Block block;
    
    public DesolateWoodBlock(final ObsidianGearModElements instance) {
        super(instance, 62);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(DesolateWoodBlock.block, new Item.Properties().func_200916_a(ObsidianGearItemGroup.tab));
            return (Item)blockItem.setRegistryName(DesolateWoodBlock.block.getRegistryName());
        });
    }
    
    static {
        block = null;
    }
    
    public static class CustomBlock extends Block
    {
        public static final EnumProperty<Direction.Axis> AXIS;
        
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151575_d).func_200947_a(SoundType.field_185848_a).func_200948_a(2.0f, 2.0f).func_235838_a_(s -> 0).harvestLevel(0).harvestTool(ToolType.AXE).func_235861_h_());
            this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)CustomBlock.AXIS, (Comparable)Direction.Axis.Y));
            this.setRegistryName("desolate_wood");
        }
        
        public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
            return 15;
        }
        
        protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
            builder.func_206894_a(new Property[] { (Property)CustomBlock.AXIS });
        }
        
        public BlockState func_185499_a(final BlockState state, final Rotation rot) {
            if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
                if ((Direction.Axis)state.func_177229_b((Property)CustomBlock.AXIS) == Direction.Axis.X) {
                    return (BlockState)state.func_206870_a((Property)CustomBlock.AXIS, (Comparable)Direction.Axis.Z);
                }
                if ((Direction.Axis)state.func_177229_b((Property)CustomBlock.AXIS) == Direction.Axis.Z) {
                    return (BlockState)state.func_206870_a((Property)CustomBlock.AXIS, (Comparable)Direction.Axis.X);
                }
            }
            return state;
        }
        
        public BlockState func_196258_a(final BlockItemUseContext context) {
            final Direction.Axis axis = context.func_196000_l().func_176740_k();
            return (BlockState)this.func_176223_P().func_206870_a((Property)CustomBlock.AXIS, (Comparable)axis);
        }
        
        public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
            return 5;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
        }
        
        static {
            AXIS = BlockStateProperties.field_208148_A;
        }
    }
}
