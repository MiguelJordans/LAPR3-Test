package lapr.project.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    static AuthController authController = new AuthController();

    @BeforeAll
    public static void init() {

        authController.getApp().getAuthFacade().addUserRole("Trolley","Construir software sem desing");
        authController.getApp().getAuthFacade().addUserWithRole("Mariana","1200902@isep.ipp.pt","69Sus","Trolley");

    }


    @Test
    void doLogin() {

        //Arrange
        authController.doLogin("1200902@isep.ipp.pt", "69Sus");
        boolean expected = true;
        //Act
        boolean actual = authController.getApp().getCurrentUserSession().isLoggedIn();
        //Assert
        assertEquals(expected, actual);


    }

    @Test
    void getUserRoles() {
    }

    @Test
    void doLogout() {
    }
}