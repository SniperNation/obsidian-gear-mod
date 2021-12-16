
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ObsidianGearModTabs {
	public static CreativeModeTab TAB_OBSIDIAN_GEAR;

	public static void load() {
		TAB_OBSIDIAN_GEAR = new CreativeModeTab("tabobsidian_gear") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ObsidianGearModItems.OBSIDIAN_PICKAXE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
