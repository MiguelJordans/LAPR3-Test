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
    //BinarySearchTree<Pair<Ship, Ship>> pairsOfShipsSearchTree;

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

        }

        return true;
    }

    public void addShip(Ship ship) {
        this.shipBinarySearchTree.insert(ship);
    }

    public Ship getShipByMMSI(int mmsi) {


        Iterable<Ship> ls = shipBinarySearchTree.inOrder();
        Iterator<Ship> iterShip = ls.iterator();

        while (iterShip.hasNext()) {

            Ship s = iterShip.next();

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
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    public LocalDateTime getLastDate(Ship s) {
        try {
            return s.getPosDate().getBiggestPosition().getDate();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
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

            if (count == 0) return 0;

            return (meanSOG / count);
        } catch (ArithmeticException | NullPointerException e) {
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

            if (count == 0) return 0;

            return (meanCOG / count);
        } catch (ArithmeticException | NullPointerException e) {
            return 0;
        }
    }

    public BinarySearchTree<Ship> getShipBinarySearchTree() {
        return shipBinarySearchTree;
    }

    public double getDepartureLatitude(Ship s) {
        try {
            return (s.getPosDate().getSmallestPosition().getLatitude());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return 0;
        }
    }

    public double getDepartureLongitude(Ship s) {
        try {
            return (s.getPosDate().getSmallestPosition().getLongitude());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return 0;
        }
    }

    public double getArrivalLatitude(Ship s) {
        try {
            return (s.getPosDate().getBiggestPosition().getLatitude());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return 0;
        }
    }

    public double getArrivalLongitude(Ship s) {
        try {
            return (s.getPosDate().getBiggestPosition().getLongitude());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return 0;
        }
    }

    public List<Ship> sortedList() {
        List<Ship> shipList = transformBSTintoList();
        Comparator<Ship> comparator1 = (o1, o2) -> {

            double x1 = o1.getTravelledDistance();
            double x2 = o2.getTravelledDistance();

            double z1 = o1.getPosDate().getSize();
            double z2 = o2.getPosDate().getSize();

            double result1 = x2 - x1;
            double result2 = z2 - z1;

            if (result1 > 0) {
                return 1;
            } else if (result1 < 0) {
                return -1;
            } else {
                if (result2 > 0) {
                    return -1;
                } else if (result2 < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        shipList.sort(comparator1);

        return shipList;
    }

    public List<Ship> getTopN(int n, String vesselType, LocalDateTime dt, LocalDateTime dt2){


        DistanceCalculation distance = new DistanceCalculation();
        int count = 0;
        List <Ship> shipsByVessel = new ArrayList();


        if(this.getShipBinarySearchTree().isEmpty()) {
            System.out.println("Store is empty!");
            return null;
        }
        else{


            Iterable<Ship> iterableShip = this.getShipBinarySearchTree().inOrder();
            Iterator<Ship> iteratorShip = iterableShip.iterator();


            while(iteratorShip.hasNext()){

                Ship s = iteratorShip.next();

                if(s.getVesselType().equals(vesselType) && count < n){

                    shipsByVessel.add(s);
                    count++;}

            }


            double max = 0;
            Ship maxShip = null;
            List topNShips = new ArrayList();

            while(shipsByVessel.size() != 0){


                for(Ship s : shipsByVessel){

                    if(max < distance.traveledDistanceBaseDateTime(s,dt,dt2));{
                        max = distance.traveledDistanceBaseDateTime(s,dt,dt2);
                        maxShip = s;

                    }
                }

                shipsByVessel.remove(maxShip);
                topNShips.add(maxShip);
                max = 0;

            }



            return topNShips;
        }

    }

    public void getPairOfShipsInsideBST() {

        List<Ship> lShip = transformBSTintoList();

        for (int i = 0; i < lShip.size(); i++) {

            Ship s1 = lShip.get(i);

            for (int j = 1; j < lShip.size(); j++) {

                Ship s2 = lShip.get(j);

                if (!s1.equals(s2) && (s1.getDeltaDistance() == s2.getDeltaDistance() && (s1.getDeltaDistance() < 5000 && s2.getDeltaDistance() < 5000) && (s1.getDeltaDistance() > 10000 && s2.getDeltaDistance() > 10000))) {

                   // Pair<Ship, Ship> pairOfShips = new Pair(s1, s2);
                  //  pairsOfShipsSearchTree.insert(pairOfShips);

                }
            }
        }
    }
}
