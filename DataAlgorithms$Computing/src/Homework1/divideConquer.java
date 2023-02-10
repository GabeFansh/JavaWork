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
 *  high
 *  low
 *  a[]
 *  leftsum
 *  rightsum
 *  sum
 *
 *  Visible methods:
 *  addArray
 *  deleteArray
 *  toString
 *  maxSubarraySum
 *  maxCrossingSubarray
 *
 *
 *   Remarks
 *   -------
 *
 *   This FILE is the divide & conquer algorithm. For organization, it is not located within the main class.
 *
 *
 *************************************************************************/





import java.util.Arrays;

public class divideConquer {

    public int[] array;

    public divideConquer() {
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

    public String toString() {
        return "divideConquer{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public int maxSubarraySum(int[] A, int low, int high) {
        if (high == low) {
            return A[low];
        } else {
            int mid = (low + high) / 2;
            int leftSum = maxSubarraySum(A, low, mid);
            int rightSum = maxSubarraySum(A, mid + 1, high);
            int crossSum = maxCrossingSubarray(A, low, mid, high);
            return Math.max(Math.max(leftSum, rightSum), crossSum);
        }
    }

    private int maxCrossingSubarray(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += A[j];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }





}
