abstract public class RisicoRijkeAttractie extends Attractie {
    void opstellingsKeuring() {
        System.out.println("Opstellingskeuring van " + naam + " is uitgevoerd.");
    }

    void onderhoud() {
        System.out.println("onderhoudsbeurt ivm draailimiet van een risicorijke attractie wordt uitgevoerd");
    }
}
