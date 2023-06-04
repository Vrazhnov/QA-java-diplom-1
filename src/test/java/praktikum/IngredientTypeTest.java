package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Стоимость булочки. Тестовые данные: {0} {1} {2}")
    public static Object[][] getTypeData() {
        return new Object[][]{
                {IngredientType.FILLING, "Secret Krusty ingredient", 9.99f},
                {IngredientType.SAUCE, "Secret Krusty sauce", 5.5f},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}
