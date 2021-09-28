//BasicSetInterface.java
/*
   Interface to specify the behavior/operations of the Set ADT
*/
public interface BasicSetInterface<E> extends Iterable<E> {

  /*  Provide signature/headers for the following methods:
  Methods:
  - add: a method that takes an element of type E and adds it into the set,
  - addAll: a method that takes a BasicListInterface of elements of type
  E and inserts them into the set,
  - difference: a method that takes a Set as an argument and
  returns a new Set that is the difference of the current set and the argument,
  - in: a method that takes an element of type E and returns true if the
  given element is contained in the current Set or false otherwise,
  - intersection: a method that takes a Set as an argument and
  returns a new Set that is the intersection of the current set and the argument,
  - isEmpty: a method that returns true if the Set contains no elements and
  false otherwise,
  - size: a method that returns the number of elements in the set as an int value,
  - union: a method that takes a Set as an argument and returns a
  new Set that is the union of the current set and the argument.
  */
  // TODO: Complete

  public BasicSetInterface<E> union(BasicSetInterface<E> other);

}
