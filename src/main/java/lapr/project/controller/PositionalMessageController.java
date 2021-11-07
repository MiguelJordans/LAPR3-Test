package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.stores.ShipStore;
<<<<<<< HEAD
=======

>>>>>>> 74b846f8bfc46f46d8bbe410d135c0baa5eac826

public class PositionalMessageController {

    private Company company;
    private ShipStore shipStore;

    public PositionalMessageController() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipStore();
    }


    public boolean getPositionalMessages(int mmsi) {

        Ship ship = shipStore.getShipByMMSI(mmsi);


        if (ship == null) return false;

        String posMessage = ship.writeAllPos();

        if (posMessage.equals("Positional Messages:")) {
            System.out.println(mmsi + " positional messages are empty!");
        } else {
            System.out.println(posMessage);
            System.out.println("\n\nPositional messages sent successfully|");
        }

        return true;
    }
}
