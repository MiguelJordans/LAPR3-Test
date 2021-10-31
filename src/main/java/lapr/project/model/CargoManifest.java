package lapr.project.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class CargoManifest {

    private HashMap<String,String> cargoManifest_Containers = new HashMap<>();
    private int[][][] containerPosition;
    private HashMap<String,String> cargoManifest_ContainerGross = new HashMap<>();

    public CargoManifest(HashMap<String,String> cargoManifest_Containers,int[][][] containerPosition,HashMap<String,String>cargoManifest_ContainerGross){

        this.cargoManifest_Containers = cargoManifest_Containers;
        this.containerPosition = containerPosition;
        this.cargoManifest_ContainerGross=cargoManifest_ContainerGross;

    }

    public void setCargoManifest_ContainerGross(HashMap<String, String> cargoManifest_ContainerGross) {
        this.cargoManifest_ContainerGross = cargoManifest_ContainerGross;
    }

    public void setCargoManifest_Containers(HashMap<String, String> cargoManifest_Containers) {
        this.cargoManifest_Containers = cargoManifest_Containers;
    }

    public void setContainerPosition(int[][][] containerPosition) {
        this.containerPosition = containerPosition;
    }

    public HashMap<String, String> getCargoManifest_ContainerGross() {
        return cargoManifest_ContainerGross;
    }

    public HashMap<String, String> getCargoManifest_Containers() {
        return cargoManifest_Containers;
    }

    public int[][][] getContainerPosition() {
        return containerPosition;
    }

    @Override
    public String toString() {
        return "CargoManifest{" +
                "cargoManifest_Containers=" + cargoManifest_Containers +
                ", containerPosition=" + Arrays.toString(containerPosition) +
                ", cargoManifest_ContainerGross=" + cargoManifest_ContainerGross +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoManifest that = (CargoManifest) o;
        return Objects.equals(cargoManifest_Containers, that.cargoManifest_Containers) && Arrays.equals(containerPosition, that.containerPosition) && Objects.equals(cargoManifest_ContainerGross, that.cargoManifest_ContainerGross);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cargoManifest_Containers, cargoManifest_ContainerGross);
        result = 31 * result + Arrays.hashCode(containerPosition);
        return result;
    }
}
