package je.applicatie.domain.soexintegratie.Services;

import jakarta.annotation.Resource;
import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public void getApiData() {
        //todo: beter invullen
        System.out.println("Dit is API-data van de trip-API. Doe alsof je JSON ziet.");
    }
}
