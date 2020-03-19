import java.util.ArrayList;
import java.util.Scanner;

public class Kermis {
    Scanner sc = new Scanner(System.in);
    String optieKeuze;
    ArrayList<Attractie> attracties = new ArrayList<>();
    Kassa kassa = new Kassa();

    public Kermis() {
        attracties.add(new Botsauto());
        attracties.add(new Spin());
        attracties.add(new SpiegelPaleis());
        attracties.add(new Spookhuis());
        attracties.add(new Hawaii());
        attracties.add(new LadderKlimmen());
    }

    public void startKermis () {
        while (true) {
            optieKeuze = kiesOptie().toUpperCase();
            attractieDraaien(optieKeuze);
            System.out.println();
        }

    }

    public String kiesOptie() {
        System.out.println("kies een attractie/optie, type bijhorend getal/letter:\n" +
                "1 voor botsauto\n" +
                "2 voor spin\n" +
                "3 voor spiegelpaleis\n" +
                "4 voor spookhui\n" +
                "5 voor hawaii\n" +
                "6 voor ladderklimmen\n"+
                "O voor omzet\n" +
                "K voor aantal kaartjes\n" +
                "Q voor kermis sluiten");
        optieKeuze = sc.nextLine();
        return optieKeuze;
    }

    public void attractieDraaien(String optie) {
        switch (optie) {
            case "1": attracties.get(0).draaien(); break;
            case "2": attracties.get(1).draaien(); break;
            case "3": attracties.get(2).draaien(); break;
            case "4": attracties.get(3).draaien(); break;
            case "5": attracties.get(4).draaien(); break;
            case "6": attracties.get(5).draaien(); break;
            case "O":
                for (int i = 0; i < attracties.size(); i++) {
                    System.out.println(attracties.get(i).naam + " heeft "+ attracties.get(i).omzetBerekenen() + " omgezet.");
                }
                System.out.println("Totale omzet is: " + kassa.totaalOmzetBerekenen(attracties));break;
            case "K":
                for (int i = 0; i < attracties.size(); i++) {
                    System.out.println("Voor " + attracties.get(i).naam + " zijn "+ attracties.get(i).aantalKaartjesVerkocht + " kaartjes verkocht.");
                }
                System.out.println("Totale aantal verkochte kaartjes is: " + kassa.totaalKaartjesBereken(attracties));break;
            case "Q":
                System.out.println("Kermis is gesloten");
                System.exit(1);
            default:
                System.out.println("Ongeldige invoer, probeer opnieuw");
                kiesOptie();
        }
    }
}

/*
+
                "O voor omzet\n" +
                "K voor aantal kaartjes")
 */
