package after;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CloudCustomerStorage implements CustomerStorage{

    @Override
    public void save(Customer customer) {
        log.debug("Saving to cloud...");
    }
}
