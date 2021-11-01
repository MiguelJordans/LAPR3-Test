package lapr.project.utils;

import java.util.Objects;

public class OrgRole  {

    private String id;

    private String designation;

    public OrgRole(String id,String designation) {
        if(id == null || designation == null) {
            throw new IllegalArgumentException("Error: at least one of the attributes of OrgRole is null.");
        }
        this.designation = designation;
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getId() {
        return id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation, id);
    }


    @Override
    public String toString() {
        return "OrgRole{" +
                "id='" + id + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}

