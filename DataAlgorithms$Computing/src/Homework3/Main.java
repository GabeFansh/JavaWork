package Homework3;

/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: Gabriel Fanshteyn
 *  Collaborators: None
 *  References: NONE
 *
 *  Assignment: Assignment 3
 *  Problem: Badness
 *  Description: The purpose of this homework is to compare experimentally
 * the result obtained justifying text with a greedy algorithm (as used by MS Word) against doing the same using
 * LATEX rules and Dynamic Programming.
 *
 *  Input:
 *  Output:
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *
 *************************************************************************/



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Prompt user for n and width
        Scanner scanner = new Scanner(System.in);
        badnessString bad = new badnessString();
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        System.out.print("Enter the page width: ");
        int width = scanner.nextInt();

        // Create array of random strings
        String[] words = new String[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int len = rand.nextInt(15) + 1;
            StringBuilder sb = new StringBuilder(len);
            for (int j = 0; j < len; j++) {
                sb.append((char)(rand.nextInt(26) + 'a'));
            }
            words[i] = sb.toString();
        }

        // Split into lines
        List<Integer> breakpoints = bad.split(width, words);
        System.out.println(breakpoints);

        // Justify and output to file
        StringBuilder justified = bad.justify(width, words, breakpoints);
        try {
            PrintWriter writer = new PrintWriter(new File("unjust.txt"));
            for (String word : words) {
                writer.print(word + " ");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Done
        System.out.println("Unjustified text written to unjust.txt");
        System.out.println("Justified text:\n" + justified);
    }
}
