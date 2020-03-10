//TO DO: andere invoer dan gewenst uitfilteren

package nl.workingtalent.asopos.model;

import java.util.Scanner;

public class Dock {
    private Boat[] boats = new Boat[5];
    Scanner input = new Scanner(System.in);
    //hoewel 80 boten meer de werkelijkheid benaderd voor een grote vereniging als Asopos,
    //is het voor het testen handiger als het maar 5 boten betreft, aangezien er nog geen gevulde database aan hangt.

    public void menu() {
        System.out.println("what would you like to do?");
        System.out.println("- add new boat (N)\n" +
                "- remove a boat (R)\n" +
                "- Count boats (C)\n" +
                "- check if dock is full or not (F)\n" +
                "- List the boats (L)\n" +
                "- List available boats (A)\n" +
                "- change/add boat-data (D)\n" +
                "- quit program (Q)");
        String inputOption = (input.nextLine()).toUpperCase();
        if (inputOption.equals("N")) {
            Boat newBoat = new Boat();
            this.addBoat(newBoat);
            this.menu();
        } else if (inputOption.equals("R")) {
            System.out.println("enter boat ID");
            int inputID = Integer.parseInt(input.nextLine());

            System.out.println("are you sure you want to delete the following boat");
            getBoatData(inputID);

            String inputYN = (input.nextLine()).toUpperCase();
            if (inputYN.equals("Y")) {
                this.deleteBoatByID(inputID);
                this.menu();
            } else {
                this.menu();
            }

        } else if (inputOption.equals("C")) {
            System.out.println(this.countBoats());
            this.menu();
        } else if (inputOption.equals("F")) {
            this.checkForRoom();
            this.menu();
        } else if (inputOption.equals("L")) {
            this.printBoats();
            this.menu();
        } else if (inputOption.equals("A")) {
            printAvailableBoats();
            this.menu();
            //TO DO: add print available method
        } else if (inputOption.equals("D")) {
            System.out.println("enter boat ID or enter -1 to go back to main menu.");
            int inputID = Integer.parseInt(input.nextLine());
            this.changeBoatData(inputID);
            //TO DO: add change info method
        } else if (inputOption.equals("Q")) {
            System.out.println("are you sure you want to quit");
            String inputYN = (input.nextLine()).toUpperCase();
            if (inputYN.equals("Y")) {
                System.exit(0);
            } else {
                this.menu();
            }
        } else {
            System.out.println("invalid input");
            this.menu();
        }
    }

    /*
    //oude code, voordat er een menu was
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
    */



    public void addBoat(Boat newBoat) {
         if (isFull() > -1) {
            long locationID = isFull();
            newBoat.setBoatID(locationID);
            boats[(int) locationID] = newBoat;
            System.out.println("Your boat ID is: " + newBoat.getBoatID());
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

    public void printAvailableBoats () {
        for (Boat boat : this.boats) {
            if (boat != null && boat.isAvailable() == true) {
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

    public void changeBoatData (int inputID) {

        String inputOption = "";
        if (inputID < 0) {
            this.menu();
        } else {
            System.out.println("What would you like to change for the following boat?\n");
            getBoatData(inputID);
            System.out.println("   - name (N)\n" +
                    "   - type (T)\n" +
                    "   - Weightclass (W)\n" +
                    "   - TopTeamboat (TTB)\n" +
                    "   - private boat (P)\n" +
                    "   - aivailability (A)\n" +
                    "   - back to main menu (M)");
            inputOption = (input.nextLine()).toUpperCase();
        }

        if (inputOption.equals("N")) {
            System.out.println("Enter new name:");
            String inputName = input.nextLine();
            for (Boat boat : this.boats) {
                if (boat.getBoatID() == inputID) {
                    boat.setName(inputName);
                    break;
                }
            }
            this.continueChangingData(inputID);
        } else if (inputOption.equals("T")) {
            System.out.println("Enter (new) type:");
            String inputType = input.nextLine();
            for (Boat boat : this.boats) {
                if (boat.getBoatID() == inputID) {
                    boat.setType(inputType);
                    break;
                }
            }
            this.continueChangingData(inputID);
        } else if (inputOption.equals("W")) {
            System.out.println("Enter (new) weightclass):");
            String inputWeightclass = input.nextLine();
            for (Boat boat : this.boats) {
                if (boat.getBoatID() == inputID) {
                    boat.setWeightClass(inputWeightclass);
                    break;
                }
            }
            this.continueChangingData(inputID);
        } else if (inputOption.equals("TTB")) {
            System.out.println("is this a TopTeam boat? enter Y for yes and N if it is a competition boat");
            String inputYN = (input.nextLine()).toUpperCase();
            for (Boat boat : this.boats) {
                if (boat.getBoatID() == inputID && inputYN.equals("Y")) {
                    boat.setTopTeamBoat(true);
                    break;
                } else if (boat.getBoatID() == inputID && inputYN.equals("N")) {
                    boat.setTopTeamBoat(false);
                    break;
                }
            }
            this.continueChangingData(inputID);
        } else if (inputOption.equals("P")) {
            System.out.println("is this a private boat? enter Y for yes and N if it is a Asopos boat.");
            String inputYN = (input.nextLine()).toUpperCase();
            for (Boat boat : this.boats) {
                if (boat.getBoatID() == inputID && inputYN.equals("Y")) {
                    boat.setPrivateBoat(true);
                    break;
                } else if (boat.getBoatID() == inputID && inputYN.equals("N")) {
                    boat.setPrivateBoat(false);
                    break;
                }
            }
            this.continueChangingData(inputID);
        } else if (inputOption.equals("A")) {
            System.out.println("is the boat currently available? enter Y if it is (default), enter N if it is currently unavailable.");
            String inputYN = (input.nextLine()).toUpperCase();
            for (Boat boat : this.boats) {
                if (boat.getBoatID() == inputID && inputYN.equals("Y")) {
                    boat.setAvailable(true);
                    break;
                } else if (boat.getBoatID() == inputID && inputYN.equals("N")) {
                    boat.setAvailable(false);
                    break;
                }
            }
            this.continueChangingData(inputID);
        } else if (inputOption.equals("M")) {
            this.menu();
        } else {
            System.out.println("invalid input");
            this.changeBoatData(inputID);
        }
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

    public void getBoatData(int inputBoatID) {
        for (Boat boat : this.boats) {
            if (boat.getBoatID() == inputBoatID) {
                System.out.println(boat.toString());
                break;
            }
        }
    }

    public void continueChangingData (int boatID) {
        System.out.println("want to continue?\n" +
                "- to continue changing data of the same boat enter C\n" +
                "- to change data on another boat enter boat ID \n" +
                "- to go back to main menu enter M");
        String inputOption = (input.nextLine()).toUpperCase();
        if (inputOption.equals("C")) {
            changeBoatData(boatID);
        } else if (inputOption.equals("M")) {
            this.menu();
        } else {
            int otherBoatID = Integer.parseInt(inputOption);
            changeBoatData(otherBoatID);
        }
    }
}
