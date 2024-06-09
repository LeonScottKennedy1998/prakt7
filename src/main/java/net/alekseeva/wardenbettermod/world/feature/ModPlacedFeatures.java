package net.alekseeva.wardenbettermod.world.feature;

import net.alekseeva.wardenbettermod.WardenBetterMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.world.level.biome.Biomes.*;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, WardenBetterMod.MOD_ID);

    public static void register (IEventBus eventBus){
        PLACED_FEATURE.register(eventBus);
    }


    public static final RegistryObject<PlacedFeature> WARDENITE_ORE_PLACED = PLACED_FEATURE.register("wardenite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WARDENITE_ORE.getHolder().get(),
                    commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.belowTop(80)),
                        BiomeFilter.biome())));




    public static List<PlacementModifier> orePlacement(PlacementModifier... modifiers) {
        return List.of(modifiers);
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange, PlacementModifier biome) {
        return orePlacement(CountPlacement.of(count), InSquarePlacement.spread(), heightRange, biome);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightRange, PlacementModifier biome) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), InSquarePlacement.spread(), heightRange, biome);
    }
}
