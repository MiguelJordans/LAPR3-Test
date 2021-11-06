package lapr.project.model.stores;

import lapr.project.model.Ship;
import lapr.project.shared.BinarySearchTree;

public class ShipStore {

    BinarySearchTree<Ship> shipBinarySearchTree;

    public ShipStore() {
        this.shipBinarySearchTree = new BinarySearchTree<>();
    }

    public ShipStore(BinarySearchTree<Ship> shipBinarySearchTree) {
        this.shipBinarySearchTree = shipBinarySearchTree;
    }




}
