package je.applicatie.domain.soexintegratie.Controllers;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Domain.HotelBouwsteen;
import je.applicatie.domain.soexintegratie.Domain.TripBouwsteen;
import je.applicatie.domain.soexintegratie.Services.HotelServiceStrategyImpl;
import je.applicatie.domain.soexintegratie.Services.ServiceStrategy;
import je.applicatie.domain.soexintegratie.Services.TripServiceStrategyImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BouwsteenController {
    private ServiceStrategy service;
    private Bouwsteen bouwsteen;


    private void chooseStrategy(String strategy) {
        switch (strategy) {
            case "hotel":
                service = new HotelServiceStrategyImpl();
                bouwsteen = new HotelBouwsteen();
                break;
            case "trip":
                service = new TripServiceStrategyImpl();
                bouwsteen = new TripBouwsteen();
                break;
            default:
                service = null;
                break;
        }
    }

    public BouwsteenController() {
        this.service = null;
        this.bouwsteen = null;
    }

    @PostMapping("/{strategy}/boeken")
    public void boekBouwsteen(@PathVariable String strategy, @RequestBody Map<String, String> body) {
        chooseStrategy(strategy);
        bouwsteen.setDetails(body);
        try {
            service.saveBouwsteen(bouwsteen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{strategy}/getOne/{id}")
    public void getOneBouwsteen(@PathVariable String strategy, @PathVariable int id) {
        chooseStrategy(strategy);
        try {
            service.getBouwsteenDataById(id, bouwsteen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{strategy}/getAll")
    public void getAllBouwstenen(@PathVariable String strategy) {
        chooseStrategy(strategy);
        try {
            service.getBouwstenen(bouwsteen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{strategy}/getApiData")
    public void getApiData(@PathVariable String strategy) {
        chooseStrategy(strategy);
        try {
            service.getApiData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo: kan ik dit dynamisch doen of kan ik beter een if-statement maken?
    //todo: ja, dat kan. gebruik later een van de onderste twee opties
    //todo: key-value pair
    //todo: reflectie??

    //todo: moet ik alleen van happy path uit gaan?
}
