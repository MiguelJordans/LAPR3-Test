package lapr.project.model;

import java.util.*;

public class Ship implements Comparable<Ship> {

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
    List<Position> Date;

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

        this.posDate = new HashMap<>();
        Date = new ArrayList<>();
    }

    //Getters
    public int getMmsi() {
        return mmsi;
    }

    public String getName() {
        return name;
    }

    public int getImo() {
        return imo;
    }

    public int getNumGen() {
        return numGen;
    }

    public String getCallSign() {
        return callSign;
    }

    public String getVesselType() {
        return vesselType;
    }

    public long getLength() {
        return length;
    }

    public long getWidth() {
        return width;
    }

    public long getCapacity() {
        return capacity;
    }

    public long getDraft() {
        return draft;
    }

    public long getGenPowerOutput() {
        return genPowerOutput;
    }

    public Map<Date, Position> getPosDate() {
        return posDate;
    }


    public List<Position> getDate() {
        return Date;
    }

    public void setDate(List<Position> date) {
        Date = date;
    }

    //Setters
    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImo(int imo) {
        this.imo = imo;
    }

    public void setNumGen(int numGen) {
        this.numGen = numGen;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void setDraft(long draft) {
        this.draft = draft;
    }

    public void setGenPowerOutput(long genPowerOutput) {
        this.genPowerOutput = genPowerOutput;
    }


    //Checks
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

    public boolean addNewPosMessage(Date date, Position pos){

        if(date != null && pos != null){
            posDate.put(date,pos);
            return true;
        }
        return false;
    }

    public void organizeDatePos() {

        this.posDate = new TreeMap<>(posDate);
    }

    public String writeAllPos() {

        String positionalMessage = "Positional Messages:";

        for (Date dateTime : posDate.keySet()) {
            positionalMessage = positionalMessage + "\n" + dateTime + ": " + posDate.get(dateTime).toString();
        }

        return positionalMessage;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "mmsi=" + mmsi +
                ", name='" + name + '\'' +
                ", imo=" + imo +
                ", numGen=" + numGen +
                ", genPowerOutput=" + genPowerOutput +
                ", callSign='" + callSign + '\'' +
                ", vesselType='" + vesselType + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", capacity=" + capacity +
                ", draft=" + draft +
                ", posDate=" + posDate +
                '}';
    }

    @Override
    public int compareTo(Ship o) {
        return 0;
    } //Falta implementar isto
}