package je.applicatie.domain.soexintegratie.Repository;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;

public class BouwsteenRepo {

    public void saveBouwsteen(Bouwsteen bouwsteen) {
        System.out.println(STR."De bouwsteen van klasse \{bouwsteen.getClass().getSimpleName().toString()} is toegevoegd aan de database.");
    }
    public void getBouwsteen(int id, Bouwsteen bouwsteen) {
        System.out.println(STR."De bouwsteen van klasse \{bouwsteen.getClass().getSimpleName().toString()} is opgehaald uit de database.");
    }
    public void getAllBouwstenen(Bouwsteen bouwsteen) {
        System.out.println(STR."Alle bouwstenen van klasse \{bouwsteen.getClass().getSimpleName().toString()} zijn opgehaald uit de database.");

    }

}
