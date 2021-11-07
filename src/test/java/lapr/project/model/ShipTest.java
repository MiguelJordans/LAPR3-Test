package lapr.project.model;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShipTest {


    Ship shipgeral = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

    LocalDateTime dateTime =LocalDateTime.now();

    Position posgeral = new Position(0, 0, 0, 1, 0,dateTime);

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
    public void getPositionByLocalDateTimeTest(){

        //Arrange
        shipgeral.addPosition(posgeral);
        Position expected = posgeral;
        //Act
        //Assert
        assertEquals(expected, shipgeral.getPositionByLocalDateTime(dateTime));
    }


    @Test
    public void toStringTest() {

        //Arrange
        String expected = shipgeral.toString();
        //Act
        //Assert
        assertEquals(expected, shipgeral.toString());
    }


}
