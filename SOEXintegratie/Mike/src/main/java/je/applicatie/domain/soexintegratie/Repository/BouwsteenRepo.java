package je.applicatie.domain.soexintegratie.Repository;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;

import java.util.ArrayList;
import java.util.List;

public class BouwsteenRepo {

    public void saveBouwsteen(Bouwsteen bouwsteen) {
        System.out.println(STR."De bouwsteen van klasse \{bouwsteen.getClass().getSimpleName().toString()} is toegevoegd aan de database.");
    }
    public Bouwsteen getBouwsteen(int id, Bouwsteen bouwsteen) {
        System.out.println(STR."De bouwsteen van klasse \{bouwsteen.getClass().getSimpleName().toString()} is opgehaald uit de database.");
        return bouwsteen;
    }
    public List<Bouwsteen> getAllBouwstenen(Bouwsteen bouwsteen) {
        System.out.println(STR."Alle bouwstenen van klasse \{bouwsteen.getClass().getSimpleName().toString()} zijn opgehaald uit de database.");
        List<Bouwsteen> allBouwstenen = new ArrayList<>();
        allBouwstenen.add(bouwsteen);
        return allBouwstenen;
    }

}
