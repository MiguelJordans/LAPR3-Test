package lapr.project.controller;

import lapr.project.model.Employee;
import lapr.project.utils.auth.AuthFacade;
import lapr.project.utils.auth.domain.UserRole;

import java.util.ArrayList;
import java.util.List;

public class RegisterAEmployeeController {

    AuthFacade authFacade = App.getInstance().getAuthFacade();

    public boolean addUser(String name, String email, String pwd, String roleId) {

        return authFacade.addUserWithRole(name, email, pwd, roleId);
    }

    public List<UserRole> getRolesList() {

        List<UserRole> userRolesList = new ArrayList<>();

        userRolesList.addAll(authFacade.getRoles().getUserRoles());

        return userRolesList;
    }

}