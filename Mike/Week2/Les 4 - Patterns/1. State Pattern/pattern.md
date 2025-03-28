```java
public class Dobbelsteen {
    private int aantalOgen;
    private enum STATES {enkel, dubbel, kwadraat}
    private Random rand = new Random();
    
    
    
    public int werp() {
        aantalOgen = rand.nextInt(6)+1;
        
        return aantalOgen;
    }
    
    
}

```