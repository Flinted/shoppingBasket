package shopper;
import java.util.*;
import interfaces.*;

public class NonPerishableItem extends Item implements Shoppable{
    
    public NonPerishableItem(String name, double price, boolean discountable){
        super(name,price,discountable);
    }

}