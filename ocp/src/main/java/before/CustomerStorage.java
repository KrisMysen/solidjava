package before;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerStorage {

    void writeToFile(String name, Customer customer) {
        String fileName = name + ".data";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(customer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
