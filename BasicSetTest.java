//BasicSetTest.java

public class BasicSetTest {

  /**
   * Simple main function to test ADT Set.
   */
  public static void main(String[] args) {
    BasicArrayList<Integer> array1 = new BasicArrayList<>();
    array1.append(2);
    array1.append(3);
    array1.append(5);
    array1.append(7);
    array1.append(11);
    array1.append(13);
    array1.append(17);
    array1.append(19);
    array1.append(23);
    array1.append(29);

    BasicSet<Integer> setA = new BasicSet<Integer>();
    setA.add(0);
    setA.addAll(array1);
    System.out.println("\nSet A Follows:");
    System.out.println(setA);

    BasicArrayList<Integer> array2 = new BasicArrayList<>();
    array2.append(1);
    array2.append(3);
    array2.append(6);
    array2.append(8);
    array2.append(9);
    array2.append(11);
    array2.append(12);
    array2.append(17);
    array2.append(19);
    array2.append(23);
    array2.append(24);
    array2.append(25);
    array2.append(3);

    BasicSetInterface<Integer> setB = new BasicSet<Integer>();
    setB.addAll(array2);
    setB.add(11);
    System.out.println("\nSet B Follows:");
    System.out.println(setB);

    BasicSetInterface<Integer> setC = setA.union(setB);
    System.out.println("\nSet C which is (A Union B) Follows:");
    System.out.println(setC);

    BasicSetInterface<Integer> setD = setA.intersection(setB);
    System.out.println("\nSet D which is (A intersect B) Follows:");
    System.out.println(setD);

    BasicSetInterface<Integer> setE = setA.difference(setB);
    System.out.println("\nSet E which is sets (A - B) Follows:");
    System.out.println(setE);

    BasicSetInterface<Integer> setF = setB.difference(setA);
    System.out.println("\nSet F which is sets (B - A) Follows:");
    System.out.println(setF);

    System.out.println("\nElement 2 in Set E:");
    System.out.println(setE.in(2));
    System.out.println("\nElement 2 in set F:");
    System.out.println(setF.in(2));
  } // end main
}
