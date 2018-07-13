package com.example.recipe.converters;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final String STRING_VALUE = "1";

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {

        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void nullObjectTest() {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObjectTest() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(STRING_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(STRING_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}