- De naam en definitie van het principe.
    - Het Open/Closed Principle stelt dat een software-entiteit open moet zijn voor uitbreiding, maar gesloten voor modificatie. Dit betekent dat we bestaande code niet direct aanpassen om nieuwe functionaliteiten toe te voegen, maar in plaats daarvan mechanismen zoals overerving, interfaces of compositie gebruiken.

- De consequenties van het toepassen van het principe.
    - Bestaande functionaliteiten blijven werken
    - Betere testbaarheid doordat nieuwe functionaliteiten word toegevoegd via uitbreidinging van bv: klassen, interfaces, enz, kunnen nieuwe klassen afzonderlijk worden getest zonder oude code te beïnvloeden.
    - Het toepassen van OCP kan leiden tot extra abstractie van klassen en interfaces, wat de codecomplexiteit kan verhogen. Het kan moeilijker zijn om te begrijpen voor nieuwe ontwikkelaars die de structuur niet goed kennen.
    - Hoewel OCP het makkelijker maakt om functionaliteit uit te breiden zonder bestaande code te wijzigen, kan het in sommige gevallen moeilijker zijn om **bestaande functionaliteit** te wijzigen. Bijvoorbeeld, als de oorspronkelijke ontwerpkeuzes niet goed waren, kan het moeilijk zijn om de interface of abstracte klasse te wijzigen zonder alle afgeleide klassen aan te passen.
    - Debuggen wordt moeilijker omdat er veel lagen in de hiërarchie kunnen ontstaan

- Een _eigen_ codevoorbeeld waarbij het principe wordt toegepast (dus niet het codevoorbeeld uit het boek).
~~~java
abstract class Animal {
	private String name;

	public Animal(String name) {
	this.name = name;
	}

	public abstract String makeSound();
}

class Cat extends Animal {
		public Cat(String name) {
			super(name);
		}

		@Override
		public String makeSound() {
			return "meow meow";
		}
}

class Bird extends Animal {
		public Bird(String name) {
			super(name);
		}

		@Override
		public String makeSound() {
			return "chirp chirp";
		}
}
~~~

- Op welk design property of properties het principe gebaseerd is.
    - **Extensibility:** Het principe draait om het uitbreiden van functionaliteit zonder bestaande code aan te passen. Dit maakt de code flexibel en makkelijk uitbreidbaar.
    - **Separation of Concerns:** Door functionaliteit te scheiden in uitbreidbare klassen en interfaces, blijft de code georganiseerd en overzichtelijk.
    - **Coupling:** Het principe helpt om de afhankelijkheden tussen componenten te minimaliseren. Door bijvoorbeeld gebruik te maken van interfaces of abstracte klassen, voorkom je sterke koppeling tussen concrete implementaties.