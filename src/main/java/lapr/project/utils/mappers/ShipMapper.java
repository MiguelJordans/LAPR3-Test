package lapr.project.utils.mappers;

import lapr.project.model.Ship;
import lapr.project.utils.mappers.dto.ShipDTO;

import java.util.ArrayList;
import java.util.List;

public class ShipMapper {

    private ShipDTO toDTO(Ship ship, int totalNumberMovements) {
        return new ShipDTO(ship.getMmsi(), totalNumberMovements, ship.getTravelledDistance(), ship.getDeltaDistance());
    }

    public List<ShipDTO> toDTO(List<Ship> sList, int totalNumberMovements) {
        List<ShipDTO> shipDTOS = new ArrayList<>();
        for (Ship ship : sList) {
            shipDTOS.add(this.toDTO(ship, totalNumberMovements));
        }
        return shipDTOS;
    }
}

