// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import java.util.function.Predicate;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.function.Consumer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;

@Mod("obsidian_gear")
public class ObsidianGearMod
{
    public static final Logger LOGGER;
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER;
    public ObsidianGearModElements elements;
    
    public ObsidianGearMod() {
        this.elements = new ObsidianGearModElements();
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener((Consumer)this::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener((Consumer)this::clientLoad);
        MinecraftForge.EVENT_BUS.register((Object)new ObsidianGearModFMLBusEvents(this));
    }
    
    private void init(final FMLCommonSetupEvent event) {
        this.elements.getElements().forEach(element -> element.init(event));
    }
    
    public void clientLoad(final FMLClientSetupEvent event) {
        this.elements.getElements().forEach(element -> element.clientLoad(event));
    }
    
    @SubscribeEvent
    public void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getBlocks().stream().map((Function<? super Object, ?>)Supplier::get).toArray(Block[]::new));
    }
    
    @SubscribeEvent
    public void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getItems().stream().map((Function<? super Object, ?>)Supplier::get).toArray(Item[]::new));
    }
    
    @SubscribeEvent
    public void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getEntities().stream().map((Function<? super Object, ?>)Supplier::get).toArray(EntityType[]::new));
    }
    
    @SubscribeEvent
    public void registerEnchantments(final RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])this.elements.getEnchantments().stream().map((Function<? super Object, ?>)Supplier::get).toArray(Enchantment[]::new));
    }
    
    @SubscribeEvent
    public void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        this.elements.registerSounds(event);
    }
    
    static {
        LOGGER = LogManager.getLogger((Class)ObsidianGearMod.class);
        PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("obsidian_gear", "obsidian_gear"), () -> "1", (Predicate)"1"::equals, (Predicate)"1"::equals);
    }
    
    private static class ObsidianGearModFMLBusEvents
    {
        private final ObsidianGearMod parent;
        
        ObsidianGearModFMLBusEvents(final ObsidianGearMod parent) {
            this.parent = parent;
        }
        
        @SubscribeEvent
        public void serverLoad(final FMLServerStartingEvent event) {
            this.parent.elements.getElements().forEach(element -> element.serverLoad(event));
        }
    }
}
