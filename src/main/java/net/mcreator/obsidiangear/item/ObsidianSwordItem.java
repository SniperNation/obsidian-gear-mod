
package net.mcreator.obsidiangear.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;

import net.mcreator.obsidiangear.procedures.LifestealProcedureProcedure;
import net.mcreator.obsidiangear.ObsidianGearModElements;

import java.util.Map;
import java.util.HashMap;

@ObsidianGearModElements.ModElement.Tag
public class ObsidianSwordItem extends ObsidianGearModElements.ModElement {
	@ObjectHolder("obsidian_gear:obsidian_sword")
	public static final Item block = null;
	public ObsidianSwordItem(ObsidianGearModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.OBSIDIAN));
			}
		}, 3, -2.5f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					LifestealProcedureProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("obsidian_sword"));
	}
}
