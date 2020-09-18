package g.o.cartlib;


class CartItem{
    private String count;
    private String price;
    private String name;
    private String url;


    public CartItem(String name, String price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
        count="1";
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