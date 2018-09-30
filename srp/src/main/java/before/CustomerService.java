package before;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    public Customer createCustomer(String name, String email) {

        // Validate
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name can not be null");
        }
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (StringUtils.isEmpty(email) || !emailMatcher.matches()) {
            throw new IllegalArgumentException("Email is empty or is invalid");
        }

        // Create customer
        Customer customer = Customer.builder()
                .name(name)
                .email(email)
                .build();

        // Persist customer
        String fileName = name + ".data";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(customer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customer;
    }

}
