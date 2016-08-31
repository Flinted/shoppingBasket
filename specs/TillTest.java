import static org.junit.Assert.*;
import org.junit.*;
import shopper.*;
import interfaces.*;

public class TillTest{
  Shoppable item;
  Shoppable item2;
  Shoppable item3;
  Shoppable item4;
  Basket basket;
  Till till;

  @Before
  public void before(){
    item = new FoodItem("Potato",1.99,false);
    item2 = new MediaItem("DVD",14.99,true);
    item3 = new AlcoholItem("Wine", 5.75, true);
    item4 = new NonPerishableItem("Cloths", 0.50, true);
    basket = new Basket();
    Discounter discounter = new Discounter();
    till = new Till(discounter);
  }

  @Test
  public void tillCanProcessBasket(){
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
    till.processBasket(basket,true);
    assertEquals("SubTotal: £72.95, Discount: £32.41, Total: £40.54",till.getCurrentSale());
    
  }


}