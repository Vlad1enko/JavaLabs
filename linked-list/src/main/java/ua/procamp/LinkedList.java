package ua.procamp;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {
    Node<T> head;
    private int size;

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
    }

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for ( T item : elements) {
            list.add(item);
        }
        return list;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
        }
        Node<T> temp = new Node<>(element);
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
        this.size++; // todo: implement this method
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if ( index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            head = new Node<>(element);
        }
        Node<T> temp = new Node<>(element);
        Node<T> current = head;
        if (current != null) {
            for (int i = 0; i < index && current.next != null; i++) {
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
        }
        this.size++; // todo: implement this method
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        if (current != null) {
            for (int i = 0; i < index+1 && current.next != null; i++) {
                current = current.next;
            }
            current.setData(element);
        }
        // todo: implement this method
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < index + 1; i++) {
                if (current.next == null) {
                    return null;
                }
                current = current.next;
            }
            return current.getData();
        }
        return null; // todo: implement this method
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        if (head != null) {
            if ( index == 0 ) {
                head = head.next;
            }
            for (int i = 0; i < index; i++) {
                if (current.next == null) {
                    return;
                }
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        } // todo: implement this method
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> current = head;
        if (current != null) {
            for (int i = 0; i < size && current.next != null; i++) {
                if (current.data == element) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;// todo: implement this method
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // todo: implement this method
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size; // todo: implement this method
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        size = 0;
        head = null;// todo: implement this method
    }
}
