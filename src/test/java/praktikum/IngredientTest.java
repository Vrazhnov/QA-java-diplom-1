package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private IngredientType type = SAUCE;
    private String ingredientName = "Secret Krusty ingredient";
    private float ingredientPrice = 9.99F;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        assertEquals(type, ingredient.getType());
    }
}
