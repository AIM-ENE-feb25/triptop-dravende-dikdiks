package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
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
    public void getBouwstenen(Bouwsteen bouwsteen) {
        repo.getAllBouwstenen(bouwsteen);
    }

    @Override
    public void getBouwsteenDataById(int id, Bouwsteen bouwsteen) {
        repo.getBouwsteen(id, bouwsteen);
    }

    @Override
    public void getApiData() {
        //todo: beter invullen
        System.out.println("Dit is API-data van de trip-API. Doe alsof je JSON ziet.");
    }
}
