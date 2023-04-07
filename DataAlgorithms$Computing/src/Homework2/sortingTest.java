package Homework2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

//5;
//(int) Math.log(n);
//Math.sqrt(n);
//n/3;

/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: Gabriel Fanshteyn
 *  Collaborators: NONE
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
 *  randomSort
 *  quickSort
 *  heapSort
 *
 *  Visible methods:
 *
 *
 *
 *   Remarks
 *   -------
 *
 *   1. The run time for the quickSort method would be O(nlogn) because the code goes through the array from both sides
 *   towards a pivot. A pivot is randomly chosen from within the array, with the parition method. there is a possibility
 *   for the partition to be either the lowest or largest number.
 *   Random selection is calling to itself recursively as it goes through each of the numbers until it finds i smallest numbers
 *   so it runs in O(n)
 *   The run time for a minheap sort is O(n + ilogn). Building a heap is done in linear time, while finding i minimum items
 *   requires multiple calls for extractmin which runs in logn.
 *
 *
 *   Quicksort runs in T(n) = T(n/2) + O(n). I is the amount of items after the pivot and n is the amount of items in the list
 *   since the recurrence occurs within both sides of the pivot. Because the partition is chosen at random, it shortens the amount of unbalanced
 *   partitions so the run time is slightly different then quicksort.
 *
 *   Random selection runs T(n) = T(i) + T(n) + O(n) because we can either find the smallest numbers right away or we recursive call
 *   to a pivot of i and check each side of the pivot. It is similar to quick sort where there is a pivot item in the starting array but
 *   it's goal isn't to sort the items its to select the items from any point within the arrays
 *
 *   Min heap runs in T(n) = O(n) + T(n-1) * O(logn). In min heap sort, the elements are put into a min heap which takes O(n) time. The
 *   root element is extracted and placed at the end of the array. Heapify takes O(logn) in worst case since it is going through the heap.
 *   A heap has n elements.
 *
 *
 * 4.
 * *
 * *   		iQS		|     10^2      |    10^3     |    10^4     |    10^5     |    10^6
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = 5  		|    23200     |   105000    |   396400  |  2539300   | 16403200
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = lgn 	|    36700     |   93200    |   673400   |   6124300  | 12637300
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = root n	|     24700    |   869700   |  984300    |  5332100   | 21758000
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = n/3 	|   53900      |  900600    |  2853400   | 20813700   | 66151800
 * *
 * *
 * *
 * *   		iMH		|     10^2      |    10^3     |    10^4     |    10^5     |    10^6
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = 5  		|    465700    |    1431800  |   2827700   |  16251200   | 41145500
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = lgn 	|   1088600     |   1278200   |   2363900   |   13332400  | 63245000
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = root n	|   499200     |   1271800   |  2575400    |   19288300  | 56170500
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = n/3 	|   947400     |   2069300   |  16794400   |  47048900   | 340788800
 * *
 * *
 * *
 * *   		iRS		|     10^2      |    10^3     |    10^4     |    10^5     |    10^6
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = 5  		|    130200     |   156100    |   551200    |   4783800   | 9747900
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = lgn 	|     272600    |    189300   |   488600    |  14548100    | 12083300
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = root n	|   152700      |   414800    |    889700  |   7616100   | 13885200
 * *   ----------------------------------------------------------------------------------------------------------------
 * *   	i = n/3 	|   141600      |    325700   |  1324700   |   9321600   | 18876300
 * *
 * ```
 *
 *      5. Between all of the different algorithms, when comparing the runtimes for finding i smallest items
 *      for each, the runtime between different values of i does not largely change. This is also something that
 *      is kept when increasing the amount of n numbers in the array. While the run times do increase the more n numbers
 *      in the array, the run time does not change between the different i values.
 *
 *      Quick Sort runtimes show that it runs in a more logmirthmic way where it increases up to a point where once you reach a certain amount
 *      of n integers, the run time for the algorithm does not change as much compared to a slightly smaller value of n.
 *
 *      Random Selection runs in a more linear way so there would constantly so proportionally the value of n would also increase the run time
 *      for the algorithm. Since the partitions are mostly balanced when the algorithm runs, it doesn't do any extra recurrsive calls then
 *      it needs to.
 *
 *      Min heap runs logerithmically, similar to quick sort. However, since min heap also has to move items towards the end of the array as each
 *      new item is entered, it slows down the run time the larger the value of n is. the run time increases more the more n is because of
 *      the amount of new items have to be added to the heap before the heapify method is called.
 *
 *************************************************************************/


public class sortingTest {
    public static void main(String[] args) {

        Random rand = new Random();
        randomSelect randomSort = new randomSelect();
        quickSortRandomPivot quickSort = new quickSortRandomPivot();
        minHeapSort heapSort = new minHeapSort();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a value of numbers: ");
        int n = scan.nextInt();
        System.out.println("Enter a value of index: ");
        int i = scan.nextInt();

        int[][] arrays = generateRandomArrays(n, 10000000);


        long startTime1 = System.nanoTime();
        int[] mins1 = randomSort.randomSelectMins(arrays[0], i);
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        int[] mins2 = quickSort.quickSortSmallest(arrays[1], i);
        long endTime2 = System.nanoTime();

        long startTime3 = System.nanoTime();
        int[] mins3 = heapSort.extractSmallest(arrays[2], i);
        long endTime3 = System.nanoTime();

        long deltaTime1 = endTime1 - startTime1;
        long deltaTime2 = endTime2 - startTime2;
        long deltaTime3 = endTime3 - startTime3;
        System.out.println("Random Selection RunTime: " + deltaTime1);
        System.out.println("Quick Sort RunTime: " + deltaTime2);
        System.out.println("Heap Sort RunTime: " + deltaTime3);


    }

    public static int[][] generateRandomArrays(int n, int max) {
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = max - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int[][] arrays = new int[3][n];
        for (int i = 0; i < n; i++) {
            arrays[0][i] = nums[i];
            arrays[1][i] = nums[i + n];
            arrays[2][i] = nums[i + 2 * n];
        }
        return arrays;
    }
}
