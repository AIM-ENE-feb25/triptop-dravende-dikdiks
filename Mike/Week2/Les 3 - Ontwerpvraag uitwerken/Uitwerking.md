# Uitwerking Huiswerk les 3

## Voorbereiding
### Ontwerpvraag
- Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen?

### Componenten

```plantuml
@startuml

!include https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Component.puml

Component("hc", "HotelController")
Component("tc", "TripController")
Component("hr", "HotelRepo")
Component("tr", "TripRepo")
Component("s", "Service")
Component("db", "Database")
Component("ag", "APIGateway")

Component_Ext("hapi","HotelAPI")
Component_Ext("tapi","TripAPI")


Rel("hc", "ag", "Stuurt request")
Rel("tc", "ag", "Stuurt request")
Rel("ag", "hapi", "Doet request")
Rel("ag", "tapi", "Doet request")
Rel("hc", "s", "Geeft data van response door")
Rel("tc", "s", "Geeft data van response door")
Rel("s", "hr", "Heeft data van response verwerkt")
Rel("s", "tr", "Heeft data van response verwerkt")
Rel("hr", "db", "Slaat data response op")
Rel("tr", "db", "Slaat data response op")

@enduml

```

scenario 1: gebruiker wil nieuwe bouwsteen toevoegen. hoe gaat dat?
scenario 2: ik ga nieuw soort bouwsteen toevoegen (theaterbezoek of zo)



