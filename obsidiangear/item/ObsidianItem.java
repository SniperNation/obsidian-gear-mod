// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.IItemProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.SoundEvent;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class ObsidianItem extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:obsidian_helmet")
    public static final Item helmet;
    @ObjectHolder("obsidian_gear:obsidian_chestplate")
    public static final Item body;
    @ObjectHolder("obsidian_gear:obsidian_leggings")
    public static final Item legs;
    @ObjectHolder("obsidian_gear:obsidian_boots")
    public static final Item boots;
    
    public ObsidianItem(final ObsidianGearModElements instance) {
        super(instance, 3);
    }
    
    @Override
    public void initElements() {
        final IArmorMaterial armormaterial = (IArmorMaterial)new IArmorMaterial() {
            public int func_200896_a(final EquipmentSlotType slot) {
                return (new int[] { 13, 15, 16, 11 })[slot.func_188454_b()] * 25;
            }
            
            public int func_200902_b(final EquipmentSlotType slot) {
                return (new int[] { 2, 7, 8, 4 })[slot.func_188454_b()];
            }
            
            public int func_200900_a() {
                return 9;
            }
            
            public SoundEvent func_200899_b() {
                return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
            }
            
            public Ingredient func_200898_c() {
                return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)Blocks.field_150343_Z) });
            }
            
            @OnlyIn(Dist.CLIENT)
            public String func_200897_d() {
                return "obsidian";
            }
            
            public float func_200901_e() {
                return 4.0f;
            }
            
            public float func_230304_f_() {
                return 0.3f;
            }
        };
        final ArmorItem armorItem;
        final IArmorMaterial x0;
        this.elements.items.add(() -> {
            new ArmorItem(x0, EquipmentSlotType.HEAD, new Item.Properties().func_200916_a(ItemGroup.field_78037_j)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "obsidian_gear:textures/models/armor/obsidian_armor_layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem.setRegistryName("obsidian_helmet");
        });
        final ArmorItem armorItem2;
        final IArmorMaterial x2;
        this.elements.items.add(() -> {
            new ArmorItem(x2, EquipmentSlotType.CHEST, new Item.Properties().func_200916_a(ItemGroup.field_78037_j)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "obsidian_gear:textures/models/armor/obsidian_armor_layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem2.setRegistryName("obsidian_chestplate");
        });
        final ArmorItem armorItem3;
        final IArmorMaterial x3;
        this.elements.items.add(() -> {
            new ArmorItem(x3, EquipmentSlotType.LEGS, new Item.Properties().func_200916_a(ItemGroup.field_78037_j)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "obsidian_gear:textures/models/armor/obsidian_armor_layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem3.setRegistryName("obsidian_leggings");
        });
        final ArmorItem armorItem4;
        final IArmorMaterial x4;
        this.elements.items.add(() -> {
            new ArmorItem(x4, EquipmentSlotType.FEET, new Item.Properties().func_200916_a(ItemGroup.field_78037_j)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "obsidian_gear:textures/models/armor/obsidian_armor_layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem4.setRegistryName("obsidian_boots");
        });
    }
    
    static {
        helmet = null;
        body = null;
        legs = null;
        boots = null;
    }
}
