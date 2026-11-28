package net.behold.liminality;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Liminality.MOD_ID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Liminality.MOD_ID);

    public static final List<DeferredItem<BlockItem>> BLOCK_ITEMS =
            new ArrayList<>();

    // Add new blocks here.
    public static final DeferredBlock<Block> TEST_BLOCK =
            registerBlock("test_block");






    private static DeferredBlock<Block> registerBlock(String name) {
        DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(name);

        DeferredItem<BlockItem> item =
                ITEMS.registerSimpleBlockItem(name, block);

        BLOCK_ITEMS.add(item);

        return block;


    }
}
