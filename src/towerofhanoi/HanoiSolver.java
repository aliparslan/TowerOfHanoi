// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import java.util.Observable;

/**
 * Represents a Tower of Hanoi puzzle.
 * Uses the Tower and Disk classes to implement a solution to the
 * Tower of Hanoi problem.
 * 
 * @author aliparslan
 * @version 2021.03.14
 *
 */
public class HanoiSolver extends Observable {

    // Fields ...................................

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    // Constructor ..............................

    /**
     * Creates a HanoiSolver object with a specified number of disks
     * 
     * @param numDisks
     *            the number of disks in the tower problem
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);

        this.numDisks = numDisks;
    }

    // Methods ..................................


    /**
     * Returns the number of disks in the object
     * 
     * @return the number of disks in the problem
     */
    public int disks() {
        return this.numDisks;
    }


    /**
     * Returns the tower at a specified position
     * 
     * @param pos
     *            the position to be checked for a tower
     * @return the tower at the position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }
    }


    /**
     * Returns the disk widths as a string
     * 
     * @return the widths of the disks across all towers; lists disks
     *         in order of top-to-bottom, left-to-right
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(left.toString());
        s.append(middle.toString());
        s.append(right.toString());
        
        return s.toString();
    }


    /**
     * Moves a disk from one tower to another
     * 
     * @param source
     *            the tower from which the disk will be taken
     * @param destination
     *            the tower on which the disk will be placed
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        this.setChanged();
        this.notifyObservers(destination.position());
    }


    /**
     * Recursive solution to the Tower of Hanoi problem.
     */
    private void solveTowers(int currentDisks, Tower startPole,
                             Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else {
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Runs the solveTowers() method with:
     * the left tower as the starting tower,
     * the right tower as the ending tower,
     * the middle tower as the temporary tower
     */
    public void solve() {
        this.solveTowers(numDisks, left, middle, right);

    }

}
