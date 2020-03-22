import java.util.ArrayList;

abstract class Attractie {
    String naam;
    double prijs;
    double oppervlakte;
    double omzet;
    int aantalKaartjesVerkocht;
    double omzetVoorBelasting;
    int kaartjesTeller;

    void draaien(Kassa k) {
        System.out.println(naam + " draait.");
        aantalKaartjesVerkocht++;
        kaartjesTeller++;
        k.totaalAantalKaartjes++;
        omzet += prijs;
        k.totaalOmzetKermis += prijs;
        omzetVoorBelasting += prijs;
    }
/*
    double omzetBerekenen() {
        omzet = aantalKaartjesVerkocht * prijs;
        return omzet;
    }

 */
}
