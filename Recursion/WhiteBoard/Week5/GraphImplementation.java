package Recursion.WhiteBoard.Week5;

import java.util.*;

public class GraphImplementation {
    private Map<Integer, Set<Integer>> verticesMap;
    private int edgesCount;

    public GraphImplementation() {
        verticesMap = new HashMap<>();
    }

    public int getNumVertices() {
        return verticesMap.size();
    }

    public int getNumEdges() {
        return edgesCount;
    }

    private void validateVertex(Integer v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v.toString() + " is not a vertex");
    }

    public void addEdge(Integer v, Integer w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) edgesCount++;
        verticesMap.get(v).add(w);
        verticesMap.get(w).add(v);
    }

    public void addVertex(Integer v) {
        if (!hasVertex(v)) verticesMap.put(v, new HashSet<>());
    }

    public boolean hasEdge(Integer v, Integer w) {
        validateVertex(v);
        validateVertex(w);
        return verticesMap.get(v).contains(w);
    }

    public boolean hasVertex(Integer v) {
        return verticesMap.containsKey(v);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Integer v: verticesMap.keySet()) {
            builder.append(v.toString() + ": ");
            for (Integer w: verticesMap.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        GraphImplementation graph = new GraphImplementation();

        graph.addEdge(200, 300);
        graph.addEdge(200, 500);
        graph.addEdge(500, 600);
        graph.addEdge(600, 100);
        graph.addEdge(600, 20);
        graph.addEdge(100, 20);
        graph.addVertex(900);

        System.out.println(graph);

        System.out.println("Vertices: " + graph.getNumVertices());
        System.out.println("Edges: " + graph.getNumEdges());
    }
}
