package lapr.project.model;

import lapr.project.shared.DistanceCalculation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;

public class DistanceCalculationTest extends DistanceCalculation {

    LocalDateTime dateTime =LocalDateTime.now();

    Position posgeral = new Position(0, 0, 0, 1, 0,dateTime);

    LocalDateTime dateTime2 = LocalDateTime.of(2021,7,10,23,2,2);

    Position posgeral2 = new Position(20, 20, 20, 10, 10,dateTime);



    @Test
    public void distanceCalculationTest(){

        //Arrange
        //Act
        double d = distanceTo(posgeral,posgeral2);
        double d2 = distanceTo(null,null);
        //Assert
        assertEquals(3112.445040079722,distanceTo(posgeral,posgeral2));
        assertEquals(0,d2);


    }
}
