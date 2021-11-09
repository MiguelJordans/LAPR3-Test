package lapr.project.model.stores;

import lapr.project.model.Position;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PositionTreeTest {

    PositionTree positionTree = new PositionTree();

    Position position = new Position(0, 0, 0, 0, 0, LocalDateTime.now());


    @Test
    void getPosition() {
        //Arrange
        positionTree.addPosition(position);
        Position expected = position;
        //Act
        Position actual = positionTree.getPosition(position.getDate());
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getOrderList(){
        //Arrange + Act + Assert
        positionTree.addPosition(position);
        assertNotNull(positionTree.getOrderList());
    }

    @Test
    void getOrderListPositions(){
        //Arrange + Act + Assert
        positionTree.addPosition(position);
        assertNotNull(positionTree.getInOrderList());
    }

    @Test
    void getSmallestElement(){
        //Arrange + Act + Assert
        positionTree.addPosition(position);
        assertNotNull(positionTree.getSmallestPosition());
    }

    @Test
    void getBiggestElement(){
        //Arrange + Act + Assert
        positionTree.addPosition(position);
        assertNotNull(positionTree.getBiggestPosition());
    }

    @Test
    void getSize(){
        //Arrange + Act + Assert
        positionTree.addPosition(position);
        assertNotNull(positionTree.getSize());
    }

}