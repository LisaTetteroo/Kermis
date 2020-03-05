package nl.workingtalent.asopos.model;

import java.util.Scanner;

public class Dock {
    private Boat[] boats = new Boat[5];
    //hoewel 80 boten meer de werkelijkheid benaderd voor een grote vereniging als Asopos,
    //is het voor het testen handiger als het maar 5 boten betreft, aangezien er nog geen gevulde database aan hangt.

    public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("what would you like to do?");
        System.out.println("- add new boat (N)\n" +
                "- remove a boat (R)\n" +
                "- Count boats (C)\n" +
                "- check if dock is full or not (F)\n" +
                "- List the boats (L)\n" +
                "- List available boats (A) (not yet working)\n" +
                "- change/add boat infomation (C) (not yet working)\n" +
                "- quit program (Q)");
        String inputOption = (input.nextLine()).toUpperCase();
        if (inputOption.equals("N")) {
            Boat newBoat = new Boat();
            this.addBoat(newBoat);
            this.menu();
        } else if (inputOption.equals("R")) {
            System.out.println("enter boat ID");
            int inputID = Integer.parseInt(input.nextLine());
            this.deleteBoatByID(inputID);
            this.menu();
        } else if (inputOption.equals("C")) {
            this.countBoats();
            this.menu();
        } else if (inputOption.equals("F")) {
            this.checkForRoom();
            this.menu();
        } else if (inputOption.equals("L")) {
            this.printBoats();
            this.menu();
        } else if (inputOption.equals("A")) {
            System.out.println("function not available in this version");
            this.menu();
            //TO DO: add print available method
        } else if (inputOption.equals("C")) {
            System.out.println("function not available in this version");
            this.menu();
            //TO DO: add change info method
        } else if (inputOption.equals("Q")) {
            System.out.println("are you sure you want to quit");
            String inputYN = (input.nextLine()).toUpperCase();
            if (inputYN.equals("Y")) {
                System.exit(0);
            } else {
                this.menu();
            }
        }
    }

    public void addBoatYesNo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to dock your boat? Y/N");
        String inputYN = (input.nextLine()).toUpperCase();
        //System.out.println(inputYN); --> d
        if (inputYN.equals("Y")) {
            // System.out.println("enter the name of the boat, no caps, write as one word with no spaces");
            Boat newBoat = new Boat();
            this.addBoat(newBoat);
        }
    }

    public void addBoat(Boat newBoat) {
         if (isFull() > -1) {
            long locationID = isFull();
            newBoat.setBoatID(locationID);
            boats[(int) locationID] = newBoat;
            System.out.println("Your boat ID / location ID is: " + newBoat.getBoatID());
         } else {
             System.out.println("No room for another boat!");
         }
    }

    public void printBoats() {
        for (Boat boat : this.boats) {
            if (boat != null) {
                System.out.println(boat.toString());
            }
        }
    }

    public void deleteBoatByID(long boatID) {
        this.boats[(int) boatID] = null;
    }
    //TO DO: add double check

    public void checkForRoom() {
        if (isFull() > -1) {
            System.out.println("There is space for another boat");
        } else {
            System.out.println("Dock is full");
        }
    }

    public int countBoats() {
        int n = 0;
        for (Boat boat:boats) {
            if (boat != null) {
                n = n + 1;
            }
        }
        return n;
    }

    public long isFull() {
        boolean full = true;
        for (int i = 0; i < boats.length; i++) {
            if (boats[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
