package lapr.project.model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Ship {

    //dados estaticos
    int mmsi;
    String name;
    int imo;
    int numGen;
    long genPowerOutput;
    String callSign;
    String vesselType;
    long length;
    long width;
    long capacity;
    long draft;

    //dados dinamicos
    Map<Date, Position> posDate; // DateTime is the key, which will save the specific position of its time.

    public Ship(int mmsi, String name, int imo, int numGen, long genPowerOutput, String callSign, String vesselType, long length, long width, long capacity, long draft) {

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


        posDate = new HashMap<>();

    }

    //checkers

    public boolean checkMMSI(int mmsi) {

        if (mmsi < 100000000 || mmsi > 999999999) {
            throw new IllegalArgumentException("MMSI code must have 9 digits!");
        }
        return true;
    }

    public boolean checkIMO(int imo) {

        if (imo < 1000000 || imo > 9999999) {
            throw new IllegalArgumentException("IMO code must have 7 digits!");
        }
        return true;
    }

    //getters and setters

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImo() {
        return imo;
    }

    public void setImo(int imo) {
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

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getDraft() {
        return draft;
    }

    public void setDraft(long draft) {
        this.draft = draft;
    }

}