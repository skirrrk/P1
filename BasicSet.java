//BasicSet.java

import java.util.Iterator;

/*
   Implementation of the Set ADT that uses a BasicLinkedList private variable to store data.
*/
public class BasicSet<E> implements BasicSetInterface<E> {

  private BasicLinkedList<E> list;

  /*  Provide code for the following methods:
  -------------------------------------------------------------------------------
  Constructors:
  - a default constructor,
  - a constructor that takes a single argument of type E and
  initializing the set to contain that object, and
  - a copy constructor.

  Methods:
  - add: a method that takes an element of type E and adds it into the set,
  - addAll: a method that takes a BasicListInterface of elements of type
  E and inserts them into the set,
  - difference: a method that takes a Set as an argument and
  returns a new Set that is the difference of the current set and the argument,
  - equals: a method that takes a Set as an argument and returns true if both
  Sets contain the same elements and false otherwise,
  - in: a method that takes an element of type E and returns true if the
  given element is contained in the current Set or false otherwise,
  - intersection: a method that takes a Set as an argument and
  returns a new Set that is the intersection of the current set and the argument,
  - isEmpty: a method that returns true if the Set contains no elements and
  false otherwise,
  - size: a method that returns the number of elements in the set as an int value,
  - toString: a method that returns the String representation of the Set,
  - union: a method that takes a Set as an argument and returns a
  new Set that is the union of the current set and the argument.
  -------------------------------------------------------------------------------
  */
  // TODO: Complete

  /**
   * This method implements the iterator required by the Iterable interface,
   * with SetInterface inherits from. It enables the list to be iterable,
   * which allows the use of enhanced for loops.
   * @return an iterator.
   */
  public Iterator<E> iterator() {
    return (list.iterator());
  }

}
