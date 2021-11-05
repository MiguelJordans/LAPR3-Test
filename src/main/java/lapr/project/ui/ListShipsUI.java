package lapr.project.ui;

import lapr.project.controller.ListShipsController;

import java.util.List;

public class ListShipsUI implements Runnable {
    ListShipsController ctrl;

    public ListShipsUI() {
        ctrl = new ListShipsController();
    }

    public void run() {
        try {
            ctrl.getShipListMmsi();
            ctrl.getShipListMovements();
        } catch (Exception e) {
            System.out.println("Ship list empty!");
            return;
        }

        List<Integer> shipListMmsi = ctrl.getShipListMmsi();
        System.out.println();
        System.out.println("### Ship List - MMSI ###");
        System.out.println(shipListMmsi);

        List<String> shipListMov = ctrl.getShipListMovements();
        System.out.println();
        System.out.println("### Ship List - Number of Movements ###");
        System.out.println(shipListMov);
    }
}
