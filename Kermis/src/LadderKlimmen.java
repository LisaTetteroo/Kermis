public class LadderKlimmen extends Attractie implements GokAttractie{


    public LadderKlimmen() {
        naam = "Ladder klimmen";
        prijs = 5.00;
        oppervlakte = 10;
        omzet = 0;
        aantalKaartjesVerkocht = 0;
        omzetVoorBelasting = 0;
    }

    public double kansSpelBelastingBetalen() {
        double kansSpelBelasting = 0.30 * omzetVoorBelasting;
        omzetAttractieNaBelasting(kansSpelBelasting);
        omzetVoorBelasting = 0;
        return kansSpelBelasting;
    }

    public double omzetAttractieNaBelasting(double kansSpelBelasting) {
         omzet = omzet - kansSpelBelasting;
        return omzet;
    }
}
