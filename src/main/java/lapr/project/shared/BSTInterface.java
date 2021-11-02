package lapr.project.shared;

import java.util.List;
import java.util.Map;

/**
 * @param <E>
 * @author DEI-ESINF
 */

public interface BSTInterface<E> {

    boolean isEmpty();

    void insert(E element);

    void remove(E element);

    int size();

    int height();

    E smallestElement();

    Iterable<E> inOrder();

    Iterable<E> preOrder();

    Iterable<E> posOrder();

    Map<Integer, List<E>> nodesByLevel();

}