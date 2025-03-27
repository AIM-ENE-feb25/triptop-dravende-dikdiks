# 2. Welke maps-api gaan we gebruiken?

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
- 
