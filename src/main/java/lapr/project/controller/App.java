package lapr.project.controller;


import lapr.project.model.*;
import lapr.project.utils.auth.AuthFacade;
import lapr.project.shared.Constants;
import lapr.project.utils.auth.UserSession;
import lapr.project.utils.auth.domain.OrgRole;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class App {


    private final Company company;
    private final AuthFacade authFacade;

    public App() {


        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();

    }

    public Company getCompany()
    {
        return this.company;
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "CargoShipping");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }

    public boolean doLogin(String email, String pwd) {
        return this.authFacade.doLogin(email, pwd).isLoggedIn();
    }

    public UserSession getCurrentUserSession() {
        return this.authFacade.getCurrentUserSession();

    }

    public void doLogout() {
        this.authFacade.doLogout();
    }


    private void bootstrap() {

        this.authFacade.addUserRole(Constants.ROLE_CLIENT, Constants.ROLE_CLIENT);
        this.authFacade.addUserRole(Constants.TRAFFIC_MANAGER, Constants.ROLE_TRAFFIC_MANAGER);

        this.company.getOrgRoleStore().addOrgRole(new OrgRole(Constants.CLIENT, Constants.MODEL_CLASS_PATH + "" + Constants.CLIENT));
        this.company.getOrgRoleStore().addOrgRole(new OrgRole(Constants.TRAFFIC_MANAGER, Constants.MODEL_CLASS_PATH + "" + Constants.TRAFFIC_MANAGER));

        //email: R00001@lei.pt pass: 123
        Client c1 = new Client(this.company.getOrgRoleStore().getRoleById(Constants.CLIENT), "R00001", "Receptionist1");
        this.authFacade.addUserWithRole(c1.getName(), c1.getEmail(), "123", Constants.ROLE_CLIENT);

        //email: TM00001@lei.pt pass: 495
        TrafficManager tm1 = new TrafficManager(this.company.getOrgRoleStore().getRoleById(Constants.TRAFFIC_MANAGER), "TM00001", "Traffic Manager");
        this.authFacade.addUserWithRole(tm1.getName(), tm1.getEmail(), "495", Constants.ROLE_TRAFFIC_MANAGER);

        //Position
        Position posgeral = new Position(0, 0, 0, 1, 0);
        Position posgeral2 = new Position(20, 30, 20, 10, 10);

        //Ships

        //mmsi: 111111111
        Ship shipTest1 = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
        shipTest1.addNewPosMessage(new Date("Dec 31 1998 23:37:50"),posgeral);
        shipTest1.addNewPosMessage(new Date("Dec 31 1997 23:37:50"),posgeral2);
        company.getShipStore().getlShip().add(shipTest1);

        //mmsi: 222222222
        Ship shipTest2 = new Ship(222222222, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
        company.getShipStore().getlShip().add(shipTest2);
    }

    private static App singleton = null;

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }
}
