package after;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CloudCustomerStorage implements CustomerReader, CustomerWriter, CloudStorage {

    @Override
    public void write(Customer customer) {
        log.debug("Saving to cloud...");
    }

    @Override
    public Customer read(String name) {
        return Customer.builder()
                .name("F.R.OmCloud")
                .email("cloud@cloud.com")
                .build();
    }

    @Override
    public String getUrl() {
        return "https://mycloud.com";
    }
}
