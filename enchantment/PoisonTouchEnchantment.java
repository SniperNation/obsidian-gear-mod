// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.enchantment.Enchantment;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class PoisonTouchEnchantment extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:poison_touch")
    public static final Enchantment enchantment;
    
    public PoisonTouchEnchantment(final ObsidianGearModElements instance) {
        super(instance, 92);
    }
    
    @Override
    public void initElements() {
        final CustomEnchantment customEnchantment;
        this.elements.enchantments.add(() -> {
            new CustomEnchantment(new EquipmentSlotType[] { EquipmentSlotType.MAINHAND });
            return (Enchantment)customEnchantment.setRegistryName("poison_touch");
        });
    }
    
    static {
        enchantment = null;
    }
    
    public static class CustomEnchantment extends Enchantment
    {
        public CustomEnchantment(final EquipmentSlotType... slots) {
            super(Enchantment.Rarity.VERY_RARE, EnchantmentType.BREAKABLE, slots);
        }
        
        public int func_77319_d() {
            return 1;
        }
        
        public int func_77325_b() {
            return 3;
        }
        
        public boolean func_185261_e() {
            return false;
        }
        
        public boolean func_190936_d() {
            return false;
        }
        
        public boolean isAllowedOnBooks() {
            return true;
        }
        
        public boolean func_230310_i_() {
            return true;
        }
        
        public boolean func_230309_h_() {
            return true;
        }
    }
}
