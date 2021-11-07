package lapr.project.ui;

import lapr.project.controller.RegisterAEmployeeController;
import lapr.project.utils.Utils;
import lapr.project.utils.auth.domain.OrgRole;

public class RegisterANewEmployeeUI implements Runnable {

    public RegisterANewEmployeeUI() {
        //Empty
    }

    private final RegisterAEmployeeController registerAEmployeeController = new RegisterAEmployeeController();

    @Override
    public void run() {

        boolean sucess = false;
        int maxAttemps = 3;

        do {

            OrgRole orgRole = (OrgRole) Utils.showAndSelectOne(registerAEmployeeController.getRolesList(), "Choose a valid role to register the new Employee");
            String name = Utils.readLineFromConsole("Please enter the Employee's name");

            System.out.println(orgRole.toString());

        } while (sucess || maxAttemps != 0);

    }

}
