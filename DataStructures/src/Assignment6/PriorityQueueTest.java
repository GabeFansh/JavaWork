package Assignment6;


/**
 * Pace University
 *  Fall 2022
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team authors: Gabriel Fanshteyn
 *  External Collaborators: None
 *  References: None
 *
 *  Assignment: Assignment 6
 *  Problem: My Priority Queue
 *  Description: The purpose of this assignment is to evaluate the time performance of
 * these two implementations of Priority Queue.
 *
 *
 *  Input: 100,1000,10000,100000,1000000
 *  Output:
 *
 *  Visible data fields:
 *  value
 *  apiStartTime
 *  apiEndTime
 *  apiDeltTime
 *  myStartTime
 *  myEndTime
 *  myDeltTime
 *  numValues
 *
 *
 *  Visible methods:
 *  add
 *  remove
 *  insert
 *  extractmin
 *
 *
 *
 *
 *  3.
 *                              |   100   |  1000    |    10000  |   60000     |  80000    |
 *    JAVA API PRIORITY QUEUE   |  719300 | 5448299  |  15360200 | 47280600    | 66663400    |
 *        MY PRIORITY QUEUE     | 1868400 | 12430100 | 364923401 | 24798673800 | 40183123500 |
 *
 *
 * 4. For the Java Api priority queue, the big O run time I expected was O(nlog(n)) for both because for each integer n
 * that is being added to the binary heap that was created, it shifts the other values of N in order to keep the heap sorted
 * which takes log(n) since it the add method in the priorityqueue.java class contains a method called siftup, which moves a
 * smaller value up the tree until it is placed under a node that it is smaller than.
 *
 *    For the priority queue that I had created, the big O run time would be O(n^2) for add because for n integers, each
 * has to compare with the current node on the linked list, if it is smaller than the current node, the number gets added
 * into the linked list at that point and everything else gets shifted to the right by one value. When extracting the minimum
 * value, it would always be the first node, so extractMin would be O(1) because you would always be removing the first node
 * and not have to search the entire list.
 *
 *
 *
 * 5. I believe that my measurements for each queue are consistent with my previous answer. For the API queue, it starts off
 * fast, taking a more linear time as the numbers increase, with 100 numbers taking 719300 nanoseconds and 1000 numbers taking
 * 5448299 nanoseconds the more numbers it has. When it gets to about 80000 numbers, it takes 66663400 which roughly matches the shape
 * of nlog(n).
 *
 *    For my priority queue, the more numbers are added to the linked list, the more time it takes to add and remove all of them,
 * at an exponentional rate. When moving from 100 to 1000 numbers, 10x increase, the time change in the time in smaller than when
 * there is already a lot of numbers such as 10000 with a time of 364923401 nanoseconds and the amount of numbers is increased by 6x
 * to get a speed of 24798673800 nanoseconds for 600000 numbers.
 *
 *
 *
 */






import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> apiPriorityQueue = new PriorityQueue<>();
        MPQ<Integer> myPriorityQueue = new MPQ<>();
        Random rand = new Random();


        int numValues = 80000;

        long apiTimeStart = System.nanoTime();
        for (int i = 0; i < numValues; i++){
            int value = rand.nextInt(numValues);
            apiPriorityQueue.add(value);
        }
        while(!apiPriorityQueue.isEmpty()){
            apiPriorityQueue.remove();
        }
        long apiTimeEnd = System.nanoTime();

        long apiDeltTime = apiTimeEnd - apiTimeStart;

        System.out.println("API PRIORITY QUEUE TIME: " + apiDeltTime);


        long myTimeStart = System.nanoTime();
        for (int i = 0; i < numValues; i++){
            int value = rand.nextInt(numValues);
            myPriorityQueue.insert(value);
        }
        while(!myPriorityQueue.isEmpty()){
            myPriorityQueue.extractMin();
        }
        long myTimeEnd = System.nanoTime();

        long myDeltTime = myTimeEnd - myTimeStart;

        System.out.println("MY PRIORITY QUEUE TIME: " + myDeltTime);







    }

}
