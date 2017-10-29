import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Arrays;


/**
 * Represents a Set of squares on a chess board.
 *
 * @version 1.0
 * @author mabdi3
 * @see Square
 */

public class SquareSet<Square> implements Set<Square> {

    private Square[] bArray;
    private int numOfElements;


    /**
     * Creates a SquareSet with an Object array as a backing store.
     */
    public SquareSet() {
        bArray = ((Square[]) new Object[10]);
        numOfElements = 0;
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
    public boolean add(Square e) {
        for (Object x: bArray) {
            if (e == null ? x == null : e.equals(x)) {
                return false;
            }
        }
        if (numOfElements == bArray.length) {
            Object[] copy = new Object[bArray.length * 3];
            for (int x = 0; x < bArray.length; x++) {
                copy[x] = bArray[x];
            }
            copy[numOfElements] = e;
            numOfElements++;
            bArray = (Square[]) copy;
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
    public boolean addAll(Collection<? extends Square> c) {
        for (Square x: c) {
            this.add(x);
        }
        return true;
    }
    /**
     * @return true if this set contains the specified elemnent
     * @param o element whose presence in this set is to be tested
     */
    public boolean contains(Object o) {
        for (Square x: bArray) {
            if (o != null && o.equals(x)) {
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
        for (Square x: (Set<Square>) c) {
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
        return numOfElements == 0;
    }

    /**
     * @return iterator over the elements in this set
     * @see Iterator
     */
    public Iterator<Square> iterator() {
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
     * @param o object to tested for equality
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if ((((Set) o).size()) != this.size()) {
            return false;
        }
        if (!(o instanceof Set)) {
            return false;
        }
        return this.containsAll((Set) o);
    }

    /**
     * @return array containing all the elements in this set
     */
    public Object[] toArray() {
        Object[] copy = new Object[numOfElements];
        for (int x = 0; x < numOfElements; x++) {
            copy[x] = bArray[x];
        }
        return ((Square[]) copy);
    }


    /**
     * @return array containing all of the elements in this set;
     * the runtime type of the returned array is that of the specified array
     * @param a the array into wich the elements of this set are to be stored
     * @param <Square> runtime type of the array to contain the collection
     */
    public <Square> Square[] toArray(Square[] a) {
        if (a.length < numOfElements) {
            Square[] b = (Square[])this.toArray();
            a = b;
            return a;
        } else {
            for (int x = 0; x < numOfElements && x < a.length; x++) {
                a[x] = ((Square) bArray[x]);
            }
            if(a.length > numOfElements) {
                a[numOfElements] = null;
            }
            return a;
        }
    }


    /**
     * Removes the specified element from this set if it is present
     *
     * @param o object to be removed if present
     * @return true if this set contained the specified element
     */
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
       /* for (Object x:bArray) {
            if ((o == null ? x == null : o.equals(x)) {
                Object store = x;
                numOfElements--;
                Object[] copy = new Object[numOfElements];
                for (int x = 0; i < numOfElements; i++) {

                }


            }
       }*/
        boolean found = false;

        for (int i = 0; i < bArray.length; i++) {
            if (o == null ? bArray[i] == null : o.equals(bArray[i])) {
                found = true;
                numOfElements--;
                Object[]  copy = new Object[numOfElements];
                for (int x = 0; x < numOfElements; x++) {
                    if (bArray[i] == null && o == null) {
                        if (bArray[x] != null) {
                            copy[x] = bArray[x];
                        }
                    } else {
                        if (!(bArray[x].equals(bArray[i]))) {
                            copy[x] = bArray[x];
                        }
                    }
                }
                bArray = (Square[]) copy;
                return found;
            }
        }
        return found;
    }

    public String toString() {
      String result = "";

      for (int index=0; index < numOfElements; index++)
         result = result + bArray[index].toString() + "\n";

      return result;
    }

    /**
     * @throws UnsupportedOperationExcetion
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }
    /**
     * @throws UnsupportedOperationExcetion
     * @param c collection to be removed
     * @return an UnsupportedOperationException
     */
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    /**
     * @throws UnsupportedOperationExcetion
     * @param c collection to be removed
     * @return an UnsupportedOperationException
     */
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    /**
     * Represents an iterator over a Square collection.
     *
     * @version 1.0
     * @author mabdi3
     * @see Square
     */
    private class SquareIterator implements Iterator<Square> {
        private int cursor = 0;
       /**
        * @return true if the iteration has more elements
        */
        public boolean hasNext() {
            return cursor <= (numOfElements - 1);
        }
       /**
        *@return the next element in the iteration
        *@throws NoSuchElementException if the iteration has no more elements
        */
        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Square next = bArray[cursor];
            cursor++;
            return next;
        }
    }
}