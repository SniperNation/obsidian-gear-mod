
package net.mcreator.obsidiangear.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.obsidiangear.procedures.ReinforcedEventideLvl2LifestealProcedure;

import java.util.List;

public class ReinforcedEventideLvl2Item extends SwordItem {
	public ReinforcedEventideLvl2Item() {
		super(new Tier() {
			public int getUses() {
				return 7810;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 13f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 35;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.BEDROCK));
			}
		}, 3, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant());
		setRegistryName("reinforced_eventide_lvl_2");
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Level world = entity.level;

		ReinforcedEventideLvl2LifestealProcedure.execute(entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Legendary Greatedge (Unique)"));
		list.add(new TextComponent("Materials: Bedrock; Dragonbone"));
		list.add(new TextComponent("Enchantments:"));
		list.add(new TextComponent("Lifesteal III - Lifesteal grants regeneration to the wielder."));
		list.add(new TextComponent("Gem: Level 2"));
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
