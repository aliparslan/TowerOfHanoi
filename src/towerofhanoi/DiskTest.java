// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import student.TestCase;

/**
 * Tests the Disk class's methods and
 * all of its possible conditions.
 * 
 * @author aliparslan
 * @version 2021.03.15
 *
 */
public class DiskTest extends TestCase {

    // Fields ...............................................

    private Disk disk1;

    // Constructor ..........................................

    /**
     * Empty constructor
     */
    public DiskTest() {
        // Intentionally left empty
    }

    // Methods ..............................................


    /**
     * The code to be run before each test is performed
     */
    public void setUp() {
        disk1 = new Disk(5);
    }


    /**
     * Tests the compareTo() method
     * Makes sure the right number is returned to reflect the inequality
     * between the compared disks
     */
    public void testCompareTo() {
        Disk disk2 = new Disk(2);
        assertEquals(1, disk1.compareTo(disk2));

        disk2 = new Disk(10);
        assertEquals(-1, disk1.compareTo(disk2));

        disk2 = new Disk(5);
        assertEquals(0, disk1.compareTo(disk2));
    }


    /**
     * Tests the compareTo() method when the parameter is null
     */
    public void testCompareToNull() {
        Disk disk2 = null;
        Exception exception = null;
        try {
            disk1.compareTo(disk2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);

    }


    /**
     * Tests the overridden toString() method
     */
    public void testToString() {
        assertEquals("5", disk1.toString());
    }


    /**
     * Tests the overridden equals() method
     */
    public void testEquals() {
        assertTrue(disk1.equals(disk1));

        Object obj = null;
        assertFalse(disk1.equals(obj));

        obj = new Object();
        assertFalse(disk1.equals(obj));

        Disk disk2 = new Disk(10);
        assertFalse(disk1.equals(disk2));

        disk2 = new Disk(5);
        assertTrue(disk1.equals(disk2));
    }
}
