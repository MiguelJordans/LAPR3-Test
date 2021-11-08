package lapr.project.model.stores;

import lapr.project.model.Position;
import lapr.project.shared.BinarySearchTree;

import java.time.LocalDateTime;

public class PositionTree {
    BinarySearchTree<Position> positionBinarySearchTree;

    public PositionTree() {
        this.positionBinarySearchTree = new BinarySearchTree<Position>();
    }

    public void addPosition(Position position) {
        positionBinarySearchTree.insert(position);
    }

    public Position getSmallestPosition() {
        return positionBinarySearchTree.smallestElement();
    }

    public Position getBiggestPosition() {
        return positionBinarySearchTree.biggestElement();
    }

    public int getSize() {
        return positionBinarySearchTree.size();
    }

    public Iterable<Position> getOrderList() {
        return positionBinarySearchTree.inOrder();
    }

    public void getPosition(LocalDateTime date) {
        positionBinarySearchTree.find(new Position(0, 0, 0, 0, 0,date));
    }
}