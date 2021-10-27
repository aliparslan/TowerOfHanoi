package towerofhanoi;

import student.TestCase;
import java.util.EmptyStackException;

/**
 * Tests the LinkedStack class's methods and
 * all of its possible conditions.
 * 
 * @author aliparslan
 * @version 2021.03.15
 *
 */
public class LinkedStackTest extends TestCase {

    // Fields ...................................................

    private LinkedStack<String> stack;

    // Constructor ..............................................

    /**
     * Empty constructor
     */
    public LinkedStackTest() {
        // Intentionally left empty
    }

    // Methods ..................................................


    /**
     * The code to be run before each test is performed
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }


    /**
     * Tests the size() method
     */
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push("A");
        assertEquals(1, stack.size());

        stack.push("A");
        stack.push("A");
        stack.push("A");
        assertEquals(4, stack.size());
    }


    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("A");
        assertFalse(stack.isEmpty());
    }


    /**
     * Tests the peek() method when the stack is empty
     * 
     * Catches the appropriate exception
     */
    public void testPeekEmpty() {
        Exception exception = null;
        try {
            stack.peek();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyStackException);
    }


    /**
     * Tests the peek() method
     */
    public void testPeek() {
        stack.push("A");
        assertEquals("A", stack.peek());

        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.peek());
    }


    /**
     * Tests the push() method
     */
    public void testPush() {
        stack.push("A");
        assertEquals(1, stack.size());
    }


    /**
     * Tests the pop() method when the stack is empty
     * 
     * Catches the appropriate exception
     */
    public void testPopEmpty() {
        Exception exception = null;
        try {
            stack.pop();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyStackException);
    }


    /**
     * Tests the pop() method
     */
    public void testPop() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        assertEquals("D", stack.pop());
        assertEquals(3, stack.size());
    }


    /**
     * Tests the clear() method
     */
    public void testClear() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.clear();
        assertEquals(0, stack.size());
    }


    /**
     * Tests the overridden toString() method
     */
    public void testToString() {
        assertEquals("[]", stack.toString());

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        assertEquals("[D, C, B, A]", stack.toString());
    }
}
