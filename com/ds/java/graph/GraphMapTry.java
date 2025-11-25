package com.ds.java.graph;

import java.util.*;

public class GraphMapTry {
    public static Map<Integer, Set<Integer>> graph = new HashMap<>();
    public static void main(String[] args) {
        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(3,2);

        printGraph();
        removeEdge(3,4);
        printGraph();
        removeEdge(1,3);
        printGraph();
        removeVertex(2);
        printGraph();
    }

    /**
     * Example: graph = { 1: [2], 2: [1] }
     * This represents an undirected edge between node 1 and node 2.
     *
     * The graph is represented as a Map from node to a set of its neighbors.
     * addEdge(u, v) adds an edge between nodes u and v (both directions because the graph is undirected).
     */
    public static void addEdge(int u, int v) {
        if(!graph.containsKey(u))
            graph.put(u, new HashSet<>());
        if(!graph.containsKey(v))
            graph.put(v, new HashSet<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    /**
     * Removes the vertex u and all its associated edges from the graph.
     * For every neighbor of u, remove u from its neighbor set.
     * Finally, remove u from the graph entirely.
     */
    public static void removeVertex(int u) {
        if(!graph.containsKey(u))
            return;
        // Remove u from all its neighbors' adjacency sets.
        for (int neighbor : graph.get(u)) {
            graph.get(neighbor).remove(u);
        }
        // Remove u itself from the graph.
        graph.remove(u);
    }

    /**
     * Removes the undirected edge between nodes u and v, if it exists.
     * Removes v from u's neighbor set and u from v's neighbor set.
     */
    public static void removeEdge(int u, int v) {
        if(!graph.containsKey(u) || !graph.containsKey(v))
            return;
        graph.get(u).remove(v);
        graph.get(v).remove(u);
    }

    /**
     * Prints the graph's adjacency list representation.
     * Each line shows a node, followed by a list of its neighbors.
     * Example output:
     * 1: [2, 3]
     * 2: [1]
     * 3: [1]
     */
    public static void printGraph() {
        graph.entrySet().stream().forEach(e->
                System.out.println(e.getKey() + ": " + e.getValue()));
        System.out.println("--------");
    }
}
