# 3. Network Library

Date: 2025-03-14

## Status

Accepted

## Context

Twee computers moeten een verbinding met elkaar kunnen leggen die voldoet aan alle time behaviour eisen uit hoofdstuk 5 van het SAD. Over deze verbinding moeten game-events verstuurd kunnen worden.

## Considered Options

| Forces                                |  Kafka  |  Netty  |
|---------------------------------------|:-------:|:-------:|
| Werkt op eigen laptops van developers |    0    |    +    |
| Lage leercurve                        |    -    |    +    |

## Decision

In het onderzoek naar de netwerk communicatie (Lensink et al., 2024) zijn Netty en Kafka als mogelijke COTS geïdentificeerd om de verbinding tussen twee computers te realiseren. Kafka vereist krachtigere hardware dan Netty en is minder snel. Bovendien brengt Kafka veel complexiteit met zich mee. Hierdoor is er gekozen om voor Netty te gaan.

## Consequences

Door het toepassen van Netty hoeft er geen volledig eigen RPC-mechanisme te worden ontwikkeld. Dit bespaart tijd en geld. Netty is een lichtgewicht netwerk library die goed presteert en eenvoudig te gebruiken is. Het is een goede keuze voor de verbinding tussen twee computers en de structuur lijkt sterk op het Broker-pattern.
