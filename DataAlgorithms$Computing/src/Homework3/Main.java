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
 *  Input: scanner, bad, words, writer, rand, sb
 *  Output:
 *
 *  Visible data fields:
 *
 *
 *  Visible methods:
 *  main
 *  createRandomStrings
 *
 *
 *   Remarks
 *   -------
 *
 *   Between the unjustified text, and the justified text. we can see that the text gets aligned within page length (in this case its margin length
 *   by character). If a word's character length is too large to fit onto a line after words are already added, then it is moved onto the next
 *   line and the empty space is distributed somewhat equally within each line so that the entire "box" of words is flush with the width of the margins
 *
 *   MS word does something similar with the greedy approach where if the user were to make the page margins smaller, the text would shift around
 *  so that it can fit every word, if a word cant fit but it leaves extra space at the end of the line, the words on the line adjust so that
 *  it does not look as empty at the end.
 *
 *
 *  EXTRA CREDIT:
 *
 *  By changing the exponent, it increases the growth of the length unit of the empty space. The larger the number, the more priorty the program has to
 *  focus on the amount of empty space that is a result when going to the next line. This could work by lowering the exponent or increasing it.
 *  However, if the value if linear then it doesn't prioritize the empty space as much so the justification would not be as "justified" compared to
 *  having the exponent cubed or powered to the 5th.
 *
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
        BadnessString bad = new BadnessString();
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        System.out.print("Enter the page width: ");
        int width = scanner.nextInt();

        String[] words = createRandomSprings(n);


        // Split into lines
        int[] breakpoints = bad.split(width, words);

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


    private static String[] createRandomSprings(int n) {
        // Create array of random strings
        String[] words = new String[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int len = rand.nextInt(15) + 1;
            StringBuilder sb = new StringBuilder(len);
            for (int j = 0; j < len; j++) {
                sb.append((char) (rand.nextInt(26) + 'a'));
            }
            words[i] = sb.toString();
        }
        return words;
    }
}
