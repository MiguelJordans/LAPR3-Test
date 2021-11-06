package lapr.project.model;

import java.time.LocalDateTime;

public class Position {

    long latitude;
    long longitude;
    long heading;
    long sog;
    long cog;
    LocalDateTime date;

    public Position(long latitude, long longitude, long heading, long sog, long cog, LocalDateTime date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.heading = heading;
        this.sog = sog;
        this.cog = cog;
        this.date = date;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public long getHeading() {
        return heading;
    }

    public long getSog() {
        return sog;
    }

    public long getCog() {
        return cog;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public void setHeading(long heading) {
        this.heading = heading;
    }

    public void setSog(long sog) {
        this.sog = sog;
    }

    public void setCog(long cog) {
        this.cog = cog;
    }

    @Override
    public String toString() {
        return "Position{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", heading=" + heading +
                ", sog=" + sog +
                ", cog=" + cog +
                '}';
    }
}

