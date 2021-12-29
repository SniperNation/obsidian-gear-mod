
package net.mcreator.obsidiangear.fluid;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.obsidiangear.init.ObsidianGearModItems;
import net.mcreator.obsidiangear.init.ObsidianGearModFluids;
import net.mcreator.obsidiangear.init.ObsidianGearModBlocks;
import net.mcreator.obsidiangear.fluid.attributes.PoisonWaterFluidAttributes;

public abstract class PoisonWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> ObsidianGearModFluids.POISON_WATER,
			() -> ObsidianGearModFluids.FLOWING_POISON_WATER,
			PoisonWaterFluidAttributes
					.builder(new ResourceLocation("obsidian_gear:blocks/poison_water_still"),
							new ResourceLocation("obsidian_gear:blocks/poison_water_moving"))

					.rarity(Rarity.UNCOMMON).sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")))
					.color(-13083194)).explosionResistance(100f).canMultiply()

							.bucket(() -> ObsidianGearModItems.POISON_WATER_BUCKET).block(() -> (LiquidBlock) ObsidianGearModBlocks.POISON_WATER);

	private PoisonWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.FALLING_WATER;
	}

	public static class Source extends PoisonWaterFluid {
		public Source() {
			super();
			setRegistryName("poison_water");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends PoisonWaterFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_poison_water");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
