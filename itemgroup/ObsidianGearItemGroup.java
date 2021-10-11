// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.itemgroup;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.IItemProvider;
import net.mcreator.obsidiangear.item.ObsidianPickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class ObsidianGearItemGroup extends ObsidianGearModElements.ModElement
{
    public static ItemGroup tab;
    
    public ObsidianGearItemGroup(final ObsidianGearModElements instance) {
        super(instance, 19);
    }
    
    @Override
    public void initElements() {
        ObsidianGearItemGroup.tab = new ItemGroup("tabobsidian_gear") {
            @OnlyIn(Dist.CLIENT)
            public ItemStack func_78016_d() {
                return new ItemStack((IItemProvider)ObsidianPickaxeItem.block);
            }
            
            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {
                return true;
            }
        }.func_78025_a("item_search.png");
    }
}
