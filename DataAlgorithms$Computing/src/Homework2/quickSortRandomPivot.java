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
 *  quickSortSmallest
 *  quickSort
 *  randomizedParition
 *  partition
 *  swap
 *
 *
 *   Remarks
 *   -------
 *
 *   THIS IS THE QUICKSORT WITH RANDOM PIVOT CLASS - ALL MAIN QUESTION ANSWERS WILL BE IN THE HEADER IN
 *   THE TEST CLASS
 *
 *
 *************************************************************************/
public class quickSortRandomPivot {
    public quickSortRandomPivot() {

    }

    Random rand = new Random();

    public int[] quickSortSmallest(int[] arr, int i) {
        quickSort(arr, 0, arr.length - 1, i);
        return Arrays.copyOf(arr, i);
    }

    public void quickSort(int[] arr, int left, int right, int i) {
        if (left < right) {
            int pivotIndex = randomizedPartition(arr, left, right);
            int k = pivotIndex - left + 1;
            if (i == k) {
                return;
            } else if (i < k) {
                quickSort(arr, left, pivotIndex - 1, i);
            } else {
                quickSort(arr, left, pivotIndex - 1, k);
                quickSort(arr, pivotIndex + 1, right, i - k);
            }
        }
    }

    private int randomizedPartition(int[] arr, int left, int right) {
        int randomIndex = rand.nextInt(right - left + 1) + left;
        swap(arr, randomIndex, right);
        return partition(arr, left, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
