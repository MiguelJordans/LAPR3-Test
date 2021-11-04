package lapr.project.model;

import lapr.project.utils.auth.domain.store.OrgRoleStore;
import lapr.project.utils.auth.AuthFacade;
import lapr.project.utils.auth.domain.store.ShipStore;
import org.apache.commons.lang3.StringUtils;

public class Company {


    //Ship Store
    private ShipStore shipStore;


    //Company Constructor

    private final AuthFacade authFacade;
    private final OrgRoleStore orgRoleStore;

    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.authFacade = new AuthFacade();
        this.orgRoleStore = new OrgRoleStore();

        this.shipStore = new ShipStore();
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public OrgRoleStore getOrgRoleStore() {
        return this.orgRoleStore;
    }

    public ShipStore getShipStore(){return this.shipStore;}
}



