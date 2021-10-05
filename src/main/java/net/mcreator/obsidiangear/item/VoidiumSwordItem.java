
package net.mcreator.obsidiangear.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.obsidiangear.ObsidianGearModElements;

@ObsidianGearModElements.ModElement.Tag
public class VoidiumSwordItem extends ObsidianGearModElements.ModElement {
	@ObjectHolder("obsidian_gear:voidium_sword")
	public static final Item block = null;
	public VoidiumSwordItem(ObsidianGearModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 21;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(VoidiumIngotItem.block));
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("voidium_sword"));
	}
}
