package shopper;
import java.util.ArrayList;
import interfaces.*;

public class Counter{
  private ArrayList<Shoppable> items;
  private int count;
  private boolean bogof;

  public Counter(Shoppable item){
    this.items = new ArrayList<Shoppable>();
    items.add(item);
    bogof = item.getDiscountable();
    count = 1;
  }

  public int getCount(){
    return count;
  }

  public void addItem(Shoppable item){
   items.add(item);
   count ++;
 }

 public void removeOne(){
  items.remove(0);
  count--;
}

public double total(){
  double price = items.get(0).getPrice();
  return price * this.count;
}

public double calculateBOGOF(){
  double price = items.get(0).getPrice();

  if(!bogof){
    return 0.00;
  }else if(count % 2 == 1){
    return price * ((count-1)/2);
  }else{
    return price * count/2;
  }
}

}
