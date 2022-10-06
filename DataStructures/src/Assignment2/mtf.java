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
 *               |Linked List | Array List|
 *           push|           |            |
 *            pop|           |            |
 *       contains|           |            |
 *        isEmpty|           |            |
 *       toString|           |            |
*
 *
 *
 * 4. Explain each of the eight running times in the table applying the
 * rules of counting seen in class, and for the method calls, if we have
 * covered them already, directly refer to the running times of those methods.
 *
 *
 *
*
*************************************************************************/

import java.util.*;
public class mtf<T>{
    // left of the list is top of the mtf
    private LinkedList<T> myData = new LinkedList<T>();
    // push removing previous occurrences of item
    // O(n) because remove(item) is O(n) and add() is O(1) in LL
    public void push(T item){
        myData.remove(item);
        myData.add(item);
    }
    // pop
    // O(1) because remove() is O(1) in LL
    public T pop(){return myData.remove();}
    // contains
    // O(n) because contains() is O(n) in LL
    public boolean contains(T item){return myData.contains(item);}
    // isEmpty
    // O(1) because isEmpty() is O(1) in LL
    public boolean isEmpty(){return myData.isEmpty();}
    // toString
    // O(n) because toString is O(n) in LL
    public String toString(){return myData.toString();}
    // test

}
