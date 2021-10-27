// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * A linked implementation of a stack.
 * 
 * @author aliparslan
 * @version 2021.03.14
 *
 * @param <T>
 *            The type of object to be used for a linked stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    // Fields .....................................

    private Node<T> topNode;
    private int size;

    // Constructor ................................

    /**
     * Creates an empty linked stack
     */
    public LinkedStack() {
        topNode = null;
    }

    // Methods ....................................


    /**
     * Returns the number of nodes in the stack
     * 
     * @return the size field
     */
    public int size() {
        return this.size;
    }


    /**
     * Returns if the stack has no nodes
     * 
     * @return if the size is zero
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * Returns the data of the item at the top of the stack
     * 
     * @return the contents of the top node
     * @throws EmptyStackException
     *             if the stack is empty
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Adds a node to the top of the stack with the given data
     * 
     * @param anEntry
     *            the data of the new node that will be added
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;
    }


    /**
     * Removes the top node of the stack and returns its data
     * 
     * @return the data of the removed node
     * @throws EmptyStackException
     *             if the stack is empty
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T topData = topNode.getData();
        topNode = topNode.getNextNode();
        size--;

        return topData;

    }


    /**
     * Removes all nodes in the stack
     */
    public void clear() {
        this.size = 0;
        this.topNode = null;
    }


    /**
     * Returns the data of the nodes as the toString() of an array
     * 
     * @return string representation of the stack
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> p = topNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }

    /**
     * 
     * A simple node implementation.
     * 
     * @author aliparslan
     * @version 2021.03.14
     *
     * @param <T>
     */
    protected static final class Node<T> {
        // Fields ..................................
        private Node<T> next;
        private T data;

        // Constructor .............................

        /**
         * Creates a node with specified data
         * 
         * @param nodeData
         *            the data to be stored in the node
         */
        public Node(T nodeData) {
            this.data = nodeData;
        }

        // Methods .................................


        /**
         * Returns the node that this one references
         * 
         * @return the node that follows the current one
         */
        public Node<T> getNextNode() {
            return this.next;
        }


        /**
         * Returns the data stored in the node
         * 
         * @return the data stored in the node
         */
        public T getData() {
            return this.data;
        }


        /**
         * Sets the parameter to be the current node's next node
         * 
         * @param nextNode
         *            the node to follow the current one
         */
        public void setNextNode(Node<T> nextNode) {
            this.next = nextNode;
        }

    }

}
