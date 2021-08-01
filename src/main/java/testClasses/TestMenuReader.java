package testClasses;

import javaClasses.MenuReader;
import junit.framework.TestCase;

import java.util.Map;

public class TestMenuReader extends TestCase {

    public void testReader(){
        MenuReader menuReader = new MenuReader();
        Map<String, Integer> map =  menuReader.readMenu("kfc.txt");

        assertEquals(2.09, map.get(0));
    }
}
