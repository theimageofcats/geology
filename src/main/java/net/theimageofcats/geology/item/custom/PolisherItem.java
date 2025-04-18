package net.theimageofcats.geology.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.theimageofcats.geology.block.ModBlocks;

import java.util.Map;

public class PolisherItem extends Item {
    private static final Map<Block, Block> POLISHER_MAP = Map.ofEntries(
            Map.entry(ModBlocks.FELDSPAR_BLOCK.get(), ModBlocks.POLISHED_FELDSPAR_BLOCK.get()),
            Map.entry(Blocks.STONE, Blocks.SMOOTH_STONE),
            Map.entry(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE),
            Map.entry(Blocks.DIORITE, Blocks.POLISHED_DIORITE),
            Map.entry(Blocks.GRANITE, Blocks.POLISHED_GRANITE),
            Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
            Map.entry(Blocks.BASALT, Blocks.POLISHED_BASALT),
            Map.entry(Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE),
            Map.entry(Blocks.TUFF, Blocks.POLISHED_TUFF),
            Map.entry(Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ),
            Map.entry(Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE),
            Map.entry(Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE)
    );

    public PolisherItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clicked = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(POLISHER_MAP.containsKey(clicked)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), POLISHER_MAP.get(clicked).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
