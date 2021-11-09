package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Position;
import lapr.project.model.Ship;
import lapr.project.model.stores.PositionTree;
import lapr.project.model.stores.ShipStore;
import lapr.project.shared.BinarySearchTree;

import java.time.LocalDateTime;
import java.util.Iterator;


public class PositionalMessageController {

    private Company company;
    private ShipStore shipStore;

    public PositionalMessageController() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipStore();
    }


    public boolean getPositionalMessages(int mmsi, LocalDateTime di , LocalDateTime df) {

        Ship ship = shipStore.getShipByMMSI(mmsi);


        if (ship == null) return false;

        String posMessage = ship.writeAllPos(di,df);

        if (posMessage.equals("Positional Message:")) {
            System.out.println(mmsi + " positional messages are empty!");
        } else {
            System.out.println(posMessage);
            System.out.println("\n\nPositional messages sent successfully|");
        }

        return true;
    }
}
