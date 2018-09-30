package after.config;

import after.Customer;
import after.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        CustomerService customerService = context.getBean(CustomerService.class);

        try {
            Customer customer = customerService.createCustomer("kristoffer", "kristoffer.mysen@bouvet.no");
            System.out.println(customer);
        } catch (IllegalArgumentException e) {
            log.info("We are expecting this....");
        }
    }
}
