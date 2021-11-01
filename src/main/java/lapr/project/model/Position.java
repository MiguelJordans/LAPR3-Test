package lapr.project.model;

public class Position {
    long[] latitude;
    long[] longitude;
    long[] heading;
    long sog;
    long[] cog;

    public Position(long[] latitude, long[] longitude, long[] heading, long sog, long[] cog) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.heading = heading;
        this.sog = sog;
        this.cog = cog;
    }

    public long getLatitude(int i) {
        return latitude[i];
    }

    public long getLongitude(int i) {
        return longitude[i];
    }

    public long getHeading(int i) {
        return heading[i];
    }

    public long getSog() {
        return sog;
    }

    public long getCog(int i) {
        return cog[i];
    }

    public void setLatitude(long[] latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(long[] longitude) {
        this.longitude = longitude;
    }

    public void setHeading(long[] heading) {
        this.heading = heading;
    }

    public void setSog(long sog) {
        this.sog = sog;
    }

    public void setCog(long[] cog) {
        this.cog = cog;
    }
}

