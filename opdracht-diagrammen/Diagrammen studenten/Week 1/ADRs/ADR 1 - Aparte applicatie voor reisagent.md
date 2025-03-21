# 1. Applicatie voor reisagent

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

[//]: # (todo: bronnen toevoegen)
Bronnen:

## Decision

We hebben ervoor gekozen om 1 applicatie te maken waar, afhankelijk van de rollen van de ingelogde persoon, bepaalde functionaliteiten wel of niet worden weergegeven. Dit zorgt ervoor dat de geschatte ontwikkelijktijd relatief gezien laag blijft en we de benodigde applicatie met 1 ontwikkelteam kunnen bouwen.

## Consequences

- Minder developers nodig
- Minder ontwikkeltijd nodig
- Makkelijker te onderhouden
- Niet scheiden van functionaliteiten maakt de applicatie soms dubbelzinnig
- Er moet strict bijgehouden worden welke gebruiker welke rechten heeft