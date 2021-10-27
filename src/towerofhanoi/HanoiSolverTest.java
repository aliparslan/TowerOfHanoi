// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import student.TestCase;

/**
 * Tests the HanoiSolver class's methods and
 * all of its possible conditions.
 * 
 * @author aliparslan
 * @version 2021.03.16
 *
 */
public class HanoiSolverTest extends TestCase {

    // Fields ........................................

    private HanoiSolver game;
    private Tower left;
    private Tower middle;
    private Tower right;

    // Constructor ...................................

    /**
     * Empty constructor
     */
    public HanoiSolverTest() {
        // Intentionally left empty
    }

    // Methods .......................................


    /**
     * The code to be run before each test is performed
     */
    public void setUp() {
        game = new HanoiSolver(2);
        left = game.getTower(Position.LEFT);
        middle = game.getTower(Position.MIDDLE);
        right = game.getTower(Position.RIGHT);
    }


    /**
     * Tests the disks() method
     */
    public void testDisks() {
        assertEquals(2, game.disks());
    }


    /**
     * Tests the getTower() method
     */
    public void testGetTower() {
        assertNotNull(left);
        assertNotNull(right);
        assertNotNull(middle);
        assertNotNull(game.getTower(Position.DEFAULT));

        left.push(new Disk(5));
        right.push(new Disk(10));

        assertFalse(left.toString().equals(right.toString()));
    }


    /**
     * Tests the overridden toString() method
     */
    public void testToString() {
        assertEquals("[][][]", game.toString());

        left.push(new Disk(5));
        middle.push(new Disk(10));
        right.push(new Disk(15));
        assertEquals("[5][10][15]", game.toString());

        left.push(new Disk(1));
        middle.push(new Disk(9));
        right.push(new Disk(14));
        assertEquals("[1, 5][9, 10][14, 15]", game.toString());
    }


    /**
     * Tests the solve() method
     * Makes sure disks start on the left tower and end on the right tower
     */
    public void testSolve() {
        left.push(new Disk(10));
        left.push(new Disk(5));

        game.solve();

        assertEquals(0, left.size());
        assertEquals(2, right.size());
    }
}
