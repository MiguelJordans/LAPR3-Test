package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.stores.ShipStore;
import lapr.project.utils.mappers.ShipMapper;
import lapr.project.utils.mappers.dto.ShipDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListShipsController {

    Company company;
    ShipStore shipStore;
    List<Ship> shipList;
    ShipMapper shipMapper;

    public ListShipsController() {
        this.company = App.getInstance().getCompany();
        this.shipStore = company.getShipStore();
    }

    public List<Ship> getShipList() {
        shipList = new ArrayList<>();
        shipList = shipStore.getlShip();
        return shipList;
    }

    public List<Ship> sortedList() {
        Comparator<Ship> comparator1 = (o1, o2) -> {

            double x1 = o1.getTravelledDistance();
            double x2 = o2.getTravelledDistance();

            double z1 = o1.getPosDate().getSize();
            double z2 = o2.getPosDate().getSize();

            double result1 = x2 - x1;
            double result2 = z2 - z1;

            if (result1 > 0) {
                return 1;
            } else if (result1 < 0) {
                return -1;
            } else {
                if (result2 > 0) {
                    return -1;
                } else if (result2 < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        shipList.sort(comparator1);

        return shipList;
    }

    public List<ShipDTO> getShipListDTO() {
        this.shipMapper = new ShipMapper();
        List<Ship> sShips = sortedList();

        return shipMapper.toDTO(sShips);
    }
}