// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.item;

import net.minecraft.world.World;
import java.util.Map;
import net.mcreator.obsidiangear.procedures.ImbuedProcedure;
import java.util.HashMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class KyriteAxeItem extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:kyrite_axe")
    public static final Item block;
    
    public KyriteAxeItem(final ObsidianGearModElements instance) {
        super(instance, 27);
    }
    
    @Override
    public void initElements() {
        final AxeItem axeItem;
        this.elements.items.add(() -> {
            new AxeItem(new IItemTier() {
                public int func_200926_a() {
                    return 3200;
                }
                
                public float func_200928_b() {
                    return 10.0f;
                }
                
                public float func_200929_c() {
                    return 18.0f;
                }
                
                public int func_200925_d() {
                    return 5;
                }
                
                public int func_200927_e() {
                    return 35;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)KyriteItem.block) });
                }
            }, 1.0f, -3.0f, new Item.Properties().func_200916_a(ItemGroup.field_78040_i)) {
                public boolean func_77644_a(final ItemStack itemstack, final LivingEntity entity, final LivingEntity sourceentity) {
                    final boolean retval = super.func_77644_a(itemstack, entity, sourceentity);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    final World world = entity.field_70170_p;
                    final Map $_dependencies = new HashMap();
                    $_dependencies.put("entity", entity);
                    $_dependencies.put("itemstack", itemstack);
                    ImbuedProcedure.executeProcedure($_dependencies);
                    return retval;
                }
            };
            return (Item)axeItem.setRegistryName("kyrite_axe");
        });
    }
    
    static {
        block = null;
    }
}
