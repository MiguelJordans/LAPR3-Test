package lapr.project.model;

public class Position {
    long latitude [];
    long longitude [];
    long heading[];
    long sog;
    long cog[];


    public Position(long [] latitude, long longitude[], long heading[] , long sog, long cog[]){

        this.latitude = latitude;
        this.longitude = longitude;
        this.heading = heading;
        this.sog = sog;
        this.cog = cog;

    }


    //Getters and Setters
    public long getLatitude(int i) {
        return latitude[i];
    }

    public void setLatitude(long[] latitude) {
        this.latitude = latitude;
    }

    public long getLongitude(int i) {
        return longitude[i];
    }

    public void setLongitude(long[] longitude) {
        this.longitude = longitude;
    }

    public long getHeading(int i) {
        return heading[i];
    }

    public void setHeading(long[] heading) {
        this.heading = heading;
    }

    public long getSog() {
        return sog;
    }

    public void setSog(long sog) {
        this.sog = sog;
    }

    public long getCog(int i) {
        return cog[i];
    }

    public void setCog(long[] cog) {
        this.cog = cog;
    }
}

