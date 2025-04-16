package net.theimageofcats.geology.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.theimageofcats.geology.GeologyMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GeologyMod.MOD_ID);

    // Silicates ~90% Earth's crust
    public static final RegistryObject<Item> FELDSPAR =
            ITEMS.register("feldspar",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FELDSPAR_CLAY =
            ITEMS.register("feldspar_clay",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FELDSPAR_POWDER =
            ITEMS.register("feldspar_powder",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
