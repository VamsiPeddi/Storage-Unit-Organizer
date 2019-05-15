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
public class StorageUnitTests {

  // Checks whether the behavior of equals method is correct
  public static boolean testBoxEquals() {
    boolean testPassed = true;

    Box box = new Box(12, 6);
    Box box2 = new Box(12, 6);

    if (!box.equals(box2)) {
      testPassed = false;
    }

    return testPassed;
  }

  // Checks whether the behavior of compareTo method is correctly implemented
  public static boolean testBoxCompareTo() {
    boolean testPassed = true;

    Box box = new Box();
    Box otherBox = new Box();

    int weight = box.getWeight();
    int weight1 = otherBox.getWeight();

    if (weight1 < weight) {
      int a = box.compareTo(otherBox);
      if (a != -1) {
        testPassed = false;
      }
    }
    if (weight1 > weight) {
      int a = box.compareTo(otherBox);
      if (a != 1) {
        testPassed = false;
      }
    }
    if (weight1 == weight) {
      int a = box.compareTo(otherBox);
      if (a != 0) {
        testPassed = false;
      }
    }

    return testPassed;

  }

  public static boolean testLinkedBoxNode() {

    boolean testPassed = true;
    Box box = new Box();
    LinkedBoxNode next = new LinkedBoxNode(box);
    next = next.getNext();
    if (next != null) {
      testPassed = false;
    }

    return testPassed;
  }

  // Checks whether add method defined in your LinkedBoxList works correctly
  public static boolean testLinkedBoxListAdd() {

    boolean testPassed = true;
    Box newBox = new Box(12, 6);
    Box newBox1 = new Box(14, 8);
    Box newBox2 = new Box(12, 9);

    LinkedBoxList lbl = new LinkedBoxList(10);
    lbl.add(newBox);
    lbl.add(newBox1);
    lbl.add(newBox2);

    if (lbl.get(1) != newBox1) {
      testPassed = false;
    }

    return testPassed;
  }

  // Checks whether remove method defined in your LinkedBoxList works correctly
  public static boolean testLinkedBoxListRemove() {

    boolean testPassed = true;
    Box newBox = new Box(12, 6);
    Box newBox1 = new Box(14, 8);
    Box newBox2 = new Box(12, 9);

    LinkedBoxList lbl = new LinkedBoxList(10);
    lbl.add(newBox);
    lbl.add(newBox1);
    lbl.add(newBox2);
    lbl.remove(1);
    if (lbl.get(1) != newBox2) {
      testPassed = false;
    }

    return testPassed;
  }

}
