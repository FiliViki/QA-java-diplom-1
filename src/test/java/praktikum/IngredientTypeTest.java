package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testIngredientTypeValues() {
        // Проверяем, что перечисление содержит ожидаемые значения
        IngredientType[] types = IngredientType.values();

        // Проверяем, что длина массива равна 2
        assertEquals(2, types.length);

        // Проверяем соответствие элементов в перечислении
        assertEquals(IngredientType.SAUCE, types[0]); // Первый элемент
        assertEquals(IngredientType.FILLING, types[1]); // Второй элемент
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}

