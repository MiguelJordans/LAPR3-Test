package lapr.project.model;

import lapr.project.model.stores.PositionTree;
import lapr.project.shared.DistanceCalculation;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

public class Ship implements Comparable<Ship> {


    //dados dinamicos
    private PositionTree posDate;
    private List<Position> Date;
    //dados estaticos
    private char transcieverClass;
    private int cargo;
    private int mmsi;
    private String name;
    private String imo;
    private int numGen;
    private long genPowerOutput;
    private String callSign;
    private String vesselType;
    private double length;
    private double width;
    private double capacity;
    private double draft;

    public Ship(int mmsi, String name, String imo, String callSign, String vesselType, double length, double width, double draft, int cargo, char transcieverClass) {
        checkIMO(imo);
        checkMMSI(mmsi);

        this.mmsi = mmsi;
        this.name = name;
        this.imo = imo;
        this.callSign = callSign;
        this.vesselType = vesselType;
        this.length = length;
        this.width = width;
        this.draft = draft;
        this.cargo = cargo;
        this.transcieverClass = transcieverClass;

        this.posDate = new PositionTree();
        Date = new ArrayList<>();
    }

    public Ship(int mmsi, String name, String imo, int numGen, long genPowerOutput, String callSign, String vesselType, double length, double width, double capacity, double draft) {
        checkIMO(imo);
        checkMMSI(mmsi);

        this.mmsi = mmsi;
        this.name = name;
        this.imo = imo;
        this.numGen = numGen;
        this.genPowerOutput = genPowerOutput;
        this.callSign = callSign;
        this.vesselType = vesselType;
        this.length = length;
        this.width = width;
        this.capacity = capacity;
        this.draft = draft;

        this.posDate = new PositionTree();
        Date = new ArrayList<>();
    }


    public Ship(int mmsi) {
        checkMMSI(mmsi);
        this.mmsi = mmsi;
    }

    public Position createPosition(LocalDateTime time, double latitude, double longitude, double heading, double sog, double cog) {
        return new Position(latitude, longitude, heading, sog, cog, time);
    }

    public void insertPosition(Position position) {
        posDate.addPosition(position);
    }

    //Getters
    public int getMmsi() {
        return mmsi;
    }

    //Setters
    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImo() {
        return imo;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public int getNumGen() {
        return numGen;
    }

    public void setNumGen(int numGen) {
        this.numGen = numGen;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public double getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public PositionTree getPosDate() {
        return posDate;
    }

    public double getDraft() {
        return draft;
    }

    public void setDraft(long draft) {
        this.draft = draft;
    }

    public long getGenPowerOutput() {
        return genPowerOutput;
    }

    public void setGenPowerOutput(long genPowerOutput) {
        this.genPowerOutput = genPowerOutput;
    }


    public List<Position> getDate() {
        return Date;
    }

    public void setDate(List<Position> date) {
        Date = date;
    }

    //Checks
    public void checkMMSI(int mmsi) {
        if (mmsi > 99999999 && mmsi < 1000000000) {
            return;
        }
        throw new IllegalArgumentException("MMSI code must have 9 digits!");
    }

    public void checkIMO(String imo) {
        if (imo.length() != 10 || (!imo.startsWith("IMO") && StringUtils.isNumeric(imo.substring(2, imo.length() - 1)))) {
            throw new IllegalArgumentException("IMO code must have 7 digits!");
        }
    }

    public boolean addNewPosMessage(Position pos) {

        return Boolean.parseBoolean(null);
    }


    public String writeAllPos(LocalDateTime di, LocalDateTime df) {

        String positionalMessage = "Positional Message:";

        if(di == null || df == null) return positionalMessage;

        Date initiald = java.sql.Timestamp.valueOf(di);
        Date finald = java.sql.Timestamp.valueOf(df);




        double d = 0;
        List<Position> positionList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initiald);

        PositionTree binaryTest = this.getPosDate();
        Iterable<Position> posIterable = binaryTest.getInOrderList();
        Iterator<Position> posIterator = posIterable.iterator();




        while (initiald.before(finald)) {


            if (calendar.getTime().getMinutes() == 60) {
                calendar.add(Calendar.HOUR_OF_DAY, 1);
                calendar.getTime().setMinutes(0);
                calendar.getTime().setSeconds(0);
            }
            if (calendar.getTime().getSeconds() == 60) {
                calendar.add(Calendar.MINUTE, 1);
                calendar.getTime().setSeconds(0);
            }


            while (posIterator.hasNext()) {



                Position pos = posIterator.next();
                Date posDate = java.sql.Timestamp.valueOf(pos.getDate());

                if (!posDate.before(initiald) && !posDate.after(initiald)) {
                    positionList.add(pos);
                }

            }

            posIterator = posIterable.iterator();

            calendar.add(Calendar.SECOND, 1);
            initiald = calendar.getTime();
        }



        if(positionList.isEmpty()) return positionalMessage;

        for(Position pos : positionList){
           positionalMessage =  positionalMessage +"\n" + pos.toString() ;
        }



        return positionalMessage;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "posDate=" + posDate +
                ", Date=" + Date +
                ", transceiverClass=" + transcieverClass +
                ", cargo=" + cargo +
                ", mmsi=" + mmsi +
                ", name='" + name + '\'' +
                ", imo='" + imo + '\'' +
                ", numGen=" + numGen +
                ", genPowerOutput=" + genPowerOutput +
                ", callSign='" + callSign + '\'' +
                ", vesselType='" + vesselType + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", capacity=" + capacity +
                ", draft=" + draft +
                '}';
    }

    @Override
    public int compareTo(Ship o) {
        if (mmsi > o.mmsi) {
            return 1;
        } else if (mmsi < o.mmsi) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return getMmsi() == ship.getMmsi() && Objects.equals(getImo(), ship.getImo()) && getNumGen() == ship.getNumGen() && getGenPowerOutput() == ship.getGenPowerOutput() && getLength() == ship.getLength() && getWidth() == ship.getWidth() && getCapacity() == ship.getCapacity() && getDraft() == ship.getDraft() && Objects.equals(getName(), ship.getName()) && Objects.equals(getCallSign(), ship.getCallSign()) && Objects.equals(getVesselType(), ship.getVesselType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMmsi(), getName(), getImo(), getNumGen(), getGenPowerOutput(), getCallSign(), getVesselType(), getLength(), getWidth(), getCapacity(), getDraft());
    }

    public double getTravelledDistance() {
        double travelledDistance = 0;

        for (int i = 0; i < this.getPosDate().getInOrderList().size() - 1; i++) {
            travelledDistance += DistanceCalculation.distanceTo(this.getPosDate().getInOrderList().get(i), this.getPosDate().getInOrderList().get(i + 1));
        }
        return travelledDistance;
    }

    public double getDeltaDistance() {
        return DistanceCalculation.distanceTo(this.getPosDate().getSmallestPosition(), this.getPosDate().getBiggestPosition());
    }

    public int getTotalNumberOfMovements(Ship s) {

        return s.getPosDate().getSize();

    }

}