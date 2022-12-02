package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mishka implements Worker{
    private Integer countBroken = 0;

    @Override
    public void getProduct(Product product) {

    }

    @Override
    public void damageProduct(Product product) {
        countBroken++;
        if(countBroken % 2 == 0)
        {
            product.setBroken(true);
        }
    }
}
