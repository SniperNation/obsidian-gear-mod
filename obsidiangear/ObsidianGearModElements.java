// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import java.util.HashMap;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Function;
import net.minecraft.network.PacketBuffer;
import java.util.function.BiConsumer;
import net.minecraftforge.event.RegistryEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;
import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.ModList;
import java.util.ArrayList;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import java.util.function.Supplier;
import java.util.List;

public class ObsidianGearModElements
{
    public final List<ModElement> elements;
    public final List<Supplier<Block>> blocks;
    public final List<Supplier<Item>> items;
    public final List<Supplier<EntityType<?>>> entities;
    public final List<Supplier<Enchantment>> enchantments;
    public static Map<ResourceLocation, SoundEvent> sounds;
    private int messageID;
    
    public ObsidianGearModElements() {
        this.elements = new ArrayList<ModElement>();
        this.blocks = new ArrayList<Supplier<Block>>();
        this.items = new ArrayList<Supplier<Item>>();
        this.entities = new ArrayList<Supplier<EntityType<?>>>();
        this.enchantments = new ArrayList<Supplier<Enchantment>>();
        this.messageID = 0;
        try {
            final ModFileScanData modFileInfo = ModList.get().getModFileById("obsidian_gear").getFile().getScanResult();
            final Set<ModFileScanData.AnnotationData> annotations = (Set<ModFileScanData.AnnotationData>)modFileInfo.getAnnotations();
            for (final ModFileScanData.AnnotationData annotationData : annotations) {
                if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
                    final Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
                    if (clazz.getSuperclass() != ModElement.class) {
                        continue;
                    }
                    this.elements.add((ModElement)clazz.getConstructor(this.getClass()).newInstance(this));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(this.elements);
        this.elements.forEach(ModElement::initElements);
    }
    
    public void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        for (final Map.Entry<ResourceLocation, SoundEvent> sound : ObsidianGearModElements.sounds.entrySet()) {
            event.getRegistry().register(sound.getValue().setRegistryName((ResourceLocation)sound.getKey()));
        }
    }
    
    public <T> void addNetworkMessage(final Class<T> messageType, final BiConsumer<T, PacketBuffer> encoder, final Function<PacketBuffer, T> decoder, final BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        ObsidianGearMod.PACKET_HANDLER.registerMessage(this.messageID, (Class)messageType, (BiConsumer)encoder, (Function)decoder, (BiConsumer)messageConsumer);
        ++this.messageID;
    }
    
    public List<ModElement> getElements() {
        return this.elements;
    }
    
    public List<Supplier<Block>> getBlocks() {
        return this.blocks;
    }
    
    public List<Supplier<Item>> getItems() {
        return this.items;
    }
    
    public List<Supplier<EntityType<?>>> getEntities() {
        return this.entities;
    }
    
    public List<Supplier<Enchantment>> getEnchantments() {
        return this.enchantments;
    }
    
    static {
        ObsidianGearModElements.sounds = new HashMap<ResourceLocation, SoundEvent>();
    }
    
    public static class ModElement implements Comparable<ModElement>
    {
        protected final ObsidianGearModElements elements;
        protected final int sortid;
        
        public ModElement(final ObsidianGearModElements elements, final int sortid) {
            this.elements = elements;
            this.sortid = sortid;
        }
        
        public void initElements() {
        }
        
        public void init(final FMLCommonSetupEvent event) {
        }
        
        public void serverLoad(final FMLServerStartingEvent event) {
        }
        
        @OnlyIn(Dist.CLIENT)
        public void clientLoad(final FMLClientSetupEvent event) {
        }
        
        @Override
        public int compareTo(final ModElement other) {
            return this.sortid - other.sortid;
        }
        
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Tag {
        }
    }
}
