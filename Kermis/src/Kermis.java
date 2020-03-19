import java.util.ArrayList;
import java.util.Scanner;

public class Kermis {
    Scanner sc = new Scanner(System.in);
    int attractieKeuze;
    ArrayList<Attractie> attracties = new ArrayList<>();

    public Kermis() {
        attracties.add(new Botsauto());
        attracties.add(new Spin());
        attracties.add(new SpiegelPaleis());
        attracties.add(new Spookhuis());
        attracties.add(new Hawaii());
        attracties.add(new LadderKlimmen());
    }

    public void startKermis () {
        attractieKeuze = kiesAttractie();
        attractieDraaien(attractieKeuze);
    }

    public int kiesAttractie () {
        System.out.println("kies een attractie, type het bijhorende getal:\n" +
                "1 voor botsauto'\n" +
                "2 voor spin\n" +
                "3 voor spiegelpaleis\n" +
                "4 voor spookhui\n" +
                "5 voor hawaii\n" +
                "6 voor ladderklimmen");
        attractieKeuze = Integer.parseInt(sc.nextLine());
        return attractieKeuze;
    }

    public void attractieDraaien(int attractieKeuze) {
        switch (attractieKeuze) {
            case 1: attracties.get(0).draaien(); break;
            case 2: attracties.get(1).draaien(); break;
            case 3: attracties.get(2).draaien(); break;
            case 4: attracties.get(3).draaien(); break;
            case 5: attracties.get(4).draaien(); break;
            case 6: attracties.get(5).draaien(); break;
        }
    }
}

/*
+
                "O voor omzet\n" +
                "K voor aantal kaartjes")
 */
