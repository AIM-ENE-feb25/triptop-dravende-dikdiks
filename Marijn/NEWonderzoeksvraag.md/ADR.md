### Hoe zorg je ervoor dat je makkelijk een nieuwe externe service kan toevoegen?

## Status
Geaccepteerd

## Context
In ons systeem willen we flexibel en eenvoudig nieuwe externe services kunnen toevoegen zonder bestaande code aan te moeten passen. We hebben verschillende patterns overwogen om deze uitbreidbaarheid te ondersteunen.

## Alternatieven

### 1. Adapter Pattern (Gekozen oplossing)
Het Adapter Pattern zorgt ervoor dat een nieuwe externe service eenvoudig kan worden geïntegreerd door een abstracte interface te definiëren. Elke externe service heeft een eigen adapter klasse die de interface implementeert. Hierdoor is het makkelijk om een nieuwe externe service toe te voegen die eigen logica nodig heeft.

**Voordelen:**
- Externe services kunnen onafhankelijk van elkaar worden ontwikkeld en gewijzigd.
- Weinig impact op de bestaande code bij het toevoegen van nieuwe services.
- Houdt de businesslogica gescheiden van externe afhankelijkheden.

**Nadelen:**
- Vereist extra code (adapterklassen).
- Kan leiden tot een toename van het aantal klassen en bestanden (Kan het onoverzichtelijk maken).

### 2. Factory Pattern
Het Factory Pattern kan worden gebruikt om objecten van externe services te creëren via een centrale factory. Dit zorgt voor een makkelijke manier om externe services te beheren en biedt minimale flexibiliteit.


**Voordelen:**
- Centraliseert objectcreatie, waardoor het eenvoudiger wordt om services te wisselen.
- Zorgt voor een consistente manier om services te initialiseren.

**Nadelen:**
- De implementaties van externe services moeten nog steeds voldoen aan een interface.
- Minder flexibel dan een adapter als er significante verschillen zijn tussen de externe services.

| Criteria                                       | Adapter Pattern | Factory Pattern |
|-----------------------------------------------|-----------------|-----------------|
| Flexibiliteit bij verschillende services       | ++              | -               |
| Scheiding van businesslogica en services       | ++              | +               |
| Eenvoud bij toevoegen van nieuwe services      | +               | 0               |
| Overzichtelijkheid van de codebase             | -               | +               |
| Complexiteit van implementatie                 | -               | 0               |


## Besluit
We kiezen voor het adapter pattern omdat het de meeste flexibiliteit biedt bij het toevoegen van nieuwe externe services. Het houdt de code schoon en zorgt ervoor dat de kernlogica niet afhankelijk is van specifieke externe implementaties.

## Consequenties
- Elke nieuwe externe service vereist een eigen adapter.
- De architectuur blijft schaalbaar en uitbreidbaar.
- Er moet een duidelijke abstracte interface worden gedefinieerd voor externe services.

## Gerelateerde beslissingen
- Gebruik van Dependency Injection om adapters eenvoudig te gebruiken.
- Overweging van een Factory Pattern voor het beheren van adaptercreatie.