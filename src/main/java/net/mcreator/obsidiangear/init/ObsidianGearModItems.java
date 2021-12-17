
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.obsidiangear.item.VoidiumSwordItem;
import net.mcreator.obsidiangear.item.VoidiumShovelItem;
import net.mcreator.obsidiangear.item.VoidiumPickaxeItem;
import net.mcreator.obsidiangear.item.VoidiumIngotItem;
import net.mcreator.obsidiangear.item.VoidiumHoeItem;
import net.mcreator.obsidiangear.item.VoidiumAxeItem;
import net.mcreator.obsidiangear.item.VoidiumArmorItem;
import net.mcreator.obsidiangear.item.TheVoidItem;
import net.mcreator.obsidiangear.item.PoisonWaterItem;
import net.mcreator.obsidiangear.item.ObsidianSwordItem;
import net.mcreator.obsidiangear.item.ObsidianPickaxeItem;
import net.mcreator.obsidiangear.item.ObsidianItem;
import net.mcreator.obsidiangear.item.KyriteSwordItem;
import net.mcreator.obsidiangear.item.KyriteShovelItem;
import net.mcreator.obsidiangear.item.KyritePickaxeItem;
import net.mcreator.obsidiangear.item.KyriteItem;
import net.mcreator.obsidiangear.item.KyriteHoeItem;
import net.mcreator.obsidiangear.item.KyriteAxeItem;
import net.mcreator.obsidiangear.item.KyriteArmorItem;
import net.mcreator.obsidiangear.item.EnderiumSwordItem;
import net.mcreator.obsidiangear.item.EnderiumShovelItem;
import net.mcreator.obsidiangear.item.EnderiumPickaxeItem;
import net.mcreator.obsidiangear.item.EnderiumIngotItem;
import net.mcreator.obsidiangear.item.EnderiumHoeItem;
import net.mcreator.obsidiangear.item.EnderiumAxeItem;
import net.mcreator.obsidiangear.item.EnderiumArmorItem;
import net.mcreator.obsidiangear.item.EnderiteSwordItem;
import net.mcreator.obsidiangear.item.EnderiteShovelItem;
import net.mcreator.obsidiangear.item.EnderiteScrapItem;
import net.mcreator.obsidiangear.item.EnderitePickaxeItem;
import net.mcreator.obsidiangear.item.EnderiteIngotItem;
import net.mcreator.obsidiangear.item.EnderiteHoeItem;
import net.mcreator.obsidiangear.item.EnderiteAxeItem;
import net.mcreator.obsidiangear.item.EnderiteArmorItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ObsidianGearModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item OBSIDIAN_PICKAXE = register(new ObsidianPickaxeItem());
	public static final Item OBSIDIAN_SWORD = register(new ObsidianSwordItem());
	public static final Item OBSIDIAN_HELMET = register(new ObsidianItem.Helmet());
	public static final Item OBSIDIAN_CHESTPLATE = register(new ObsidianItem.Chestplate());
	public static final Item OBSIDIAN_LEGGINGS = register(new ObsidianItem.Leggings());
	public static final Item OBSIDIAN_BOOTS = register(new ObsidianItem.Boots());
	public static final Item VOID_STONE = register(ObsidianGearModBlocks.VOID_STONE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item VOID_PORTAL_FRAME = register(ObsidianGearModBlocks.VOID_PORTAL_FRAME, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item THE_VOID = register(new TheVoidItem());
	public static final Item VOID_GRASS = register(ObsidianGearModBlocks.VOID_GRASS, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item KYRITE = register(new KyriteItem());
	public static final Item KYRITE_ORE = register(ObsidianGearModBlocks.KYRITE_ORE, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item KYRITE_BLOCK = register(ObsidianGearModBlocks.KYRITE_BLOCK, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item KYRITE_PICKAXE = register(new KyritePickaxeItem());
	public static final Item KYRITE_AXE = register(new KyriteAxeItem());
	public static final Item KYRITE_SWORD = register(new KyriteSwordItem());
	public static final Item KYRITE_SHOVEL = register(new KyriteShovelItem());
	public static final Item KYRITE_HOE = register(new KyriteHoeItem());
	public static final Item KYRITE_ARMOR_HELMET = register(new KyriteArmorItem.Helmet());
	public static final Item KYRITE_ARMOR_CHESTPLATE = register(new KyriteArmorItem.Chestplate());
	public static final Item KYRITE_ARMOR_LEGGINGS = register(new KyriteArmorItem.Leggings());
	public static final Item KYRITE_ARMOR_BOOTS = register(new KyriteArmorItem.Boots());
	public static final Item VOIDIUM_INGOT = register(new VoidiumIngotItem());
	public static final Item VOIDIUM_ORE = register(ObsidianGearModBlocks.VOIDIUM_ORE, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item VOIDIUM_BLOCK = register(ObsidianGearModBlocks.VOIDIUM_BLOCK, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item VOIDIUM_PICKAXE = register(new VoidiumPickaxeItem());
	public static final Item VOIDIUM_AXE = register(new VoidiumAxeItem());
	public static final Item VOIDIUM_SWORD = register(new VoidiumSwordItem());
	public static final Item VOIDIUM_SHOVEL = register(new VoidiumShovelItem());
	public static final Item VOIDIUM_HOE = register(new VoidiumHoeItem());
	public static final Item VOIDIUM_ARMOR_HELMET = register(new VoidiumArmorItem.Helmet());
	public static final Item VOIDIUM_ARMOR_CHESTPLATE = register(new VoidiumArmorItem.Chestplate());
	public static final Item VOIDIUM_ARMOR_LEGGINGS = register(new VoidiumArmorItem.Leggings());
	public static final Item VOIDIUM_ARMOR_BOOTS = register(new VoidiumArmorItem.Boots());
	public static final Item DESOLATE_WOOD = register(ObsidianGearModBlocks.DESOLATE_WOOD, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item DESOLATE_LOG = register(ObsidianGearModBlocks.DESOLATE_LOG, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item DESOLATE_PLANKS = register(ObsidianGearModBlocks.DESOLATE_PLANKS, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item DESOLATE_LEAVES = register(ObsidianGearModBlocks.DESOLATE_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final Item DESOLATE_STAIRS = register(ObsidianGearModBlocks.DESOLATE_STAIRS, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item DESOLATE_SLAB = register(ObsidianGearModBlocks.DESOLATE_SLAB, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item DESOLATE_FENCE = register(ObsidianGearModBlocks.DESOLATE_FENCE, CreativeModeTab.TAB_DECORATIONS);
	public static final Item DESOLATE_FENCE_GATE = register(ObsidianGearModBlocks.DESOLATE_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final Item DESOLATE_PRESSURE_PLATE = register(ObsidianGearModBlocks.DESOLATE_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final Item DESOLATE_BUTTON = register(ObsidianGearModBlocks.DESOLATE_BUTTON, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item VOID_GRASS_PLANT = register(ObsidianGearModBlocks.VOID_GRASS_PLANT, CreativeModeTab.TAB_DECORATIONS);
	public static final Item POISON_WATER_BUCKET = register(new PoisonWaterItem());
	public static final Item AEON_FORGE_BLOCK = register(ObsidianGearModBlocks.AEON_FORGE_BLOCK, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item RED_IRON = register(ObsidianGearModBlocks.RED_IRON, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item ENDERIUM_INGOT = register(new EnderiumIngotItem());
	public static final Item ENDERIUM_ORE = register(ObsidianGearModBlocks.ENDERIUM_ORE, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item ENDERIUM_BLOCK = register(ObsidianGearModBlocks.ENDERIUM_BLOCK, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item ENDERIUM_PICKAXE = register(new EnderiumPickaxeItem());
	public static final Item ENDERIUM_AXE = register(new EnderiumAxeItem());
	public static final Item ENDERIUM_SWORD = register(new EnderiumSwordItem());
	public static final Item ENDERIUM_SHOVEL = register(new EnderiumShovelItem());
	public static final Item ENDERIUM_HOE = register(new EnderiumHoeItem());
	public static final Item ENDERIUM_ARMOR_HELMET = register(new EnderiumArmorItem.Helmet());
	public static final Item ENDERIUM_ARMOR_CHESTPLATE = register(new EnderiumArmorItem.Chestplate());
	public static final Item ENDERIUM_ARMOR_LEGGINGS = register(new EnderiumArmorItem.Leggings());
	public static final Item ENDERIUM_ARMOR_BOOTS = register(new EnderiumArmorItem.Boots());
	public static final Item SPOOK_WOOD = register(ObsidianGearModBlocks.SPOOK_WOOD, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item SPOOK_LOG = register(ObsidianGearModBlocks.SPOOK_LOG, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item SPOOK_PLANKS = register(ObsidianGearModBlocks.SPOOK_PLANKS, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item SPOOK_LEAVES = register(ObsidianGearModBlocks.SPOOK_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final Item SPOOK_STAIRS = register(ObsidianGearModBlocks.SPOOK_STAIRS, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item SPOOK_SLAB = register(ObsidianGearModBlocks.SPOOK_SLAB, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item SPOOK_FENCE = register(ObsidianGearModBlocks.SPOOK_FENCE, CreativeModeTab.TAB_DECORATIONS);
	public static final Item SPOOK_FENCE_GATE = register(ObsidianGearModBlocks.SPOOK_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final Item SPOOK_PRESSURE_PLATE = register(ObsidianGearModBlocks.SPOOK_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final Item SPOOK_BUTTON = register(ObsidianGearModBlocks.SPOOK_BUTTON, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item ENDERITE_INGOT = register(new EnderiteIngotItem());
	public static final Item ENDERITE_ORE = register(ObsidianGearModBlocks.ENDERITE_ORE, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item ENDERITE_BLOCK = register(ObsidianGearModBlocks.ENDERITE_BLOCK, ObsidianGearModTabs.TAB_OBSIDIAN_GEAR);
	public static final Item ENDERITE_PICKAXE = register(new EnderitePickaxeItem());
	public static final Item ENDERITE_AXE = register(new EnderiteAxeItem());
	public static final Item ENDERITE_SWORD = register(new EnderiteSwordItem());
	public static final Item ENDERITE_SHOVEL = register(new EnderiteShovelItem());
	public static final Item ENDERITE_HOE = register(new EnderiteHoeItem());
	public static final Item ENDERITE_ARMOR_HELMET = register(new EnderiteArmorItem.Helmet());
	public static final Item ENDERITE_ARMOR_CHESTPLATE = register(new EnderiteArmorItem.Chestplate());
	public static final Item ENDERITE_ARMOR_LEGGINGS = register(new EnderiteArmorItem.Leggings());
	public static final Item ENDERITE_ARMOR_BOOTS = register(new EnderiteArmorItem.Boots());
	public static final Item ENDERITE_SCRAP = register(new EnderiteScrapItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
