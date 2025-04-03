package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelServiceStrategyImpl implements ServiceStrategy {
    private BouwsteenRepo repo;
    private BouwsteenAdapter adapter;
    //    @Value("${hotel.url}")
    private final String API_URL = "";
    //    @Value("${hotel.key}")
    private final String API_KEY = "";

    public HotelServiceStrategyImpl() {
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
    public void getApiData() {
        //todo: beter invullen
        System.out.println("Dit is API-data van de trip-API. Doe alsof je JSON ziet.");
    }
}
