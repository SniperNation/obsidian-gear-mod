// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.item;

import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class ObsidianPickaxeItem extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:obsidian_pickaxe")
    public static final Item block;
    
    public ObsidianPickaxeItem(final ObsidianGearModElements instance) {
        super(instance, 1);
    }
    
    @Override
    public void initElements() {
        final PickaxeItem pickaxeItem;
        this.elements.items.add(() -> {
            new PickaxeItem(new IItemTier() {
                public int func_200926_a() {
                    return 4000;
                }
                
                public float func_200928_b() {
                    return 18.0f;
                }
                
                public float func_200929_c() {
                    return 5.0f;
                }
                
                public int func_200925_d() {
                    return 4;
                }
                
                public int func_200927_e() {
                    return 2;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.field_193370_a;
                }
            }, 1, -3.0f, new Item.Properties().func_200916_a(ItemGroup.field_78040_i).func_234689_a_()) {
                public boolean func_77634_r() {
                    return true;
                }
                
                public ItemStack getContainerItem(final ItemStack itemstack) {
                    return new ItemStack((IItemProvider)this);
                }
                
                public boolean isRepairable(final ItemStack itemstack) {
                    return false;
                }
            };
            return (Item)pickaxeItem.setRegistryName("obsidian_pickaxe");
        });
    }
    
    static {
        block = null;
    }
}
