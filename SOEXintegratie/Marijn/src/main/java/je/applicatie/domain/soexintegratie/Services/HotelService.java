package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BookincomAdapter;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final BookincomAdapter bookincomAdapter;

    public HotelService(BookincomAdapter bookincomAdapter) {
        this.bookincomAdapter = bookincomAdapter;
    }

    public String callExternalApi() {
        return bookincomAdapter.fetchData("");
    }
}
