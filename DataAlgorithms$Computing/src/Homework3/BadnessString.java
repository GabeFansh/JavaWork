package Homework3;

import java.io.*;
import java.util.*;


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
 *  Input: words, i, j, w, width, breakpoints
 *  Output:
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  getLength
 *  badness
 *  split
 *  memoizedMinimumBadness
 *  distribute
 *  justify
 *
 *
 *   Remarks
 *   -------
 *
 *   ANSWERS WILL BE IN MAIN FILE
 *
 *
 *************************************************************************/

public class BadnessString {


    public BadnessString() {
    }

    public int getLength(String[] words, int i, int j) {
        int length = 0;
        for (int index = i; index < j; index++) {
            length += words[index].length();
        }
        // Add spaces between the words
        if (j - i > 1) {
            length += (j - i - 1);
        }
        return length;
    }


    public int badness(String[] words, int i, int j, int w) {
        int totalLength = getLength(words, i, j);
        int availableWidth = w - totalLength;
        if (availableWidth < 0) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.pow(availableWidth, 3);
    }


    public int[] split(int width, String[] words) {
        int n = words.length;
        int[] memo = new int[n + 1];
        int[] linebreaks = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[n] = 0;  // base case: last suffix has 0 badness
        memoizedMinimumBadness(words, 0, memo, linebreaks, width);
        return linebreaks;
    }

    public int memoizedMinimumBadness(String[] words, int i, int[] memo, int[] linebreaks, int width) {
        if (memo[i] >= 0) {
            return memo[i];
        }
        if (i == words.length) {
            memo[i] = 0;
            linebreaks[i] = words.length;
        } else {
            int min = Integer.MAX_VALUE;
            int index_of_min = 0;
            for (int j = i + 1; j <= words.length; j++) {
                int temp = badness(words, i, j, width);
                //System.out.println(temp);
                if (temp < Integer.MAX_VALUE) {
                    temp += memoizedMinimumBadness(words, j, memo, linebreaks, width);
                }
                //System.out.println(temp);
                if (temp < min) {
                    min = temp;
                    index_of_min = j;
                }
            }
            memo[i] = min;
            linebreaks[i] = index_of_min;
        }
        return memo[i];
    }


    /***
     * distribute method below goes line by line and calculates the amount of extra empty space (the amount of space to reach
     * page length) and adds those spaces between each word in the line. Any extra space after doing the main repeat is then cycled again.
     * each line is then returned to the justify command which adds it to the main string to put into the text file.
     */
    public String distribute(int width, String[] words, int wordNum, int wordCount) {
        int numExtraSpaces = width - getLength(words, wordNum, wordCount + wordNum);
        int numSpaces = wordCount - 1;
        if (wordCount == 1) return words[wordNum];
        if (wordCount == 2) return words[wordNum] + " ".repeat(numSpaces + numExtraSpaces) + words[wordNum + 1];
        StringBuilder sb = new StringBuilder();
        sb.append(words[wordNum]);
        int remainderSpaces = numExtraSpaces % numSpaces;
        for (int i = 1; i < wordCount; i++) {
            sb.append(" ");
            sb.append(" ".repeat(numExtraSpaces / numSpaces));
            if (remainderSpaces > 0) {
                sb.append(" ");
                remainderSpaces--;
            }
            sb.append(words[wordNum + i]);
        }
        return sb.toString();
    }


    public StringBuilder justify(int width, String[] words, int[] breakpoints) {
        StringBuilder sb = new StringBuilder();
        try {
            FileWriter fileWriter = new FileWriter("just.txt");
            for (int wordNum = 0; wordNum < words.length; wordNum++) {
                int wordCount = breakpoints[wordNum] - wordNum;
                String line = distribute(width, words, wordNum, wordCount);
                sb.append(line);


                wordNum += wordCount - 1;
                sb.append("\n");
            }

            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }


}

