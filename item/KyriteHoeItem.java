// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.item;

import net.minecraft.item.HoeItem;
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
public class KyriteHoeItem extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:kyrite_hoe")
    public static final Item block;
    
    public KyriteHoeItem(final ObsidianGearModElements instance) {
        super(instance, 30);
    }
    
    @Override
    public void initElements() {
        final HoeItem hoeItem;
        this.elements.items.add(() -> {
            new HoeItem(new IItemTier() {
                public int func_200926_a() {
                    return 3200;
                }
                
                public float func_200928_b() {
                    return 10.0f;
                }
                
                public float func_200929_c() {
                    return 3.0f;
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
            }, 0, -3.0f, new Item.Properties().func_200916_a(ItemGroup.field_78040_i)) {};
            return (Item)hoeItem.setRegistryName("kyrite_hoe");
        });
    }
    
    static {
        block = null;
    }
}
