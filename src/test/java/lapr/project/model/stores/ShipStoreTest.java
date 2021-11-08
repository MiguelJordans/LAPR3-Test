package lapr.project.model.stores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lapr.project.model.Position;
import lapr.project.model.Ship;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class ShipStoreTest {


    Ship shipgeral = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

    ShipStore shipstore = new ShipStore();

    String sdate = "31-12-2020 23:16";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    LocalDateTime date = LocalDateTime.parse(sdate, formatter);

    String sdate2 = "31-12-2020 23:50";
    LocalDateTime date2 = LocalDateTime.parse(sdate2, formatter);

    Position posgeral = new Position(0, 0, 0, 0, 1, date);
    Position posgeral2 = new Position(10, 20, 30, 20, 10, date2);

    @Test
    void getlShipTest() {

        //Arrange
        List expected = shipstore.getlShip();
        //Act
        //Assert
        assertEquals(expected, shipstore.getlShip());


    }

    @Test
    void getShipSummaryByMMSI1Position() {

        //Arrange
        shipgeral.addPosition(posgeral);
        shipstore.addShip(shipgeral);
        String expected = "MMSI : 111111111\n" +
                "Vessel name: A\n" +
                "Start Base date Time: 2020-12-31T23:16\n" +
                "End base date time : 2020-12-31T23:16\n" +
                "Total movement time: 0 minutes\n" +
                "Total number of movements : 1\n" +
                "Max SOG : 0\n" +
                "Mean SOG : 0\n" +
                "Max COG : 1\n" +
                "Mean COG : 1\n" +
                "Departure Latitude : 0\n" +
                "Departure Longitude : 0\n" +
                "Arrival Latitude : 0\n" +
                "Arrival Longitude : 0\n" +
                "Travelled Distance : 0.0\n" +
                "Delta Distance : 0.0";
        //Act
        String actual = shipstore.getShipSummaryByMMSI(shipgeral.getMmsi());
        //Assert
        assertEquals(expected, actual);

    }


    @Test
    void getShipSummaryByMMSIInvalid() {

        //Arrange
        shipstore.addShip(shipgeral);
        String expected = "MMSI : 111111111\n" +
                "Vessel name: A\n" +
                "Start Base date Time: null\n" +
                "End base date time : null\n" +
                "Total movement time: 0 minutes\n" +
                "Total number of movements : 0\n" +
                "Max SOG : 0\n" +
                "Mean SOG : 0\n" +
                "Max COG : 0\n" +
                "Mean COG : 0\n" +
                "Departure Latitude : 0\n" +
                "Departure Longitude : 0\n" +
                "Arrival Latitude : 0\n" +
                "Arrival Longitude : 0\n" +
                "Travelled Distance : 0.0\n" +
                "Delta Distance : 0.0";
        //Act
        String actual = shipstore.getShipSummaryByMMSI(shipgeral.getMmsi());
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getShipSummaryByMMSI2Positions() {

        //Arrange
        shipgeral.addPosition(posgeral);
        shipgeral.addPosition(posgeral2);
        shipstore.addShip(shipgeral);
        String expected = "MMSI : 111111111\n" +
                "Vessel name: A\n" +
                "Start Base date Time: 2020-12-31T23:16\n" +
                "End base date time : 2020-12-31T23:50\n" +
                "Total movement time: 34 minutes\n" +
                "Total number of movements : 2\n" +
                "Max SOG : 20\n" +
                "Mean SOG : 10\n" +
                "Max COG : 10\n" +
                "Mean COG : 5\n" +
                "Departure Latitude : 0\n" +
                "Departure Longitude : 10\n" +
                "Arrival Latitude : 0\n" +
                "Arrival Longitude : 20\n" +
                "Travelled Distance : 2476.1714106209574\n" +
                "Delta Distance : 2476.1714106209574";
        //Act
        String actual = shipstore.getShipSummaryByMMSI(shipgeral.getMmsi());
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getShipSummaryByIMO1Position() {

        //Arrange
        shipgeral.addPosition(posgeral);
        shipstore.addShip(shipgeral);
        String expected = "MMSI : 111111111\n" +
                "Vessel name: A\n" +
                "Start Base date Time: 2020-12-31T23:16\n" +
                "End base date time : 2020-12-31T23:16\n" +
                "Total movement time: 0 minutes\n" +
                "Total number of movements : 1\n" +
                "Max SOG : 0\n" +
                "Mean SOG : 0\n" +
                "Max COG : 1\n" +
                "Mean COG : 1\n" +
                "Departure Latitude : 0\n" +
                "Departure Longitude : 0\n" +
                "Arrival Latitude : 0\n" +
                "Arrival Longitude : 0\n" +
                "Travelled Distance : 0.0\n" +
                "Delta Distance : 0.0";
        //Act
        String actual = shipstore.getShipSummaryByMMSI(shipgeral.getImo());
        //Assert
        assertEquals(expected, actual);

    }


    @Test
    void getShipSummaryByIMOInvalid() {

        //Arrange
        shipstore.addShip(shipgeral);
        String expected = "MMSI : 111111111\n" +
                "Vessel name: A\n" +
                "Start Base date Time: null\n" +
                "End base date time : null\n" +
                "Total movement time: 0 minutes\n" +
                "Total number of movements : 0\n" +
                "Max SOG : 0\n" +
                "Mean SOG : 0\n" +
                "Max COG : 0\n" +
                "Mean COG : 0\n" +
                "Departure Latitude : 0\n" +
                "Departure Longitude : 0\n" +
                "Arrival Latitude : 0\n" +
                "Arrival Longitude : 0\n" +
                "Travelled Distance : 0.0\n" +
                "Delta Distance : 0.0";
        //Act
        String actual = shipstore.getShipSummaryByMMSI(shipgeral.getMmsi());
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getShipSummaryByIMO2Positions() {

        //Arrange
        shipgeral.addPosition(posgeral);
        shipgeral.addPosition(posgeral2);
        shipstore.addShip(shipgeral);
        String expected = "MMSI : 111111111\n" +
                "Vessel name: A\n" +
                "Start Base date Time: 2020-12-31T23:16\n" +
                "End base date time : 2020-12-31T23:50\n" +
                "Total movement time: 34 minutes\n" +
                "Total number of movements : 2\n" +
                "Max SOG : 20\n" +
                "Mean SOG : 10\n" +
                "Max COG : 10\n" +
                "Mean COG : 5\n" +
                "Departure Latitude : 0\n" +
                "Departure Longitude : 10\n" +
                "Arrival Latitude : 0\n" +
                "Arrival Longitude : 20\n" +
                "Travelled Distance : 2476.1714106209574\n" +
                "Delta Distance : 2476.1714106209574";
        //Act
        String actual = shipstore.getShipSummaryByMMSI(shipgeral.getMmsi());
        //Assert
        assertEquals(expected, actual);

    }




   /* @Test
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
    }*/

}