package net.behold.liminality;

import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class ModBlockModels extends ModelProvider {

    public ModBlockModels(PackOutput output) {
        super(output, Liminality.MOD_ID);
    }

    @Override
    protected void registerModels(
            BlockModelGenerators blockModels,
            ItemModelGenerators itemModels
    ) {
        getKnownBlocks().forEach(holder -> {
            var block = holder.value();

            blockModels.createTrivialCube(block);

            Identifier blockId = BuiltInRegistries.BLOCK.getKey(block);
            Identifier modelId = Identifier.fromNamespaceAndPath(
                    blockId.getNamespace(),
                    "block/" + blockId.getPath()
            );
            blockModels.registerSimpleItemModel(block, modelId);
        });
    }

    public static void gather(GatherDataEvent.Client event) {
        event.createProvider(ModBlockModels::new);
    }
}
