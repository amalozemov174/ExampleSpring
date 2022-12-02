import org.example.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.*;

import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Storage storage = context.getBean(Storage.class);
        System.out.println(storage);

        Absolute absolute = context.getBean(Absolute.class);
        absolute.addProdut(new Vodka(), storage);
        absolute.addProdut(new Vodka(), storage);
        absolute.addProdut(new Vodka(), storage);

        Aist aist = context.getBean(Aist.class);
        aist.addProdut(new Bycicle(), storage);
        aist.addProdut(new Bycicle(), storage);
        aist.addProdut(new Bycicle(), storage);

        System.out.println(storage.getProducts());
        storage.processProducts();

        Petrovich petrovich = context.getBean(Petrovich.class);
        Rishar rishar = context.getBean(Rishar.class);

        Product[] productRemove = new Product[2];
        for (Map.Entry<String, Product> product : storage.getProducts().entrySet()) {
            if(product.getValue().getIsBroken() && productRemove[0] == null) {
                productRemove[0] = product.getValue();
                continue;
            }
            else if(!product.getValue().getIsBroken() && productRemove[0] == null) {
                productRemove[1] = product.getValue();
                continue;
            }
        }
        petrovich.getProduct(storage, productRemove[0]);
        rishar.getProduct(storage, productRemove[1]);
        System.out.println(storage.getProducts());

    }

}
