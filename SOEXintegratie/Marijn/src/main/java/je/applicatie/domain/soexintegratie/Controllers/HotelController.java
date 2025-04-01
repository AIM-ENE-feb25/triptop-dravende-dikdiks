package je.applicatie.domain.soexintegratie.Controllers;

import je.applicatie.domain.soexintegratie.Services.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HotelController {

    private final HotelService HotelService;

    public HotelController(HotelService HotelService) {
        this.HotelService = HotelService;
    }

    @GetMapping("/external")
    public String callExternalApi() {
        return HotelService.callExternalApi();
    }
}
