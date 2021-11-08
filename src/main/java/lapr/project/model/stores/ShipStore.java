package lapr.project.model.stores;

import lapr.project.model.Position;
import lapr.project.model.Ship;
import lapr.project.shared.BinarySearchTree;
import lapr.project.shared.DistanceCalculation;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class ShipStore {

    BinarySearchTree<Ship> shipBinarySearchTree;
    // BinarySearchTree<List<Ship>> pairsOfShipsSearchTree;

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


    public String getShipSummaryByMMSI(double mmsi) {


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

    public String getShipSummaryByIMO(String imo) {


        String returnString;
        List<Ship> lShip = transformBSTintoList();

        try {

            StringBuilder sb = new StringBuilder();

            for (Ship s : lShip) {

                if (imo.equals(s.getImo())) {

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

        Iterable<Position> dateIterable = s.getPosDate().getOrderList();
        List<Position> positionList = new ArrayList<>();
        dateIterable.iterator().forEachRemaining(positionList::add);

        StringBuilder sb = new StringBuilder();

        sb
                .append("Vessel name: " + s.getVesselType() + "\n")
                .append("Start Base date Time: " + getFirstDate(s) + "\n")
                .append("End base date time : " + getLastDate(s) + "\n")
                .append("Total movement time: " + differenceBetweenDates(getFirstDate(s), getLastDate(s)) + " minutes" + "\n")
                .append("Total number of movements : " + s.getTotalNumberOfMovements(s) + "\n")
                .append("Max SOG : " + getMaxSOG(s) + "\n")
                .append("Mean SOG : " + getMeanSOG(s) + "\n")
                .append("Max COG : " + getMaxCOG(s) + "\n")
                .append("Mean COG : " + getMeanCOG(s) + "\n")
                .append("Departure Latitude : " + getDepartureLatitude(s) + "\n")
                .append("Departure Longitude : " + getDepartureLongitude(s) + "\n")
                .append("Arrival Latitude : " + getArrivalLatitude(s) + "\n")
                .append("Arrival Longitude : " + getArrivalLongitude(s) + "\n")
                .append("Travelled Distance : " + s.getTravelledDistance() + "\n")
                .append("Delta Distance : " + s.getDeltaDistance());

        return sb.toString();

    }

    public LocalDateTime getFirstDate(Ship s) {
        try {
            return s.getPosDate().getSmallestPosition().getDate();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public LocalDateTime getLastDate(Ship s) {
        try {
            return s.getPosDate().getBiggestPosition().getDate();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public long differenceBetweenDates(LocalDateTime first, LocalDateTime second) {

        try {

            Date firstDate = java.util.Date.from(first.atZone(ZoneId.systemDefault()).toInstant());
            Date secondDate = java.util.Date.from(second.atZone(ZoneId.systemDefault()).toInstant());

            long diffInMillies = Math.abs(firstDate.getTime() - secondDate.getTime());
            return (TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS));
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public double getMaxSOG(Ship s) {

        double maxSog = 0;

        for (Position ps1 : s.getPosDate().getOrderList()) {
            if (ps1.getSog() > maxSog) maxSog = ps1.getSog();
        }
        return maxSog;
    }

    public double getMeanSOG(Ship s) {

        try {
            double meanSOG = 0;
            int count = 0;

            for (Position ps1 : s.getPosDate().getOrderList()) {
                meanSOG += ps1.getSog();
                count++;
            }

            return (meanSOG / count);
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public double getMaxCOG(Ship s) {

        double maxCog = 0;

        for (Position ps1 : s.getPosDate().getOrderList()) {
            if (ps1.getCog() > maxCog) maxCog = ps1.getCog();
        }
        return maxCog;
    }

    public double getMeanCOG(Ship s) {

        try {

            double meanCOG = 0;
            int count = 0;

            for (Position ps1 : s.getPosDate().getOrderList()) {
                meanCOG += ps1.getCog();
                count++;
            }

            return (meanCOG / count);
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public BinarySearchTree<Ship> getShipBinarySearchTree() {
        return shipBinarySearchTree;
    }

    public double getDepartureLatitude(Ship s) {
        try {
            return (s.getPosDate().getSmallestPosition().getLatitude());
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public double getDepartureLongitude(Ship s) {
        try {
            return (s.getPosDate().getSmallestPosition().getLongitude());
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public double getArrivalLatitude(Ship s) {
        try {
            return (s.getPosDate().getBiggestPosition().getLatitude());
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public double getArrivalLongitude(Ship s) {
        try {
            return (s.getPosDate().getBiggestPosition().getLongitude());
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

//Ainda falta acabar este método

    /*

    public void getPairOfShipsInsideBST() {

        List<Ship> lShip = transformBSTintoList();

        for (int i = 0; i < lShip.size(); i++) {

            Ship s1 = lShip.get(i);

            for (int j = 1; j < lShip.size(); j++) {

                Ship s2 = lShip.get(j);

                if (!s1.equals(s2)) {

                    Iterable<Position> date1Iterable = s1.getBinaryTreePosition().inOrder();
                    List<Position> positionS1List = new ArrayList<>();
                    date1Iterable.iterator().forEachRemaining(positionS1List::add);

                    Iterable<Position> date2Iterable = s2.getBinaryTreePosition().inOrder();
                    List<Position> positionS2List = new ArrayList<>();
                    date2Iterable.iterator().forEachRemaining(positionS2List::add);

                    if (getDeltaDistance(positionS1List) == getDeltaDistance(positionS2List) && (getDeltaDistance(positionS1List) < 5000 && getDeltaDistance(positionS2List) < 5000) && (getTravelledDistance(positionS1List) > 10000 && getTravelledDistance(positionS2List) > 10000)) {

                        List<Ship> pairOfShips = new ArrayList<>();

                        pairOfShips.add(s1);
                        pairOfShips.add(s2);

                        pairsOfShipsSearchTree.insert(pairOfShips);

                    }
                }
            }
        }
    }*/
}