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
public interface IApiGateway {
    /**
     * Verwerkt een inkomend verzoek en routeert het naar de juiste API.
     * 
     * @param request Het inkomende verzoek met de bijbehorende gegevens.
     * @return Het antwoord van de API.
     */
    ApiResponse routeRequest(ApiRequest request);
}

public interface ISecurityProxy {
    /**
     * Verwerkt onveilige verzoeken en voegt encryptie en authenticatie toe.
     * 
     * @param request Het inkomende verzoek.
     * @param apiKey De API sleutel voor authenticatie.
     * @return Het beveiligde verzoek.
     */
    ApiRequest secureRequest(ApiRequest request, String apiKey);
}

public interface IValidation {
    /**
     * Valideert de ontvangen data van een API-verzoek.
     * 
     * @param response Het antwoord van de API.
     * @return Een boolean die aangeeft of de data geldig is.
     */
    boolean validateResponse(ApiResponse response);
}

public interface ILogging {
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
### patterns

Proxy pattern: laag geplaatst tussen API gateway en de API voor security, alleen veilige verzoeken gaan naar de API en komen van de API.

Facade pattern: eenvoudige interface gemaakt om verouderde API's eenvoudiger te maken.