package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.auth.domain.store.ShipStore;

public class PositionalMessageController {

    private Company company;
    private ShipStore shipStore;

    public PositionalMessageController() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipStore();
    }


    public boolean getPositionalMessages(long mmsi) {

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
