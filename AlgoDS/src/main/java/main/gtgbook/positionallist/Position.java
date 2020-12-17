package main.gtgbook.positionallist;

public interface Position<E> {

    /**
     * Return the element stored at this position
     *
     * @return {E} the stored element
     * @throws IllegalStateException if position is no longer valid
     */
    E getElement() throws IllegalStateException;
}
