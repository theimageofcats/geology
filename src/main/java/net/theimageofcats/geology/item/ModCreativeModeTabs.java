package net.theimageofcats.geology.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.theimageofcats.geology.GeologyMod;
import net.theimageofcats.geology.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GeologyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GEOLOGY_TAB =
            CREATIVE_MODE_TABS.register("geology_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.FELDSPAR_CLAY.get()))
                    .title(Component.translatable("creativetab.geology.geology_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FELDSPAR.get());
                        output.accept(ModItems.FELDSPAR_CLAY.get());
                        output.accept(ModItems.FELDSPAR_POWDER.get());
                        output.accept(ModBlocks.FELDSPAR_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_FELDSPAR_BLOCK.get());
                        output.accept(ModBlocks.FELDSPAR_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_FELDSPAR_ORE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> GEOLOGY_UTILITIES =
            CREATIVE_MODE_TABS.register("geology_utilities_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.POLISHER.get()))
                    .title(Component.translatable("creativetab.geology.geology_utilities_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.POLISHER.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
