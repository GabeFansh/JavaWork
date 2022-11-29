package Assignment3;


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
 *  Assignment: Assignment 3
 *  Problem: Binary Search Tree
 *  Description: Find the run time when running a binary search on
 *  a skewed tree versus a balanced tree
 *
 *  Input: 100,1000,5000,8000,10000
 *  Output: 25400   |  135200  |    808900    |     820300     |  1008600
 *
 *  Visible data fields:
 *  BinarySearchTree<Integer> balancedTree
 *  BinarySearchTree<Integer> skewedTree
 *  skewStartTime
 *  skewEndTime
 *  skewDeltaTime
 *  balStartTime
 *  balEndTime
 *  balDeltaTime
 *
 *
 *  Visible methods:
 *  contains()
 *  skewedTreeInsert()
 *  seq()
 *
 *
 * 1.
 *      Big-O running times:
 *            | Skewed Tree | Binary Tree |
 *      Search|     O(n)    |   O(log(n)) |
 *
 * 2. Using the binary search tree class, the method of contains() will check through each item in the skewed tree to
 *    see if n is in the tree. A skewed tree has to check every item in the list so it will take O(n).
 *
 *    Using the binary search tree class, the method contains will check through each item in the balanced tree. Because
 *    the balanced tree is split between the smallest and largest values, it will not have to check each item in the list
 *    so it will check in log(n).
 *
 * 4.
 *    | Search     |  n = 10^2 | n = 10^3 | n = 5 * 10^3 |   n = 8 * 10^3 |  n = 10^4 |
 *    | Skewed BST |   25400   |  135200  |    808900    |     820300     |  1008600  |
 *
 *
 * 5.
 *    My obeserved run times do match my prediction of O(n) for the skewed tree because whenever the search amount was increased by
 *    a factor of 10, the time it takes to run through the whole list also increased by around a factor of 10. When n is 100, the runtime
 *    is 2.5 * 10^4; when n is 1000, the runtime is 1.352 * 10^5 which is a rough increase by a factor of 10 from the previous test.
 *
 * 7.
 *    | Search       |  n = 10^2 | n = 10^3 |  n = 10^4 | n = 10^5 | n = 10^6 |
 *    | Balanced BST |   1800    |  19000   |  26800   |   15600  |   18300   |
 *
 * 8.
 *    My observed run times match the prediction of log(n) because early one, once the amount of items increases, the speed
 *    slows down until at a certain point it eventually plataues into a runtime average speed the more items are eventually added.
 *    When n is 100 run time is 1800 nanoseconds, when n is 1000 runtime is 19000 nanoseconds, but when it reaches n = 1000000, the
 *    runtime is still the same as when n was 1000.
 *
 *
 *
 *
 *
 *
 */

public class BSTTest {
    public static void main(String[] args) {

        BinarySearchTree<Integer> balancedTree = new BinarySearchTree<>();
        BinarySearchTree<Integer> skewedTree = new BinarySearchTree<>();

        int n = 50;

        skewedTreeInsert(n, skewedTree);
        long skewStartTime = System.nanoTime();
        skewedTree.contains(n + 1);
        long skewEndTime = System.nanoTime();
        long skewDeltaTime = skewEndTime - skewStartTime;
        System.out.println("Final Skew Time:" + skewDeltaTime);


        seq(1,n, balancedTree);
        long balStartTime = System.nanoTime();
        balancedTree.contains(n+1);
        long balEndTime = System.nanoTime();
        long balDeltaTime = balEndTime - balStartTime;
        System.out.println("Final Bal Time:" + balDeltaTime);






    }


    public static void seq(int low, int high, BinarySearchTree<Integer> T){
        if (low <= high){
            int mid = (low+high)/2;
            T.insert(mid);
            seq(low, mid-1, T);
            seq(mid+1, high, T);
        }
    }

    public static void skewedTreeInsert(int n, BinarySearchTree<Integer> T){
        for (int i = 1; i <= n; i++){
            T.insert(i);
        }

    }




}
