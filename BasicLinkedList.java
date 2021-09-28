//BasicLinkedList.java

/**
 * Array-based implementation of the ADT list.
 */
import java.util.Iterator;

public class BasicLinkedList<E> implements BasicListInterface<E> {

  /** the first node in the linked list. */
  private Node<E> head;
  /** the number of elements stored in the array <code>items</code>. */
  private int size = 0;

  /** default Constructor. */
  public BasicLinkedList() {
    head = null;
  }

  /**
   * constructor with the first item: constructs a list with the
   * specified item as single element of this list.
   * @param elt first element of the list
   */
  public BasicLinkedList(E elt) {
    head = null;
    add(0, elt);
  }

  /**
   * copy constructor: create a duplicate of the specified list.
   * @param list to be copied
   */
  public BasicLinkedList(BasicListInterface<E> list) {
    head = null;
    Iterator<E> listIter = list.iterator();
    for (int i = 0; i < list.size(); i++) {
      add(i, listIter.next());
    }
  }

  /**
   * Tests if this list has no elements.
   * @return <code>true</code> if this list has no elements;
   * <code>false</code> otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  } // end isEmpty


  /**
   * Returns the number of elements in this list.
   * @return the number of elements in this list.
   */
  public int size() {
    return size;
  }  // end size

  /**
   * Remove all the elements in this list.
   */
  public void removeAll() {
    head = null;
    size = 0;
  } // end removeAll


  /**
   * Inserts the specified element at the specified position in this
   * list. Shifts the element currently at that position (if any)
   * and any subsequent elements to the right (adds one to their
   * indices).
   * @param index index at which the specified element is to be inserted.
   * @param elt element to be inserted.
   * @throws IndexOutOfBoundsException - if index is out of range (index < 0 || index > size()).
   */
  public void add(int index, E elt) throws IndexOutOfBoundsException {
    if (0 <= index && index <= size) {
      if (index == 0) {
        head = new Node<E>(elt, head);
      } else {
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
          curr = curr.getNext();
        }
        curr.setNext(new Node<E>(elt, curr.getNext()));
      }
      size++;
    } else { // index out of range
      throw new IndexOutOfBoundsException("IndexOutOfBoundsException on add");
    }  // end if
  } //end add


  /**
   * appends the specified element to the end of this list.
   * @param elt element to be added at the end of the list
   */
  public void append(E elt) {
    add(size, elt);
  }

  /**
   * Returns the element at the specified position in this list.
   * @param index index of element to return.
   * @return the element at the specified position in this list.
   * @throws IndexOutOfBoundsException - if index is out of range (index < 0 || index >= size()).
   */
  public E get(int index) throws IndexOutOfBoundsException {
    if (0 <= index && index < size) {
      Node<E> curr = head;
      for (int i = 0; i < index; i++) {
        curr = curr.getNext();
      }
      return curr.getItem();
    } else  {  // index out of range
      throw new IndexOutOfBoundsException("IndexOutOfBoundsException on get");
    }  // end if
  } // end get


  /**
   * Deletes the element at the specified position in this
   * list. Shifts any subsequent elements to the left (subtracts one
   * from their indices).
   * @param index the index to delete
   * @throws IndexOutOfBoundsException - if index is out of range (index < 0 || index >= size()).
   */
  public void delete(int index) throws IndexOutOfBoundsException {
    if (0 <= index && index < size) {
      if (index == 0) {
        head = head.getNext();
      } else {
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
          curr = curr.getNext();
        }
        curr.setNext(curr.getNext().getNext());
      }
      size--;
    } else {  // index out of range
      throw new IndexOutOfBoundsException("IndexOutOfBoundsException on remove");
    }  // end if
  } //end remove


  /**  remove
   * Remove the the specified element in this list if exists. Shifts
   * any subsequent elements to the left (subtracts one from their
   * indices).
   * @param elt the element, if it exists, to delete
   */
  public void remove(E elt) {
    int index = indexOf(elt);
    if (index >= 0) {
      delete(index);
    }
  }

  /** indexOf
   * Looks for the index of the specified element in this list. If
   * the element is not present, the method returns <code>-1</code>
   * @param elt the element which index is looked for.
   * @return either the index of the location in the list where the argument is present or
   * <code>-1</code> if the argument is not contained in the list.
   */
  public int indexOf(E elt) {
    Node<E> curr = head;
    for (int i = 0; i < size; i++) {
      if (elt.equals(curr.getItem())) {
        return i;
      }
      curr = curr.getNext();
    }
    return -1;
  }

  /** display
   * Prints all the elements in this list on the console in sequence.
   */
  public void display() {
    System.out.println(toString());
  }

  /** toString
   * Returns a String representation of the list.
   @return String representation of the list.
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Node<E> curr = head; curr != null; curr = curr.getNext()) {
      builder.append(curr.getItem().toString());
      builder.append(", ");
    }
    return builder.toString();
  }

  /** equals
   * Returns <code>true</code> if both lists contain identical elements in identical positions.
   * Otherwise, returns <code>false</code>
   * @param list to be copied.
   * @return <code>true</code> if both lists are identical. Otherwise, returns <code>false</code>.
   */
  public boolean equals(BasicListInterface<E> list) {
    if (size != list.size()) {
      return false;
    }
    Iterator<E> listIter = list.iterator();
    for (Node<E> curr = head; curr != null; curr = curr.getNext()) {
      if (! listIter.next().equals(curr.getItem())) {
        return false;
      }
    }
    return true;
  }

  /** method to make the class iterable. */
  public Iterator<E> iterator() {
    return new BasicLinkedListIterator(head);
  }

  private class BasicLinkedListIterator implements Iterator<E> {
    /** Marks where the iterator is in the array <code>items</code>. */
    private Node<E> cursor;

    public BasicLinkedListIterator(Node<E> head) {
      cursor = head;
    }

    /**
     * Tests if this list has more elements to iterate over.
     * @return <code>true</code> if cursor has not reached size;
     * <code>false</code> otherwise.
     */
    public boolean hasNext() {
      return cursor != null;
    }

    /**
     * Returns the next element in the list.
     * @return the next element in the list.
     */
    public E next() {
      if (! hasNext()) {
        return null;
      }
      E item = cursor.getItem();
      cursor = cursor.getNext();
      return item;
    }
  }

}  // end BasicArrayList
