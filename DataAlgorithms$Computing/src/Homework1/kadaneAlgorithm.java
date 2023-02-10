package Homework1;
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
 *  maxendinghere
 *  maxsofar
 *
 *  Visible methods:
 *  addArray
 *  KadaneAlgorithm
 *  deleteArray
 *  toString
 *
 *
 *   Remarks
 *   -------
 *
 *   This FILE is the Kadane algorithm. For organization, it is not located within the main class.
 *
 *
 *************************************************************************/


import java.util.Arrays;

public class kadaneAlgorithm {

    public int[] array;

    public kadaneAlgorithm() {
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


    public int kadaneAlgorithm(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }





    @Override
    public String toString() {
        return "kadaneAlgorithm{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
