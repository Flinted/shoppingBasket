package shopper;
import java.util.*;
import java.text.*;
import interfaces.*;

public abstract class Item implements Shoppable{
  private String name;
  private double price;
  private boolean discountable;

  public Item(String name, double price, boolean discountable){
    this.name = name;
    this.price = price;
    this.discountable = discountable;
  }

  public String getName(){
    return this.name;
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