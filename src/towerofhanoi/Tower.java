// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

/**
 * The towers which function as stacks and will store disks.
 * 
 * @author aliparslan
 * @version 2021.03.14
 *
 */
public class Tower extends LinkedStack<Disk> {

    // Fields ...................................
    private Position position;

    // Constructor ..............................

    /**
     * Creates a tower at a specified position
     * 
     * @param pos
     *            the position that the tower will be placed on
     */
    public Tower(Position pos) {
        super();
        position = pos;
    }

    // Methods ..................................


    /**
     * Returns the position of the tower
     * 
     * @return the position of the tower
     */
    public Position position() {
        return this.position;
    }


    /**
     * Adds a disk to the tower
     * 
     * @throws IllegalArgumentException
     *             when the disk is null
     * @throws IllegalStateException
     *             when the disk being pushed
     *             is larger than the one that will be below it
     * @param disk
     *            the disk to be added
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || disk.compareTo(this.peek()) < 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }

    }

}
