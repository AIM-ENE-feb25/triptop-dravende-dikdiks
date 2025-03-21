# 3. Welke betalingsmethode gaan we gebruiken?

Datum: 21-03-2025 

## Status

Adyen, Mollie, Stripe

## Context

We moeten een veilige en gebruiksvriendelijke betalingsmethode hebben waarmee gebruikers hun reis kunnen betalen. We hebben er meerdere tot onze beschikking en het is zaak voor ons om te kijken welke het beste aansluit bij onze wensen.



| Kenmerk               | Adyen | Stripe | Mollie |
|-----------------------|-------|--------|--------|
| Aantal betaalmethodes | +     | ++     | ++     |
| Integratiegemak       | +     | ++     | +      |
| Gebruikersgemak       | +     | ++     | ++     |
| Documentatie/API      | +     | ++     | +      |
| Webhook ondersteuning | ++    | ++     | +      |
| Kopersbescherming     | 0     | +      | ++     |
| Transactiekosten      | -     | -      | +      |

[//]: # (todo: bronnen toevoegen)
Bronnen:

## Decision

In eerste instantie kozen we voor Adyen, omdat dit de eerste was die in ons opkwam. Na verder onderzoek gedaan te hebben, zijn we tot de conclusie gekomen dat Stripe eigenlijk beter aansluit op onze eisen en wensen.

[//]: # (todo: controleren of de diagrammen en geschreven teksten overeen komen met de gekozen technologie/oplossing)



## Consequences

- We zullen onze diagrammen hierop aan moeten passen
- We zullen meer kosten maken per transactie
