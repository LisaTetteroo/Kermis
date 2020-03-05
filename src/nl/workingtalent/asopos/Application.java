package nl.workingtalent.asopos;


import com.sun.deploy.net.MessageHeader;
import nl.workingtalent.asopos.model.*;

public class Application {
    public static void main(String[] args) {
        Dock dock = new Dock();

        /*
        Boat dwars = new Boat();
        Boat knorretje = new Boat();
        Boat canton = new Boat();
        Boat bluesbrother = new Boat();
        Boat aquarius = new Boat();

        dwars.setName("Dwars");
        knorretje.setName("Knorretje");
        canton.setName("Canton");
        bluesbrother.setName("Blues Brothers");
        aquarius.setName("Aquarius");

        dwars.setType("B4+");
        knorretje.setType("C4+");
        aquarius.setType("C2x+");

        knorretje.setAvailable(false);

        dock.addBoat(dwars);
        dock.addBoat(knorretje);
        dock.addBoat(canton);
        dock.addBoat(bluesbrother);
        dock.addBoat(aquarius);

        dock.printBoats();

        System.out.println("kan er nog een boot bij?");

        dock.checkForRoom();

        dock.deleteBoatByID(canton.getBoatID());

        System.out.println("print boten na een delete");

        dock.printBoats();


        System.out.println("tellen van boten");

        System.out.println(dock.countBoats());

        System.out.println("kan er nog een boot bij? (na een delete)");

        dock.checkForRoom();

        */

        /*
        dock.addBoatYesNo();
        dock.printBoats();
         */

        dock.menu();

    }
}
