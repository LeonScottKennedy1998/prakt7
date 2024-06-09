package net.alekseeva.wardenbettermod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.alekseeva.wardenbettermod.WardenBetterMod;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    WARDEN_CHESTPLATE("warden", 50, new int[]{4, 7, 9, 4}, 20,
        SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F,
        () -> Ingredient.of(ModItems.WARDEN_INGOT.get())),

    WARDEN_LEGGINGS("warden_leggings", 50, new int[]{4, 6, 7, 4}, 20,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F,
            () -> Ingredient.of(ModItems.WARDEN_INGOT.get()));

    private static final int[] DURABILITY_PER_SLOT = new int[]{15, 18, 20, 13};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                     SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABILITY_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return WardenBetterMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }


}
