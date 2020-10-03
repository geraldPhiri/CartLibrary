package g.o.cartlibrary;


import androidx.annotation.Nullable;

public class CartItem{
    private String count;
    private String price;
    private String name;
    private String url;


    public CartItem(String name, String price, String url, @Nullable String count) {
        this.name = name;
        this.price = price;
        this.url = url;

        this.count = "1";
        if(count!=null){
            this.count=count;
        }

    }


    public String getName() {
        return name;
    }



    public String getPrice() {
        return price;
    }


    public String getCount() {
        return count;
    }


    public void incrementCount(){
        count=(Integer.parseInt(count)+1)+"";
    }


    public void decrementCount(){
        if(count!="0") {
            count = (Integer.parseInt(count) - 1)+"";
        }
    }


    public String getUrl() {
        return url;
    }


}//CartItem