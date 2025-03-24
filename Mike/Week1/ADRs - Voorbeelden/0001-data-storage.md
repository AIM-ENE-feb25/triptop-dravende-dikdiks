# 1. Data Storage

Datum: 2025-03-14

## Status

Accepted

## Context

Er moet een text-based game gemaakt worden. We willen weten op welke manier we de game-state lokaal gaan schrijven en uitlezen.

## Considered Options

| Forces                                     | SQLite | JSON | Java Object Serialization |
|:-------------------------------------------|:------:|:----:|:-------------------------:|
| Snelheid                                   |   ++   |  +   |             -             |
| Eenvoudig lees- en schrijfbaar vanuit Java |   ?    |  ++  |             +             |
| Opslagformaat ook leesbaar door mensen     |   --   |  ++  |            --             |
| Standaard APIs beschikbaar                 |   +    |  +   |             +             |

## Decision

Na de DCAR is besloten om een SQLite database te gaan gebruiken. De voornaamste reden is dat we het zweepslageffect willen laten zien. Naast de technische kant van deze keuze werd dit aspect vooraf niet helemaal goed meegewogen. Geserializeerde data is moeilijk te visualiseren (bijvoorbeeld met PowerBI). Hiervoor is dus alsnog gekozen om een SQLite database toe te passen.

## Consequences

De SQLite oplossing voldoet aan minder requirements dan de andere optie, JSON. Doordat er onvolledig is gekeken naar de requirements zou JSON een suboptimale keuze zijn, de PowerBI-eis maakte uiteindelijk voor de opdrachtgever het grootste verschil. 