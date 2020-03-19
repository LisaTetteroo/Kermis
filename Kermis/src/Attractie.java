import java.util.ArrayList;

abstract class Attractie {
    String naam;
    double prijs;
    double oppervlakte;

    void draaien() {
        System.out.println(naam + " draait.");
    }
}
