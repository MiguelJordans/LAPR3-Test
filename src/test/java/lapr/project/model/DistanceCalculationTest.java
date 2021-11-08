package lapr.project.model;

import lapr.project.shared.DistanceCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

public class DistanceCalculationTest extends DistanceCalculation {

    LocalDateTime dateTime = LocalDateTime.now();
    LocalDateTime dateTime2 = LocalDateTime.of(2021, 6, 10, 23, 2, 2);
    LocalDateTime dateTime3 = LocalDateTime.of(2021, 7, 12, 2, 2, 2);
    LocalDateTime dateTime4 = LocalDateTime.of(2020, 8, 12, 2, 2, 2);

    Position posgeral2 = new Position(20, 20, 20, 10, 10, dateTime2);
    Position posgeral = new Position(0, 0, 0, 1, 0, dateTime3);

    Position posgeral3 = new Position(0, 0, 0, 1, 0, dateTime);


    Position posgeral4 = new Position(20, 20, 20, 10, 10, dateTime3);


    Ship shipgeral = new Ship(222111122, "nome", "IMO1111111", 1, 1, "A", "A", 1, 1, 1, 1);

    Ship shipgeral2 = new Ship(222222222, "nome", "IMO1111111", 1, 1, "A", "A", 1, 1, 1, 1);


    @Test
    public void distanceCalculationTest() {

        //Arrange
        //Act
        double d = distanceTo(posgeral, posgeral2);
        double d2 = distanceTo(null, null);
        //Assert
        assertEquals(3112.445040079722, distanceTo(posgeral, posgeral2));
        assertEquals(0, d2);


    }

    @Test
    public void traveledDistanceBaseDateTimeTest() {

        //Arrange

        shipgeral.getPosDate().addPosition(posgeral2);
        shipgeral.getPosDate().addPosition(posgeral);
        shipgeral.getPosDate().addPosition(posgeral3);
        shipgeral.getPosDate().addPosition(posgeral4);
        dateTime3 = LocalDateTime.of(2021, 1, 1, 1, 1, 1);
        dateTime4 = LocalDateTime.of(2022, 1, 1, 1, 1, 1);
        double expected = 3112.445040079722;
        Ship s = null;
        //Act
        //Assert
        assertEquals(expected, 3112.445040079722);
        assertEquals(0, traveledDistanceBaseDateTime(s, dateTime3, dateTime4));
        assertEquals(0, traveledDistanceBaseDateTime(shipgeral, null, dateTime4));
        assertEquals(0, traveledDistanceBaseDateTime(shipgeral, dateTime3, null));

    }
}
