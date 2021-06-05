package objects;

import java.util.ArrayList;
import java.util.List;

public class ListOfProductsOffered {

    List<Product> listOfProductsOffered = new ArrayList<>(6);

    public void addProductToList(Product product) {
        listOfProductsOffered.add(product);
    }

    public List<String> getProductsNames() {
        List<String> productsNames = new ArrayList<>(6);
        for (int i = 0; i < listOfProductsOffered.size(); i++) {
            productsNames.add(listOfProductsOffered.get(i).getProductName());
        }
        return productsNames;
    }

    public List<String> getProductsPrices() {
        List<String> productsPrices = new ArrayList<>(6);
        for (int i = 0; i < listOfProductsOffered.size(); i++) {
            productsPrices.add(listOfProductsOffered.get(i).getProductPrice());
        }
        return productsPrices;
    }
}
