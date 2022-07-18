package Threads;
/*      Play with CompletableFuture class (maybe after the Streams and Lambdas presentation):
==========================================================================================
*   ProductService class with method Product getProduct(int id)
*   PriceService class with method double getPrice(Product product) – depends on previous class
*   PriceDealService with method double getPriceAdjustment() – independent calculation
*   use CompletableFutures to calculate the final price for a product
*   add some error handling, in case the product is not found (for example)
*/

import Threads.Product.PriceDealService;
import Threads.Product.PriceService;
import Threads.Product.Product;
import Threads.Product.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static List<Product> generateTestProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Bread", 1f));
        products.add(new Product("Eggs", 5.4f));
        products.add(new Product("Chesse", 10.2f));
        products.add(new Product("Milk", 15.2f));
        products.add(new Product("Peanuts", 7.3f));
        products.add(new Product("Banana", 4.4f));
        products.add(new Product("Apple", 2.6f));
        products.add(new Product("Hammer", 9.4f));
        products.add(new Product("Towel", 10.2f));
        products.add(new Product("Lighter", 2.5f));
        products.add(new Product("Pan", 60.5f));
        products.add(new Product("Fork", 2.35f));

        return products;
    }


    public static void main(String[] args) {
        Random rnd = new Random();
        List<Product> products = generateTestProducts();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ProductService productService = new ProductService(products);

        PriceService priceService = new PriceService(productService);

        int countQueriesThread1 = 20,
            countQueriesThread2 = 30,
            countQueriesThread3 = 10;

        CompletableFuture result = null;
        for (int i = 0; i < countQueriesThread1; i++) {
            result = CompletableFuture.runAsync(() -> {

                int idProduct = rnd.nextInt(products.size() + 4);
                Product product = productService.getProduct(idProduct);

                try {
                    System.out.println(Thread.currentThread().getName() + ".Final price price for " + product + ": " + product.getPrice() * PriceDealService.getPriceAdjustment());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (NullPointerException e) {
                    System.out.println(Thread.currentThread().getName() + ".Product with id=" + idProduct + " have not been found!");
                }
            });
        }
        for (int i = 0; i < countQueriesThread2; i++) {
            result = CompletableFuture.runAsync(() -> {

                int idProduct = rnd.nextInt(products.size()+4);
                Product product = productService.getProduct(idProduct);

                try {
                    System.out.println(Thread.currentThread().getName() + ".Final price price for " + product + ": " + product.getPrice() * PriceDealService.getPriceAdjustment());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }catch(NullPointerException e){
                    System.out.println(Thread.currentThread().getName() +".Product with id="+idProduct+" have not been found!");
                }


            });
        }
        for (int i = 0; i < countQueriesThread3; i++) {
            result = CompletableFuture.runAsync(() -> {

                int idProduct = rnd.nextInt(products.size() + 4);
                Product product = productService.getProduct(idProduct);

                try {
                    System.out.println(Thread.currentThread().getName() + ".Final price price for " + product + ": " + product.getPrice() * PriceDealService.getPriceAdjustment());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (NullPointerException e) {
                    System.out.println(Thread.currentThread().getName() + ".Product with id=" + idProduct + " have not been found!");

                }

            });
        }
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
