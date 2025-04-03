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
    private String strategy;
    private ServiceStrategy service;
    private Bouwsteen bouwsteen;

    //todo: lists van maken



    private void chooseStrategy(String strategy) {
//        bouwsteen = new Expression(/*klassenaam.class*/, "new", null);


//        Bouwsteen tempBouwsteen;


        //bouwsteen zoeken binnen spring beans
        //custom @bean maken? anders in @component zoeken
        //iets met hashmap bekijken?
        //reflection zoeken op implementaties van interface
        //todo: sowieso ADR van maken?? mogelijk focussen op spring-oplossing
        //todo: ADR maken van eventuele keuze voor switch case als de rest teveel tijd in beslag neemt

        //bouwsteen.getClass().getSimpleName().toString()

//        Constructor<?>[] c = HotelBouwsteen.class.getConstructors();
//        System.out.println(STR."Aantal constructors = \{c.length}");
//        if (c.length > 0) {
//            try {
//                bouwsteen = (Bouwsteen) c[0].newInstance();
//                System.out.println(bouwsteen);
//            } catch (Exception e) {
//                System.out.println(STR."Helaas :(, \{e}");
//            }
//        }

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

    public BouwsteenController(List<ServiceStrategy> serviceStrategyList, List<Bouwsteen> bouwsteenList) {
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

    //todo: kan ik dit dynamisch doen of kan ik beter een if-statement maken?
    //todo: ja, dat kan. gebruik later een van de onderste twee opties
    //todo: key-value pair
    //todo: reflectie??

    //todo: moet ik alleen van happy path uit gaan?
}
