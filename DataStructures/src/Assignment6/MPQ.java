package Assignment6;
import java.util.*;


/**
 *
 * This file contains the student built version of the priority queue
 * that is built based upon a linked list myq.
 *
 *
 * With a linked list, insert takes O(n) worst case while extractmin
 * takes constant time because the min value is always the first node
 * since the list is always sorted.
 *
 *
 * Answers to the non coding questions will be in the PriorityQueueTest.java
 * file header.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


public class MPQ<T extends Comparable<T>>{
    // data variable
    LinkedList<T> myq;
    // constructor
    MPQ(){myq = new LinkedList<T>();}
    // other methods
    public void insert(T key){
        int index = 0;
        ListIterator<T> iter = myq.listIterator(0);
        while (iter.hasNext() && iter.next().compareTo(key)<0){
            index++;
        }
        myq.add(index,key);
    }
    public T extractMin(){
        // to be completed
        if (!myq.isEmpty()){
            T min = myq.removeFirst();
            return min;
        }
        else{
            return null;
        }
    }

    public boolean isEmpty(){
        return myq.isEmpty();
    }
}
