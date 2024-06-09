package net.alekseeva.wardenbettermod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.alekseeva.wardenbettermod.WardenBetterMod;
import net.alekseeva.wardenbettermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import  net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.Registry;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURE =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, WardenBetterMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OWERWORLD_WARDENITE_ORES = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,ModBlocks.WARDENITE_ORE_BLOCK.get().defaultBlockState()),
        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_WARDENITE_ORE_BLOCK.get().defaultBlockState())));



    public static final RegistryObject<ConfiguredFeature<?, ?>> WARDENITE_ORE = CONFIGURED_FEATURE.register("wardenite_ore_block",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OWERWORLD_WARDENITE_ORES.get(),7)));

    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURE.register(eventBus);

    }
}
