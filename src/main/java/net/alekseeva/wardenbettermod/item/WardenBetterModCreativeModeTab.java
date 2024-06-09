package net.alekseeva.wardenbettermod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WardenBetterModCreativeModeTab {
    public static final CreativeModeTab WARDEN_TAB = new CreativeModeTab("Warden Better Mod Tab") {
    @Override
        public ItemStack makeIcon() {
        return new ItemStack(ModItems.WARDEN_INGOT.get());
        }

    };
}
