package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void createCompany() {

        //Arrange + Act + Assert

        String expected = "Designation cannot be blank.";
        String actual = null;

        try {

            Company company = new Company(null);

        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual);

    }

}