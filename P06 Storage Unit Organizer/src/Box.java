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

import java.util.*;

public class Box implements Comparable<Box> {

  private static Random randGen = new Random(); // generator of random numbers
  private int color; // color of this box
  private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

  // Creates a new Box and initializes its instance fields color and weight to
  // random values
  public Box() {
    this.weight = randGen.nextInt(31)+1;
    this.color = randGen.nextInt();
    
    }

  // Creates a new Box and initializes its instance fields color and weight to the
  // specified values
  // Throws IllegalArgumentException if the provided weight value is out of the
  // range of [1..30]
  public Box(int color, int weight) {
    if (weight > 31 || weight < 1) {
      throw new IllegalArgumentException("Weight is not between 1 and 31!");
    }
    else {
      this.color = color;
      this.weight = weight;
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Box) {
      int weight = ((Box) other).getWeight();
      int color = ((Box) other).getColor();
      if(this.weight == weight && this.color == color) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
    
  } // equals method defined in Object class

  @Override
  public int compareTo(Box otherBox) {
    if (this.weight < otherBox.weight) {
      return -1;
    }
    if (this.weight == otherBox.weight) {
      return 0;
    }
    if (this.weight > otherBox.weight) {
      return 1;
    }
   return 0;
  } // compareTo method defined in Comparable<Box>
    // interface

  public int getColor() {
    return this.color;
  } // Getter for the instance field color of this box

  public int getWeight() {
    return this.weight;
  } // Getter for the instance field weight of this box


}
