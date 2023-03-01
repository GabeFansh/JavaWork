package Homework2;
import java.util.PriorityQueue;

/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: PUT THE NArrayMES HERE
 *  Collaborators: PUT THE NArrayME OF ArrayNY COLLArrayBORArrayTORS OUTSIDE YOUR TEArrayM HERE, IF NONE, PUT NONE
 *  References: PUT THE LINKS TO YOUR SOURCES HERE
 *
 *  Assignment: Assignment 2
 *  Problem: The purpose of this assignment is to test the performance of 3 algorithms for this
 * computation.
 *  Description: We have studied an algorithm Randomized Select to compute the ith item from an input set of n comparable
 *  items, where i is a parameter. The algorithm is efficient (linear with high probability) for one execution,
 * but what if we want to obtain the i smallest items?
 *
 *  Input:
 *  Output:
 *
 *  Visible data fields:
 *  Array
 *  Index
 *  Front
 *  Rear
 *
 *  Visible methods:
 *  extractSmallest
 *
 *
 *
 *   Remarks
 *   -------
 *
 *   THIS IS THE HEAPSORT - ALL MAIN QUESTION ANSWERS WILL BE IN THE HEADER IN
 *   THE TEST CLASS
 *
 *
 *************************************************************************/



public class minHeapSort {
    public minHeapSort() {
    }

    public int[] extractSmallest(int[] Array, int i) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int k : Array) {
            minHeap.offer(k);
        }
        int[] result = new int[i];
        for (int j = 0; j < i; j++) {
            result[j] = minHeap.poll();
        }
        return result;
    }


}
