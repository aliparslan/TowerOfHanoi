// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import cs2.Window;

/**
 * This class runs the Tower Of Hanoi program.
 * Can take string parameters or if none are given,
 * will run with 6 disks.
 * 
 * @author aliparslan
 * @version 03.14.2021
 *
 */
public class ProjectRunner {

    /**
     * Runs the program with given strings, or with
     * six disks if parameter is empty.
     * 
     * @param args
     *            the number of disks
     */
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        PuzzleWindow puzzle = new PuzzleWindow(new HanoiSolver(disks));
    }

}
