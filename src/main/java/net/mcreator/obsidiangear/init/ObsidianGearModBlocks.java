
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.obsidiangear.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.obsidiangear.block.VoidiumOreBlock;
import net.mcreator.obsidiangear.block.VoidiumBlockBlock;
import net.mcreator.obsidiangear.block.VoidStoneBlock;
import net.mcreator.obsidiangear.block.VoidPortalFrameBlock;
import net.mcreator.obsidiangear.block.VoidGrassPlantBlock;
import net.mcreator.obsidiangear.block.VoidGrassBlock;
import net.mcreator.obsidiangear.block.TheVoidPortalBlock;
import net.mcreator.obsidiangear.block.SpookWoodBlock;
import net.mcreator.obsidiangear.block.SpookStairsBlock;
import net.mcreator.obsidiangear.block.SpookSlabBlock;
import net.mcreator.obsidiangear.block.SpookPressurePlateBlock;
import net.mcreator.obsidiangear.block.SpookPlanksBlock;
import net.mcreator.obsidiangear.block.SpookLogBlock;
import net.mcreator.obsidiangear.block.SpookLeavesBlock;
import net.mcreator.obsidiangear.block.SpookFenceGateBlock;
import net.mcreator.obsidiangear.block.SpookFenceBlock;
import net.mcreator.obsidiangear.block.SpookButtonBlock;
import net.mcreator.obsidiangear.block.SkrewtOreBlock;
import net.mcreator.obsidiangear.block.SkrewtBlockBlock;
import net.mcreator.obsidiangear.block.RedIronBlock;
import net.mcreator.obsidiangear.block.PoisonWaterBlock;
import net.mcreator.obsidiangear.block.KyriteOreBlock;
import net.mcreator.obsidiangear.block.KyriteBlockBlock;
import net.mcreator.obsidiangear.block.EnderiteOreBlock;
import net.mcreator.obsidiangear.block.EnderiteBlockBlock;
import net.mcreator.obsidiangear.block.DesolateWoodBlock;
import net.mcreator.obsidiangear.block.DesolateStairsBlock;
import net.mcreator.obsidiangear.block.DesolateSlabBlock;
import net.mcreator.obsidiangear.block.DesolatePressurePlateBlock;
import net.mcreator.obsidiangear.block.DesolatePlanksBlock;
import net.mcreator.obsidiangear.block.DesolateLogBlock;
import net.mcreator.obsidiangear.block.DesolateLeavesBlock;
import net.mcreator.obsidiangear.block.DesolateFenceGateBlock;
import net.mcreator.obsidiangear.block.DesolateFenceBlock;
import net.mcreator.obsidiangear.block.DesolateButtonBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ObsidianGearModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block VOID_STONE = register(new VoidStoneBlock());
	public static final Block VOID_PORTAL_FRAME = register(new VoidPortalFrameBlock());
	public static final Block THE_VOID_PORTAL = register(new TheVoidPortalBlock());
	public static final Block VOID_GRASS = register(new VoidGrassBlock());
	public static final Block KYRITE_ORE = register(new KyriteOreBlock());
	public static final Block KYRITE_BLOCK = register(new KyriteBlockBlock());
	public static final Block VOIDIUM_ORE = register(new VoidiumOreBlock());
	public static final Block VOIDIUM_BLOCK = register(new VoidiumBlockBlock());
	public static final Block DESOLATE_WOOD = register(new DesolateWoodBlock());
	public static final Block DESOLATE_LOG = register(new DesolateLogBlock());
	public static final Block DESOLATE_PLANKS = register(new DesolatePlanksBlock());
	public static final Block DESOLATE_LEAVES = register(new DesolateLeavesBlock());
	public static final Block DESOLATE_STAIRS = register(new DesolateStairsBlock());
	public static final Block DESOLATE_SLAB = register(new DesolateSlabBlock());
	public static final Block DESOLATE_FENCE = register(new DesolateFenceBlock());
	public static final Block DESOLATE_FENCE_GATE = register(new DesolateFenceGateBlock());
	public static final Block DESOLATE_PRESSURE_PLATE = register(new DesolatePressurePlateBlock());
	public static final Block DESOLATE_BUTTON = register(new DesolateButtonBlock());
	public static final Block VOID_GRASS_PLANT = register(new VoidGrassPlantBlock());
	public static final Block POISON_WATER = register(new PoisonWaterBlock());
	public static final Block RED_IRON = register(new RedIronBlock());
	public static final Block SPOOK_WOOD = register(new SpookWoodBlock());
	public static final Block SPOOK_LOG = register(new SpookLogBlock());
	public static final Block SPOOK_PLANKS = register(new SpookPlanksBlock());
	public static final Block SPOOK_LEAVES = register(new SpookLeavesBlock());
	public static final Block SPOOK_STAIRS = register(new SpookStairsBlock());
	public static final Block SPOOK_SLAB = register(new SpookSlabBlock());
	public static final Block SPOOK_FENCE = register(new SpookFenceBlock());
	public static final Block SPOOK_FENCE_GATE = register(new SpookFenceGateBlock());
	public static final Block SPOOK_PRESSURE_PLATE = register(new SpookPressurePlateBlock());
	public static final Block SPOOK_BUTTON = register(new SpookButtonBlock());
	public static final Block ENDERITE_ORE = register(new EnderiteOreBlock());
	public static final Block ENDERITE_BLOCK = register(new EnderiteBlockBlock());
	public static final Block SKREWT_ORE = register(new SkrewtOreBlock());
	public static final Block SKREWT_BLOCK = register(new SkrewtBlockBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			VoidGrassPlantBlock.registerRenderLayer();
		}
	}
}
