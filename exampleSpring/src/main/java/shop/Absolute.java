package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Absolute implements Supplier {

    @Override
    public void addProdut(Product product, Storage storage) {
        storage.setProducts(product);
    }
}
