package je.applicatie.domain.soexintegratie.Domain.factory;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Domain.Vervoer;
import je.applicatie.domain.soexintegratie.Domain.factory.BouwsteenFactory;

import java.util.Map;

public class VervoerFactory implements BouwsteenFactory {
    @Override
    public Bouwsteen createBouwsteen(Map<String, Object> details) {
        return new Vervoer(details);
    }
}

