package testClasses;

import javaClasses.Product;
import javaClasses.ProductsInMenu;
import junit.framework.TestCase;


public class testProductsInMenu extends TestCase {

    public void testaddProuct(){
        ProductsInMenu productsInMenu = new ProductsInMenu();

        productsInMenu.addProduct(new Product("a", 2), "1");
        productsInMenu.addProduct(new Product("b", 2), "1");
        productsInMenu.addProduct(new Product("c", 2), "1");
        assertEquals(3, productsInMenu.getProductsInMenu().size());

        productsInMenu.addProduct(new Product("a", 2), "1");
        productsInMenu.addProduct(new Product("a", 2), "1");
        assertEquals(3, productsInMenu.getProductsInMenu().size());

        productsInMenu.addProduct(new Product("d", 2), "1");
        assertEquals(4, productsInMenu.getProductsInMenu().size());
    }

    public void testclearMenu(){
        ProductsInMenu productsInMenu = new ProductsInMenu();

        productsInMenu.addProduct(new Product("a", 2), "1");
        productsInMenu.addProduct(new Product("b", 2), "1");
        productsInMenu.addProduct(new Product("c", 2), "1");
        assertEquals(3, productsInMenu.getProductsInMenu().size());

        productsInMenu.clearMenu();
        assertEquals(0, productsInMenu.getProductsInMenu().size());

        productsInMenu.addProduct(new Product("b", 2), "1");
        productsInMenu.addProduct(new Product("c", 2), "1");
        assertEquals(2, productsInMenu.getProductsInMenu().size());

    }

    public void testgetTotalPrice(){
        ProductsInMenu productsInMenu = new ProductsInMenu();

        productsInMenu.addProduct(new Product("a", 2), "1");
        productsInMenu.addProduct(new Product("b", 2), "1");
        productsInMenu.addProduct(new Product("c", 2), "1");
        assertEquals(6.0, productsInMenu.getTotalPrice());

        productsInMenu.clearMenu();
        assertEquals(0.0, productsInMenu.getTotalPrice());

        productsInMenu.addProduct(new Product("asd", 100.2), "1");
        assertEquals(100.2, productsInMenu.getTotalPrice());
    }

    public void testsetProcuts() {
        ProductsInMenu productsInMenu = new ProductsInMenu();

        productsInMenu.addProduct(new Product("a", 2), "1");
        productsInMenu.addProduct(new Product("b", 2), "1");
        productsInMenu.addProduct(new Product("c", 2), "1");
        assertEquals(3, productsInMenu.getProductsInMenu().size());

        productsInMenu.clearMenu();
        Product pr = new Product("a", 2);
        productsInMenu.setProductsInCart(pr, 5);
        int temp = productsInMenu.getProductsInMenu().get(pr);
        assertEquals(5, temp);
    }

    public void testIds() {
        ProductsInMenu productsInMenu = new ProductsInMenu();

        productsInMenu.addProduct(new Product("a", 2), "1");
        productsInMenu.addProduct(new Product("b", 2), "1");
        productsInMenu.addProduct(new Product("c", 2), "1");

        assertEquals("1", productsInMenu.getRestaurantId());

        productsInMenu.setRestaurantId("3");
        assertEquals("3", productsInMenu.getRestaurantId());
    }

}
