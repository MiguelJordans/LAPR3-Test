package lapr.project.model.stores;

import lapr.project.model.Position;
import lapr.project.model.Ship;
import lapr.project.shared.BinarySearchTree;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class ShipStore {

    BinarySearchTree<Ship> shipBinarySearchTree;
    List<Ship> bstIntoListShip = new ArrayList<>();


    public ShipStore() {
        this.shipBinarySearchTree = new BinarySearchTree<>();
    }

    public ShipStore(BinarySearchTree<Ship> shipBinarySearchTree) {
        this.shipBinarySearchTree = shipBinarySearchTree;
    }

    public List<Ship> transformBSTintoList() {
        Iterable<Ship> ls = shipBinarySearchTree.inOrder();
        List<Ship> lShip = new ArrayList<>();
        ls.iterator().forEachRemaining(lShip::add);

        return lShip;
    }

    public List<Ship> getlShip() {

        return transformBSTintoList();
    }

    public boolean writeAllShips() {

        List<Ship> lShip = transformBSTintoList();

        if (lShip.isEmpty()) return false;

        for (Ship s : lShip) {
            System.out.println(s);
        }

        return true;
    }

    public Ship getShipByMMSI(long mmsi) {

        List<Ship> lShip = transformBSTintoList();

        for (Ship s : lShip) {

            if (mmsi == s.getMmsi()) return s;
        }

        return null;
    }

    public List<Integer> getShipListMmsi() {

        List<Ship> lShip = transformBSTintoList();

        List<Integer> shipListMmsi = new ArrayList<>();
        for (Ship ship : lShip) {
            shipListMmsi.add(ship.getMmsi());
        }
        return shipListMmsi;
    }

    public List<String> getShipListPos() {

        List<Ship> lShip = transformBSTintoList();

        List<String> shipListPos = new ArrayList<>();
        for (Ship ship : lShip) {
            shipListPos.add(ship.writeAllPos());
        }
        return shipListPos;
    }

    public void addShip(Ship ship) {
        this.shipBinarySearchTree.insert(ship);
    }

    public Ship getShipByMMSI(int mmsi) {


        Iterable<Ship> ls = shipBinarySearchTree.inOrder();
        Iterator<Ship> iterShip = ls.iterator();

        while (iterShip.hasNext()) {
            Ship s = iterShip.next();


            List<Ship> lista = transformBSTintoList();


            if (s.getMmsi() == mmsi) return s;
        }

        return null;
    }


    public String getShipSummaryByMMSI(long mmsi) {


        String returnString;
        List<Ship> lShip = transformBSTintoList();


        try {

            StringBuilder sb = new StringBuilder();

            for (Ship s : lShip) {

                if (mmsi == s.getMmsi()) {

                    sb
                            .append("MMSI : " + s.getMmsi() + "\n")
                            .append(getShipSummaryStructure(s));

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

    public String getShipSummaryByIMO(long imo) {


        String returnString;
        List<Ship> lShip = transformBSTintoList();

        try {

            StringBuilder sb = new StringBuilder();

            for (Ship s : lShip) {

                if (imo == s.getImo()) {

                    sb
                            .append("IMO : " + s.getImo() + "\n")
                            .append(getShipSummaryStructure(s));

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

    public String getShipSummaryByCallSign(String callSign) {


        String returnString;
        List<Ship> lShip = transformBSTintoList();

        try {

            StringBuilder sb = new StringBuilder();

            for (Ship s : lShip) {

                if (callSign.equals(s.getCallSign())) {

                    sb
                            .append("Call Sign : " + s.getCallSign() + "\n")
                            .append(getShipSummaryStructure(s));

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

    public String getShipSummaryStructure(Ship s) {

        Iterable<Position> dateIterable = s.getBinaryTreePosition().inOrder();
        List<Position> positionList = new ArrayList<>();
        dateIterable.iterator().forEachRemaining(positionList::add);

        StringBuilder sb = new StringBuilder();

        sb
                .append("Vessel name: " + s.getVesselType() + "\n")
                .append("Start Base  Date Time: " + getFirstDate(positionList) + "\n")
                .append("End base date time : " + getLastDate(positionList) + "\n")
                .append("Total movement time: " + differenceBetweenDates(getFirstDate(positionList), getLastDate(positionList)) + " minutes" + "\n")
                .append("Total number of movements : " + getTotalNumberOfMovements(positionList) + "\n")
                .append("Max SOG : " + getMaxSOG(positionList) + "\n")
                .append("Mean SOG : " + getMeanSOG(positionList) + "\n")
                .append("Max COG : " + getMaxCOG(positionList) + "\n")
                .append("Mean COG : " + getMeanCOG(positionList) + "\n")
                .append("Departure Latitude : " + getDepartureLatitude(positionList) + "\n")
                .append("Departure Longitude : " + getDepartureLongitude(positionList) + "\n")
                .append("Arrival Latitude : " + getArrivalLatitude(positionList) + "\n")
                .append("Arrival Longitude : " + getArrivalLongitude(positionList) + "\n")
                .append("Travelled Distance : Travelled Distance" + "\n")
                .append("Delta Distance : Delta Distance" + "\n");

        return sb.toString();

    }

    private LocalDateTime getFirstDate(List<Position> positionList) {
        return positionList.get(0).getDate();
    }

    private LocalDateTime getLastDate(List<Position> positionList) {
        return positionList.get(positionList.size() - 1).getDate();
    }

    private long differenceBetweenDates(LocalDateTime first, LocalDateTime second) {

        Date firstDate = java.util.Date.from(first.atZone(ZoneId.systemDefault()).toInstant());
        Date secondDate = java.util.Date.from(second.atZone(ZoneId.systemDefault()).toInstant());

        long diffInMillies = Math.abs(firstDate.getTime() - secondDate.getTime());
        return (TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS));
    }

    private int getTotalNumberOfMovements(List<Position> positionList) {

        return positionList.size();

    }

    private long getMaxSOG(List<Position> positionList) {

        long maxSog = 0;

        for (Position ps1 : positionList) {
            if (ps1.getSog() > maxSog) maxSog = ps1.getSog();
        }
        return maxSog;
    }

    private long getMeanSOG(List<Position> positionList) {

        long meanSOG = 0;
        int count = 0;

        for (Position s : positionList) {
            meanSOG += s.getSog();
            count++;
        }

        return (meanSOG / count);
    }

    private long getMaxCOG(List<Position> positionList) {

        long maxCog = 0;

        for (Position ps1 : positionList) {
            if (ps1.getCog() > maxCog) maxCog = ps1.getCog();
        }
        return maxCog;
    }

    private long getMeanCOG(List<Position> positionList) {


        long meanCOG = 0;
        int count = 0;

        for (Position s : positionList) {
            meanCOG += s.getCog();
            count++;
        }

        return (meanCOG / count);
    }

    public BinarySearchTree<Ship> getShipBinarySearchTree() {
        return shipBinarySearchTree;
    }

    private long getDepartureLatitude(List<Position> positionList) {
        return (positionList.get(0).getLatitude());
    }

    private long getDepartureLongitude(List<Position> positionList) {
        return (positionList.get(positionList.size() - 1).getLatitude());
    }

    private long getArrivalLatitude(List<Position> positionList) {
        return (positionList.get(0).getLongitude());
    }

    private long getArrivalLongitude(List<Position> positionList) {
        return (positionList.get(positionList.size() - 1).getLongitude());
    }

}