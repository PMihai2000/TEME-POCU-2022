package ShopManager.Interfaces;

import ShopManager.Implementations.Product;

import java.util.List;

public interface IProductCRUD {
    boolean addProduct(Product product);
    Product getProduct(int id);
    Product getProduct(String name);
    public List<Product> getProducts();
    boolean deleteProduct(Product product);
    boolean deleteProduct(int id);
}
