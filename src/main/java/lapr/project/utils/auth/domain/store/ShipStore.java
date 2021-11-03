package lapr.project.utils.auth.domain.store;

import lapr.project.model.Ship;

import java.util.ArrayList;
import java.util.List;

    public class ShipStore {

    List<Ship> lShip;

    public ShipStore(){
        lShip = new ArrayList<>();
    }


        public List<Ship> getlShip() {
            return lShip;
        }

        public boolean writeAllShips(){

        if(lShip.isEmpty()) return false;

        for(Ship s : lShip ){
            System.out.println(s);
        }

        return true;
    }

    public Ship getShipByMMSI(long mmsi){

        for(Ship s : lShip){

            if(mmsi == s.getMmsi()) return s;
        }

        return null;
    }
}
