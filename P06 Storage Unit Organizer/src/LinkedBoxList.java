//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Storage Unit Organizer
// Files:           Box.java, LinkedBoxNode.java, LinkedBoxList.java, StorageUnitTests.java
// Course:          CS 300
//
// Author:          Vamsi Peddi
// Email:           vpeddi@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         -
// Online Sources: -
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class LinkedBoxList {

  private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private int size; // number of boxes already stored in this list
  private int capacity; // capacity of this LinkedBoxList
  // maximum number of box elements that this LinkedBoxList
  // can store

  // Creates an empty LinkedBoxList with a given initial capacity
  public LinkedBoxList(int capacity) {
    this.capacity = capacity;
  }

  // Returns the size of this list
  public int size() {
    return this.size;
  }

  // Return the capacity of this list
  public int getCapacity() {
    return this.capacity;
  }


  // Expands the capacity of this LinkedBoxList with the specified number a of
  // additional elements
  public void expandCapacity(int a) {
    this.capacity = this.capacity + a;
  }

  // Checks whether this LinkedBoxList is empty
  // returns true if this LinkedBoxList is empty, false otherwise
  public boolean isEmpty() {
    int size1 = this.size;
    if (size1 == 0) {
      return true;
    } else {
      return false;
    }
  }

  // Checks whether this LinkedBoxList is full
  // Returns true if this list is full, false otherwise
  public boolean isFull() {
    if (this.size >= this.capacity) {
      return true;
    } else {
      return false;
    }
  }

  // Adds a new box into this sorted list
  // Throws IllegalArgumentException if newBox is null
  // Throws IllegalStateException if this list is full
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {

    if (newBox == null) {
      throw new IllegalArgumentException("Illegal Argument Exception");
    }
    if (isFull()) {
      throw new IllegalStateException("Illegal State Exception");
    }

    LinkedBoxNode lbn = new LinkedBoxNode(newBox);
    LinkedBoxNode currentNode;
    LinkedBoxNode previousNode;

    this.size++;

    if (head == null) {
      head = lbn;
    } else if (lbn.getBox().getWeight() > head.getBox().getWeight()) {
      lbn.setNext(head);
      head = lbn;
    } else {
      currentNode = head.getNext();
      previousNode = head;
      while (currentNode != null) {
        if (lbn.getBox().getWeight() > currentNode.getBox().getWeight()) {
          previousNode.setNext(lbn);
          lbn.setNext(currentNode);
          return;
        }
        previousNode = currentNode;
        currentNode = currentNode.getNext();
      }

      previousNode.setNext(lbn);
      lbn.setNext(null);

    }


  }

  // Checks if this list contains a box that matches with (equals) a specific box object
  // Returns true if this list contains findBox, false otherwise
  public boolean contains(Box findBox) {

    boolean ifContains = false;
    LinkedBoxNode runner = this.head;
    while (runner.getNext() != null) {
      if (runner.getBox() == findBox) {
        ifContains = true;
      }
      runner = runner.getNext();
    }

    return ifContains;
  }

  // Returns a box stored in this list given its index
  // Throws IndexOutOfBoundsException if index is out of the range 0..size-1
  public Box get(int index) throws IndexOutOfBoundsException {

    LinkedBoxNode runner = this.head;
    if (index >= this.size || index < 0) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
    }

    for (int i = 0; i < index; i++) {
      runner = runner.getNext();
    }

    return runner.getBox();

  }

  // Removes and returns the box stored at index from this LinkedBoxList
  // Throws IndexOutOfBoundsException if index is out of bounds. index should be in
  // the range of [0.. size()-1]
  public Box remove(int index) throws IndexOutOfBoundsException {

    if (index >= this.size) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
    }

    LinkedBoxNode runner = this.head;
    for (int i = 0; i < index; i++) {
      runner = runner.getNext();
    }

    Box box = runner.getBox();

    LinkedBoxNode previous = this.head;

    for (int i = 0; i < index - 1; i++) {
      previous = previous.getNext();
    }

    previous.setNext(runner.getNext());

    return box;

  }

  // Removes all the boxes from this list
  public void clear() {
    this.head = null;
    this.size = 0;
  }

  // Returns a String representation of the state and content of this LinkedBoxList
  // An example of source code for this method is provided you in the next paragraph
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();

  }

}
