package lapr.project.shared;

import lapr.project.model.Ship;

public class PairsOfShips implements Comparable {

    private Ship left;
    private Ship right;

    public PairsOfShips(Ship left, Ship right) {
        this.left = left;
        this.right = right;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairsOfShips)) return false;
        if (!super.equals(o)) return false;

        PairsOfShips that = (PairsOfShips) o;

        if (!getLeft().equals(that.getLeft())) return false;
        return getRight().equals(that.getRight());
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + getLeft().hashCode();
        result = 31 * result + getRight().hashCode();
        return result;
    }

    public Ship getLeft() {
        return this.left;

    }

    public Ship getRight() {
        return this.right;
    }


    @Override
    public int compareTo(Object o) {

        Ship aux = null;

        PairsOfShips pairsOfShips2nd = (PairsOfShips) o;

        if (this.left.getMmsi() < this.right.getMmsi()) {
            aux = left;
            left = right;
            right = aux;
        } else if (pairsOfShips2nd.left.getMmsi() < pairsOfShips2nd.right.getMmsi()) {
            aux = pairsOfShips2nd.left;
            pairsOfShips2nd.left = pairsOfShips2nd.right;
            pairsOfShips2nd.right = aux;
        }

        Ship s1 = this.left;

        return 1;

    }
}
