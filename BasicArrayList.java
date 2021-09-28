/**
 * Array-based implementation of the ADT list.
 */
import java.util.Arrays;
import java.util.Iterator;

public class BasicArrayList<E> implements BasicListInterface<E> {

  /** contained Array object. */
  private Object[] items;
  /** the capacity of the array <code>items</code>. */
  private int capacity = 10;
  /** the number of elements stored in the array <code>items</code>. */
  private int size = 0;

  /** default Constructor. */
  public BasicArrayList() {
    items = new Object[capacity];
  }

  /**
   * constructor with the first item: constructs a list with the
   * specified item as single element of this list.
   * @param elt first element of the list
   */
  public BasicArrayList(E elt) {
    items = new Object[capacity];
    append(elt);
  }

  /**
   * copy constructor: create a duplicate of the specified list.
   * @param list to be copied
   */
  public BasicArrayList(BasicListInterface<E> list) {
    items = new Object[capacity];
    Iterator<E> listIter = list.iterator();
    while (listIter.hasNext()) {
      append(listIter.next());
    }
  }

  /**
   * Increases the capacity of the array by copying all elements
   * from the current array to a larger array.
   */
  private void grow() {
    capacity *= 2;
    items = Arrays.copyOf(items, capacity);
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
    for (int i = 0; i < size; i++) {
      items[i] = null;
    }
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
      if (size == capacity) {
        grow();
      }
      for (int i = size; i > index; i--) {
        items[i] = items[i - 1];
      }
      items[index] = elt;
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
    if (size == capacity) {
      grow();
    }
    items[size] = elt;
    size++;
  }

  /**
   * Returns the element at the specified position in this list.
   * @param index index of element to return.
   * @return the element at the specified position in this list.
   * @throws IndexOutOfBoundsException - if index is out of range (index < 0 || index >= size()).
   */
  public E get(int index) throws IndexOutOfBoundsException {
    if (0 <= index && index < size) {
      @SuppressWarnings("unchecked")
      E tmp = (E) items[index];
      return tmp;
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
      // delete item by shifting all items at
      // positions > index toward the beginning of the list
      // (no shift if index == size)
      for (int i = index; i < size; i++) {
        items[i] = items[i + 1];
      }
      items[size] = null;
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
    for (int i = 0; i < size; i++) {
      @SuppressWarnings("unchecked")
      E tmp = (E) items[i];
      if (elt.equals(tmp)) {
        return i;
      }
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
    for (int i = 0; i < size; i++) {
      builder.append(items[i].toString());
      builder.append(", ");
    }
    return builder.toString();
  }

  /** method to make the class iterable. */
  public Iterator<E> iterator() {
    return new BasicListIterator();
  }

  private class BasicListIterator implements Iterator<E> {
    /** Marks where the iterator is in the array <code>items</code>. */
    private int cursor = 0;

    /**
     * Tests if this list has more elements to iterate over.
     * @return <code>true</code> if cursor has not reached size;
     * <code>false</code> otherwise.
     */
    public boolean hasNext() {
      return cursor < size;
    }

    /**
     * Returns the next element in the list.
     * @return the next element in the list.
     */
    public E next() {
      if (! hasNext()) {
        return null;
      }
      @SuppressWarnings("unchecked")
      E tmp = (E) items[cursor];
      cursor++;
      return tmp;
    }
  }

}  // end BasicArrayList
