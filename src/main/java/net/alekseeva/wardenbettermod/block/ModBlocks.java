package net.alekseeva.wardenbettermod.block;

import net.alekseeva.wardenbettermod.WardenBetterMod;
import net.alekseeva.wardenbettermod.block.custom.PowerBlock;
import net.alekseeva.wardenbettermod.item.ModItems;
import net.alekseeva.wardenbettermod.item.WardenBetterModCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WardenBetterMod.MOD_ID);

    public static final RegistryObject<Block> WARDENITE_BLOCK = registerBlock("wardenite_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                .strength(50.0f, 1200.0f)
                .sound(SoundType.ANCIENT_DEBRIS)
                .lightLevel((state) -> 10)),
        WardenBetterModCreativeModeTab.WARDEN_TAB);


    public static final RegistryObject<Block> WARDENITE_ORE_BLOCK = registerBlock("wardenite_ore_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                .strength(6f, 6f)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops()),
        WardenBetterModCreativeModeTab.WARDEN_TAB);

    public static final RegistryObject<Block> DEEPSLATE_WARDENITE_ORE_BLOCK = registerBlock("deepslate_wardenite_ore_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                .strength(6f, 6f)
                .sound(SoundType.DEEPSLATE)
                .requiresCorrectToolForDrops()),
        WardenBetterModCreativeModeTab.WARDEN_TAB);

    public static final RegistryObject<Block> POWER_BLOCK = registerBlock("warden_power_block",
            () -> new PowerBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()),
            WardenBetterModCreativeModeTab.WARDEN_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
