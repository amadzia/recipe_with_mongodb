package com.example.recipe.converters;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final String STRING_VALUE = "1";

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {

        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void nullObjectTest() {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObjectTest() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(STRING_VALUE);
        uom.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(uom);

        //then
        assertEquals(STRING_VALUE, unitOfMeasureCommand.getId());
        assertEquals(DESCRIPTION, unitOfMeasureCommand.getDescription());
    }
}