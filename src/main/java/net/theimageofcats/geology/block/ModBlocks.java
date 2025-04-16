package net.theimageofcats.geology.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.theimageofcats.geology.GeologyMod;
import net.theimageofcats.geology.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GeologyMod.MOD_ID);

    public static final RegistryObject<Block> FELDSPAR_BLOCK =
            registerBlock("feldspar_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(2.0f, 4.0f).requiresCorrectToolForDrops()
            .sound(SoundType.METAL)));
    public static final RegistryObject<Block> POLISHED_FELDSPAR_BLOCK =
            registerBlock("polished_feldspar_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3.0f, 8.0f)
            .sound(SoundType.METAL)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
