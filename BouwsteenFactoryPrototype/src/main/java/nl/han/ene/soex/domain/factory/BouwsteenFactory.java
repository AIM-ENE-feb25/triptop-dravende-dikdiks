package nl.han.ene.soex.domain.factory;

import nl.han.ene.soex.domain.Bouwsteen;

import java.util.Map;

public interface BouwsteenFactory {
    Bouwsteen createBouwsteen(Map<String, Object> details);
}
