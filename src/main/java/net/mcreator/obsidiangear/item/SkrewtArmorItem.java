
package net.mcreator.obsidiangear.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.obsidiangear.init.ObsidianGearModItems;

public abstract class SkrewtArmorItem extends ArmorItem {
	public SkrewtArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 75;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{10, 30, 25, 10}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 25;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(ObsidianGearModItems.SKREWT));
			}

			@Override
			public String getName() {
				return "skrewt_armor";
			}

			@Override
			public float getToughness() {
				return 3.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.3f;
			}
		}, slot, properties);
	}

	public static class Helmet extends SkrewtArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("skrewt_armor_helmet");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "obsidian_gear:textures/models/armor/skrewt_layer_1.png";
		}
	}

	public static class Chestplate extends SkrewtArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("skrewt_armor_chestplate");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "obsidian_gear:textures/models/armor/skrewt_layer_1.png";
		}
	}

	public static class Leggings extends SkrewtArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("skrewt_armor_leggings");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "obsidian_gear:textures/models/armor/skrewt_layer_2.png";
		}
	}

	public static class Boots extends SkrewtArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("skrewt_armor_boots");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "obsidian_gear:textures/models/armor/skrewt_layer_1.png";
		}
	}
}
