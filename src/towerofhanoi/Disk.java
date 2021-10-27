// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * Disk object to be placed on towers. Represents disks on a tower of Hanoi.
 * 
 * @author aliparslan
 * @version 2021.03.14
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    // Fields ......................................

    // Constructor .................................

    /**
     * Creates a disk with a specified width.
     * 
     * @param width
     *            width of the disk.
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom generator = new TestableRandom();

        Color color = new Color(generator.nextInt(256), generator.nextInt(256),
                                generator.nextInt(256));
        this.setBackgroundColor(color);
    }

    // Methods .....................................


    /**
     * Returns a number to signify if a disk is larger than, less than,
     * or equal to another disk.
     * 
     * @return an integer to represent inequality between
     *         the disks being compared
     * 
     *         -1: this disk is smaller than the parameter
     *         0: they are equal in width
     *         1: this disk is larger than the parameter
     * 
     * @throws IllegalArgumentException
     *             when the disk is null
     * 
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        else if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        return 0; // they are equal
    }


    /**
     * String representation of a disk
     * @return the width of the disk as a string.
     */
    @Override
    public String toString() {
        return Integer.toString(this.getWidth());
    }


    /**
     * Compares the equality of a disk to another object
     * @param obj
     *            the object to be compared to for equality
     * @return if the two objects are equal
     *         equal means they are the same class and have the same disk width
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        if (this.getClass() == obj.getClass()) {
            Disk objDisk = (Disk)obj;
            return this.getWidth() == objDisk.getWidth();
        }
        return false;
    }

}
