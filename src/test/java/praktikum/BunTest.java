package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BunTest {

    private String bunName = "Krusty bun";
    private float bunPrice = 9.99F;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}