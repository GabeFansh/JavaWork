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
 *  time
 *  vertices
 *  vertex
 *  color
 *  pi
 *  f
 *  d
 *  index
 *
 *
 *  Visible methods:
 *  DFS
 *  DFS-Visited
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

public class DFS {
    int time;
    Vertex[] vertices;

    public void DFS(List<List<Integer>> adjList) {
        time = 0;

        // Initialize all vertices to white and with no parent
        int n = adjList.size();
        vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        for (Vertex u : vertices) {
            if (u.color == Color.WHITE) {
                DFS_Visited(adjList, u);
            }
        }
    }

    private void DFS_Visited(List<List<Integer>> adjList, Vertex u) {
        time++;
        u.d = time;
        u.color = Color.GRAY;
        //System.out.println("GRAY: " + u.index);

        for (int vIndex : adjList.get(u.index)) {
            Vertex v = vertices[vIndex];
            if (v.color == Color.WHITE) {
                v.pi = u;
                DFS_Visited(adjList, v);
            }
        }

        time++;
        u.f = time;
        u.color = Color.BLACK;
        // System.out.println("BLACK: " + u.index);
    }

    private class Vertex {
        int index;
        Color color;
        int d;
        int f;
        Vertex pi;

        Vertex(int index) {
            this.index = index;
            this.color = Color.WHITE;
            this.d = 0;
            this.f = 0;
            this.pi = null;
        }
    }

    private enum Color {
        WHITE, GRAY, BLACK
    }
}
