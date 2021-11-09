package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.stores.ShipStore;
import lapr.project.shared.TopNShips;
import java.time.LocalDateTime;
import java.util.List;

public class TopNShipsController {

    TopNShips topNShips;

    public TopNShipsController(){
        topNShips = new TopNShips();
    }


    public List<Ship> getTopNShips(int n,String vesselType, LocalDateTime li, LocalDateTime lf){


        List<Ship> lShip = topNShips.getTopN(10,vesselType,li,lf);

        if(lShip == null) return null;

        else return lShip;

    }
}
