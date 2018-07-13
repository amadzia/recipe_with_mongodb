package com.example.recipe.converters;

import com.example.recipe.commands.IngredientCommand;
import com.example.recipe.domain.Ingredient;
import com.example.recipe.domain.Recipe;
import com.example.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheesburger";
    public static final String UOM_ID = "2";
    public static final String ID_VALUE = "1";

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {

        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void nullObjectTest() {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObjectTest() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convertNullUOMTest() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertNull(ingredientCommand.getUom());
        assertEquals(ID_VALUE, ingredientCommand.getId());
//        assertEquals(RECIPE, ingredientCommand.getRecipe());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }

    @Test
    public void convertWithUOMTest() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        ingredient.setUom(uom);

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUom());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());
//        assertEquals((RECIPE, ingredientCommand.get));
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }
}