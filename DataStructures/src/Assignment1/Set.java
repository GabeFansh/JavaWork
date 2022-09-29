package Assignment1;
/*************************************************************************
 *
 *  Pace University
 *  Fall 2022
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team authors: PUT THE NAMES OF ALL YOUR TEAM MEMBERS HERE
 *  External Collaborators: PUT THE NAME OF ANY COLLABORATORS OUTSIDE YOUR TEAM HERE, IF NONE, PUT NONE
 *  References: PUT THE LINKS TO YOUR SOURCES HERE
 *
 *  Assignment: Assignment 1
 *  Problem: Creating a Set
 *  Description: Create a Set of generic type using class ArrayList(T)
 *
 *  Input:
 *  Output:
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
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
 *            add|           |            |
 *         remove|           |            |
 *     membership|           |            |
 *       toString|           |            |
 *
 *
 *  4. Explain each of the eight running times in the table applying the
 *  rules of counting seen in class, and for the method calls, if we have
 *  covered them already, directly refer to the running times of those methods.
 *
 *
 *
 *************************************************************************/

import java.util.*;

public class Set<T>{
    //data fields
    private ArrayList<T> myList;
    String returnList = "";

    // constructors
    Set(){
        myList = new ArrayList<T>();
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
        returnList = "";
        myList.forEach((n) -> returnList = returnList + n + "\n");
        return returnList;
    }
}
