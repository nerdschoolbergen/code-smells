package nerdschool.bar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class PubPricesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Pub pub;

    @Before
    public void setUp() throws Exception {
        pub = new Pub();
    }

    @Test
    public void oneBeerTest() {
        int actualPrice = pub.computeCost(pub.ONE_BEER, false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    public void testStudentsGetADiscountForBeer() throws Exception {
        int actualPrice = pub.computeCost(pub.ONE_BEER, true, 1);
        assertEquals(67, actualPrice);
    }

    @Test
    public void testCidersAreCostly() throws Exception {
        int actualPrice = pub.computeCost(pub.ONE_CIDER, false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    public void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost(pub.A_PROPER_CIDER, false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    public void testACocktail() throws Exception {
        int actualPrice = pub.computeCost(pub.GT, false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testThatADrinkNotInTheSortimentGivesError() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("No such drink");
        pub.computeCost("sanfranciscosling", false, 1);
    }

    @Test
    public void testStudentsDoNotGetDiscountsForCocktails() throws Exception {
        int actualPrice = pub.computeCost(pub.GT, true, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost(pub.BACARDI_SPECIAL, false, 1);
        assertEquals(127, actualPrice);
    }

    @Test
    public void testCanBuyAtMostTwoDrinksInOneGo() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Too many");
        pub.computeCost(pub.BACARDI_SPECIAL, false, 3);
    }

    @Test
    public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() throws Exception {
        int actualPrice = pub.computeCost(pub.ONE_BEER, true, 2);
        assertEquals(67*2, actualPrice);
    }

    @Test
    public void testCanOrderMoreThanTwoBeers() throws Exception {
        pub.computeCost(pub.ONE_BEER, false, 5);
    }
}
