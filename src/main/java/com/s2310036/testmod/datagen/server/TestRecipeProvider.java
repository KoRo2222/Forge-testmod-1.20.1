package com.s2310036.testmod.datagen.server;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class TestRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GUARDIAN_SMELTABLES = List.of(TestBlocks.GUARDIAN_FOSSIL.get());

    public TestRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, GUARDIAN_SMELTABLES, RecipeCategory.MISC, TestItems.GUARDIAN_FIN.get(), 0.25f, 100, "guardian_fin");
        oreSmelting(pWriter, GUARDIAN_SMELTABLES, RecipeCategory.MISC, TestItems.GUARDIAN_FIN.get(), 0.25f, 200, "guardian_fin");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TestBlocks.GUARDMARINE.get())
                .pattern("#$#")
                .pattern("$#$")
                .pattern("#$#")
                .define('#', TestItems.GUARDIAN_FIN.get())
                .define('$', TestItems.GUARDIAN_SCALES.get())
                .unlockedBy(getHasName(TestItems.GUARDIAN_FIN.get()), has(TestItems.GUARDIAN_FIN.get()))
                .unlockedBy(getHasName(TestItems.GUARDIAN_SCALES.get()), has(TestItems.GUARDIAN_SCALES.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TestItems.GUARDIAN_SCALES.get(), 4)
                .requires(TestItems.GUARDIAN_FIN.get())
                .unlockedBy(getHasName(TestItems.GUARDIAN_FIN.get()), has(TestItems.GUARDIAN_FIN.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TestMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
