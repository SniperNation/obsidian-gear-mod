
package net.mcreator.obsidiangear.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.obsidiangear.ObsidianGearModElements;

@ObsidianGearModElements.ModElement.Tag
public class KyriteAxeItem extends ObsidianGearModElements.ModElement {
	@ObjectHolder("obsidian_gear:kyrite_axe")
	public static final Item block = null;
	public KyriteAxeItem(ObsidianGearModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3200;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 35;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KyriteItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("kyrite_axe"));
	}
}
