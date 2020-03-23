abstract public class RisicoRijkeAttractie extends Attractie {
    int draaiLimiet;
    int draaiLimietTeller;

    void draaien(Kassa k) {
        try {
            draaiLimietChecker(k);
        } catch (Exception e) {
            System.out.println("Draai limiet bereikt, bel onderhouds monteur voor onder houd aan de " + naam + ". Vertel de klant dat deze attractie tijdelijk buiten bedrijf is.");
        }
        System.out.println("test" + draaiLimietTeller);
    }

    void opstellingsKeuring() {
        System.out.println("Opstellingskeuring van " + naam + " is uitgevoerd.");
    }

    void draaiLimietChecker(Kassa k) throws Exception{
        if (draaiLimietTeller > 0) {
            System.out.println(naam + " draait.");
            aantalKaartjesVerkocht++;
            k.totaalAantalKaartjes++;
            omzet += prijs;
            k.totaalOmzetKermis += prijs;
            omzetVoorBelasting += prijs;
            draaiLimietTeller--;
        } else {
            throw new Exception();
        }
    }

    void onderhoud() {
        System.out.println("Draailimiet onderhoud voor " + naam + "is uitgevoerd, de attractie kan weer in gebruik worden genomen.");
        draaiLimietTeller = draaiLimiet;
    }
}
