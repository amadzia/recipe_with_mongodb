package com.example.recipe.converters;

import com.example.recipe.commands.CategoryCommand;
import com.example.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final String ID_VALUE = "1";
    public static String DESCRIPTION = "description";
    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void nullObjectTest() {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObjectTest() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}