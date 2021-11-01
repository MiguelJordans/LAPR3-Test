package lapr.project.utils;

import org.apache.commons.lang3.StringUtils;

public class Company {
    private final AuthFacade authFacade;
    private final OrgRoleStore orgRoleStore;

    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.authFacade = new AuthFacade();
        this.orgRoleStore = new OrgRoleStore();
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public OrgRoleStore getOrgRoleStore() {
        return this.orgRoleStore;
    }
}


