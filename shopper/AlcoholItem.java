package shopper;
import java.util.*;
import interfaces.*;

public class AlcoholItem extends Item implements Shoppable{
  public AlcoholItem(String name, double price, boolean discountable){
      super(name,price,discountable);
  }
}