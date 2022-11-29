package Assignment5;

import java.util.Random;


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
 *  Assignment: Assignment 4
 *  Problem: QuickSort and InsertionSort
 *  Description: Test the run time of different variations of sorting and compare them.
 *
 *
 *
 *
 *  Input: n = 10000
 *  Output:
 *
 *  Visible data fields:
 *  itemCount
 *  array
 *  insertionStart
 *  insertionEnd
 *  insertionDelta
 *  quick1Start
 *  quick1End
 *  quick1Delta
 *  quick2Start
 *  quick2End
 *  quick2Delta
 *
 *
 *  Visible methods:
 *  insertionSort()
 *  quickSort()
 *  randomQuickSort()
 *  partition()
 *  randomPartition()
 *
 *                    | increasing order | decreasing order | random   |
 *    insertionSort   |   698900         |   36340600       | 30682500 |
 *    quickSort       |   42349000       |   35034900       | 64521100 |
 *    randomQuickSort |   9773400        |  10310700        | 12152300 |
 *
 *
 *
 * 4. Draw conclusions from the values observed. Are the measurements significantly different for some cases?
 *    Why? How the pivot choice helps for those cases where the running time is smaller?
 *
 *    One noticeable thing is how when the array is listed with numbers in increasing order, normal quick sort takes
 *    the longest. I believe the reason for that is because the partiton ends up for every value in the array since it's checking
 *    for a number that is less than the current one.
 *
 *    I was surprised to see that the random pivot quick sort was faster than the normal quick sort, especially when the numbers
 *    in the array are listed at random. I believe that the reason for this is the possibility that the sub array that was made
 *    from the pivot point could be mostly sorted already, which because it is random, could be a possibility. With decreasing order,
 *    insertion sort and normal quick sort were relatively the same because the process of creating a new pivot for the quick sort
 *    seems like its similar to insertion when the numbers are already in order decreasing.
 *
 *
 */

public class sortTest {
    public static void main(String[] args) {
        Random rand1 = new Random();
        int itemCount = 10000;

        int[] array = new int[itemCount];

        for (int i = 0; i < array.length; i++){
            array[i] = rand1.nextInt(itemCount);
        }


        long insertionStart = System.nanoTime();
        insertionSort(array);
        long insertionEnd = System.nanoTime();


        long quick1Start = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long quick1End = System.nanoTime();

        long quick2Start = System.nanoTime();
        randomQuickSort(array, 0, array.length - 1);
        long quick2End = System.nanoTime();

        long insertionDelta = insertionEnd - insertionStart;
        long quick1Delta = quick1End - quick1Start;
        long quick2Delta = quick2End - quick2Start;

        System.out.println("Insertion: " + insertionDelta + "\n" +
                "Quick Sort: " + quick1Delta + "\n" +
                "Random Quick Sort: " + quick2Delta);




    }



    public static void insertionSort(int[] a){
        for (int j=1; j < a.length; j++){
            int key = a[j];
            int i = j - 1;
            while (i > 0 && a[i] > key){
                a[i+1] = a[i];
                i = i-1;
            }
            a[i+1] = key;
        }


    }

    public static void quickSort(int[] a, int p, int r){
        if (p < r){
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    public static void randomQuickSort(int[] a, int p, int r){
        if (p < r){
            int q = randomPartition(a, p, r);
            randomQuickSort(a, p, q-1);
            randomQuickSort(a, q+1, r);
        }
    }


    public static int partition(int[] a, int p, int r){
        int x = a[r];
        int i = p - 1;
        for (int j = p;j < r; j++) {
            if (a[j] <= x) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }
        }
        int temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }

    public static int randomPartition(int[] a, int p, int r){

        Random rand = new Random();
        int piv = rand.nextInt(r - p) + p;
        int temp1 = a[piv];
        a[piv] = a[r];
        a[r] = temp1;


        int x = a[r];
        int i = p - 1;
        for (int j = p;j < r; j++) {
            if (a[j] <= x) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }
        }
        int temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }






}

