package nl.han.ene.soex.domain.factory;

import nl.han.ene.soex.domain.Bouwsteen;
import nl.han.ene.soex.domain.Overnachting;

import java.util.Map;

public class OvernachtingFactory implements BouwsteenFactory {
    @Override
    public Bouwsteen createBouwsteen(Map<String, Object> details) {
        return new Overnachting(details);
    }
}

