package objects;

public class Product {

    String productItemName;
    String productPrice;

    public Product(String productItemName, String productPrice) {
        this.productItemName = productItemName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productItemName;
    }

    public String getProductPrice() {
        return productPrice;
    }
}