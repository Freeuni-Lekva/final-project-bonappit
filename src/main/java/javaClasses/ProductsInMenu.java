package javaClasses;

import java.util.HashMap;
import java.util.Map;

public class ProductsInMenu {
    public static final String Products = "products";
    private Map<String, Integer> productsInMenu;
    private double totalPrice;


    public ProductsInMenu(){
        productsInMenu = new HashMap<>();
        totalPrice = 0;
    }


    //adds new product in cart
    public void addProduct(String productName, String productPrice){
        if (productsInMenu.containsKey(productName)) {
            int newQuantity = productsInMenu.get(productName) + 1;
            productsInMenu.put(productName, newQuantity);
        } else {
            productsInMenu.put(productName, 1);
        }
        totalPrice += Double.parseDouble(productPrice);
    }

    //return map of products in cart
    public Map<String, Integer> getProductsInCart(){
        return productsInMenu;
    }


    //return total price of cart products
    public double getTotalPrice(){
        return totalPrice;
    }


    //method to update values when update cart button is used
    public void setProductsInCart(String productName, int quantity, double productPrice){
        int oldQuantity = productsInMenu.get(productName);
        if (oldQuantity == quantity) return;

        if (oldQuantity > quantity){
            totalPrice = totalPrice - productPrice * (oldQuantity - quantity);
            productsInMenu.put(productName, quantity);

        } else {
            totalPrice = totalPrice + productPrice * (quantity - oldQuantity);
            productsInMenu.put(productName, quantity);
        }
    }
}
