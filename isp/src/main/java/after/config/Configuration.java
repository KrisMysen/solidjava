package after.config;

import after.*;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public CustomerService customerService(CustomerValidator validator, CustomerWriter customerWriter) {
        return new CustomerService(validator, customerWriter);
    }

    @Bean
    public CustomerWriter customerWriter() {
        return new CloudCustomerStorage();
    }

    @Bean
    public CustomerValidator customerValidator() {
        return new SimpleCustomerValidator();
    }
}
