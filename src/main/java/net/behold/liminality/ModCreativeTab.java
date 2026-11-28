package net.behold.liminality;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Liminality.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> LIMINALITY_TAB =
            TABS.register("liminality", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.liminality"))
                    .icon(() -> ModBlocks.TEST_BLOCK.get().asItem().getDefaultInstance())
                    .displayItems((parameters, output) ->
                            ModBlocks.BLOCK_ITEMS.forEach(item -> output.accept(item.get())))
                    .build());
}
