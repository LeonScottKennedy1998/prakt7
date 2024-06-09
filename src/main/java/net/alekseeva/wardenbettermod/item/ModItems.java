package net.alekseeva.wardenbettermod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.alekseeva.wardenbettermod.WardenBetterMod;

public class ModItems {
    public static final DeferredRegister <Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WardenBetterMod.MOD_ID);

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> WARDEN_INGOT = ITEMS.register("warden_ingot",
            () -> new Item(new Item.Properties().tab(WardenBetterModCreativeModeTab.WARDEN_TAB)));

    public static final RegistryObject<Item> WARDEN_NUGGET = ITEMS.register("warden_nugget",
            () -> new Item(new Item.Properties().tab(WardenBetterModCreativeModeTab.WARDEN_TAB)));

    public static final RegistryObject<Item> WARDEN_PICKAXE = ITEMS.register("warden_pickaxe",
        () -> new PickaxeItem(ModToolMaterial.WARDEN_PICKAXE, 4, -2.4F, new Item.Properties().tab(WardenBetterModCreativeModeTab.WARDEN_TAB)));

    public static final RegistryObject<Item> WARDEN_SWORD = ITEMS.register("warden_sword",
            () -> new SwordItem(ModToolMaterial.WARDEN_SWORD, 10, -2.4F, new Item.Properties().tab(WardenBetterModCreativeModeTab.WARDEN_TAB)));

    //public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate",
           // () -> new ArmorItem(ModArmorMaterial.WARDEN_CHESTPLATE, EquipmentSlot.CHEST, new Item.Properties().tab(WardenBetterModCreativeModeTab.WARDEN_TAB)));

    //public static final RegistryObject<Item> WARDEN_LEGGINNS = ITEMS.register("warden_leggings",
            //() -> new ArmorItem(ModArmorMaterial.WARDEN_LEGGINGS, EquipmentSlot.LEGS, new Item.Properties().tab(WardenBetterModCreativeModeTab.WARDEN_TAB)));




}
