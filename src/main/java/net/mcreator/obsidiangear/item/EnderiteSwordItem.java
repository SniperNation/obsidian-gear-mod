
package net.mcreator.obsidiangear.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.obsidiangear.init.ObsidianGearModItems;

public class EnderiteSwordItem extends SwordItem {
	public EnderiteSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2380;
			}

			public float getSpeed() {
				return 16f;
			}

			public float getAttackDamageBonus() {
				return 18f;
			}

			public int getLevel() {
				return 10;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(ObsidianGearModItems.ENDERITE_INGOT));
			}
		}, 3, -2.7f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
		setRegistryName("enderite_sword");
	}
}
