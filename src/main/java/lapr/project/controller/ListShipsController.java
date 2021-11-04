package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.auth.domain.store.ShipStore;

import java.util.ArrayList;
import java.util.List;

public class ListShipsController {

    Ship ship;
    ShipStore shipStore;
    List<Integer> shipListMmsi;

    public ListShipsController() {
        App app = App.getInstance();
        Company company = app.getCompany();
        shipStore = company.getShipStore();
        shipListMmsi = new ArrayList<>();
    }

    public List<Integer> getShipList() {
        shipListMmsi = new ArrayList<>();
        shipListMmsi.addAll(shipStore.getMmsiList(ship));
        return shipListMmsi;
    }
}
