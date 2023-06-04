package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Некорректная булочка", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Некорректное количество ингридиентов", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Некорректное количество ингридиентов", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        assertEquals("Первым ингридиентом должен быть соус", IngredientType.SAUCE, burger.ingredients.get(0).getType());
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(9.99F);
        assertEquals("Некорректная цена бургера", 19.98F, burger.getPrice(), 0F);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), ingredient.getType().toString().toLowerCase(), ingredient.getName(),
                bun.getName(), bun.getPrice() * 2 + ingredient.getPrice());
        assertEquals("Некорректный состав бургера", expectedReceipt, burger.getReceipt());
    }
}