package nerdschool.bar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PubPricesTest {

    private Pub pub;

    @BeforeEach
    public void setUp() throws Exception {
        pub = new Pub();
    }

    @Test
    public void oneBeerTest() {
        int actualPrice = pub.computeCost(Pub.ONE_BEER, false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    public void testStudentsGetADiscountForBeer() throws Exception {
        int actualPrice = pub.computeCost(Pub.ONE_BEER, true, 1);
        assertEquals(67, actualPrice);
    }

    @Test
    public void testCidersAreCostly() throws Exception {
        int actualPrice = pub.computeCost(Pub.ONE_CIDER, false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    public void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost(Pub.A_PROPER_CIDER, false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    public void testACocktail() throws Exception {
        int actualPrice = pub.computeCost(Pub.GT, false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testThatADrinkNotInTheSortimentGivesError() throws Exception {
        assertThrows(RuntimeException.class, () -> pub.computeCost("sanfranciscosling", false, 1));
    }

    @Test
    public void testStudentsDoNotGetDiscountsForCocktails() throws Exception {
        int actualPrice = pub.computeCost(Pub.GT, true, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost(Pub.BACARDI_SPECIAL, false, 1);
        assertEquals(127, actualPrice);
    }

    @Test
    public void testCanBuyAtMostTwoDrinksInOneGo() throws Exception {
        assertThrows(RuntimeException.class, () -> pub.computeCost(Pub.BACARDI_SPECIAL, false, 3));
    }

    @Test
    public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() throws Exception {
        int actualPrice = pub.computeCost(Pub.ONE_BEER, true, 2);
        assertEquals(67 * 2, actualPrice);
    }

    @Test
    public void testCanOrderMoreThanTwoBeers() throws Exception {
        pub.computeCost(Pub.ONE_BEER, false, 5);
    }
}
