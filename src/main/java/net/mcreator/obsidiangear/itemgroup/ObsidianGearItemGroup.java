
package net.mcreator.obsidiangear.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.obsidiangear.item.ObsidianPickaxeItem;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@ObsidianGearModElements.ModElement.Tag
public class ObsidianGearItemGroup extends ObsidianGearModElements.ModElement {
	public ObsidianGearItemGroup(ObsidianGearModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabobsidian_gear") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ObsidianPickaxeItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
