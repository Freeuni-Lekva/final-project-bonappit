package javaClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuReader {
    private final static String fileEnding = "---";


    public List<Product> readMenu(String fileName){
        List<Product> result = new ArrayList<>();

        File tempFile = new File(fileName);
        String tempString = tempFile.getAbsolutePath().substring(0, tempFile.getAbsolutePath().length()-fileName.length());
        File file = new File(tempString + "/src/main/java/javaClasses/menuFiles/" + fileName);

        if(file.canRead()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                boolean first = true;

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    if (!first)
                        line = br.readLine();

                    first = false;

                    if (line.equals(fileEnding))
                        break;

                    int lastSpace = 0;
                    for (int i = line.length() - 1; i >= 0; i--){
                        if (line.charAt(i) == ' ') {
                            lastSpace = i;
                            break;
                        }
                    }

                    String price = line.substring(lastSpace + 2);
                    Double productPrice = Double.parseDouble(price);
                    Product product = new Product(line.substring(0, lastSpace - 1), productPrice);
                    result.add(product);
                }

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
