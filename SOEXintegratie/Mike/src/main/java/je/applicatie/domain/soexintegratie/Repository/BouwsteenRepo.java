package je.applicatie.domain.soexintegratie.Repository;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;

import java.util.ArrayList;
import java.util.List;

public class BouwsteenRepo {

    public void saveBouwsteen(Bouwsteen bouwsteen) {
        System.out.println("Bouwsteen van klasse " + bouwsteen.getClass().getSimpleName() + "gemaakt.");
    }
    public Bouwsteen getBouwsteen(int id, Bouwsteen bouwsteen) {
        System.out.println("Bouwsteen van klasse " + bouwsteen.getClass().getSimpleName() + "opgehaald.");
        return bouwsteen;
    }
    public List<Bouwsteen> getAllBouwstenen(Bouwsteen bouwsteen) {
        System.out.println("Alle bouwstenen van klasse " + bouwsteen.getClass().getSimpleName() + "opgehaald.");
        List<Bouwsteen> allBouwstenen = new ArrayList<>();
        allBouwstenen.add(bouwsteen);
        return allBouwstenen;
    }

}
