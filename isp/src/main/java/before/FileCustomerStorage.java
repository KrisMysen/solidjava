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

    @Override
    public Customer get(String name) {
        return Customer.builder()
                .name("Mr.File")
                .email("file@file.com")
                .build();
    }

    @Override
    public String getFileLocation() {
        return "TheFileLocation";
    }

    @Override
    public String getUrl() {
        throw new UnsupportedOperationException("I don't care about the cloud!");
    }
}
