package before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerValidator validator;
    private final CustomerWriter storage;

    @Autowired
    public CustomerService(CustomerValidator validator, CustomerWriter storage) {
        this.validator = validator;
        this.storage = storage;
    }

    public final Customer createCustomer(String name, String email) {

        validator.validateName(name);
        validator.validateEmail(email);

        Customer customer = Customer.builder()
                .name(name)
                .email(email)
                .build();

        storage.write(customer);

        return customer;
    }
}
