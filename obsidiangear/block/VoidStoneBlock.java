// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.block;

import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.world.IBlockReader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class VoidStoneBlock extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:void_stone")
    public static final Block block;
    
    public VoidStoneBlock(final ObsidianGearModElements instance) {
        super(instance, 12);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(VoidStoneBlock.block, new Item.Properties().func_200916_a(ItemGroup.field_78030_b));
            return (Item)blockItem.setRegistryName(VoidStoneBlock.block.getRegistryName());
        });
    }
    
    static {
        block = null;
    }
    
    public static class CustomBlock extends Block
    {
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(1.3f, 13.0f).func_235838_a_(s -> 0).harvestLevel(1).harvestTool(ToolType.PICKAXE).func_235861_h_().func_226897_b_(1.2f).func_235852_d_((bs, br, bp) -> true).func_235856_e_((bs, br, bp) -> true));
            this.setRegistryName("void_stone");
        }
        
        @OnlyIn(Dist.CLIENT)
        public void func_190948_a(final ItemStack itemstack, final IBlockReader world, final List<ITextComponent> list, final ITooltipFlag flag) {
            super.func_190948_a(itemstack, world, (List)list, flag);
            list.add((ITextComponent)new StringTextComponent("The Void Dimension's most common block!"));
        }
        
        public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
            return 15;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
        }
    }
}
