package lapr.project.model.stores;

import lapr.project.model.Ship;
import lapr.project.shared.BinarySearchTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShipStore {

    BinarySearchTree<Ship> shipBinarySearchTree;

    public ShipStore() {
        this.shipBinarySearchTree = new BinarySearchTree<>();
    }

    public ShipStore(BinarySearchTree<Ship> shipBinarySearchTree) {
        this.shipBinarySearchTree = shipBinarySearchTree;
    }

    public void addShip(Ship ship) {
        this.shipBinarySearchTree.insert(ship);
    }

    public Ship getShipByMMSI(int mmsi) {

        Iterable<Ship> ls = shipBinarySearchTree.inOrder();
        Iterator<Ship> iterShip = ls.iterator();

        while(iterShip.hasNext()){
            Ship s = iterShip.next();


            if(s.getMmsi() == mmsi) return s;
        }

        return null;
    }

}
