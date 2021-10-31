package lapr.project.model;

public class Facility {
    private String identification;
    private String name;
    private String continent;
    private String country;
    private Location location;

    public Facility(String identification, String name, String continent, String country, Location location) {
        this.identification = identification;
        this.name = name;
        this.continent = continent;
        this.country = country;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;

        Facility facility = (Facility) o;

        if (getIdentification() != null ? !getIdentification().equals(facility.getIdentification()) : facility.getIdentification() != null)
            return false;
        if (getName() != null ? !getName().equals(facility.getName()) : facility.getName() != null) return false;
        if (getContinent() != null ? !getContinent().equals(facility.getContinent()) : facility.getContinent() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(facility.getCountry()) : facility.getCountry() != null)
            return false;
        return getLocation() != null ? getLocation().equals(facility.getLocation()) : facility.getLocation() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdentification() != null ? getIdentification().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getContinent() != null ? getContinent().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
