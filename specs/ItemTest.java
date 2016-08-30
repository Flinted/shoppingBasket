import static org.junit.Assert.*;
import org.junit.*;
import shopper.*;
import interfaces.*;

public class ItemTest{
  Item item;
  Item item2;
  Item item3;
  Item item4;


  @Before
  public void before(){
    item = new FoodItem("Potato",1.99,false);
    item2 = new MediaItem("DVD",14.99,true);
    item3 = new AlcoholItem("Wine", 5.75, true);
    item4 = new NonPerishableItem("Cloths", 0.50, true);
  }

  @Test
  public void shouldHaveAPrice(){
    assertEquals(1.99, item.getPrice(),0.01);
  }

  @Test
  public void shouldHaveDiscountableVariable(){
    assertEquals(true, item2.getDiscountable());
    assertEquals(false, item.getDiscountable());
  }

  @Test
  public void shouldBeAbleToSetDiscountable(){
    item.toggleDiscountable();
    assertEquals(true, item.getDiscountable());
  }

  @Test
  public void shouldBeAbleToSetNotDiscountable(){
    item2.toggleDiscountable();
    assertEquals(false, item.getDiscountable());
  }
}