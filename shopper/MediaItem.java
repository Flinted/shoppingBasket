package shopper;
import java.util.*;
import interfaces.*;

public class MediaItem extends Item implements Shoppable{
  private int review;

  public MediaItem(String name, double price, boolean discountable){
    super(name,price,discountable);
  }

  public void review(int reviewNumber){
    if(reviewNumber<=10){
      this.review = reviewNumber;
    }
  }

  public int getReview(){
    return this.review;
  }

}