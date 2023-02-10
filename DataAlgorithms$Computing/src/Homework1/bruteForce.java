package Homework1;

import java.util.Arrays;

/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: Gabriel Fanshteyn
 *  Collaborators: None
 *  References: N/A
 *
 *  Assignment: Homework 1
 *  Problem: Maximum Sub-arry problem
 *  Description: Inplement 2 programs and measure the running time of each program for n number of items
 *
 *  Input:
 *  Output:
 *
 *  Visible data fields:
 *  array
 *  returnarray
 *  sum
 *  Smax
 *
 *  Visible methods:
 *  addArray
 *  maxSubarraySum
 *  deleteArray
 *  toString
 *
 *
 *   Remarks
 *   -------
 *
 *   This FILE is the brute force algorithm. For organization, it is not located within the main class.
 *
 *
 *************************************************************************/



public class bruteForce {

    public int[] array;

    public bruteForce() {
        this.array = null;
    }

    public int[] addArray(int[] array) {
        this.array = array;
        return this.array;
    }

    public int[] deleteArray() {
       int[] returnArray = this.array;
       this.array = null;
       return returnArray;
    }


    public int maxSubarraySum(int[] A) {
        int Smax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                Smax = Math.max(Smax, sum);
            }
        }
        return Smax;
    }



    public String toString() {
        return "bruteForce{" +
                "array=" + Arrays.toString(array) +
                '}';
    }



}
