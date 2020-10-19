package ua.procamp;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

    private Node front, last;
    private int size;

    private class Node
    {
        T data;
        Node next;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        Node oldLast = last;
        last = new Node();
        last.data = element;
        last.next = null;
        if (this.isEmpty()) {
            front = last;
        } else {
            oldLast.next = last;
        }
        this.size++; // todo: implement this method
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if ( this.size == 0) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (this.isEmpty())
        {
            last = null;
        }
        this.size--;
        return data; // todo: implement this method
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return this.size; // todo: implement this method
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return this.size == 0; // todo: implement this method
    }
}

