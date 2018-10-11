package Recursion.WhiteBoard.Week5;

import java.util.*;

class Vertex {
    int value;
    List<Vertex> neighbour = new ArrayList<>();

    public Vertex(int data) {
        this.value = data;
    }
}

public class DFS {

    public static void main(String args[]) {

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(200);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.neighbour.add(vertex2);
        vertex1.neighbour.add(vertex3);
        vertex2.neighbour.add(vertex3);
        vertex2.neighbour.add(vertex4);
        vertex3.neighbour.add(vertex5);
        vertex4.neighbour.add(vertex5);

        dfsMain(vertex1);
    }

    static void dfsMain(Vertex v) {
        HashSet<Integer> visited = new HashSet<>();
        dfs(v, visited);
    }

    static void dfs(Vertex v, HashSet<Integer> visited) {
        visited.add(v.value);
        System.out.print(v.value + ",");
        for (Vertex n : v.neighbour) {
            if (!visited.contains(n.value))
                dfs(n, visited);
        }
    }
}
