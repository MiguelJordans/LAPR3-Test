package lapr.project.utils.mappers.dto;

public class ShipDTO {

    private int mmsi;
    private int totalNumberOfMovements;
    private double travelledDistance;
    private double deltaDistance;

    public ShipDTO(int mmsi, int totalNumberOfMovements, double travelledDistance, double deltaDistance) {

        this.mmsi = mmsi;
        this.totalNumberOfMovements = totalNumberOfMovements;
        this.travelledDistance = travelledDistance;
        this.deltaDistance = deltaDistance;

    }

    @Override
    public String toString() {
        return "ShipDTO{" +
                "mmsi=" + mmsi +
                ", totalNumberOfMovements=" + totalNumberOfMovements +
                ", travelledDistance=" + travelledDistance +
                ", deltaDistance=" + deltaDistance +
                "} \n";
    }

}
