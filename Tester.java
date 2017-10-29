import java.util.*;
public class Tester {
    public static void main(String[] args) throws InvalidSquareException {
        SquareSet<Square> squares = new SquareSet<>();
        MySet<Square> hm = new MySet<>();
        squares.add(new Square("a4"));
        squares.add(new Square("a5"));
        squares.add(new Square("a5"));
        squares.add(new Square("a6"));
        SquareSet<Square> squares2 = new SquareSet<>();
        squares2.add(new Square("a5"));
        squares2.add(new Square("a6"));
        squares2.add(new Square("a4"));
        squares.addAll(squares2);
        SquareSet<Square> squares3 = new SquareSet<>();
       // System.out.println(squares);
       // System.out.println(squares.contains(new Square("a8")));
       // System.out.println(squares.contains(new Square("a7")));
      //  System.out.println(squares.containsAll(squares2));
      //  System.out.println(squares.equals(squares2));
       // System.out.println(squares2.isEmpty());
       // System.out.println(squares3.isEmpty());
       // System.out.println(squares.size());
        //System.out.println(squares2.size());
        //Object[] array = squares.toArray();
        Square[] array  = new Square[2];
        array = (Square[]) squares.toArray(array);
        System.out.println(Arrays.toString(array));
    }
}