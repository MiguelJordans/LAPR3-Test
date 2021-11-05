package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.auth.domain.store.ShipStore;

import java.util.ArrayList;
import java.util.List;

public class ListShipsController {

    Company company;
    ShipStore shipStore;
    List<Integer> shipListMmsi;
    List<String> shipListMov;

    public ListShipsController() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipStore();
        this.shipListMmsi = new ArrayList<>();
    }

    public List<Integer> getShipListMmsi() {
        shipListMmsi = new ArrayList<>();
        shipListMmsi = shipStore.getShipListMmsi();
        return shipListMmsi;
    }

    public List<String> getShipListMovements() {
        shipListMov = new ArrayList<>();
        shipListMov = shipStore.getShipListPos();
        return shipListMov;
    }
}
