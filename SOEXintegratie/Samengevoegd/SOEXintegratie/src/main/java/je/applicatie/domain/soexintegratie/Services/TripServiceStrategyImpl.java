package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TripServiceStrategyImpl implements ServiceStrategy {
    private BouwsteenRepo repo;
    private BouwsteenAdapter adapter;
    //    @Value("${trip.url}")
    private final String API_URL = "";
    //    @Value("${trip.key}")
    private final String API_KEY = "";

    public TripServiceStrategyImpl() {
        this.repo = new BouwsteenRepo();
        this.adapter = new BouwsteenAdapter();
    }

    @Override
    public void saveBouwsteen(Bouwsteen bouwsteen) {
        repo.saveBouwsteen(bouwsteen);
    }

    @Override
    public Bouwsteen getBouwsteenDataById(int id, Bouwsteen bouwsteen) {
        return repo.getBouwsteen(id, bouwsteen);
    }

    @Override
    public List<Bouwsteen> getBouwstenen(Bouwsteen bouwsteen) {
        return repo.getAllBouwstenen(bouwsteen);
    }

    @Override
    public String[][] getApiData() {
        System.out.println("Dit is API-data van de trip-API. Doe alsof je JSON ziet.");
        return new String[0][0];
    }
}
