package g.o.cartlibrary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gerald Phiri
 */
public class Cart {
    private static Map cart=new HashMap<String, CartItem>();

    private boolean isPersist=false;


    //load cart with items on device
    static {
        //ToDo:implement
    }


    public static void add(String key, String name, String price, String url) {
        if (!cart.containsKey(key)) {
            CartItem item=new CartItem(name, price, url);
            cart.put(key,item);
        }
        else{
            CartItem item=(CartItem)cart.get(key);
            item.incrementCount();
        }
        System.out.println("size sss: "+cart.size());
    }


    public void remove(String key){
        cart.remove(key);
    }


    public static CartItem getItem(String key){
        return (CartItem) cart.get(key);
    }//getItem



    public void save(){
        //ToDo:implement
    }


    public void setPersist(boolean persist) {
        isPersist = persist;
    }


    public static java.util.Set getKeys(){
        return cart.keySet();
    }

}//Cart





