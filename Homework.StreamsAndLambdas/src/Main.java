/*
##HOMEWORK - Streams and Lambdas

Create a shop manager that can answer several queries about multiple shops. Each shop contains multiple products.
1.Print the name of each shop in capital letters.
2.Print the name of shops opened after year 2005.
3.Print the name of each product.
4.Print the name of the cheapest product.
5.Print the price sum of all products from technology shops.
6.Print the concatenation of all shop names separated by: "| " using the collect method.
7.Build a list of String consisting of all the product names and their respective price.

 */

import ShopManager.Implementations.*;
import ShopManager.*;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Shop> sampleShops = getTestShops();

        ShopManager shopManager = getTestShopManager(sampleShops);

        testQuery1(shopManager);
        testQuery2(shopManager);
        testQuery3(shopManager);
        testQuery4(shopManager);
        testQuery5(shopManager);
        testQueri6(shopManager);

        System.out.println("7.Build a list of String consisting of all the product names and their respective price.");
        System.out.println("Result: ");
        System.out.println(shopManager.getShops().stream()
                .flatMap(s->s.getProducts().stream())
                .map(p->String.format("%s %f",p.getName(),p.getPrice()))
                .collect(toList()));

        System.out.println();



    }

    private static void testQueri6(ShopManager shopManager) {
        System.out.println("6.Print the concatenation of all shop names separated by: \"| \" using the collect method.");
        System.out.println("Result: ");
        System.out.println(shopManager.getShops().stream()
                .map(Shop::getName)
                .collect(Collectors.joining("|")));
        System.out.println();
    }

    private static void testQuery5(ShopManager shopManager) {
        System.out.println("5.Print the price sum of all products from technology shops.");
        System.out.println("Result: ");
        System.out.println(shopManager.getShops().stream()
                .filter(s->s.getProductType()==ProductType.TECHNOLOGY)
                .flatMap(s->s.getProducts().stream())
                .map(Product::getPrice)
                .reduce(0.0, Double::sum));
        System.out.println();
    }

    private static void testQuery4(ShopManager shopManager) {
        System.out.println("4.Print the name of the cheapest product.");
        System.out.println("Result: ");
        System.out.println(shopManager.getShops().stream()
                .flatMap(s->s.getProducts().stream())
                .min(Comparator.comparingDouble(Product::getPrice)).get().getName());
        System.out.println();
    }

    private static void testQuery3(ShopManager shopManager) {
        System.out.println("3.Print the name of each product.");
        System.out.println("Result: ");
        shopManager.getShops().stream()
                .flatMap(s -> s.getProducts().stream())
                .forEach(p-> System.out.println(p.getName()));
        System.out.println();
    }

    private static void testQuery2(ShopManager shopManager) {
        System.out.println("2.Print the name of shops opened after year 2005.");
        System.out.println("Result: ");
        shopManager.getShops().stream()
                .filter(s->s.getStartingYear()>2005)
                .map(Shop::getName)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void testQuery1(ShopManager shopManager) {
        System.out.println("1.Print the name of each shop in capital letters.");
        System.out.println("Result: ");
        shopManager.getShops().stream()
                .map(s->s.getName().toUpperCase())
                .forEach(System.out::println);
        System.out.println();
    }

    public static ShopManager getTestShopManager(List<Shop> shops){
        ShopManager shopManager = new ShopManager();

        for (Shop shop:
             shops) {
            shopManager.addShop(shop);
        }

        return shopManager;
    }

    private static List<Shop> getTestShops() {
        Product product1 = new Product("Headphones",114.49f,ProductType.TECHNOLOGY);
        Product product2 = new Product("Golden apple",5.45f,ProductType.FOOD);
        Product product3 = new Product("Orange",4.65f,ProductType.FOOD);
        Product product4 = new Product("Orange 5€ SIM card",30.00f,ProductType.TECHNOLOGY);
        Product product5 = new Product("Violin 5 cords ",445.60f,ProductType.MUSICAL_INSTRUMENTS);
        Product product6 = new Product("Bass 6 cords",876.99f,ProductType.MUSICAL_INSTRUMENTS);
        Product product7 = new Product("World of Warcraft - Collector's Edition",399.98f,ProductType.TECHNOLOGY);
        Product product8 = new Product("Sun Glasses - Extra Durable",30.23f,ProductType.CLOTHES);
        Product product9 = new Product("Praise the SUN - T-Shirt",195.27f,ProductType.CLOTHES);


        List<Shop> shops = new ArrayList<>();
        Shop shop1 = new Shop("TechDonnut", ProductType.TECHNOLOGY,2004);
        shop1.addProduct(product1);
        shop1.addProduct(product4);
        shop1.addProduct(product7);

        Shop shop2 = new Shop("BlueTwist", ProductType.CLOTHES,2007);
        shop2.addProduct(product8);
        shop2.addProduct(product9);


        Shop shop3 = new Shop("GameDungeon", ProductType.TECHNOLOGY,2009);
        shop3.addProduct(product1);
        shop3.addProduct(product7);

        Shop shop4 = new Shop("MarraciaTree Shop", ProductType.FOOD,2006);
        shop4.addProduct(product2);
        shop4.addProduct(product3);

        Shop shop5 = new Shop("Heaven's Instruments", ProductType.MUSICAL_INSTRUMENTS,2001);
        shop5.addProduct(product5);
        shop5.addProduct(product6);


        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);
        shops.add(shop4);
        shops.add(shop5);

        return shops;
    }
}