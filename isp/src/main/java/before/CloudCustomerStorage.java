package before;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CloudCustomerStorage implements CustomerStorage {

    @Override
    public void save(Customer customer) {
        log.debug("Saving to cloud...");
    }

    @Override
    public Customer get(String name) {
        return Customer.builder()
                .name("F.R.OmCloud")
                .email("cloud@cloud.com")
                .build();
    }

    @Override
    public String getFileLocation() {
        throw new UnsupportedOperationException("Im the cloud...doh!");
    }

    @Override
    public String getUrl() {
        return "https://mycloud.com";
    }
}
