package lapr.project.controller;

import lapr.project.model.Ship;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PositionalMessageControllerTest {

    PositionalMessageController positionalMessageController = new PositionalMessageController();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    String sdate = "31-12-2020 23:16";
    LocalDateTime date = LocalDateTime.parse(sdate, formatter);

    String sdate2 = "31-12-2020 23:56";
    LocalDateTime date2 = LocalDateTime.parse(sdate2, formatter);

    @Test
    void getPositionalMessages() {

        //Arrange
        //Act
        //Assert
        assertEquals(false,positionalMessageController.getPositionalMessages(1234567899,date,date2));
        assertEquals(true,positionalMessageController.getPositionalMessages(111111111,date,date2));
    }
}