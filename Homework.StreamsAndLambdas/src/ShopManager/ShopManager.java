package ShopManager;

import ShopManager.Implementations.Shop;
import ShopManager.Interfaces.IShopManagerCRUD;

import java.util.ArrayList;
import java.util.List;

public class ShopManager implements IShopManagerCRUD {
    private List<Shop> shopList;

    public ShopManager() {
        this.shopList = new ArrayList<>();
    }

    @Override
    public boolean addShop(Shop shop) {
        if(shopList.contains(shop)){
            return false;
        }
        return shopList.add(shop);
    }

    @Override
    public Shop getShop(int id) {
        for (Shop shop :
                shopList) {
            if (shop.getId() == id) {
                return shop;
            }
        }
        return null;
    }

    @Override
    public Shop getShop(String name) {
        for (Shop shop :
                shopList) {
            if (shop.getName() == name) {
                return shop;
            }
        }
        return null;
    }

    @Override
    public List<Shop> getShops() {
        return List.copyOf(shopList);
    }

    @Override
    public boolean deleteShop(int id) {
        Shop shop = shopList.stream().filter((s)-> s.getId()==id).findAny().get();

        if(shop!=null){
            return shopList.remove(shop);
        }

        return false;
    }

    @Override
    public boolean deleteShop(Shop shop) {
        return shopList.remove(shop);
    }


}
