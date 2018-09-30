package before;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class FileCustomerStorage implements CustomerStorage {

    @Override
    public void save(Customer customer) {
        log.debug("Saving to file...");
        String fileName = customer.getName() + ".data";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(customer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
