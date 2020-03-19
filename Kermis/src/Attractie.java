import java.util.ArrayList;

abstract class Attractie {
    String naam;
    double prijs;
    double oppervlakte;
    double omzet;
    int aantalKaartjesVerkocht;

    void draaien() {
        System.out.println(naam + " draait.");
        aantalKaartjesVerkocht++;
    }

    double omzetBerekenen() {
        omzet = aantalKaartjesVerkocht * prijs;
        return omzet;
    }
}
