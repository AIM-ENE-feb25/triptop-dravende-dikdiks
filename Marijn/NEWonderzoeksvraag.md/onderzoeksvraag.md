### Hoe zorg je ervoor dat je makkelijk een nieuwe externe service kan toevoegen?

### Componenten
TripController: Handelt alle request naar backend af.
Interface: Defineert basis request API.
Adapter: Past de API request aan zodat deze werkt met de specifieke API.
ServiceFactory: Hierin staat welke API actief is (BV: Stripe wordt nu gebruikt voor betalingen).
ExternalServiceHandler: Maakt verbinding met externe API's.
TripRepo: Verbind backend met database.

