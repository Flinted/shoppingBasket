package shopper;
import java.util.*;
import interfaces.*;

public class FoodItem extends Item implements Shoppable{
 
  public FoodItem(String name, double price, boolean discountable){
      super(name,price,discountable);
  }


}