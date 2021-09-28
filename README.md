# P1

You’ve been provided with seven files: BasicArrayList.java, BasicLinkedList.java, BasicListInterface.java, BasicSet.java, BasicSetInterface.java, BasicSetTest.java, and Node.java. BasicArrayList.java is a basic implementation of the ArrayList class provided by the Java library. BasicLinkedList.java is a basic implementation of the LinkedList class provided by the Java library. BasicListInterface.java is an interface that describes many of the public methods available in the ADT List interface, which corresponds to the List interface in the Java library. BasicSet.java is an implementation of a Set that utilizes a linked list. BasicSetInterface.java is a basic implementation of the Set interface provided by the Java library. TestBasicSet.java is provided to test your code before submitting to codePost. Node.java is a simple implementation of a Node ADT to support BasicLinkedList. 

Assignment - Implement the following constructors for the BasicSet class: 

Default constructor: construct an empty BasicSet. 
Constructor initializing the BasicSet with a single initial element: construct a BasicSet with a single element. Elements in a set are not considered to have a position, so new elements can be inserted anywhere into the set. 

Copy constructor: Make a deep copy of another BasicSet that uses a shallow copy of each item in the other BasicSet. 
In addition, write the following method declarations in the BasicSetInterface and implement these methods in the BasicSet class: 

add: a method that takes an element of type E and adds it into the set, 

addAll: a method that takes a BasicListInterface of elements of type E and inserts them into the set, 

difference: a method that takes a Set as an argument and returns a new Set that is the difference of the current set and the argument, 
The difference of sets A and B is defined as a new set C such that C contains all elements in A that are also not in B. 

equals: a method that takes a Set as an argument and returns true if both Sets contain the same elements and false otherwise, 

in: a method that takes an element of type E and returns true if the given element is contained in the current Set or false otherwise, 

intersection: a method that takes a Set as an argument and returns a new Set that is the intersection of the current set and the argument, 
The intersection of sets A and B is defined as a new set C such that C contains all elements in A that are also in B. 

isEmpty: a method that returns true if the Set contains no elements and false otherwise, 

size: a method that returns the number of elements in the set as an int value, 

toString: a method that returns the String representation of the Set, 

union: a method that takes a Set as an argument and returns a new Set that is the union of the current set and the argument. 
The union of sets A and B is defined as a new set C such that C contains all elements that are either in A or in B.
