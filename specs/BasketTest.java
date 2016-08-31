import static org.junit.Assert.*;
import org.junit.*;
import shopper.*;
import interfaces.*;

public class BasketTest{
    Shoppable item;
    Shoppable item2;
    Shoppable item3;
    Shoppable item4;
    Basket basket;

    @Before
    public void before(){
      item = new FoodItem("Potato",1.99,false);
      item2 = new MediaItem("DVD",14.99,true);
      item3 = new AlcoholItem("Wine", 5.75, true);
      item4 = new NonPerishableItem("Cloths", 0.50, true);
      basket = new Basket();
    }

    @Test
    public void shouldStartEmpty(){
      assertEquals(0,basket.countBasket());
    }

    @Test
    public void shouldBeAbleToAddItems(){
      basket.addToBasket(item);
      basket.addToBasket(item2);
      assertEquals(2,basket.countBasket());
    }

    @Test
    public void shouldIncreaseCountIfItemInBasket(){
      basket.addToBasket(item);
      basket.addToBasket(item);
      assertEquals(1,basket.countBasket());
      assertEquals(2, basket.countItemInBasket(item));
    }

    @Test
    public void shouldBeAbleToRemoveItems(){
      basket.addToBasket(item);
      basket.addToBasket(item);
      basket.removeFromBasket(item);
      assertEquals(1, basket.countBasket());
    }

    @Test
    public void shouldRemoveCounterWhenAllItemsRemoved(){
      basket.addToBasket(item);
      basket.removeFromBasket(item);
      assertEquals(0, basket.countBasket());
    }

}
