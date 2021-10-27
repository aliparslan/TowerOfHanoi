// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Creates a window for the shapes to be displayed
 * and interacted with.
 * Implements the front-end aspect of the Tower of Hanoi problem.
 * 
 * @author aliparslan
 * @version 2021.03.14
 *
 */
public class PuzzleWindow implements Observer {

    // Fields .......................................

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    private static final int TOWER_WIDTH = 5;

    /**
     * The difference in width between ascending disks
     */
    public static final int WIDTH_FACTOR = 20;

    /**
     * Vertical gap between two disks
     */
    public static final int DISK_GAP = 0;

    /**
     * The height of each disk
     */
    public static final int DISK_HEIGHT = 15;

    // Constructor ..................................

    /**
     * Creates a window with three towers, the specified
     * number of disks, and a solve button to initiate the
     * Tower of Hanoi solution
     * 
     * @param game
     *            the object to be displayed to solve the problem
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");

        left = new Shape(125, 100, TOWER_WIDTH, 150, Color.black);
        middle = new Shape(300, 100, TOWER_WIDTH, 150, Color.black);
        right = new Shape(475, 100, TOWER_WIDTH, 150, Color.black);

        for (int i = game.disks(); i > 0; i--) {
            Disk tempDisk = new Disk(WIDTH_FACTOR * i);
            window.addShape(tempDisk);
            game.getTower(Position.LEFT).push(tempDisk);
            this.moveDisk(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }

    // Methods ......................................


    /**
     * The time between each move.
     */
    public void sleep() {
        try {
            Thread.sleep(100);
        }
        catch (Exception e) {
        }
    }


    /**
     * Updates the front-end to represent the disks being moved
     * 
     * @param position
     *            the position of the tower from which the
     *            disk was just removed
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;

        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            default:
                currentPole = middle;
                break;
        }

        currentDisk.moveTo(currentPole.getX() - (currentDisk.getWidth()
            - TOWER_WIDTH) / 2, currentPole.getY() + (currentPole.getHeight()
                - ((game.getTower(position).size() * (DISK_HEIGHT + DISK_GAP))
                    - DISK_GAP)));
    }


    /**
     * Updates the observer and position
     * 
     * @param o
     *            the observable to be updated
     * @param the
     *            object to be updated
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position posArg = (Position)arg;
            this.moveDisk(posArg);
            this.sleep();
        }
    }


    /**
     * Implementation of a "solve" button
     * 
     * @button the solve button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
