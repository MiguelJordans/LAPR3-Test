package lapr.project.shared;


import lapr.project.controller.App;
import lapr.project.model.Company;
import lapr.project.model.Position;
import lapr.project.model.Ship;
import lapr.project.model.stores.ShipStore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TopNShips extends DistanceCalculation {

    /*
    static Ship shipgeral = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);
    static Ship shipgeral2 = new Ship(111111111, "name", 1111111, 1, 1, "A", "A", 1, 1, 1, 1);

    static LocalDateTime localDateTime = LocalDateTime.of(2021,1,1,1,1);
    static LocalDateTime localDateTime2 = LocalDateTime.of(2021,3,1,1,1);

    Position posgeral1 = new Position(0, 0, 0, 1, 0, localDateTime);
    Position posgeral2= new Position(20, 20, 20, 1, 0,localDateTime2);
    Position posgeral3 = new Position(0, 0, 0, 1, 0,localDateTime);
    Position posgeral4 = new Position(30, 30, 30, 1, 0,localDateTime2);
*/

    Company company;
    ShipStore shipStore;
    public TopNShips(){

     this.company = App.getInstance().getCompany();
     this.shipStore = company.getShipStore();}



    public List<Ship> getTopN(int n, String vesselType, LocalDateTime dt, LocalDateTime dt2){




        int count = 0;
        List <Ship> shipsByVessel = new ArrayList();


        if(shipStore.getShipBinarySearchTree().root == null) {
            System.out.println("Store is empty!");
            return null;
        }
        else{


            Iterable<Ship> iterableShip = shipStore.getShipBinarySearchTree().inOrder();
            Iterator<Ship> iteratorShip = iterableShip.iterator();


            while(iteratorShip.hasNext()){

                Ship s = iteratorShip.next();

                if(s.getVesselType().equals(vesselType) && count <= n){
                    shipsByVessel.add(s);
                    count++;}

            }

            double max = 0;
            Ship maxShip = null;
            List topNShips = new ArrayList();

            while(shipsByVessel.size() != 0){

                for(Ship s : shipsByVessel){

                    if(max < traveledDistanceBaseDateTime(s,dt,dt2));{
                        max = traveledDistanceBaseDateTime(s,dt,dt2);
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


/*
    public static void main(String[] args) {



        List<Ship> maxPls = getTopN(2,"A",localDateTime,localDateTime2);

        for(Ship s : maxPls){

            System.out.println(s);
        }

    }

*/

}
