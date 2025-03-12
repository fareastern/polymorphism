public class Sale extends Deal {
    public Sale(String productName, int price) {
        super("Продажа " + productName + " на " + price + " руб.", price, 0);
    }
}