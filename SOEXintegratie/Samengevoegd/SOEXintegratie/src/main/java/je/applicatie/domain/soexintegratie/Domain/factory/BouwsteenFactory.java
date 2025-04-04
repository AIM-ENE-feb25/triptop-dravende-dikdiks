package je.applicatie.domain.soexintegratie.Domain.factory;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;

import java.util.Map;

public interface BouwsteenFactory {
    Bouwsteen createBouwsteen(Map<String, Object> details);
}
