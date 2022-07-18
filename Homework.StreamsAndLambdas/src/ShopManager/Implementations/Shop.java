package ShopManager.Implementations;

import ShopManager.Interfaces.IProductCRUD;
import ShopManager.ProductType;

import java.util.*;

public class Shop implements IProductCRUD {
    private static int SHOP_ID = 0;

    private int id;
    private String name;
    private ProductType productType;
    private List<Product> products;
    private int startingYear;

    public Shop(String name, ProductType productType,int startingYear) {
        this.id = SHOP_ID++;
        this.name = name;
        this.productType = productType;
        this.startingYear = startingYear;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(int startingYear) {
        this.startingYear = startingYear;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean addProduct(Product product) {
        if(productType != product.getProductType() || products.contains(product)){
            return false;
        }
        return products.add(product);
    }

    @Override
    public Product getProduct(int id) {
        for (Product product:
             products) {
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProduct(String name) {
        for (Product product :
                products) {
            if (product.getName() == name) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    @Override
    public boolean deleteProduct(int id) {
        Product product = products.stream().filter((prod)-> prod.getId()==id).findAny().get();

        if(product!=null){
            return products.remove(product);
        }

        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return products.remove(product);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id || Objects.equals(name, shop.name) && productType == shop.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productType);
    }
}
