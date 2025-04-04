# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
2. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
3. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
4. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context

![contextDiagram.svg](../opdracht-diagrammen/Diagrammen%20studenten/Week%201/ContextDiagram/contextDiagram.svg)  
<sub> Context diagram


Toelichting op de context van de software inclusief System Context Diagram:
* Functionaliteit
* Gebruikers
* Externe systemen

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren 

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 6. Principles

### Ontwerpvraag Mike

- Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen?  

Om een prototype te kunnen bouwen waarmee ik antwoord geef op mijn gekozen ontwerpvraag, heb ik gebruik moeten maken van het strategy-pattern.
Wanneer je een strategy patten gebruikt, gebruik je daar automatisch de `composition over inheritance`- en `open-closed` principes bij.  

Ik heb ervoor gekozen dit pattern en deze principes te gebruiken omdat je, wanneer je ze op de juiste manier toepast, je enkel de implementatie van een service, de implementatie van een bouwsteen en de implementatie van een adapter hoeft te schrijven.
In de oude code hoeft bijna niets veranderd te worden om het programma te laten functioneren met de nieuwe bouwsteen.  

Idealiter had ik er in mijn prototype voor gezorgd dat er, na het toevoegen van een nieuwe bouwsteen, compleet geen oude code aan had hoeven passen, bijvoorbeeld door gebruik te maken van reflection of het zoeken door Spring Boot Beans. Helaas is dit door een tekort aan tijd niet gelukt.  

### Ontwerpvraag Marijn

- Hoe zorg je ervoor dat je makkelijk een nieuwe externe service kan toevoegen?

- Single Responsibility Principle (adapter heeft 1 taak).
- Open/Closed Principle (nieuwe adapter zonder bestaande adapters aan te passen).
- Client Transparency (Controller werkt met alle adapters want hij called gewoon fetchData())


We kiezen voor het adapter pattern omdat het de meeste flexibiliteit biedt bij het toevoegen van nieuwe externe services. Het houdt de code schoon en zorgt ervoor dat de kernlogica niet afhankelijk is van specifieke externe implementaties.


### Ontwerpvraag Bartu

Om te bepalen wie verantwoordelijk is voor het creëren en verwijderen van een bouwsteen, heb ik de Factory Method Pattern toegepast. Deze pattern zorgt ervoor dat de logica voor het creëren van nieuwe bouwstenen wordt gecentraliseerd en flexibel blijft.

#### Open-closed principle
Het Open-Closed Principle wordt hierbij ook toegepast, omdat de code uitbreidbaar is zonder bestaande functionaliteit aan te passen. Nieuwe bouwsteentypes kunnen eenvoudig worden toegevoegd door nieuwe factory klasse, die door het gebruik van reflection automatisch worden uitgebreid aan de applicatie.

####  Single Responsibility Principle
Verder is het Single Responsibility Principle van toepassing: de verantwoordelijkheid zijn duidelijk verdeeld over de klassen, zodat elke klasse een specifieke taak heeft. De BouwsteenFactory is verantwoordelijk voor het creëren van bouwstenen, terwijl de BouwsteenRepository zich bezighoudt met het beheren van de opslag en verwijdering naar de database.

## 7. Software Architecture

###     7.1. Containers
![container_diagram-0.svg](Bijlagen/Containerdiagram/container_diagram-0.svg)  
<sub> Container diagram </sub>

