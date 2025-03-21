# 2. Second Programming Language

Date: 2025-03-14

## Status

Accepted

## Context

De klas wil ervaring opdoen met een nieuwe programmeertaal.

## Considered Options

| Forces                                       | Kotlin | Clojure | Scala | C# |
|----------------------------------------------|:------:|:-------:|:-----:|:--:|
| Werkt op de Java Virtuele Machine            |   ++   |   ++    |  ++   | -- |
| Leercurve                                    |   0    |   --    |   +   | ++ |
| Ook begrijpbaar voor beginnende programmeurs |   0    |   --    |  --   | ++ |
| Helpt om ASD competentie 5 aan te tonen      |   ++   |   ++    |  ++   | +  |
| Snelheid                                     |   +    |    +    |   +   | ++ |
| Kosten                                       |   --   |   --    |  ++   | 0  |

## Decision

We kiezen geen tweede taal.
    
## Consequences

Het behalen van het ASD-project wordt moeilijker met alleen Java als taal. 

* C# en andere talen die niet JVM-compatible zijn zorgen ervoor dat er containers/VMs gebruikt moeten worden om de verschillende codetalen te compileren. Dit naast het onderhouden van een complex netwerk met peer-to-peer en software agents die we ook nog op containers willen draaien zorgen ervoor dat er een te grote network overhead is en het dusdanig ingewikkeld wordt dat het voor meer frustratie gaat leiden dan het waard is.
* Clojure en Scala zijn ingewikkeld om werkend te krijgen met integration tests en error handling.
* Kotlin voegt niet genoeg waarde toe aan het systeem om de tijd die het duurt om te leren goed te praten.
* Het zal met een nieuwe taal lastiger zijn voor lagerejaars om de documentatie te begrijpen en het zal voor de developers langer duren om uit te kunnen breiden op het systeem. 