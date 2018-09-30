package before;

public interface CustomerStorage {

    void save(Customer customer);

    Customer get(String name);

    String getFileLocation();

    String getUrl();
}
