package testClasses;

import javaClasses.MenuReader;
import javaClasses.Product;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

public class TestMenuReader extends TestCase {

    public void testReader(){
        MenuReader menuReader = new MenuReader();
        List<Product> list =  menuReader.readMenu("kfc.txt");

        assertEquals(1.59, list.get(10).getProductPrice());
        assertEquals(2.09, list.get(0).getProductPrice());
        assertEquals(3.39, list.get(1).getProductPrice());
        assertEquals(2.58, list.get(13).getProductPrice());
        assertEquals("Chicken Pieces one", list.get(0).getProductName());
    }

    public void testReader2(){
        MenuReader menuReader = new MenuReader();
        List<Product> list =  menuReader.readMenu("domino.txt");

        assertEquals(20.0, list.get(0).getProductPrice());
        assertEquals(25.0, list.get(3).getProductPrice());
        assertEquals(3.0, list.get(7).getProductPrice());
        assertEquals("pizza A", list.get(0).getProductName());
        assertEquals("pizza B", list.get(1).getProductName());

    }

    public void testReader3(){
        MenuReader menuReader = new MenuReader();
        List<Product> list =  menuReader.readMenu("randomRestaurant.txt");

        assertEquals(20.0, list.get(0).getProductPrice());
        assertEquals(35.0, list.get(4).getProductPrice());
        assertEquals(3.0, list.get(7).getProductPrice());
        assertEquals("randomrastourant A", list.get(0).getProductName());
        assertEquals("randomrastourant drink1", list.get(5).getProductName());
    }
}
