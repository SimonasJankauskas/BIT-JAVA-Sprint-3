package lt.simonasjankauskas.app;

public class Product {
    int ID;
    private String name;
    private double price;

    public Product(int ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }
//    public int getID() {return this.ID;}
//
//    public double getPrice() {
//        return this.price;
//    }
//
//    public String getName() {
//        return this.name;
//    }


    @Override
    public String toString() {
        return
                "Product ID: " + ID +
                "\nProduct name: " + name +
                "\nProduct price: " + price + "Eur";
    }


}
