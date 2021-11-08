package lapr.project.model;

import lapr.project.utils.auth.domain.OrgRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    OrgRole orgRole = new OrgRole("1Ab", "Employee Role");
    Employee employee = new Employee(orgRole, "1AB", "Mariana");

    @Test
    void testToString() {
        //Arrange
        String expected = "\n1Ab - employeeId: 1AB, email: 1AB@lei.pt, name: Mariana";
        //Act
        String actual = employee.toString();
        //Assert
        assertEquals(expected,actual);
    }
}