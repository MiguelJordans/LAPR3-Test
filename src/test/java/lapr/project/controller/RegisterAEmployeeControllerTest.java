package lapr.project.controller;

import lapr.project.utils.auth.domain.UserRole;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegisterAEmployeeControllerTest {

    RegisterAEmployeeController registerAEmployeeController = new RegisterAEmployeeController();

    @Test
    void addUser() {

        //Arrange
        boolean expected = false;
        //Act
        boolean actual = registerAEmployeeController.addUser("Tiagovski", "vski@email.com", "452", "1AB");
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getRolesList() {

        //Arrange
        List<UserRole> expected = registerAEmployeeController.getRolesList();
        //Act + Assert
        assertNotNull(expected);

    }
}