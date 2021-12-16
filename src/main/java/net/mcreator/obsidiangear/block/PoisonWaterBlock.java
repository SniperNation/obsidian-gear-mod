
package net.mcreator.obsidiangear.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.obsidiangear.procedures.PoisonWaterEntityTouchProcedure;
import net.mcreator.obsidiangear.init.ObsidianGearModFluids;

public class PoisonWaterBlock extends LiquidBlock {
	public PoisonWaterBlock() {
		super(ObsidianGearModFluids.POISON_WATER, BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
		setRegistryName("poison_water");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		PoisonWaterEntityTouchProcedure.execute(entity);
	}
}
