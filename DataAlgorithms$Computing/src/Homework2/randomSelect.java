package Homework2;


import java.util.Arrays;
import java.util.Random;

/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: Gabriel Fanshteyn
 *  Collaborators: None
 *  References: None
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
 *  randomizedParition
 *  randomizedSelect
 *  partition
 *
 *
 *   Remarks
 *   -------
 *
 *   THIS IS THE RandomSelection Sort CLASS WITH RANDOM PARTITION - ALL MAIN QUESTION ANSWERS WILL BE IN THE HEADER IN
 *   THE TEST CLASS
 *
 *
 *************************************************************************/

public class randomSelect {
    public randomSelect() {

    }


    public int[] randomSelectMins(int[] Array, int i){
        randomizedSelect(Array, 0, Array.length - 1, i);
        return Arrays.copyOf(Array, i);
    }



    public int randomizedSelect(int[] Array, int front, int rear, int index) {
        if (front == rear) {
            return Array[front];
        }
        int randomPartition = randomizedPartition(Array, front, rear);
        int k = randomPartition - front + 1;
        if (index == k) {
            return Array[randomPartition];
        } else if (index < k) {
            return randomizedSelect(Array, front, randomPartition - 1, index);
        } else {
            return randomizedSelect(Array, randomPartition + 1, rear, index - k);
        }
    }

    public int randomizedPartition(int[] Array, int front, int rear) {
        Random rand = new Random();
        int index = rand.nextInt(rear - front + 1) + front;
        int temp = Array[rear];
        Array[rear] = Array[index];
        Array[index] = temp;
        return partition(Array, front, rear);
    }

    public int partition(int[] Array, int front, int rear) {
        int x = Array[rear];
        int index = front - 1;
        for (int j = front; j < rear; j++) {
            if (Array[j] <= x) {
                index++;
                int temp = Array[index];
                Array[index] = Array[j];
                Array[j] = temp;
            }
        }
        int temp = Array[index + 1];
        Array[index + 1] = Array[rear];
        Array[rear] = temp;
        return index + 1;
    }

}
