package lapr.project.utils.mappers.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipDTOTest {

    ShipDTO shipDTO = new ShipDTO(1111111111, 3, 34.2, 32.2);


    @Test
    void testToString() {

        //Arrange
        String expected = shipDTO.toString();

        //Act
        String actual = shipDTO.toString();

        //Assert
        assertEquals(expected, actual);

    }
}