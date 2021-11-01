package lapr.project.model;

<<<<<<< HEAD:src/main/java/lapr/project/model/Company.java
import lapr.project.model.stores.OrgRoleStore;
import lapr.project.utils.auth.AuthFacade;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
=======
import org.apache.commons.lang3.StringUtils;
>>>>>>> 4e6f34017a297fcd12ad0f1da2c2ee196daa9129:src/main/java/lapr/project/utils/Company.java

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


