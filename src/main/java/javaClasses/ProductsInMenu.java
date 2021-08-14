package javaClasses;

import java.util.HashMap;
import java.util.Map;

public class ProductsInMenu {
    public static final String Products = "products";
    private Map<Product, Integer> productsInMenu;
    private double totalPrice;
    private String restaurantId;


    public ProductsInMenu(){
        productsInMenu = new HashMap<>();
        totalPrice = 0;
    }


    //adds new item in menu
    public void addProduct(Product product, String restaurantId){
        this.restaurantId = restaurantId;

        boolean contains = false;
        Product containedProduct = null;
        for(Product currProduct : productsInMenu.keySet()){
            if (currProduct.getProductName().equals(product.getProductName())) {
                contains = true;
                containedProduct = currProduct;
                break;
            }
        }
        if (contains) {
            int newQuantity = productsInMenu.get(containedProduct) + 1;
            productsInMenu.put(containedProduct, newQuantity);
        } else {
            productsInMenu.put(product, 1);
        }
        totalPrice += product.getProductPrice();
    }

    //returns products in menu
    public Map<Product, Integer> getProductsInMenu(){
        return productsInMenu;
    }

    //resets menu
    public void clearMenu(){
        productsInMenu.clear();
        restaurantId = null;
        totalPrice = 0;
    }

    //return total price of products in menu
    public double getTotalPrice(){
        return totalPrice;
    }


    //updates values and quantities when update menu button is pressed
    public void setProductsInCart(Product product, int quantity){
        int oldQuantity = 0;
        if (productsInMenu.containsKey(product))
            oldQuantity = productsInMenu.get(product);

        if (oldQuantity == quantity) return;

        if (oldQuantity > quantity){
            totalPrice = totalPrice - product.getProductPrice() * (oldQuantity - quantity);
            productsInMenu.put(product, quantity);

        } else {
            totalPrice = totalPrice + product.getProductPrice() * (quantity - oldQuantity);
            productsInMenu.put(product, quantity);
        }
    }

    //remove unnecessary products
    public void removeZeroQuantities(){
        for(Product currProduct : productsInMenu.keySet()){
            if (productsInMenu.get(currProduct) == 0) {
                productsInMenu.remove(currProduct);
            }
        }
    }

    public String getRestaurantId(){
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId){
        this.restaurantId = restaurantId;
    }

}
