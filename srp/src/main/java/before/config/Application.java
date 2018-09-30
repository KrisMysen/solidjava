package before.config;

import before.Customer;
import before.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        Customer customer = customerService.createCustomer("Kristoffer", "kristoffer.mysen@bouvet.no");

        System.out.println(customer);
    }

}
