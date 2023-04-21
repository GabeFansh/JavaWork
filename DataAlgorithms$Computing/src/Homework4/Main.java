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
 *   Using the DFS program of part (1), fill in the following
 *   chart with the running times observed for different edge-set sizes.
 *
 *   |            | |E| = |v| - 1 | |E| = (|v| - 1)^(3/2) | |E| = (|v| - 1)^2 |
 *   | |v| = 10   | 1592000       |    1124400            |    934100         |
 *   | |v| = 100  |  2315500      |    1596800            |    4341500        |
 *   | |v| = 1000 |   1101800     |     4830000           |    29948300       |
 *
 *
 *
 *  Give an approximate formula (with constants, not big-O)
 * for the asymptotic running time of DFS based on your experiments.
 * How does this compare with the expected O(|V | + |E|)? If the results
 * differ, overview the code of the data structures used for the adjacency
 * list and explain what might have happened.
 *
 *
 *  T(n, m) = c1 * n + c2 * m + c3. This formula is formed based on the type of structure I used to store the
 *  adjecentcy list. Since my main list is derived from an arraylist of different linked list, the actual constant values
 *  would be different. The reason why values are constant are because it only has to visit each node once and
 *  each edge once. Since its only visiting each once, the final formula would be linear as the final run time
 *  would change depending on node amount and edge amount. If I were to change the handling of the link nodes in the
 *  arrayList, the 2nd constant would either increase or decrease based on the efficiency of the data type.
 *  This compares to O(|V| + |E|) because that is based on the amount of nodes and edges that are inputted by the
 *  user. It also changes linearly based on the amount.
 *************************************************************************/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DFS dfs = new DFS();
        genList list = new genList();

        // Prompt the user to input the number of nodes and edges
        System.out.print("Enter the number of nodes: ");
        int nodeCount = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edgeCount = scanner.nextInt();

        List<List<Integer>> adjList = list.getLists(nodeCount, edgeCount);

        list.printList(nodeCount, adjList);

        scanner.close();


        long startTime = System.nanoTime();
        dfs.DFS(adjList);
        long endTime = System.nanoTime();
        System.out.println("Start Time:" + startTime);
        System.out.println("End Time: " + endTime);
        long deltaTime = endTime - startTime;
        System.out.println("Delta Time: " + deltaTime);


    }


}