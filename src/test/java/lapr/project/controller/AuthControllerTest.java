package lapr.project.controller;

import lapr.project.utils.auth.domain.User;
import lapr.project.utils.auth.mappers.dto.UserRoleDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    static AuthController authController = new AuthController();

    @BeforeAll
    public static void init() {

        authController.getApp().getAuthFacade().addUserRole("Trolley", "Construir software sem desing");
        authController.getApp().getAuthFacade().addUserWithRole("Mariana", "1200902@isep.ipp.pt", "69Sus", "Trolley");
        authController.doLogin("1200902@isep.ipp.pt", "69Sus");

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

        //Arrange + Act
        List<UserRoleDTO> list = authController.getUserRoles();
        System.out.println(list);
        authController.doLogin("1200902@isep.ipp.pt", "69Sus");
        //Assert
        assertNull(list);

    }

    @Test
    void doLogout() {
        //Arrange
        User expected = null;
        authController.doLogout();
        //Act
        User actual = authController.getApp().getCurrentUserSession().getUser();
        //Assert
        assertEquals(expected, actual);
    }


    @Test
    void getCompany() {
        //Arrange + Act + Assert
        assertNotNull(authController.getApp().getCompany());
    }

}