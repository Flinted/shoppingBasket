package shopper;
import java.util.HashMap;
import interfaces.*;


public class Basket{

  HashMap<String, Counter> items;

  public Basket(){
    items = new HashMap<String, Counter>();
  }

  public int countBasket(){
    return items.size();
  }

  public int countItemInBasket(Shoppable item){
    String name = item.getName();
    Counter counter = items.get(name);
    return counter.getCount();
  }

  public void addToBasket(Shoppable item){
    String name = item.getName();
    if (!items.containsKey(name)) {
        items.put(name, new Counter(item));
    } else {
        items.get(name).addItem(item);
    }
  }

  public void emptyBasket(){
    items.clear();
  }

  public HashMap<String,Counter> getItems(){
    return items;
  }

  public void removeFromBasket(Shoppable item){
      String name = item.getName();
      if (items.get(name).getCount() == 1) {
          items.remove(name);
      } else {
          items.get(name).removeOne();
      }
    }
  
}