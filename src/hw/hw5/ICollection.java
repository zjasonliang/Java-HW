package hw.hw5;

public interface ICollection<E> {

    /**
     * Add a new element to the container.
     * @param element   a given element.
     * @return  true if insertion is done successfully, false if there is a duplicate.
     */
    boolean add(E element);

    /**
     * Remove a given element from the container. If the element is not present, raise exception.
     * @param element   a given element
     */
    void remove(E element);

    /**
     * Clear all elements in the container.
     */
    void clear();

    /**
     * This method will tell you whether the given element is present in the container.
     * @param element   an element of type E
     * @return  true if it is present in the container, false if not
     */
    boolean contains(E element);

    /**
     * Return the size of the container object.
      * @return the size of the container
     */
    int size();

    /**
     * Convert the object to an array [] of the element.
     * @return  the returned array
     */
    E[] toArray();
}
