
package net.mcreator.obsidiangear.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.obsidiangear.itemgroup.ObsidianGearItemGroup;
import net.mcreator.obsidiangear.ObsidianGearModElements;

import java.util.List;
import java.util.Collections;

@ObsidianGearModElements.ModElement.Tag
public class DesolatePlanksBlock extends ObsidianGearModElements.ModElement {
	@ObjectHolder("obsidian_gear:desolate_planks")
	public static final Block block = null;
	public DesolatePlanksBlock(ObsidianGearModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ObsidianGearItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.AXE).setRequiresTool());
			setRegistryName("desolate_planks");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
