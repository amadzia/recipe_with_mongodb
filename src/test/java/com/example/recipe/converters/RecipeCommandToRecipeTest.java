package com.example.recipe.converters;

import com.example.recipe.commands.CategoryCommand;
import com.example.recipe.commands.IngredientCommand;
import com.example.recipe.commands.NotesCommand;
import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.domain.Difficulty;
import com.example.recipe.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    public static final String RECIPE_ID = "1";
    public static final Integer COOK_TIME = 5;
    public static final Integer PREP_TIME = 7;
    public static final String DESCRIPTION = "description";
    public static final String DIRECTIONS = "directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final Integer SERVINGS = Integer.valueOf("3");
    public static final String SOURCE = "source";
    public static final String URL = "someURL";
    public static final String CAT_ID_1 = "1";
    public static final String CAT_ID_2 = "2";
    public static final String INGR_ID_1 = "3";
    public static final String INGR_ID_2 = "4";
    public static final String NOTES_ID = "5";

    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void nullObjectTest() {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObjectTest() {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);

        recipeCommand.setNotes(notesCommand);

        CategoryCommand categoryCommand1 = new CategoryCommand();
        categoryCommand1.setId(CAT_ID_1);

        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand2.setId(CAT_ID_2);

        recipeCommand.getCategories().add(categoryCommand1);
        recipeCommand.getCategories().add(categoryCommand2);

        IngredientCommand ingredientCommand1 = new IngredientCommand();
        ingredientCommand1.setId(INGR_ID_1);

        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(INGR_ID_2);

        recipeCommand.getIngredients().add(ingredientCommand1);
        recipeCommand.getIngredients().add(ingredientCommand2);

        //when
        Recipe recipe = converter.convert(recipeCommand);

        //then
        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }
}