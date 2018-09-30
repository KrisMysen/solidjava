package before;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerValidator validator = new CustomerValidator();
    private final CustomerStorage storage = new CustomerStorage();

    public Customer createCustomer(String name, String email) {

        validator.validateName(name);
        validator.validateEmail(email);

        Customer customer = Customer.builder()
                .name(name)
                .email(email)
                .build();

        storage.writeToFile(name, customer);

        return customer;
    }
}
