package objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListOfProductsOffered {
    private List<Product> listOfProducts = new ArrayList<>(6);

    public void addProductToList(Product product) {
        listOfProducts.add(product);
    }

    public List<String> getListOfProductsNames() {
        List<String> productsNames = new ArrayList<>(6);
        for (int i = 0; i < listOfProducts.size(); i++) {
            productsNames.add(listOfProducts.get(i).getProductName());
        }
        return productsNames;
    }

    public List<String> getListOfProductsPrices() {
        List<String> productsPrices = new ArrayList<>(6);
        for (int i = 0; i < listOfProducts.size(); i++) {
            productsPrices.add(listOfProducts.get(i).getProductPrice());
        }
        return productsPrices;
    }
}
