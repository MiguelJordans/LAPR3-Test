package lapr.project.utils.auth.domain.store;

import lapr.project.model.Ship;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> getMmsiList(Ship ship) {
        List<Integer> shipListMmsi = new ArrayList<>();
        shipListMmsi.add(ship.getMmsi());
        return shipListMmsi;
    }

    public String getShipSummary(long mmsi) {

        String returnString;

        try {

            StringBuilder sb = new StringBuilder();

            for (Ship s : lShip) {

                if (mmsi == s.getMmsi()) {

                    sb
                            .append("SHIP SUMMARY :[MMSI : " + s.getMmsi())
                            .append("Vessel name: " + s.getVesselType())
                            .append("Start Base  Date Time: falta o date time")
                            .append("End base date time : falta tbm o end date")
                            .append("Total movement time: implementar o total time")
                            .append("Total number of movements : implementar o total number of movements")
                            .append("Max SOG : max SOG")
                            .append("Mean SOG : mean SOG")
                            .append("Max COG : max COG")
                            .append("Mean COG : mean COG")
                            .append("Departure Latitude : Departure Latitude")
                            .append("Departure Longitude : Departure Longitude")
                            .append("Arrival Latitude : Arrival Latitude")
                            .append("Arrival Longitude : Arrival Longitude")
                            .append("Travelled Distance : Travelled Distance")
                            .append("Delta Distance : Delta Distance");

                }
            }

            returnString = sb.toString();

            if (returnString == null || returnString.isEmpty()) throw new IllegalArgumentException("Invalid Ship, please enter another one");
            else return returnString;

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage()); //Depois fazer um logger
            return null;
        }
    }
}
