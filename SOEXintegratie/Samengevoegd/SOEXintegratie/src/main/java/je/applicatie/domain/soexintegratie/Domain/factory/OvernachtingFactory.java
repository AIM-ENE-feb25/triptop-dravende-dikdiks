package je.applicatie.domain.soexintegratie.Domain.factory;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Domain.Overnachting;

import java.util.Map;

public class OvernachtingFactory implements BouwsteenFactory {
    @Override
    public Bouwsteen createBouwsteen(Map<String, Object> details) {
        return new Overnachting(details);
    }
}

