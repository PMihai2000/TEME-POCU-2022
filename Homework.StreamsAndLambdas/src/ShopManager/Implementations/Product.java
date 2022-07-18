package ShopManager.Implementations;

import ShopManager.ProductType;

import java.util.Objects;

public class Product{
    private static int PRODUCT_ID=0;

    private int id;
    private String name;
    private double price;
    private ProductType productType;


    public Product(String name, double price, ProductType productType) {
        this.id = PRODUCT_ID++;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id || (name == product.name
                                    && productType==product.productType
                                    && Double.compare(price,product.price)==0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
