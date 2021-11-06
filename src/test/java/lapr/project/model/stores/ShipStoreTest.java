package lapr.project.model.stores;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lapr.project.model.Ship;
import org.junit.jupiter.api.Test;

import java.util.List;

class ShipStoreTest {


    public Ship shipgeral = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

    ShipStore shipstore = new ShipStore();


    @Test
    public void getlShipTest() {

        //Arrange
        List expected = shipstore.getlShip();
        //Act
        //Assert
        assertEquals(expected,shipstore.getlShip());


    }


    @Test
    public void writeAllShips(){
        //Arrange
        shipstore.getlShip().add(shipgeral);
        ShipStore shipstore2 = new ShipStore();

        //Act
        //Assert
        assertEquals(false,shipstore2.writeAllShips());
        assertEquals(true,shipstore.writeAllShips());

    }

    @Test
    public void getShipByMMSITest(){
        //Arrange
        shipstore.getlShip().add(shipgeral);
        ShipStore shipstore2 = new ShipStore();
        //Act
        //Assert
        assertEquals(shipgeral,shipstore.getShipByMMSI(111111111));
        assertEquals(null,shipstore2.getShipByMMSI(111111111));
    }

}