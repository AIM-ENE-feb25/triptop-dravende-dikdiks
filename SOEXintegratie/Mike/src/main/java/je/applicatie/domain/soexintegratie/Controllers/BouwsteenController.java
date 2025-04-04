package je.applicatie.domain.soexintegratie.Controllers;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Domain.HotelBouwsteen;
import je.applicatie.domain.soexintegratie.Domain.TripBouwsteen;
import je.applicatie.domain.soexintegratie.Services.HotelServiceStrategyImpl;
import je.applicatie.domain.soexintegratie.Services.ServiceStrategy;
import je.applicatie.domain.soexintegratie.Services.TripServiceStrategyImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
                bouwsteen = null;
                break;
        }
    }

    public BouwsteenController(List<ServiceStrategy> serviceStrategyList,
                               List<Bouwsteen> bouwsteenList)
    {

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
    public Bouwsteen getOneBouwsteen(@PathVariable String strategy, @PathVariable int id) {
        chooseStrategy(strategy);
        Bouwsteen b = null;
        try {
            b = service.getBouwsteenDataById(id, bouwsteen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @GetMapping("/{strategy}/getAll")
    public List<Bouwsteen> getAllBouwstenen(@PathVariable String strategy) {
        chooseStrategy(strategy);
        List<Bouwsteen> allBouwstenen = null;
        try {
            allBouwstenen = service.getBouwstenen(bouwsteen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allBouwstenen;
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
}
