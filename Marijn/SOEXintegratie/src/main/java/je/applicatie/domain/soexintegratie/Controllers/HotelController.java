package je.applicatie.domain.soexintegratie.Controllers;

import je.applicatie.domain.soexintegratie.Services.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/bookingcom")
    public String callBookincom() {
        return hotelService.callBookingcom();
    }

    @GetMapping("/airbnb")
    public String callAirbnb() {
        return hotelService.callAirbnb();
    }
}