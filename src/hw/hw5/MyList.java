package hw.hw5;



import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
TODO: if elements of type E are comparable, thea add() operation should maintain the order of elements.
 */
public class MyList<E> implements ICollection<E> {

    private int size = 0;
    private Node<E> head = new Node<>(null);
    private Node<E> tail = head;  // the last element in the linked list

    private class Node<E> {
        private E content;
        private Node<E> next;

        public Node(E content) {
            this.content = content;
        }
    }

    /**
     * Default constructor
     */
    public MyList() {}

    /**
     * Add a new element to the container.
     *
     * @param element a given element.
     * @return true if insertion is done successfully, false if there is a duplicate.
     */
    @Override
    public boolean add(E element) {

        if (head.next == null) {
            head.next = new Node <>(element);
            tail = head.next;
            size++;
            return true;
        }

        if (element instanceof Comparable) {
            Node<E> current = head;
            Comparable<E> newElement = (Comparable<E>) element;
            while (current.next != null && newElement.compareTo(current.next.content) == 1) {
                current = current.next;
            }

            if (current.next == null) {
                current.next = new Node <>(element);
                tail = current.next;
                size++;
                return true;
            } else {
                Node<E> temp = new Node <>(element);
                temp.next = current.next;
                current.next = temp;
                size++;
                return true;
            }
        } else {
            tail.next = new Node <>(element);
            tail = tail.next;
            size++;
            return true;
        }
    }

    /**
     * Remove a given element from the container. If the element is not present, raise exception.
     *
     * @param element a given element
     */
    @Override
    public void remove(E element) {
        boolean hasDeleted = false;
        Node<E> current = head;

        while (current.next != null) {
            if (current.next.content.equals(element)) {
                current.next = current.next.next;
                size--;
                hasDeleted = true;
                continue;
            } else {
                current = current.next;
            }
        }

        tail = current;
        if (!hasDeleted) throw new NoSuchElementException();
    }

    /**
     * Clear all elements in the container.
     */
    @Override
    public void clear() {

    }

    /**
     * This method will tell you whether the given element is present in the container.
     *
     * @param element an element of type E
     * @return true if it is present in the container, false if not
     */
    @Override
    public boolean contains(E element) {
        return false;
    }

    /**
     * Return the size of the container object.
     *
     * @return the size of the container
     */
    @Override
    public int size() {
        return this.size;

    }

    /**
     * Convert the object to an array [] of the element.
     *
     * @return the returned array
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        // return new E[0];
        E[] array = (E[]) new Object[size];
        Node<E> current = head;
        int index = 0;
        while (current.next != null) {
            array[index] = current.next.content;
            index++;
            current = current.next;
        }
        return array;
    }


    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder string = new StringBuilder();
        while (current != null) {
            string.append(current.content);
            string.append(" -> ");
            current = current.next;
        }
        return string.toString();
    }

    public E getTailElement() {
        return this.tail.content;
    }

    public static void main(String[] args) {
        MyList<Integer> list = new MyList <>();
        list.add(3);
        list.add(6);
        System.out.println(list.getTailElement());
        list.remove(6);
        // System.out.println(list);
        list.add(9);
        // System.out.println(list.size());
        list.add(1);
        System.out.println(list.getTailElement());
        list.add(1);
        // System.out.println(list.size());
        list.add(2);
        // System.out.println(list);
        System.out.println(list.getTailElement());
        System.out.println("====");

        for (Integer i: list.toArray()) {
            System.out.println(i);
        }
    }
}
