package nl.han.ene.soex.domain.factory;

import nl.han.ene.soex.domain.Bouwsteen;
import nl.han.ene.soex.domain.Vervoer;

import java.util.Map;

public class VervoerFactory implements BouwsteenFactory {
    @Override
    public Bouwsteen createBouwsteen(Map<String, Object> details) {
        return new Vervoer(details);
    }
}

