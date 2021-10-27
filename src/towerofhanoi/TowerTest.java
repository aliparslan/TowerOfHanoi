// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import student.TestCase;

/**
 * Tests the Tower class's methods and
 * all of its possible conditions.
 * 
 * @author aliparslan
 * @version 2021.03.16
 *
 */
public class TowerTest extends TestCase {

    // Fields ........................................

    private Tower tower;

    // Constructor ...................................

    /**
     * Empty constructor
     */
    public TowerTest() {
        // Intentionally left empty
    }

    // Methods .......................................


    /**
     * The code to be run before each test is performed
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }


    /**
     * Tests the position() method
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }


    /**
     * Tests the push() method when the parameter is null
     */
    public void testPushNull() {
        Disk disk = null;
        Exception exception = null;
        try {
            tower.push(disk);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * Tests the push() method
     */
    public void testPush() {
        tower.push(new Disk(10));
        assertEquals(1, tower.size());

        tower.push(new Disk(5));
        assertEquals(2, tower.size());
    }


    /**
     * Tests the push() method when the disk attempted to be pushed
     * is larger than the disk that would be below it
     * 
     * Catches the appropriate exception
     */
    public void testPushIllegalStateException() {
        tower.push(new Disk(10));
        Exception exception = null;

        try {
            tower.push(new Disk(20));
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
    }
}
