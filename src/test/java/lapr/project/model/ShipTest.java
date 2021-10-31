package lapr.project.model;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShipTest {


    Ship shipgeral = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

    @Test
    public void checkMMSITest() {

        try {
            Ship ship1 = new Ship(111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
            Ship ship2 = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "MMSI code must have 9 digits!");
        }


    }

    @Test
    public void checkIMOTest() {

        try {
            Ship ship1 = new Ship(111111111, "name", 11, 1, 1, "A", "A", 1, 1, 1, 1);
            Ship ship2 = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "IMO code must have 7 digits!");
        }


    }


    @Test
    public void getMmsiTest() {
        assertEquals(111111111, shipgeral.getMmsi());
    }

    @Test
    public void setMmsiTest() {
        shipgeral.setMmsi(222222222);
        assertEquals(222222222, shipgeral.getMmsi());
    }

    @Test
    public void getNameTest() {
        assertEquals("name", shipgeral.getName());

    }

    @Test
    public void setNameTest() {
        shipgeral.setName("barco");
        assertEquals("barco", shipgeral.getName());

    }

    @Test
    public void getImoTest() {
        assertEquals(1111111, shipgeral.getImo());
    }

    @Test
    public void setImoTest() {

        shipgeral.setImo(2222222);

        assertEquals(2222222, shipgeral.getImo());
    }

    @Test
    public void getNumGenTest() {

        assertEquals(1, shipgeral.getNumGen());
    }

    @Test
    public void setNumGenTest() {

        shipgeral.setNumGen(2);
        assertEquals(2, shipgeral.getNumGen());

    }

    @Test
    public void getCallSignTest() {

        assertEquals("A", shipgeral.getCallSign());
    }

    @Test
    public void setCallSignTest() {

        shipgeral.setCallSign("B");
        assertEquals("B", shipgeral.getCallSign());
    }

    @Test
    public void getVesselTypeTest() {

        assertEquals("A", shipgeral.getVesselType());
    }

    @Test
    public void setVesselTypeTest() {

        shipgeral.setVesselType("B");
        assertEquals("B", shipgeral.getVesselType());
    }

    @Test
    public void getLength() {

        assertEquals(1, shipgeral.getLength());
    }

    @Test
    public void setLengthTest() {

        shipgeral.setLength(2);
        assertEquals(2, shipgeral.getLength());
    }

    @Test
    public void getWidthTest() {

        assertEquals(1, shipgeral.getWidth());
    }

    @Test
    public void setWidthTest() {

        shipgeral.setWidth(2);
        assertEquals(2, shipgeral.getWidth());
    }

    @Test
    public void getCapacityTest() {

        assertEquals(1, shipgeral.getCapacity());
    }

    @Test
    public void setCapacityTest() {

        shipgeral.setCapacity(2);
        assertEquals(2, shipgeral.getCapacity());
    }

    @Test
    public void getDraftTest() {

        assertEquals(1, shipgeral.getDraft());
    }

    @Test
    public void setDraftTest() {

        shipgeral.setDraft(2);
        assertEquals(2, shipgeral.getDraft());

    }
}
