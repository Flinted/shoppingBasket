package shopper;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class Till{

  private Discounter discounter;
  private HashMap<String,Double> currentSale;


  public Till(Discounter discounter){
    this.discounter = discounter;
  }

  public void processBasket(Basket basket, boolean discountCard){
    HashMap<String,Counter> items = basket.getItems();
    this.currentSale = discounter.checkAllDiscounts(items,discountCard);
    display();
  }
  public HashMap<String,Double> returnSaleAsFigures(){
    return currentSale;
  }

  public String getCurrentSale(){
    DecimalFormat dec = new DecimalFormat("#.00");
    double subTotal = currentSale.get("subtotal");
    double discount = currentSale.get("discount");
    double total = currentSale.get("total");

    String displaysubTotal = dec.format(subTotal);
    String displaydiscount = dec.format(discount);
    String displaytotal = dec.format(total);

    String currentSaleInfo = "SubTotal: £" + displaysubTotal  + ", Discount: £" + displaydiscount + ", Total: £" + displaytotal ;
    return currentSaleInfo;
  }

  public void display(){
    System.out.println(getCurrentSale());
  }

}