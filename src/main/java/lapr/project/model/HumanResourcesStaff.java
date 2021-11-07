package lapr.project.model;

import lapr.project.utils.auth.domain.OrgRole;

public class HumanResourcesStaff extends Employee {

    public HumanResourcesStaff(OrgRole role, String employeeId, String name) {
        super(role, employeeId, name);
    }

}
