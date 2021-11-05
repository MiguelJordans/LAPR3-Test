package lapr.project.utils.auth.domain.store;

import lapr.project.model.Ship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShipStore {

    List<Ship> lShip;

    public ShipStore() {
        lShip = new ArrayList<>();
    }


    public List<Ship> getlShip() {
        return lShip;
    }

    public boolean writeAllShips() {

        if (lShip.isEmpty()) return false;

        for (Ship s : lShip) {
            System.out.println(s);
        }

        return true;
    }

    public Ship getShipByMMSI(long mmsi) {

        for (Ship s : lShip) {

            if (mmsi == s.getMmsi()) return s;
        }

        return null;
    }

    public List<Integer> getShipListMmsi() {
        List<Integer> shipListMmsi = new ArrayList<>();
        for (Ship ship : lShip) {
            shipListMmsi.add(ship.getMmsi());
        }
        return shipListMmsi;
    }

    public List<String> getShipListPos() {
        List<String> shipListPos = new ArrayList<>();
        for (Ship ship : lShip) {
            shipListPos.add(ship.writeAllPos());
        }
        return shipListPos;
    }

    public String getShipSummary(long mmsi) {

        String returnString;

        try {

            StringBuilder sb = new StringBuilder();

            for (Ship s : lShip) {

                if (mmsi == s.getMmsi()) {

                    sb
                            .append("SHIP SUMMARY :[MMSI : " + s.getMmsi())
                            .append(",Vessel name: " + s.getVesselType())
                            .append(",Start Base  Date Time: " + getFirstDate(s))
                            .append(",End base date time : " + getLastDate(s))
                            .append(",Total movement time: " + differenceBetweenDates(getFirstDate(s), getLastDate(s)))
                            .append(",Total number of movements : " + getTotalNumberOfMovements(s))
                            .append(",Max SOG : " + getMaxSOG(s))
                            .append(",Mean SOG : " + getMeanSOG(s))
                            .append(",Max COG : " + getMaxCOG(s))
                            .append(",Mean COG : " + getMeanCOG(s))
                            .append(",Departure Latitude : " + getDepartureLatitude(s))
                            .append(",Departure Longitude : " + getDepartureLongitude(s))
                            .append(",Arrival Latitude : " + getArrivalLatitude(s))
                            .append(",Arrival Longitude : " + getArrivalLongitude(s))
                            .append(",Travelled Distance : Travelled Distance")
                            .append(",Delta Distance : Delta Distance");

                }
            }

            returnString = sb.toString();

            if (returnString == null || returnString.isEmpty())
                throw new IllegalArgumentException("Invalid Ship, please enter another one");
            else return returnString;

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage()); //Depois fazer um logger
            return null;
        }
    }

    private Date getFirstDate(Ship s) {
        return s.getPosDate().keySet().iterator().next();
    }

    private Date getLastDate(Ship s) {
        Date lastDate = null;
        while (s.getPosDate().keySet().iterator().hasNext()) {
            lastDate = s.getPosDate().keySet().iterator().next();
        }
        return lastDate;
    }

    private long differenceBetweenDates(Date first, Date second) {
        long diffInMillies = Math.abs(second.getTime() - first.getTime());
        return (TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
    }

    private int getTotalNumberOfMovements(Ship s) {

        int count = 0;

        while (s.getPosDate().keySet().iterator().hasNext()) {
            count++;
        }

        if (count % 2 == 0) return count;
        else return count - 1;

    }

    private long getMaxSOG(Ship s) {

        long maxSOG = 0;

        for (Date dateTime : s.getPosDate().keySet()) {
            if (maxSOG < s.getPosDate().get(dateTime).getSog()) maxSOG = s.getPosDate().get(dateTime).getSog();
        }

        return maxSOG;
    }

    private long getMeanSOG(Ship s) {

        long meanSOG = 0;
        int count = 0;

        for (Date dateTime : s.getPosDate().keySet()) {
            meanSOG += s.getPosDate().get(dateTime).getSog();
            count++;
        }

        return (meanSOG / count);
    }

    private long getMaxCOG(Ship s) {

        long maxCOG = 0;

        for (Date dateTime : s.getPosDate().keySet()) {
            if (maxCOG < s.getPosDate().get(dateTime).getCog()) maxCOG = s.getPosDate().get(dateTime).getCog();
        }

        return maxCOG;
    }

    private long getMeanCOG(Ship s) {

        long meanCOG = 0;
        int count = 0;

        for (Date dateTime : s.getPosDate().keySet()) {
            meanCOG += s.getPosDate().get(dateTime).getCog();
            count++;
        }

        return (meanCOG / count);
    }

    private long getDepartureLatitude(Ship s) {
        return (s.getPosDate().get(getFirstDate(s)).getLatitude());
    }

    private long getDepartureLongitude(Ship s) {
        return (s.getPosDate().get(getFirstDate(s)).getLongitude());
    }

    private long getArrivalLatitude(Ship s) {
        return (s.getPosDate().get(getLastDate(s)).getLatitude());
    }

    private long getArrivalLongitude(Ship s) {
        return (s.getPosDate().get(getLastDate(s)).getLongitude());
    }

}
