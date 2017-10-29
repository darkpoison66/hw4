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
     * nh
     */
    public SquareSet() {
        bArray = new Object[10];
        int numOfElements = 0;
    }

    @Override

    public boolean add (Square e) {
        for (Square x:bArray) {
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

    public boolean contains(Object o) {
        for (Square x:bArray){
                   if (o != null && o.equals(x)){
                       return true;
                    }
               }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return true;
    }

    public int hashCode() {
        int sum = 0;
        for (Square x:bArray) {
            sum += x.hashCode();
        }
        return 6;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator<Square> iterator {
        return new SquareIterator;
    }


    public int size() {
        return numOfElements;
    }

    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (!(o instanceof SquareSet)) { return false; }
        Set<Square> that = (Set<Square>) o;
        return false;
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