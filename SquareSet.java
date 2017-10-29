import java.util.Set;
import java.util.Iterator;

/**
 * Represents a Set of squares on a chess board.
 *
 * @version 1.0
 * @author mabdi3
 * @see Square
 */

public class SquareSet implements Set<Square> {

    private Object[] bArray;
    private int numOfElements;


    /* Creates a SquareSet with an Object array as a backing store.
     */
    public SquareSet() {
        bArray = new Object[10];
        int numOfElements = 0;
    }

    @Override

    /**
     * Adds the square element to this square set if it is not already present
     *
     * @param e square to be added to this set
     * @return true if the set did not already contain the specified element
     * @throws InvalidSquareException if invalid square is passed into the
     * the method.
     */
    public boolean add (Square e) throws InvalidSquareException {
        for (Square x: bArray) {
            if (e == null ? x == null : e.equals(x)) {
                return false;
            }
        }
         if (numOfElements == bArray.length()) {
            Square[] copy = new Square[bArray.length * 3];
            for (int x = 0; x < bArray.length; x++) {
                copy[x] = bArray[x];
            }
            copy[numOfElements] = e;
            numOfElements++;
            bArray = copy;
            return true;
         } else {
            bArray[numOfElements] = e;
            numOfElements++;
            return true;
         }
    }

    /**
     * Adds all of the elements in the specified collection
     * to this set if they're not already present.
     *
     * @param c collection cotaining squares to be added to this set
     * @return true if this set changed as a result of this call
     */
    public boolean addAll(Collection<? extends Square> c){
        for(Square x:c){
            this.add(x);
        }
        return true;
    }
    /**
     * @return true if this set contains the specified elemnent
     * @param o element whose presence in this set is to be tested
     */
    public boolean contains(Object o) {
        for (Square x: bArray){
                   if (o != null && o.equals(x)){
                       return true;
                    }
               }
        return false;
    }

    /**
     * @param c collection to be checked for containment in this set
     * @return true if this set contains all of the elements of the
     * specified collection
     */
    public boolean containsAll(Collection<?> c) {
        for (Square x: bArray) {
            if (!(this.contains(x))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the hash code value for this set, defined
     * by the sum of the hash codes of the elements in the set
     */
    public int hashCode() {
        int sum = 0;
        for (Square x:bArray) {
            sum += x.hashCode();
        }
        return sum;
    }

    /**
     * @return true if this set contains no elements
     */
    public boolean isEmpty() {
        if (numOfElements == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return iterator over the elements in this set
     * @see Iterator
     */
    public Iterator<Square> iterator {
        return new SquareIterator();
    }

    /**
     * @return the number of elements in this set
     */
    public int size() {
        return numOfElements;
    }

    /**
     * @return true if the specified object is also a set, the two sets have the
     * same size, and every member of the specified set is contained in this
     * set (or equivalently, every member of this set is contained
     * in the specified set)
     */
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if ((Set)o.size() != this.size()) { return false; }
        if (!(o instanceof Set)) { return false;}
        return this.containsAll((Set) o);
        }
    }

    /**
     * @return array containing all the elements in this set
     */
    public Object[] toArray() {
        Object[] copy = new Object[numOfElements];
        for (int x = 0; x < numOfElements; x++) {
            copy[x] = bArray[x];
        }
        return copy;
    }
    /**
     *
     *
     */
    public <T> T[] toArray(T[] a) {

    }

   private class SquareIterator implements Iterator<Square> {
        private int cursor = 0;

        public boolean hasNext() { return cursor <= (numOfElements - 1); }

        public Square next() {
            if (!hasNext()) { throw new NoSuchElementException();}
            Square answer = get(cursor)
        }

   }


}