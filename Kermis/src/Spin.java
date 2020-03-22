public class Spin extends  RisicoRijkeAttractie  {
    public Spin() {
        naam = "Spin";
        prijs = 2.25;
        oppervlakte = 10;
        omzet = 0;
        aantalKaartjesVerkocht = 0;
        kaartjesTeller = 0;
        omzetVoorBelasting = 0;
    }

    /*
    // Als implements GokAttractie
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
    */
}
