package javaClasses;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MenuReader {


    public Map<String, Integer> readMenu(String fileName){
        Map<String, Integer> result = new HashMap<>();
        File file = new File("webapp/WEB-INF/menuFiles/" + fileName);
        System.out.println(file.toString());
        if(file.canRead()) {
            System.out.println("ss");
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                int lastSpace = 0;
                for (int i = everything.length() - 1; i >= 0; i--){
                    if (everything.charAt(i) == ' ') {
                        lastSpace = i;
                        break;
                    }
                }

                String price = everything.substring(lastSpace + 2, everything.length());
                int productPrice = Integer.parseInt(price);
                result.put(everything.substring(0, lastSpace), productPrice);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
