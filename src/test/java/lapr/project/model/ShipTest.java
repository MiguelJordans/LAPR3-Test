package lapr.project.model;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShipTest {


    Ship shipgeral = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

    Position posgeral = new Position(0, 0, 0, 1, 0);

    @Test
    public void checkMMSITest() {

        //Arrange
        //Act
        try {
            Ship ship1 = new Ship(111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
            Ship ship2 = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

        } catch (IllegalArgumentException ex) {
            //Assert
            assertEquals(ex.getMessage(), "MMSI code must have 9 digits!");
        }


    }

    @Test
    public void checkIMOTest() {

        //Arrange
        //Act
        try {
            Ship ship1 = new Ship(111111111, "name", 11, 1, 1, "A", "A", 1, 1, 1, 1);
            Ship ship2 = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
        } catch (IllegalArgumentException ex) {
            //Assert
            assertEquals(ex.getMessage(), "IMO code must have 7 digits!");
        }


    }


    @Test
    public void getMmsiTest() {

        //Arrange
        //Act
        //Assert
        assertEquals(111111111, shipgeral.getMmsi());
    }

    @Test
    public void setMmsiTest() {
        //Arrange
        //Act
        shipgeral.setMmsi(222222222);
        //Assert
        assertEquals(222222222, shipgeral.getMmsi());
    }

    @Test
    public void getNameTest() {
        //Arrange
        //Act
        //Assert
        assertEquals("name", shipgeral.getName());

    }

    @Test
    public void setNameTest() {
        //Arrange
        //Act
        shipgeral.setName("barco");
        //Assert
        assertEquals("barco", shipgeral.getName());

    }

    @Test
    public void getImoTest() {
        //Arrange
        //Act
        //Assert
        assertEquals(1111111, shipgeral.getImo());
    }

    @Test
    public void setImoTest() {

        //Arrange
        //Act
        shipgeral.setImo(2222222);

        //Assert
        assertEquals(2222222, shipgeral.getImo());
    }

    @Test
    public void getNumGenTest() {
        //Arrange
        //Act
        //Assert
        assertEquals(1, shipgeral.getNumGen());
    }

    @Test
    public void setNumGenTest() {

        //Arrange
        //Act
        shipgeral.setNumGen(2);
        //Assert
        assertEquals(2, shipgeral.getNumGen());

    }

    @Test
    public void getCallSignTest() {

        //Arrange
        //Act
        //Assert
        assertEquals("A", shipgeral.getCallSign());
    }

    @Test
    public void setCallSignTest() {

        //Arrange
        //Act
        shipgeral.setCallSign("B");
        //Assert
        assertEquals("B", shipgeral.getCallSign());
    }

    @Test
    public void getVesselTypeTest() {

        //Arrange
        //Act
        //Assert
        assertEquals("A", shipgeral.getVesselType());
    }

    @Test
    public void setVesselTypeTest() {

        //Arrange
        //Act
        shipgeral.setVesselType("B");
        //Assert
        assertEquals("B", shipgeral.getVesselType());
    }

    @Test
    public void getLength() {

        //Arrange
        //Act
        //Assert
        assertEquals(1, shipgeral.getLength());
    }

    @Test
    public void setLengthTest() {

        //Arrange
        //Act
        shipgeral.setLength(2);
        //Assert
        assertEquals(2, shipgeral.getLength());
    }

    @Test
    public void getWidthTest() {

        //Arrange
        //Act
        //Assert
        assertEquals(1, shipgeral.getWidth());
    }

    @Test
    public void setWidthTest() {

        //Arrange
        //Act
        shipgeral.setWidth(2);
        //Assert
        assertEquals(2, shipgeral.getWidth());
    }

    @Test
    public void getCapacityTest() {

        //Arrange
        //Act
        //Assert
        assertEquals(1, shipgeral.getCapacity());
    }

    @Test
    public void setCapacityTest() {

        //Arrange
        //Act
        shipgeral.setCapacity(2);
        //Assert
        assertEquals(2, shipgeral.getCapacity());
    }

    @Test
    public void getDraftTest() {

        //Arrange
        //Act
        //Assert
        assertEquals(1, shipgeral.getDraft());
    }

    @Test
    public void setDraftTest() {

        //Arrange
        //Act
        shipgeral.setDraft(2);
        //Assert
        assertEquals(2, shipgeral.getDraft());

    }

    @Test
    public void setGenPowerOutputTest() {

        //Arrange
        //Act
        shipgeral.setGenPowerOutput(2);
        //Assert
        assertEquals(2, shipgeral.getGenPowerOutput());
    }

    @Test
    public void getPosDate() {

        //Arrange
        Map<Date, Position> expected = new HashMap<>();
        expected.put(new Date("Thu, Dec 31 1998 23:37:50"), posgeral);
        //Act
        shipgeral.getPosDate().put(new Date("Thu, Dec 31 1998 23:37:50"), posgeral);
        //Assert
        assertEquals(expected.keySet().toArray()[0], shipgeral.getPosDate().keySet().toArray()[0]);

    }

    @Test
    public void organizePosDateTest() {

        //Arrange
        shipgeral.getPosDate().put(new Date("Thu, Dec 31 1998 23:37:50"), posgeral);
        shipgeral.getPosDate().put(new Date("Thu, Dec 20 1997 23:36:30"), posgeral);

        //act
        shipgeral.organizeDatePos();

        //Assert
        assertEquals(new Date("Thu, Dec 20 1997 23:36:30"), shipgeral.getPosDate().keySet().toArray()[0]);
        assertEquals(new Date("Thu, Dec 31 1998 23:37:50"), shipgeral.getPosDate().keySet().toArray()[1]);
    }

    /*
    @Test
    public void  writeAllPos(){

        //Arrange
        Map<LocalDateTime,Position> expected = new HashMap<>();

        //Act
        shipgeral.getPosDate().put(new Date("Thu, Dec 31 1998 23:37:50"),posgeral);

        //Assert
        assertEquals("Thu Dec 31 23:37:50 WET 1998: Position{latitude=0, longitude=0, heading=0, sog=1, cog=0}",shipgeral.writeAllPos());
    }*/

    @Test
    public void addNewPosMessageTest() {

        //Arrange
        Position posgeral = new Position(0, 0, 0, 1, 0);
        //Act
        //Assert
        assertEquals(false, shipgeral.addNewPosMessage(null, null));
        assertEquals(true, shipgeral.addNewPosMessage(new Date("Thu, Dec 31 1998 23:37:50"), posgeral));


    }


    @Test
    public void toStringTest() {

        //Arrange
        String expected = "Ship{mmsi=111111111, name='name', imo=1111111, numGen=1, genPowerOutput=1, callSign='A', vesselType='A', length=1, width=1, capacity=1, draft=1, posDate={}}";

        //Act
        //Assert
        assertEquals(expected, shipgeral.toString());
    }
}
