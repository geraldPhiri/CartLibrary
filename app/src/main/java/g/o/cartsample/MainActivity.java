package g.o.cartsample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import g.o.cartlibrary.Cart;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart=new Cart(this);
        cart.setPersist(true);

        cart.add("1", "2","3" , null);
        cart.add("11", "22","33" , null);

        try {
            cart.save();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}