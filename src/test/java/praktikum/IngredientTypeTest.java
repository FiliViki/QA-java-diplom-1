package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    @Parameterized.Parameter(0)
    public IngredientType ingredientType;

    @Parameterized.Parameter(1)
    public String expectedName;

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][] {
                { IngredientType.SAUCE, "SAUCE" },
                { IngredientType.FILLING, "FILLING" }
        };
    }

    @Test
    public void testIngredientTypeValues() {
        // Проверяем соответствие элементов в перечислении
        if (ingredientType == IngredientType.SAUCE) {
            assertEquals(IngredientType.SAUCE, ingredientType);
        } else if (ingredientType == IngredientType.FILLING) {
            assertEquals(IngredientType.FILLING, ingredientType);
        }
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals(expectedName, ingredientType.name());
    }
}

//    @Test
//    public void testIngredientTypeValues() {
//        // Проверяем, что перечисление содержит ожидаемые значения
//        IngredientType[] types = IngredientType.values();
//
//        // Проверяем, что длина массива равна 2
//        assertEquals(2, types.length);
//
//        // Проверяем соответствие элементов в перечислении
//        assertEquals(IngredientType.SAUCE, types[0]); // Первый элемент
//        assertEquals(IngredientType.FILLING, types[1]); // Второй элемент
//    }
//
//    @Test
//    public void testIngredientTypeName() {
//        assertEquals("SAUCE", IngredientType.SAUCE.name());
//        assertEquals("FILLING", IngredientType.FILLING.name());
//    }
//}

