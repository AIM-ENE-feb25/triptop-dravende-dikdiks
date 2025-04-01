package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
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
    public void getBouwstenen(Bouwsteen bouwsteen) {
        repo.getAllBouwstenen(bouwsteen);
    }

    @Override
    public void getBouwsteenDataById(int id, Bouwsteen bouwsteen) {
        repo.getBouwsteen(id, bouwsteen);
    }

    @Override
    public void getApiData() {
        System.out.println("Dit is API-data van de trip-API. Doe alsof je JSON ziet.");
    }
}
