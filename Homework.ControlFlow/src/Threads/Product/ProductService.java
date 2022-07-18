package Threads.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public Product getProduct(int id){
        for (Product product:
             products) {
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    public ProductService(List<Product> products) {
        this.products = products;
    }
}
