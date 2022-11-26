package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bycicle extends Product{
    private Boolean isBroken = false;

    @Override
    public void setBroken(Boolean broken) {
        this.isBroken = broken;
    }

    @Override
    public Boolean getIsBroken() {
        return this.isBroken;
    }

}