package Homework4;
/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: Gabriel Fanshteyn
 *  Collaborators: NONE
 *  References: NONE
 *
 *  Assignment: Assignment 4
 *  Problem: DFS on graph and adjlist
 *  Description: The purpose of this homework is to evaluate experimentally the
 *  performance of an efficient implementation of DFS.
 *
 *  Input: nodeCount edgeCount
 *  Output: adjlist and time
 *
 *  Visible data fields:
 *  nodeCount
 *  edgeCount
 *  adjList
 *  startTime
 *  endTime
 *  deltaTime
 *
 *  Visible methods:
 *  getLists
 *  printList
 *
 *
 *   Remarks
 *   -------
 *
 *   NON CODING IS IN MAIN.JAVA
 *
 *
 *************************************************************************/

import java.util.*;

public class genList {

    int u;
    int v;
    String pair;

    public void printList(int nodeCount, List<List<Integer>> adjList) {
        // Print the adjacency list
        System.out.println("Adjacency list:");
        for (int i = 0; i < nodeCount; i++) {
            System.out.print(i + ": ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getLists(int nodeCount, int edgeCount) {
        // Create an adjacency list for the random directed graph
        List<List<Integer>> adjList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < nodeCount; i++) {
            adjList.add(new LinkedList<>());
        }

        genEdges(nodeCount, adjList, random, edgeCount);

        return adjList;
    }

    private void genEdges(int nodeCount, List<List<Integer>> adjList, Random random, int edgeCount) {
        HashSet<String> pairs = new HashSet<>(nodeCount);
        for (int i = 0; i < edgeCount; i++) {
            getUV(nodeCount, random);
            // Ensure that there are no repeating edges
            while (pairs.contains(pair)) {
                getUV(nodeCount, random);
            }
            //add pair to hashset as a string, so that it can be tested against duplicates for future edges
            pairs.add(pair);
            adjList.get(u).add(v);

        }
    }

    private void getUV(int nodeCount, Random random) {
        u = random.nextInt(nodeCount);
        v = random.nextInt(nodeCount);
        // Ensure that an edge cannot connect a node to itself
        while (u == v) {
            v = random.nextInt(nodeCount);
        }
        pair = u + ", " + v;
    }
}
