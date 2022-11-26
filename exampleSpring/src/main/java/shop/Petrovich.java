package shop;

import org.springframework.stereotype.Component;

@Component
public class Petrovich implements Buyer{
    Product product;

    @Override
    public void getProduct(Storage storage, Product product) {
        if (product.getIsBroken()){
            if (this.product != null) {

            }
            else {
                storage.removeProduct(product);
                this.product = product;
            }
        }
    }
}
