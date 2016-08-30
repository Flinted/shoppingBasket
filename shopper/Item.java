package shopper;
import java.util.*;
import java.text.*;


public abstract class Item{
  private String name;
  private double price;
  private boolean discountable;

  public Item(String name, double price, boolean discountable){
    this.name = name;
    this.price = price;
    this.discountable = discountable;
  }

  public double getPrice(){
    return this.price;
  }

  public boolean getDiscountable(){
    return this.discountable;
  }

  public void toggleDiscountable(){
    if(this.discountable){
      this.discountable = false;
    }else{
      this.discountable = true;
    }

  }

}