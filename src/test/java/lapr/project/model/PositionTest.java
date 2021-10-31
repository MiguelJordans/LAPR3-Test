package lapr.project.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

public class PositionTest {

    long[] latitude = {0,0};
    long[] longitude = {0,0};
    long[] heading = {0,0};
    long[] cog = {0,0};


    Position posgeral = new Position(latitude,longitude,heading,1,cog);

    @Test
    public void getLatitudeTest() {
        long[] latitude = {0,0};
        assertEquals(latitude[0],posgeral.getLatitude(0));
        assertEquals(latitude[1],posgeral.getLatitude(1));
    }

    @Test
    public void setLatitudeTest() {

        long [] latitude = {1,1};
        posgeral.setLatitude(latitude);

        assertEquals(latitude[0],posgeral.getLatitude(0));
        assertEquals(latitude[1],posgeral.getLatitude(1));

    }

    @Test
    public void getLongitudeTest() {

        long [] longitude = {0,0};


        assertEquals(longitude[0],posgeral.getLongitude(0));
        assertEquals(longitude[1],posgeral.getLongitude(1));
    }

    @Test
    public void setLongitudeTest() {

        long [] longitude = {1,1};
        posgeral.setLongitude(longitude);

        assertEquals(longitude[0], posgeral.getLongitude(0));
        assertEquals(longitude[1], posgeral.getLongitude(1));

    }

    @Test
    public void getHeadingTest() {

        long [] heading = {0,0};

        assertEquals(heading[0],posgeral.getHeading(0));
        assertEquals(heading[1],posgeral.getHeading(1));
    }

    @Test
    public void setHeadingTest() {

        long[ ] heading = {1,1};
        posgeral.setHeading(heading);

        assertEquals(heading[0],posgeral.getHeading(0));
        assertEquals(heading[1],posgeral.getHeading(1));
    }

    @Test
    public void getSogTest() {

        assertEquals(1,posgeral.getSog());

    }

    @Test
    public void setSogTest() {
        posgeral.setSog(2);
        assertEquals(2,posgeral.getSog());
    }

    @Test
    public void getCogTest() {
        long[] cog = {0,0};


        assertEquals(cog[0],posgeral.getCog(0));
        assertEquals(cog[0],posgeral.getCog(0));
    }

    @Test
    public void setCogTest() {

        long[] cog = {1,1};
        posgeral.setCog(cog);
        assertEquals(cog[0],posgeral.getCog(0));
        assertEquals(cog[1],posgeral.getCog(1));
    }

}
