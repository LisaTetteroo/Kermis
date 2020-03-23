import java.util.ArrayList;
import java.util.Scanner;

public class Kermis {
    Scanner sc = new Scanner(System.in);
    String optieKeuze;
    ArrayList<Attractie> attracties = new ArrayList<>();
    Kassa kassa = new Kassa();
    BelastingInspecteur inspectorGadget = new BelastingInspecteur();

    public Kermis() {
        attracties.add(new Botsauto());
        attracties.add(new Spin());
        attracties.add(new SpiegelPaleis());
        attracties.add(new Spookhuis());
        attracties.add(new Hawaii());
        attracties.add(new LadderKlimmen());

        for (Attractie a:attracties) {
            if (a instanceof RisicoRijkeAttractie) {
                ((RisicoRijkeAttractie) a).opstellingsKeuring();
            }
        }
    }

    public void startKermis () {
        while (true) {
            System.out.println();
            optieKeuze = kiesOptie().toUpperCase();
            System.out.println();
            attractieDraaien(optieKeuze);
            double belastingRandom = Math.random()*15;
            if ((int) belastingRandom == 6) {
                inspectorGadget.belastingInnen(attracties, kassa);
            }
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
                "M voor monteur bellen ivm draailimiet\n" +
                "Q voor kermis sluiten");
        optieKeuze = sc.nextLine();
        return optieKeuze;
    }

    public void attractieDraaien(String optie) {
        switch (optie) {
            case "1": attracties.get(0).draaien(kassa); break;
            case "2": attracties.get(1).draaien(kassa); break;
            case "3": attracties.get(2).draaien(kassa); break;
            case "4": attracties.get(3).draaien(kassa); break;
            case "5": attracties.get(4).draaien(kassa); break;
            case "6": attracties.get(5).draaien(kassa); break;
            case "O":
                for (int i = 0; i < attracties.size(); i++) {
                    System.out.println(attracties.get(i).naam + " heeft "+ attracties.get(i).omzet + " omgezet.");
                }
                System.out.println("Totale omzet is: " + kassa.totaalOmzetKermis);break;
            case "K":
                for (int i = 0; i < attracties.size(); i++) {
                    System.out.println("Voor " + attracties.get(i).naam + " zijn "+ attracties.get(i).aantalKaartjesVerkocht + " kaartjes verkocht.");
                }
                System.out.println("Totale aantal verkochte kaartjes is: " + kassa.totaalAantalKaartjes);break;
            case "B": inspectorGadget.belastingInnen(attracties, kassa); break; // niet in menu opgenomen, maar wel in switch laten staan voor testen
            case "M":
                String monteurVoorAttractie = monteurBellen();
                switch (monteurVoorAttractie) {
                    case "1": ((RisicoRijkeAttractie) attracties.get(1)).onderhoud(); break;
                    case "2": ((RisicoRijkeAttractie) attracties.get(4)).onderhoud(); break;
                    default:
                        System.out.println("Sorry onjuiste invoer, probeer opnieuw");
                        monteurBellen();
                }
                break;

            case "Q":
                System.out.println("Kermis is gesloten");
                System.exit(1);
            default:
                System.out.println("Ongeldige invoer, probeer opnieuw");
                kiesOptie();
        }
    }

    String monteurBellen() {
        String attractieVoorOnderhoud;
        System.out.println("Voor welke attractie is draai limiet onderhoud nodig? Kies een attractie, type bijhorend getal:\n" +
                "1 voor spin\n" +
                "2 voor hawaii");
        attractieVoorOnderhoud = sc.nextLine();
        return attractieVoorOnderhoud;
    }
    /*
    void draaiLimietChecken() {
        for (Attractie a : attracties) {
            if (a instanceof RisicoRijkeAttractie) {
                if (((a.naam.equals("Spin")) && (((RisicoRijkeAttractie) a).kaartjesTeller == 5))
                        || ((a.naam.equals("Hawaii")) && (((RisicoRijkeAttractie) a).kaartjesTeller  == 10))) {
                    ((RisicoRijkeAttractie) a).onderhoud();
                    ((Attractie) a).kaartjesTeller = 0;
                }
            }
        }
    }
    */
}