[//]: # (todo: Allen - begeleidende tekst ontbreekt)


###     7.2. Components

### Componentdiagram Samengevoegd

![Algemeen - Samengevoegd componentdiagram.svg](Bijlagen/Componentdiagrammen/svg/Algemeen%20-%20Samengevoegd%20componentdiagram.svg)

[//]: # (todo: Allen - begeleidende tekst ontbreekt)

### Componentdiagram Marijn
![ComponentdiagramNewExtSys-Component_Diagram_voor_TripTop__Makkelijk_toevoegen_externe_service_.png](..%2FMarijn%2FNEWonderzoeksvraag.md%2Fdiagrammen%2FComponentdiagramNewExtSys-Component_Diagram_voor_TripTop__Makkelijk_toevoegen_externe_service_.png)  

Er wordt een endpoint aangeroepen in de controller, de controller roeps de service aan, deze service roeps weer de juiste adapters aan die vervolgens een api call doen. De data die uit de api calls terugkomen worden weer teruggestuurd naar de frontend.


### Componentdiagram Bartu
![componentDiagramOnderzoek-Component Diagram for Trip-top System.svg](../Bartu/Onderzoek/componentDiagramOnderzoek-Component%20Diagram%20for%20Trip-top%20System.svg)  
<sub>Component diagram Bartu

Dit componentendiagram toont de backend van het Trip-top systeem, met de focus op het verwerken van bouwstenen. De frontend stuurt aanvragen naar de BouwsteenController, die deze verder afhandelt via de BouwsteenService. Deze service bevat de kernlogica en maakt gebruik van de BouwsteenFactory om nieuwe bouwstenen aan te maken en van de BouwsteenRepository om gegevens op te slaan in de database.

### Componentdiagram Mike

![Mike - Componentdiagram-0.svg](Bijlagen/Componentdiagrammen/svg/Mike%20-%20Componentdiagram-0.svg)  
<sub> Componentdiagram Mike </sub>  

Via de frontend wordt een request gedaan naar de backend. Afhankelijk van of je het endpoint `hotel` of `trip` aanroept, wordt er gebruik gemaakt van een andere strategy voor de service.
Dit bepaalt ook welke bouwsteen wordt aangemaakt in de Controller, zodat die door de applicatie heen gebruikt kan worden.


###     7.3. Design & Code

### Klassediagram Marijn
![classdiagram.png](..%2FMarijn%2FNEWonderzoeksvraag.md%2Fdiagrammen%2Fclassdiagram.png)
<sub>Class diagram Marijn </sub>

De adapters implementeren de interface. apiKey, apiHost en apiURL worden met @value uit application.properties gehaald.


### Dynamic diagram Marijn
![dynamicDiagram.png](..%2FMarijn%2FNEWonderzoeksvraag.md%2Fdiagrammen%2FdynamicDiagram.png)
<sub> Dynamic diagram Marijn



### Klassediagram Bartu

![classDiagramOnderzoek-0.svg](../Bartu/Onderzoek/classDiagramOnderzoek-0.svg)  
<sub>Class diagram Bartu </sub>

Dit klassendiagram toont de structuur van het systeem voor het beheren van bouwstenen, waarbij verschillende type bouwstenen (zoals Overnachting en Vervoer) worden aangemaakt via bijbehorende factories (OvernachtingFactory en VervoerFactory). De interface BouwsteenFactory definieert de methode voor het maken van bouwstenen, en de specifieke implementaties van deze methodes zorgen voor het creëren van de verschillende soorten bouwstenen. De BouwsteenController handelt aanvragen vanuit de frontend af, zoals het toevoegen, verwijderen of ophalen van bouwstenen, en stuurt deze verzoeken door naar de BouwsteenService. De service voert de bedrijfslogica uit en maakt gebruik van de repository voor het opslaan en ophalen van gegevens. De BouwsteenRepository zorgt voor opslag van bouwstenen. Dit ontwerp volgt het Factory Pattern voor het creëren van verschillende soorten bouwstenen en zorgt voor een flexibele en uitbreidbare architectuur.


![dynamicDiagramOnderzoek-0.svg](../Bartu/Onderzoek/dynamicDiagramOnderzoek-0.svg)
<sub>Sequence diagram Bartu

Dit sequentiediagram laat zien hoe een verzoek vanuit de frontend om een bouwsteen toe te voegen wordt verwerkt. De BouwsteenController ontvangt het verzoek en schakelt de BouwsteenService in, die via de BouwsteenFactory een nieuw bouwsteen aanmaakt en dit vervolgens opslaat via de BouwsteenRepository.


### Klassediagram Mike  
![Mike - Class diagram.svg](Bijlagen/Klassediagrammen/svg-png/Mike%20-%20Class%20diagram.svg)  
<sub> Klassediagram Mike  </sub>

Belangrijk om te vermelden is dat de klasse `Bouwsteen` geen dependencypijlen naar andere klasses heeft. 
Dit is onder andere gedaan om het overzicht te bewaren, maar ook omdat in veel klasses de dependency al duidelijk is door de returntypes die gegeven zijn.

### Sequence Diagram Mike
![Mike - Sequence Diagram.svg](Bijlagen/Sequencediagrammen/svg/Mike%20-%20Sequence%20Diagram.svg)

Dit sequence diagram beschrijft de stappen die worden gezet wanneer een bouwsteen wordt opgeslagen.

## 8. Architectural Decision Records

### 8.1. ADR-001 Applicatie voor reisagent

Datum: 21-03-2025

## Status
Accepted

## Context

Voor de Triptop-applicatie die we aan het voorbereiden zijn, moet een reiziger een reis kunnen plannen. Als de reiziger er zelf niet uit komt, moet de reiziger een reisagent om assistentie kunnen vragen.
Wanneer de reisagent een reiziger helpt, kan het handig zijn als de reisagent meer of juist andere informatie kan zien dan een reiziger. De vraag is alleen of we deze extra informatie beschikbaar willen maken in de normale applicatie, of dat er voor de reisagent een andere applicatie gemaakt moet worden.


## Considered Options

|                               | 1 Applicatie | 2 Applicaties |
|-------------------------------|--------------|---------------|
| Ontwikkeltijd                 | ++           | --            | 
| Onderhoud                     | ++           | --            |  
| Scheiding van unieke functies | -            | +             |
| Dubbele functionaliteiten     | ++           | --            |
| Interactie met backend        | 0            | 0             |


## Decision

We hebben ervoor gekozen om 1 applicatie te maken waar, afhankelijk van de rollen van de ingelogde persoon, bepaalde functionaliteiten wel of niet worden weergegeven. Dit zorgt ervoor dat de geschatte ontwikkelijktijd relatief gezien laag blijft en we de benodigde applicatie met 1 ontwikkelteam kunnen bouwen.

## Consequences

- Minder developers nodig
- Minder ontwikkeltijd nodig
- Makkelijker te onderhouden
- Niet scheiden van functionaliteiten maakt de applicatie soms dubbelzinnig
- Er moet strict bijgehouden worden welke gebruiker welke rechten heeft
- 
### 8.2. ADR-002 Welke maps-api gaan we gebruiken?

Datum: 21-03-2025

## Status
Accepted

## Context
Bij het bekijken van waar bepaalde hotels hun locatie hebben, is het voor de reiziger handig als dit weergegeven wordt op een wereldkaart. Nu bestaan er meerdere online kaarten die hiervoor gebruikt kunnen worden.
Het is voor ons zaak dat we de beste kaart voor onze usecase vinden en gebruiken.


## Considered Options

|                                   | Google Maps | Apple Maps | OpenStreetMap |
|-----------------------------------|-------------|------------|---------------|
| Kosten                            | 0           | +          | ++            |
| Beschikbaarheid (uptime)          | ++          | ?          | +             |
| Development time                  | +           | +          | 0             |
| Moeilijkheidsgraad van integreren | ++          | +          | ++            |
| Nauwkeurigheid                    | ++          | +          | ++            |
| Privacy                           | 0           | 0          | ++            |
| Aangepaste functionaliteit        | ++          | 0          | ++            |

Bronnen:  
Google Maps uptime: https://status.cloud.google.com/maps-platform/summary  
OpenStreetMap uptime: https://uptime.com/upstatus/openstreetmap.org

Google Maps kosten: https://mapsplatform.google.com/pricing/  
Apple Maps kosten: https://developer.apple.com/maps/web/  
OpenStreetMap kosten: https://www.openstreetmap.org/copyright

Google Maps naslagwerk: https://developers.google.com/maps/documentation  
Apple Maps naslagwerk: https://developer.apple.com/documentation/applemapsserverapi/  
OpenStreetMap naslagwerk: https://taginfo.openstreetmap.org/taginfo/apidoc


## Decision

Hoewel de uptime van Apple Maps waarschijnlijk vrij hoog ligt, hebben we hier geen historische data van kunnen vinden. Daarom lijkt, gebaseerd op deze tabel, OpenStreetMap de beste optie.

## Consequences

- We zullen onze diagrammen hierop aan moeten passen
- De kaart ziet er voor de reiziger anders uit
- Langere ontwikkelingstijd aangezien het integreren lastiger is
- Gegevens van gebruiker zijn goed beschermd
- Er is geen sprake van extra maandelijkse kosten
### 8.3. Welke betalingsmethode gaan we gebruiken?

Datum: 21-03-2025

## Status

Adyen, Mollie, Stripe

## Context

We moeten een veilige en gebruiksvriendelijke betalingsmethode hebben waarmee gebruikers hun reis kunnen betalen. We hebben er meerdere tot onze beschikking en het is zaak voor ons om te kijken welke het beste aansluit bij onze wensen.



| Kenmerk               | Adyen | Stripe | Mollie |
|-----------------------|-------|--------|--------|
| Aantal betaalmethodes | ++    | ++     | +      |
| Integratiegemak       | +     | ++     | +      |
| Gebruikersgemak       | +     | ++     | ++     |
| Documentatie/API      | +     | ++     | +      |
| Webhook ondersteuning | ++    | ++     | +      |
| Kopersbescherming     | 0     | +      | ++     |
| Transactiekosten      | -     | -      | +      |

## Bronnen:
- Aantal betaalmethodes Stripe: https://stripe.com/nl/guides/payment-methods-guide
- Aantal betaalmethodes Adyen: https://www.adyen.com/nl_NL/betaalmethoden/?gad_source=1&gclid=Cj0KCQjwhr6_BhD4ARIsAH1YdjD7W523MnX-Zp8eIqDfE--WG2Vo1UCQW_Y4280kWwxhFirjrUpaBZMaAsXXEALw_wcB&utm_campaign=2023_05_OA_NL_BRANDEDADYEN_GSN_CONS_CON_SEARCH_[NL]_ECPC&utm_medium=Online+Advertising&utm_source=Google
- Aantal betaalmethodes Mollie: https://www.mollie.com/nl/payments

- Gebruikersgemak Adyen: https://www.adyen.com/nl_NL/web-betalingen
- Gebruikersgemak Stripe: https://stripe.com/nl/payments/elements
- Gebruikersgemak Mollie: https://www.mollie.com/nl/payments

- Documentatie Adyen: https://docs.adyen.com/
- Documentatie Stripe: https://docs.stripe.com/
- Documentatie Mollie: https://docs.mollie.com/docs/getting-started

## Decision

In eerste instantie kozen we voor Adyen, omdat dit de eerste was die in ons opkwam. Na verder onderzoek gedaan te hebben, zijn we tot de conclusie gekomen dat Stripe eigenlijk beter aansluit op onze eisen en wensen.


## Consequences

- We zullen onze diagrammen hierop aan moeten passen
- We zullen meer kosten maken per transactie


## 8.4. ADR-004 - Instanties bouwstenen

Datum: 28-03-2025

## Status

## Context

Voor mijn onderzoek heb ik de opdracht gekregen om de volgende vragen te beantwoorden:
* Wie is verantwoordelijk voor het creëren van een nieuwe instantie van een bouwsteen?
* Wie is verantwoordelijk voor het verwijderen van een instantie van een bouwsteen?
  De oplossing moest gebruik maken van een design pattern dat tijdens de lessen is behandeld. Na het analyseren van verschillende patronen heb ik gekozen voor het Factory Method Pattern. Dit patroon biedt een gestructureerde manier om objecten aan te maken zonder directe afhankelijkheid van specifieke implementaties.

## Considered Options
![classDiagramOnderzoek-0.svg](../Bartu/Onderzoek/classDiagramOnderzoek-0.svg)

Eigenlijk heb ik hierbij geen andere overwogen optie. Alleen vergelijk ik hier de implementatie zonder een factory waarbij alle logica in de service laag staat.
## Decision
Ik heb gekozen voor het Factory Method Pattern als oplossing voor het aanmaken van instanties van bouwstenen.

## Consequences

Voordelen
Uitbreidbaarheid – Nieuwe bouwsteentypes kunnen worden toegevoegd zonder wijzigingen aan bestaande code.
Duidelijke verantwoordelijkheden – Het aanmaken en verwijderen van bouwstenen is gescheiden, waardoor de code beter te begrijpen en onderhouden is.

Nadelen
Complexiteit – Het Factory Method Pattern voegt extra lagen toe, wat de leercurve verhoogt.

### 8.5. ADR-005 pattern toevoegen externe services

Datum: 4/4/2025

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
|------------------------------------------------|-----------------|-----------------|
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
