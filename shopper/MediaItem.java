package shopper;
import java.util.*;
import interfaces.*;

public class MediaItem extends Item implements Shoppable{
    
    public MediaItem(String name, double price, boolean discountable){
        super(name,price,discountable);
    }
}