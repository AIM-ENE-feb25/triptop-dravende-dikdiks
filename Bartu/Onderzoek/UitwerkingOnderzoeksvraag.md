### Wie is verantwoordelijk voor het creëren van een nieuwe instantie van een bouwsteen? Wie is verantwoordelijk voor het verwijderen van een instantie van een bouwsteen?

## Lijst met componenten
* Bouwsteencontroller : Opvangen api-calls frontend
* BouwsteenFactory : creeren van instanties van bouwstenen
* BouwsteenService : Voert businesslogica uit
* BouwsteenRepository : opslaan bouwsteen
* TripService : toevoegen/ verwijderen van bouwstenen aan reis
* ApiService : communicatie met externe API's

![componentDiagramOnderzoek-Component Diagram for Trip-top System.svg](componentDiagramOnderzoek-Component%20Diagram%20for%20Trip-top%20System.svg)

## Lijst met interfaces

```java
@RestController
@RequestMapping("/api/bouwstenen")
public interface BouwsteenController {
ResponseEntity<Bouwsteen> voegBouwsteenToe(@RequestBody BouwsteenRequest request);
ResponseEntity<Void> verwijderBouwsteen(@PathVariable String bouwsteenId);
ResponseEntity<Bouwsteen> haalBouwsteenOp(@PathVariable String bouwsteenId);
ResponseEntity<List<Bouwsteen>> haalAlleBouwstenenOpVoorTrip(@PathVariable String tripId);
}
```
```java
public interface BouwsteenFactory {
Bouwsteen createBouwsteen(String type, Map<String, Object> details);
}
```

```java
public interface BouwsteenService {
Bouwsteen addBouwsteen(String type, Map<String, Object> details);
void deleteBouwsteen(Long bouwsteenId);
Optional<Bouwsteen> getBouwsteenById(Long bouwsteenId);
}
```

```java
public interface BouwsteenRepository {
    void save(Bouwsteen bouwsteen);
    void delete(Long bouwsteenId);
    Optional<Bouwsteen> findById(Long bouwsteenId);
}
```
```java
public interface TripService {
void addBouwsteenToTrip(Long tripId, Bouwsteen bouwsteen);
void removeBouwsteenFromTrip(Long tripId, Long bouwsteenId);
List<Bouwsteen> getBouwstenenForTrip(Long tripId);
}
```
```java
public interface ApiService {
BookingInfo boekOvernachting(Overnachting overnachting);
TransportInfo boekVervoer(Vervoer vervoer);
}
```

## Sequentie diagram
![dynamicDiagramOnderzoek-0.svg](dynamicDiagramOnderzoek-0.svg)

## Class diagram

![classDiagramOnderzoek-0.svg](classDiagramOnderzoek-0.svg)

## ADR - Instanties bouwstenen

Datum: 28-03-2025

## Status
Accepted

## Context

Wie is verantwoordelijk voor het creëren van een nieuwe instantie van een bouwsteen? 
Wie is verantwoordelijk voor het verwijderen van een instantie van een bouwsteen?

## Considered Options
![classDiagramOnderzoek-0.svg](classDiagramOnderzoek-0.svg)

## Decision

## Consequences
