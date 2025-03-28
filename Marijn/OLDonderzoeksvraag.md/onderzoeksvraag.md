### Hoe beheer je veilig de interactie met verouderde externe APIs die geen moderne beveiligingsprotocollen ondersteunen?

Containers nodig: API gateway, SecurityProxy, Validation en Logging.


API gateway: Verbind backend met API's.
SecurityProxy: Voegt encryptie toe en authenticatie API's.
Validation: zorgt ervoor dat de data die terugkomt van een API is zoals deze verwacht word.
Logging: houd API verzoeken bij als er in de validatie iets geks ontdekt is.

API Gateway: Encapsulate What Varies, Separation of Concerns.
Security Proxy: Single Responsibility Principle, Separation of Concerns.
Validation: Single Responsibility Principle, Cohesion.
Logging: Single Responsibility Principle, Cohesion.


API Gateway: ApiResponse: Het antwoord van de gerouteerde API.
Security Proxy: ApiRequest: Het verzoek dat is beveiligd met encryptie en authenticatie.
Validation: boolean: Een boolean die aangeeft of de data geldig is.
Logging: returned niks.

``` java
public interface InterfaceApiGateway {
    /**
     * Verwerkt een inkomend verzoek en routeert het naar de juiste API.
     * 
     * @param request Het inkomende verzoek met de bijbehorende gegevens.
     * @return Het antwoord van de API.
     */
    ApiResponse routeRequest(ApiRequest request);
}

public interface InterfaceSecurityProxy {
    /**
     * Verwerkt onveilige verzoeken en voegt encryptie en authenticatie toe.
     * 
     * @param request Het inkomende verzoek.
     * @param apiKey De API sleutel voor authenticatie.
     * @return Het beveiligde verzoek.
     */
    ApiRequest secureRequest(ApiRequest request, String apiKey);
}

public interface InterfaceValidation {
    /**
     * Valideert de ontvangen data van een API-verzoek.
     * 
     * @param response Het antwoord van de API.
     * @return Een boolean die aangeeft of de data geldig is.
     */
    boolean validateResponse(ApiResponse response);
}

public interface InterfaceLogging {
    /**
     * Logt een API-verzoek, inclusief de ontvangen data.
     * 
     * @param request Het oorspronkelijke verzoek dat naar de API werd gestuurd.
     * @param response Het antwoord van de API.
     * @param isValid Geeft aan of de validatie van de data succesvol was.
     */
    void logRequest(ApiRequest request, ApiResponse response, boolean isValid);
}

```
# ADR: Veilig beheer van interactie met verouderde externe APIs

## Status
Besluit: Goedgekeurd  
Datum: 28/3/25

## Context
Bij het integreren van verouderde externe API's zonder moderne beveiligingsprotocollen is het belangrijk om een veilige en gestructureerde architectuur te implementeren. De volgende dingen moeten worden aangepakt:

- Geen moderne beveiliging: Verouderde APIs ondersteunen mogelijk geen encryptie of veilige authenticatie.
- Onvoorspelbare dataformaten: Gegevensstructuren kunnen inconsistent zijn en moeten worden gevalideerd.
- Monitoring en logging: Voor detectie van afwijkingen en debugging moeten verzoeken en antwoorden worden bijgehouden.
- Enkelvoudige toegangspunt: De backend moet niet direct met meerdere API's communiceren, maar via een centraal punt.

## Besluit
Om deze uitdagingen op te lossen implementeren we de volgende componenten:

### Componenten
1. API Gateway
   - Verbindt de backend met de externe APIs.
   - Routeert inkomende verzoeken naar de juiste API.
   - Biedt een enkele toegangspoort om complexiteit te verminderen (Facade Pattern).

2. Security Proxy
   - Voegt encryptie en authenticatie toe aan verzoeken.
   - Zorgt ervoor dat alleen veilige verzoeken naar de API worden gestuurd (Proxy Pattern).

3. Validation
   - Controleert of ontvangen gegevens voldoen aan de verwachte structuur en formaten.
   - Voorkomt dat corrupte of ongeldige data de backend beïnvloeden.

4. Logging
   - Houdt API-verzoeken en -antwoorden bij.
   - Registreert verdachte activiteiten en validatiefouten voor auditing en debugging.

### Patronen
- Proxy pattern: laag geplaatst tussen API gateway en de API voor security, alleen veilige verzoeken gaan naar de API en komen van de API.
- Facade pattern: eenvoudige interface gemaakt om verouderde API's eenvoudiger te maken.

## Gevolgen
### Positieve Gevolgen
- Verhoogde beveiliging door encryptie en authenticatie via Security Proxy.  
- Betere foutafhandeling en data-integriteit door validatie van API-antwoorden.  
- Verbeterde debugging en monitoring dankzij logging.  
- Verminderde afhankelijkheden en complexiteit voor de backend door de API Gateway.

### Negatieve Gevolgen
- Encryptie en validatie kan de prestatie beïnvloeden.  
- Lastiger te implementeren.  

## Besluitvorming
Deze architectuur biedt een veilige, schaalbare en beheersbare manier om met verouderde API's te werken. Daarom kiezen we voor de oplossing met API Gateway, Security Proxy, Validation en Logging.

## Toekomstige Aanpassingen
- Evalueren van bestaande API-managementtools als het systeem groeit.