package lapr.project.utils.mappers;

import lapr.project.model.Ship;
import lapr.project.utils.mappers.dto.ShipDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipMapperTest {

    Ship shipgeral = new Ship(111111111, "name", "IMO1111111", 1, 1, "A", "A", 1, 1, 1, 1);
    Ship shipgeral2 = new Ship(121111111, "name", "IMO1111111", 1, 1, "A", "A", 1, 1, 1, 1);


    ShipMapper shipMapper = new ShipMapper();

    @Test
    void toDTO() {

        //Arrange

        List<Ship> slist = new ArrayList<>();
        slist.add(shipgeral);
        slist.add(shipgeral2);

        List<ShipDTO> expected = shipMapper.toDTO(slist);

        //Act + Assert
        assertNotNull(expected);

    }
}