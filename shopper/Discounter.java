package shopper;
import java.util.ArrayList;
import java.util.HashMap;

public class Discounter{
  private double subTotal;
  private double discount;
  private double total;

  public Discounter(){
    subTotal = 0.00;
    discount = 0.00;
    total = 0.00;
  }
  public HashMap<String, Double> checkAllDiscounts(HashMap<String,Counter> items, boolean discountCard){
    setSubTotal(items);
    checkBOGOF(items);
    checkTenPercent();
    checkLoyaltyCard(discountCard);
    setTotal();
    return prepareData();
  }

  public double getDiscount(){
    return this.discount;
  }

  public double getSubTotal(){
    return this.subTotal;
  }

  public double getTotal(){
    return this.total;
  }

  public void setSubTotal(HashMap<String,Counter> items){
    double basketTotal = 0.00;
    for(Counter item : items.values()){
      basketTotal += item.total();
    }
    subTotal = basketTotal;
  }

  public void checkBOGOF(HashMap<String,Counter> items){
    double bogofDiscount = 0.00;
    for(Counter item : items.values()){
      double price = item.getPrice();
      int count = item.getCount();
      double itemDiscount = 0.00;
      if(!item.getTemplate().getDiscountable()){
        System.out.println("Hit");
        itemDiscount = 0.00;
      }else if(count % 2 == 1){
        itemDiscount = price * ((count-1)/2);
      }else{
        itemDiscount = price * count/2;
      }
      bogofDiscount += itemDiscount;
    }
    discount = bogofDiscount;
  }

  public void checkTenPercent(){
    if(subTotal-discount >= 20.00){
      double tenPercent = (subTotal - discount) * 0.1;
      discount = discount + tenPercent;
    }
  }

  public void checkLoyaltyCard(boolean discountCard){
    if(discountCard){
      double loyaltyDiscount = (subTotal-discount) * 0.02;
      discount = discount + loyaltyDiscount;
    }
  }

  public void setTotal(){
    total = subTotal - discount;
  }

  public HashMap<String, Double> prepareData(){
    HashMap<String, Double> salesInfo =  new HashMap<String, Double>();
    salesInfo.put("subtotal",subTotal);
    salesInfo.put("discount", discount);
    salesInfo.put("total",total);
    return salesInfo;
  }


}