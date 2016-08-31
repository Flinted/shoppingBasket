package shopper;
import interfaces.*;

public class AlcoholItem extends Item implements Shoppable{
  
  public AlcoholItem(String name, double price, boolean discountable){
      super(name,price,discountable);
  }

  public boolean ageCheck(int age){
    if(age >= 18){
      return true;
    }else{
      return false;
    }
  }
}