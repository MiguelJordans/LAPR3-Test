package lapr.project.utils.auth.mappers.dto;

public class UserRoleDTO {

    private String id;
    private String description;

    public UserRoleDTO(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
