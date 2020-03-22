import java.util.ArrayList;

public class BelastingInspecteur {
    double teInnenBelasting = 0;

    void belastingInnen (ArrayList<Attractie> atractieLijst, Kassa k){
        System.out.println();
        System.out.println("De belasting inspecteur, inspector Gadget is langs gekomen.");
        for (Attractie a:atractieLijst) {
            if (a instanceof GokAttractie) {
                double teInnenBelastingAttractie = 0;
                teInnenBelastingAttractie = ((GokAttractie) a).kansSpelBelastingBetalen();
                System.out.println("Voor " + a.naam + " moet " + teInnenBelastingAttractie + " worden betaald");
                teInnenBelasting = teInnenBelasting + teInnenBelastingAttractie;
            }
        }
        System.out.println("Er moet " + teInnenBelasting + " gokbelasting worden afgedragen.");
        System.out.println("De totaal omzet was " + k.totaalOmzetKermis + ".");
        k.totaalOmzetKermis = k.totaalOmzetKermis - teInnenBelasting;
        System.out.println("De omzet is nu: " + k.totaalOmzetKermis + ".");
        teInnenBelasting = 0;
    }
}
