import java.util.ArrayList;

abstract class Attractie {
    String naam;
    double prijs;
    double oppervlakte;
    double omzet;
    int aantalKaartjesVerkocht;
    double omzetVoorBelasting;

    void draaien(Kassa k) {
        System.out.println(naam + " draait.");
        aantalKaartjesVerkocht++;
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
