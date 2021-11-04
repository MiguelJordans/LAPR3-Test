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
            ctrl.getShipList();
        } catch (Exception e) {
            System.out.println("Ship list empty!");
            return;
        }

        List<Integer> shipMmsi = ctrl.getShipList();
        System.out.println(shipMmsi);
    }
}
