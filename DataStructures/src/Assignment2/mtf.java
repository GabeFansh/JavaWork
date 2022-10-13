package Assignment2;
/*************************************************************************
*
*  Pace University
*  Fall 2021
*  Data Structures and Algorithms
*
*  Course: CS 241
*  Team Authors: Gabriel Fanshteyn
*  External Collaborators: none
*  References: Java books
*
*  Assignment: 2
*  Problem: MTF
*  Description: a stack without repetitions
*
*  Input:
*  Output:
*
*  Visible data fields:
*  none
*
*  Visible methods:
public void push(T item){
public T pop(){return myData.remove();}
public boolean contains(T item){return myData.contains(item);}
public boolean isEmpty(){return myData.isEmpty();}
public String toString(){return myData.toString();}
public static void main(String[] args){
*
*   Remarks
*   -------
*
*  3. Fill the following table with the big-O running times of
 *   each of the methods implemented, as well as the running times for the
 *  same methods if they were implemented with LinkedList instead. (No
 *  need to explain here, only the big-O expression.)
 *
 *               | Linked List | Array List |
 *           push|    O(n)     |    O(n)    |
 *            pop|    O(1)     |    O(n)    |
 *       contains|    O(n)     |    O(n)    |
 *        isEmpty|    O(1)     |    O(1)    |
 *       toString|    O(n)     |    O(n)    |
*
 *
 *
 * 4. Explain each of the running times in the table applying the
 * rules of counting seen in class, and for the method calls, if we have
 * covered them already, directly refer to the running times of those methods.
 *
 *  Push for mtf is O(n) as it has to go through the whole stack and the add.
 *  Push for arrayList is o(n) because it has to go through the whole array and remove first occurence
 *  and then add number to the top.
 *
 *  Pop is O(1) as it only removes the top item in the stack
 *  Pop is O(n) as worst case it has to go through each index to reach the last filled and remove it
 *
 *  Contains is O(n) for both linked list and array list as it goes through the entire stack to check for contains
 *
 *  isEmpty is O(1) for both linked list and array list as it only has to check for one index to see if empty
 *
 *  toString is O(n) for linked list as it has to iterate through every item to add to a string and print.
 *  toString is O(n) as it takes every index data and adds to a string and prints it out.
 *
 *
*
*************************************************************************/
import java.util.*;
public class mtf<T>{
    // left of the list is top of the mtf
    private LinkedList<T> myData = new LinkedList<T>();
    // push removing previous occurrences of item
    public void push(T item){
        myData.remove(item);
        myData.add(item);
    }
    // pop
    public T pop(){
        return myData.remove();
    }
    // contains
    public boolean contains(T item){
        return myData.contains(item);
    }
    // isEmpty
    public boolean isEmpty(){
        return myData.isEmpty();
    }
    // toString
    public String toString(){
        return myData.toString();
    }
    // test

}
