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
 *  References: https://chat.openai.com/chat (FOR EXTRA CREDIT ONLY)
 *
 *  Assignment: Homework 1
 *  Problem: Maximum Sub-arry problem
 *  Description: Inplement 2 programs and measure the running time of each program for n number of items
 *
 *  Input:
 *  Output:
 *
 *  Visible data fields:
 *  rand
 *  algorithm1
 *  algorithm2
 *  extraCreditAlgorithm
 *  numCount
 *  intArray
 *
 *
 *  Visible methods:
 *  addArray
 *  maxSubarraySum
 *  KadaneAlgorithm
 *
 *
 *   Remarks
 *   -------
 *
 *   This FILE is the MAIN class. All none coding questions will be listed here.
 *
 *   2.
 *
 *   |                  |   100   |   1000   |   10000  |   20000   |   30000   |
 *   | Brute Force      | 1021100 | 15484100 | 67389300 | 208665000 | 420271400 |
 *   | Divide & Conquer | 224400  | 1488000  | 3049700  | 2705000   |  3474600  |
 *   | Kadane Algorithm | 59700   |  243600  |  746300  |  925700   |  2008200  |
 *
 *
 *   3. Based on the running times observed, draw conclusions
 * about the running times obtained in the analysis. Do they match the
 * theoretical times or not? Provide your answers in the remarks section
 * of the code header.
 *
 *  The times that I was able to find do match the theoretical times. For the Brute force algorithm,
 *  there is a massive exponential increase between the different n values (which are also increasing at a similar rate).
 *  At 100 integers, the speed is 1021100 nanoseconds but when the number of integers increases to 1000, the speed increases
 *  by more than a factor of 10, 15484100 nanoseconds, and then when 10000 numbers are in the array, it increases again
 *  by more than a factor of 10, 67389300 nanoseconds. For the Divide and conquer algorithm, the area is constantly divided in
 *  the middle, forming subarrays. That process runs at the speed of log(n). Because there are n number of items within an array,
 *  the speed that the algorithm takes to traverse the entire array/subarrays is nlog(n). The times I found seem to corrolate
 *  with that finding as when the number of items increases, the speed doesn't increase at such a large rate, even dipping faster
 *  when 20000 items were in the array.
 *
 *
 *   4. I implemented the agorithm based on findings through chatgpt ai generation.
 *      Based on what was produced by the AI, i feel that the speed is accurate to the linear time estimate.
 *      The speed is also very much faster compared to the other two algorithms that we implemented.
 *
 *
 *
 *
 *************************************************************************/






import java.util.Random;
import java.util.Scanner;

public class algorithmMain {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner userNum = new Scanner(System.in);

        bruteForce algorithm1 = new bruteForce();
        divideConquer algorithm2 = new divideConquer();
        kadaneAlgorithm extraCreditAlgorithm = new kadaneAlgorithm();



        System.out.print("Enter array size: ");
        int numCount = userNum.nextInt();
        int[] intArray = new int[numCount];

        for (int i = 0; i < numCount; i++) {
            int sign = rand.nextInt(2);
            if (sign == 1) {
                int num = (rand.nextInt(100) + 1);
                intArray[i] = num;
            }
            else {
                int num = -(rand.nextInt(100) + 1);
                intArray[i] = num;
            }

        }


        algorithm1.addArray(intArray);
        algorithm2.addArray(intArray);
        extraCreditAlgorithm.addArray(intArray);


        long startTime = System.nanoTime();
        System.out.println(algorithm1.maxSubarraySum(intArray));
        long endTime = System.nanoTime();
        System.out.println("BF= "+(endTime - startTime)+" nanosecs.");

        startTime = System.nanoTime();
        System.out.println(algorithm2.maxSubarraySum(intArray, 0, intArray.length - 1));
        endTime = System.nanoTime();
        System.out.println("DC= "+(endTime - startTime)+" nanosecs.");

        startTime = System.nanoTime();
        System.out.println(extraCreditAlgorithm.kadaneAlgorithm(intArray));
        endTime = System.nanoTime();
        System.out.println("KA= "+(endTime - startTime)+" nanosecs.");

    }
}
