import static org.junit.Assert.*;
import org.junit.*;
import shopper.*;
import interfaces.*;

public class DiscounterTest{
  Shoppable item;
  Shoppable item2;
  Shoppable item3;
  Shoppable item4;
  Basket basket;
  Discounter discounter;

  @Before
  public void before(){
    item = new FoodItem("Potato",1.99,false);
    item2 = new MediaItem("DVD",14.99,true);
    item3 = new AlcoholItem("Wine", 5.75, true);
    item4 = new NonPerishableItem("Cloths", 0.50, true);
    basket = new Basket();
    discounter = new Discounter();
  }

  @Test
  public void discounterShouldAddBOGOF(){
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    discounter.checkBOGOF(basket.getItems());
    assertEquals(29.98,discounter.getDiscount(),0.1);
  }
  @Test
  public void shouldSetSubtotal(){
    basket.addToBasket(item2);
    discounter.setSubTotal(basket.getItems());
    assertEquals(14.99,discounter.getSubTotal(), 0.1);
  }

  @Test
  public void discounterShouldIgnoreOddForBOGOF(){
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    discounter.checkBOGOF(basket.getItems());
    assertEquals(29.98,discounter.getDiscount(),0.1);
  }

  @Test
  public void shouldNotAddTenPercentIfUnderTwenty(){
    basket.addToBasket(item2);
    discounter.setSubTotal(basket.getItems());
    discounter.checkTenPercent();
    assertEquals(0,discounter.getDiscount(),0.1);
  }

  @Test
  public void shouldAddTenPercentIfOverTwenty(){
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    discounter.setSubTotal(basket.getItems());
    discounter.checkTenPercent();
    assertEquals(2.99,discounter.getDiscount(),0.1);
  }

  @Test
  public void shouldAddTwoPercentwithLoyalty(){
    basket.addToBasket(item4);
    basket.addToBasket(item4);
    discounter.setSubTotal(basket.getItems());
    discounter.checkLoyaltyCard(true);
    assertEquals(0.02,discounter.getDiscount(),0.1);
  }

  @Test
  public void shouldNotAddTwoPercentwithoutLoyalty(){
    basket.addToBasket(item4);
    basket.addToBasket(item4);
    discounter.setSubTotal(basket.getItems());
    discounter.checkLoyaltyCard(false);
    assertEquals(0.00,discounter.getDiscount(),0.1);
  }

  @Test
  public void shouldAddAllDiscountsInTurn(){
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    basket.addToBasket(item3);
    basket.addToBasket(item3);
    basket.addToBasket(item3);
    basket.addToBasket(item3);
    basket.addToBasket(item4);
    basket.addToBasket(item4);
    discounter.checkAllDiscounts(basket.getItems(),true);
    assertEquals(32.41,discounter.getDiscount(),0.1);
    assertEquals(72.95,discounter.getSubTotal(),0.1);
    assertEquals(40.54,discounter.getTotal(),0.1);
  }


}