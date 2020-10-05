package g.o.cartlibrary;

import android.app.Activity;
import android.content.Context;

import java.io.*;
import java.util.*;

/**
 * @author Gerald Phiri
 */
public class Cart {
    private static Activity activity;

    private final String FILE_CART="cart_file";
    private final String FILE_ISPERSIST="cart_persist";
    private static Map cart=null;

    private static boolean isPersist=false;


    public Cart(Activity activity){
        this.activity=activity;
        cart=new HashMap<String, CartItem>();

        isPersist=getPersistFromFile();
        if(isPersist){
            //load cart from file
            try{
                FileInputStream fis=this.activity.openFileInput("keys");
                Scanner scanner=new Scanner(fis);
                while(scanner.hasNextLine()){
                    FileInputStream fis2 = activity.openFileInput(scanner.nextLine());
                    Scanner scanner2=new Scanner(fis2);

                    add(scanner2.nextLine(),scanner2.nextLine(),
                            scanner2.nextLine(),scanner2.nextLine());

                }//while

            }
            catch (Exception e){

            }



        }
    }//Cart(Activity)


    private boolean getPersistFromFile() {
        try {
            FileInputStream fis=activity.openFileInput(FILE_ISPERSIST);
            Scanner scanner=new Scanner(fis);
            if(scanner.hasNextBoolean()){
                return scanner.nextBoolean();
            }
            return false;

        }
        catch (Exception e){

        }
        return false;
    }


    public void add(String key, String name, String price, String url) {
        if (!cart.containsKey(key)) {
            CartItem item=new CartItem(name, price, url, null);
            cart.put(key,item);
        }
        else{
            CartItem item=(CartItem)cart.get(key);
            item.incrementCount();
        }

    }//add


    public void remove(String key){
        cart.remove(key);
    }//remove


    public CartItem getItem(String key){
        return (CartItem) cart.get(key);
    }//getItem


    public void save() throws IOException{
        try {
            FileOutputStream fos = activity.openFileOutput("keys", Context.MODE_PRIVATE);
            PrintWriter pw=new PrintWriter(fos);

            for(Object key:cart.keySet()){
                pw.println(key);

                FileOutputStream fos2 = activity.openFileOutput(key+"", Context.MODE_PRIVATE);
                PrintWriter pw2=new PrintWriter(fos2);

                CartItem cartItem=(CartItem) cart.get(key);
                pw2.println(cartItem.getName());
                pw2.println(cartItem.getPrice());
                pw2.println(cartItem.getUrl());
                pw2.println(cartItem.getCount());

                pw.flush();

                pw2.close();
            }

            pw.close();

           //Toast.makeText(getApplicationContext(),"key saved on device",Toast.LENGTH_SHORT).show();

        }
        catch(Exception e){
            //Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }

    }//save


    public void setPersist(boolean persist) {
        isPersist = persist;
        try {
            FileOutputStream fos=activity.openFileOutput(FILE_ISPERSIST,0);
            PrintWriter pw=new PrintWriter(fos);
            pw.println(persist);
            pw.close();
            fos.close();

        }
        catch (Exception e){

        }
    }//setPersist


    public java.util.Set getKeys(){
        return cart.keySet();
    }//getKeys


}//Cart


