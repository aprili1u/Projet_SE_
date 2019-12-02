import java.util.NoSuchElementException;

public interface Queue<E> extends Iterable{
    /** Add specified element into this Queue, increase capacity of the queue if not enough space
     *
     * @return true if the element was successfully added
     */
    boolean insertElement(E e);

    /**
     * Retrieves (without removing) the highest element of this heap
     *
     * @return the highest element of this heap
     * @throws NoSuchElementException if this heap is empty
     */
    E element();

    /**
     * Retrieves (and remove) the highest element of this heap
     *
     * @return the highest element of this heap
     * @throws NoSuchElementException if this heap is empty
     */
    E popElement();

    /** Returns true if this heap contains no elements. */
    boolean isEmpty();

    /** Returns the number of elements contained in this heap */
    int size();
}
