package shopper;
import java.util.ArrayList;
import interfaces.*;

public class Counter{
  private Shoppable templateItem;
  private int count;

  public Counter(Shoppable item){
    this.templateItem = item;
    count = 1;
  }

  public Shoppable getTemplate(){
    return templateItem;
  }
  public int getCount(){
    return count;
  }

  public double getPrice(){
    return templateItem.getPrice();
  }

  public void addItem(Shoppable item){
   count ++;
 }

 public void removeOne(){
  count--;
}

public double total(){
  double price = templateItem.getPrice();
  return price * this.count;
}



}
