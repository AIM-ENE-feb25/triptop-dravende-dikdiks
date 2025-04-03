package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BookincomAdapter;
import je.applicatie.domain.soexintegratie.Adapters.AirbnbAdapter;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final BookincomAdapter bookincomAdapter;
    private final AirbnbAdapter airbnbAdapter;

    public HotelService(BookincomAdapter bookincomAdapter, AirbnbAdapter airbnbAdapter) {
        this.bookincomAdapter = bookincomAdapter;
        this.airbnbAdapter = airbnbAdapter;
    }

    public String[][] callHotelAPIS() {
        return new String[][]{
                {bookincomAdapter.fetchData("")},
                {airbnbAdapter.fetchData("")}
        };
    }


}
