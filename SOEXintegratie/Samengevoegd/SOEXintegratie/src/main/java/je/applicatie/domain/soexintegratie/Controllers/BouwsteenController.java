package je.applicatie.domain.soexintegratie.Controllers;

import je.applicatie.domain.soexintegratie.Adapters.AirbnbAdapter;
import je.applicatie.domain.soexintegratie.Adapters.BookincomAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Domain.HotelBouwsteen;
import je.applicatie.domain.soexintegratie.Domain.TripBouwsteen;
import je.applicatie.domain.soexintegratie.Domain.factory.BouwsteenFactory;
import je.applicatie.domain.soexintegratie.Services.BouwsteenService;
import je.applicatie.domain.soexintegratie.Services.HotelServiceStrategyImpl;
import je.applicatie.domain.soexintegratie.Services.ServiceStrategy;
import je.applicatie.domain.soexintegratie.Services.TripServiceStrategyImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BouwsteenController {
    private String strategy;
    private ServiceStrategy service;
    private final BouwsteenService bouwsteenService;
    private Bouwsteen bouwsteen;
    private AirbnbAdapter airbnbAdapter;
    private BookincomAdapter bookincomAdapter;


    private void chooseStrategy(String strategy) {
        switch (strategy) {
            case "hotel":
                service = new HotelServiceStrategyImpl(airbnbAdapter, bookincomAdapter);
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

    public BouwsteenController(List<ServiceStrategy> serviceStrategyList,
                               List<Bouwsteen> bouwsteenList,
                               BookincomAdapter bookincomAdapter,
                               AirbnbAdapter airbnbAdapter,
                               BouwsteenService bouwsteenService)
    {
        this.bouwsteenService = bouwsteenService;
        this.bookincomAdapter = bookincomAdapter;
        this.airbnbAdapter = airbnbAdapter;
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
        System.out.println("Bouwsteen getOneBouwsteen: " + b);
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

    @GetMapping("/{strategy}/getData")
    public String[][] callAPIS(@PathVariable String strategy) {
        chooseStrategy(strategy);
        return service.getApiData();
    }

    @PostMapping("/bouwstenen")
    public ResponseEntity<Bouwsteen> voegBouwsteenToe(@RequestBody Map<String, Object> request) {
        String type = (String) request.get("type");

        String className = "je.applicatie.domain.soexintegratie.Domain.factory." + type + "Factory";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            BouwsteenFactory factory = (BouwsteenFactory) constructor.newInstance();
            Bouwsteen bouwsteen = bouwsteenService.createBouwsteen(factory, request);
            return ResponseEntity.ok(bouwsteen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/bouwstenen/{bouwsteenId}")
    public ResponseEntity<Void> verwijderBouwsteen(@PathVariable Long bouwsteenId) {
        bouwsteenService.deleteBouwsteen(bouwsteenId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bouwstenen/{bouwsteenId}")
    public ResponseEntity<Bouwsteen> haalBouwsteenOp(@PathVariable Long bouwsteenId) {
        Optional<Bouwsteen> bouwsteen = bouwsteenService.getBouwsteenById(bouwsteenId);
        return bouwsteen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
