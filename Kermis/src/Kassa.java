import java.util.ArrayList;

public class Kassa {
    double totaalOmzetKermis = 0;
    int totaalAantalKaartjes = 0;

    double totaalOmzetBerekenen(ArrayList<Attractie> attracties){
        for (int i = 0; i < attracties.size(); i++) {
            totaalOmzetKermis = totaalOmzetKermis + attracties.get(i).omzetBerekenen();
        }
        return totaalOmzetKermis;
    }

    int totaalKaartjesBereken (ArrayList<Attractie> attracties) {
        for (int i = 0; i < attracties.size(); i++) {
            totaalAantalKaartjes = totaalAantalKaartjes + attracties.get(i).aantalKaartjesVerkocht;
        }
        return totaalAantalKaartjes;
    }
}
