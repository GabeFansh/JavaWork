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

public class badnessString {

    public badnessString(){

    }

    public int badness(String[] W, int i, int j, int w) {
        int totalLength = 0;
        for (int k = i; k < j; k++) {
            totalLength += W[k].length();
        }
        int spaces = j - i - 1;
        int availableWidth = w - totalLength - spaces;
        if (availableWidth < 0) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.pow(availableWidth, 3);
    }


    public List<Integer> split(int width, String[] words) {
        int n = words.length;
        int[] memo = new int[n];
        int[] linebreaks = new int[n];
        Arrays.fill(memo, -1);
        memo[n-1] = 0;  // base case: last suffix has 0 badness
        //linebreaks[n-1] = n;
        memoizedMinimumBadness(words, 0, memo, linebreaks, width);
        List<Integer> result = new ArrayList<>();
        for (int linebreak : linebreaks){
            result.add(linebreak);
        }
        return result;
    }

    private int memoizedMinimumBadness(String[] words, int i, int[] memo, int[] linebreaks, int width) {
        if (memo[i] >= 0) {
            return memo[i];
        }
        if (i == words.length) {
            memo[i] = 0;
            linebreaks[i] = words.length;
        } else {
            int min = Integer.MAX_VALUE;
            int index_of_min = 0;
            for (int j = i + 1; j < words.length; j++) {
                int temp = badness(words, i, j, width);
                //System.out.println(temp);
                temp += memoizedMinimumBadness(words, j, memo, linebreaks, width);
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

    public int getLength(String[] words, int start, int end) {
        int length = 0;
        for (int i = start; i < end; i++) {
            length += words[i].length();
        }
        // Add spaces between the words
        if (end - start > 1) {
            length += (end - start - 1);
        }
        return length;
    }


    public StringBuilder justify(int width, String[] words, List<Integer> breakpoints) {
        StringBuilder sb = new StringBuilder();
        try {
            FileWriter fileWriter = new FileWriter("just.txt");

            int start = 0;
            for (int i = 0; i < breakpoints.size(); i++) {
                int end = breakpoints.get(i);
                int numOfWords = end - start;
                int spaceCount = width - getLength(words, start, end);
                int spacePerWord = 0;
                int extraSpaces = 0;
                if (numOfWords > 1 && i != breakpoints.size() - 1) {
                    spacePerWord = spaceCount / (numOfWords - 1);
                    extraSpaces = spaceCount % (numOfWords - 1);
                }
                sb.append(words[start]);
                for (int j = start + 1; j < end; j++) {
                    for (int s = 0; s < spacePerWord; s++) {
                        sb.append(' ');
                    }
                    if (extraSpaces > 0) {
                        sb.append(' ');
                        extraSpaces--;
                    }
                    sb.append(words[j]);
                }
                sb.append(System.lineSeparator());
                start = end;
            }
            for (int i = start; i < words.length; i++) {
                sb.append(words[i]);
                sb.append(' ');
            }
            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }


}

