package com.ds.java.graph;

public class GraphMatrixTry {
    private static int[][] graph;
    private static int vertices;
    public GraphMatrixTry(int vertices){
        this.vertices=vertices;
        graph=new int[vertices][vertices];
    }
    public static void addEdge(int src, int dest){
        graph[src][dest]=1;
    }
    public static void printGraph(){
        for(int i=1;i<vertices;i++){
            for(int j=1;j<vertices;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printNeighbours(int vertex){
        for(int i=1;i<vertices;i++){
            if(graph[vertex][i]==1){
                System.out.print(i+" ");
            }
        }
        System.out.println(" - NEIGHBOURS");
    }
    public static void removeEdge(int src, int dest) {
        graph[src][dest]=0;
        graph[dest][src]=0;
    }

    public static void main(String[] args) {
        new GraphMatrixTry(10);

        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,3);
        addEdge(3,4);
        printNeighbours(1);
        printGraph();
        removeEdge(1,4);
        System.out.println("After removal");
        printGraph();
    }
}
