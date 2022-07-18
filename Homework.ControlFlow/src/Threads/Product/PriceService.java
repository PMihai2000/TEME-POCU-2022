package Threads.Product;

public class PriceService {
    private ProductService productService;


    public PriceService(ProductService productService) {
        this.productService = productService;
    }

    public double getPrice(Product product){
        return product.getPrice();
    }


}
