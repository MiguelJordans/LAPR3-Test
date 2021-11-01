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
        //Arrange
        long[] latitude = {0,0};
        //Act
        //Assert
        assertEquals(latitude[0],posgeral.getLatitude(0));
        assertEquals(latitude[1],posgeral.getLatitude(1));
    }

    @Test
    public void setLatitudeTest() {

        //Arrange
        long [] latitude = {1,1};
        //Act
        posgeral.setLatitude(latitude);

        //Assert
        assertEquals(latitude[0],posgeral.getLatitude(0));
        assertEquals(latitude[1],posgeral.getLatitude(1));

    }

    @Test
    public void getLongitudeTest() {

        //Arrange
        long [] longitude = {0,0};


        //Act
        //Assert
        assertEquals(longitude[0],posgeral.getLongitude(0));
        assertEquals(longitude[1],posgeral.getLongitude(1));
    }

    @Test
    public void setLongitudeTest() {

        //Arrange
        long [] longitude = {1,1};
        //Act
        posgeral.setLongitude(longitude);

        //Assert
        assertEquals(longitude[0], posgeral.getLongitude(0));
        assertEquals(longitude[1], posgeral.getLongitude(1));

    }

    @Test
    public void getHeadingTest() {

        //Arrange
        long [] heading = {0,0};

        //Act
        //Assert
        assertEquals(heading[0],posgeral.getHeading(0));
        assertEquals(heading[1],posgeral.getHeading(1));
    }

    @Test
    public void setHeadingTest() {

        //Arrange
        long[ ] heading = {1,1};
        //Act
        posgeral.setHeading(heading);
        //Assert
        assertEquals(heading[0],posgeral.getHeading(0));
        assertEquals(heading[1],posgeral.getHeading(1));
    }

    @Test
    public void getSogTest() {

        //Arrange
        //Act
        //Assert
        assertEquals(1,posgeral.getSog());

    }

    @Test
    public void setSogTest() {
        //Arrange
        //Act
        posgeral.setSog(2);
        //Assert
        assertEquals(2,posgeral.getSog());
    }

    @Test
    public void getCogTest() {
        //Arrange
        long[] cog = {0,0};

        //Act
        //Assert
        assertEquals(cog[0],posgeral.getCog(0));
        assertEquals(cog[0],posgeral.getCog(0));
    }

    @Test
    public void setCogTest() {

        //Arrange
        long[] cog = {1,1};
        //Act
        posgeral.setCog(cog);
        //Assert
        assertEquals(cog[0],posgeral.getCog(0));
        assertEquals(cog[1],posgeral.getCog(1));
    }


    @Test
    public void toStringTest(){

        //Arrange
        String expected = "Position{latitude=[0, 0], longitude=[0, 0], heading=[0, 0], sog=1, cog=[0, 0]}";

        //Act
        //Assert
        assertEquals(expected,posgeral.toString());
    }
}
