package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.AirbnbAdapter;
import je.applicatie.domain.soexintegratie.Adapters.BookincomAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelServiceStrategyImpl implements ServiceStrategy {
    private BouwsteenRepo repo;
    private BookincomAdapter bookincomAdapter;
    private AirbnbAdapter airbnbAdapter;

    //    @Value("${hotel.url}")
    private final String API_URL = "";
    //    @Value("${hotel.key}")
    private final String API_KEY = "";

    public HotelServiceStrategyImpl(AirbnbAdapter airbnbAdapter, BookincomAdapter bookincomAdapter) {
        this.repo = new BouwsteenRepo();
        this.bookincomAdapter = bookincomAdapter;
        this.airbnbAdapter = airbnbAdapter;
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
            return new String[][]{
                    {bookincomAdapter.fetchData("")},
                    {airbnbAdapter.fetchData("")}
            };
        }
    }

