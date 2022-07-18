package ShopManager.Interfaces;

import ShopManager.Implementations.Shop;

import java.util.List;

public interface IShopManagerCRUD {
    boolean addShop(Shop shop);
    Shop getShop(int id);
    Shop getShop(String name);
    List<Shop> getShops();
    boolean deleteShop(Shop shop);
    boolean deleteShop(int id);
}
