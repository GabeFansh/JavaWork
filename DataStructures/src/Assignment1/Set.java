package Assignment1;
/*************************************************************************
 *
 *  Pace University
 *  Fall 2022
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team authors: Gabriel Fanshteyn
 *  External Collaborators: None
 *  References: None
 *
 *  Assignment: Assignment 1
 *  Problem: Creating a Set
 *  Description: Create a Set of generic type using class ArrayList(T)
 *
 *  Input: 10 10 10 12 11
 *  Output: 10 12 11, 10 12, true
 *
 *  Visible data fields:
 *  arrayList
 *
 *  Visible methods:
 *  add
 *  remove
 *  membership
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   3. Fill the following table with the big-O running times of
 * each of the methods implemented, as well as the running times for the
 * same methods if they were implemented with LinkedList instead. (No
 * need to explain here, only the big-O expression.)
 *
 *               |Array List | Linked List|
 *            add|   O(n)    |     O(n)   |
 *         remove|   O(n)    |     O(n)   |
 *     membership|   O(n)    |     O(n)   |
 *       toString|   O(n)    |     O(n)   |
 *
 *
 *  4. Explain each of the eight running times in the table applying the
 *  rules of counting seen in class, and for the method calls, if we have
 *  covered them already, directly refer to the running times of those methods.
 *
 *  Add:
 *  Worst case of add in array list is O(n) because it is an if statement so we are
 *  checking the worst case of the condition for the if and the action if the condition is satisfied.
 *  arrayList.contains() has a worst case of O(n) and add for an arrayList has worst case O(n) so together
 *  the run time is O(n).
 *
 *  Worst case for add in Linked list is O(n) as well because contains will also run through the entire linked list; while
 *  add for linked list is O(1), together the run time is still O(n).
 *
 *  Remove:
 *  The remove method for array list has to go through every item in the list so worst case run time for remove is O(n)
 *
 *  The remove method for linked list has to check the value of each node in the list so worst case run time for remove is O(n)
 *
 *  Membership:
 *  Membership method calls for the contains method on an arrayList object which checks for each item in the list and returns
 *  true or false if it finds the item that is in the parameter. Because it checks for every item, the worst case run time is O(n)
 *
 *  Membership calls the contains method on a linked list which checks for every item in the list and will return true or false when
 *  it finds the value it was searching for. Since it checks every item, it has a worst case run time of O(n)
 *
 *  toString:
 *  ToString calls for the for each method in a array list and will go through each item and add its data into an empty string.
 *  Because it goes through each item in the list, the worst case run time is O(n)
 *
 *  ToString for a link list will run a while loop until temp.next returns null, and add each nodes value and return each nodes value
 *  one by one, done in a worst case run time of O(n)
 *
 *
 *************************************************************************/

import java.util.*;

public class Set<T>{
    //data fields
    private ArrayList<T> myList;


    // constructors
    Set(){
        myList = new ArrayList<>();
    }
    // other methods
    public void add(T item){
        // CODE HERE
        if (!myList.contains(item)){
            myList.add(item);
        }


    }
    public void remove(T item){
        myList.remove(item);
    }
    public Boolean membership(T item){
        // CODE HERE
        return myList.contains(item);
    }
    public String toString(){
        StringBuilder returnList = new StringBuilder();
        myList.forEach((n) -> returnList.append((returnList.length() > 0 ? " ": "") + n));
        return returnList.toString();
    }
}
