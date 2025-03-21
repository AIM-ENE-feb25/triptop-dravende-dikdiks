 ### **Criteria voor een goed containerdiagram:**  
 **Actoren hebben interactie met de juiste bijbehorende container**  
— Elke actor communiceert alleen met de container waarmee deze direct hoort te interageren.  

 **De rol van de container moet kloppen**  
— Een container moet duidelijk zijn in zijn verantwoordelijkheid en geen functies vervullen die niet logisch zijn voor zijn rol.  

 **Actoren hebben bij voorkeur geen directe interactie met externe systemen**  
— Communicatie met externe systemen verloopt idealiter via een tussenlaag, zoals een API Gateway of een specifieke service.  

 **Van de API Gateway naar de backend loopt slechts één pijl**  
— De API Gateway stuurt verzoeken door naar de backend en centraliseert deze communicatie, in plaats van meerdere directe verbindingen te maken.  

 **De container die het bericht start, is het beginpunt van de pijl**  
— Een pijl begint altijd bij de container die de actie initieert en wijst naar de container die de actie ontvangt.  

 **Vermijd loshangende blokken zonder ingaande pijlen**  
— Elke container of component in het diagram moet ergens in de dataflow betrokken zijn.  

 **Vermijd pijlen die naar jezelf wijzen**  
— Zelfrefererende pijlen maken een diagram minder overzichtelijk. Als een container intern iets verwerkt, hoeft dit niet expliciet met een pijl te worden weergegeven.  

 **Een restaurant-dashboard en cache moeten worden gebruikt als ze in het diagram staan**  
— Onderdelen die in het diagram worden opgenomen, moeten functioneel betrokken zijn in de interacties.  

 **De actor mag niet direct met de cache communiceren**  
— Caching moet worden beheerd door een geschikte service of container, niet door een actor.  

 **Protocollen vermelden op pijlen, niet op containers**  
— Communicatieprotocollen (bijv. HTTP, WebSocket, gRPC) horen bij de pijlen om duidelijk te maken hoe gegevens worden verstuurd, niet bij de containers zelf.  
