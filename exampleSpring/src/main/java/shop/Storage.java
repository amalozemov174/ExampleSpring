package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Storage {

    private Mishka mishka;
    private Zely zely;
    private Map <String, Product> products;

    @Autowired
    public Storage(Mishka mishka, Zely zely, Map <String, Product> products) {
        this.mishka = mishka;
        this.zely = zely;
        this.products = products;
    }

    public void setProducts(Product product) {
        this.products.put(product.toString(), product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void processProducts() {
        for (Map.Entry<String, Product> product: products.entrySet()) {
            mishka.damageProduct(product.getValue());
        }
    }

    public Map <String, Product> getProducts() {
        return this.products;
    }
}
