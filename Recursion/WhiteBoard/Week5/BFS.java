package Recursion.WhiteBoard.Week5;

import java.util.*;

class BFSVertex {
    int value;
    List<BFSVertex> neighbours = new ArrayList<BFSVertex>();

    public BFSVertex(int data) {
        this.value = data;
    }
}

public class BFS {
    public static void main(String args[]) {
        BFSVertex vertex1 = new BFSVertex(1);
        BFSVertex vertex2 = new BFSVertex(2);
        BFSVertex vertex3 = new BFSVertex(3);
        BFSVertex vertex4 = new BFSVertex(4);
        BFSVertex vertex5 = new BFSVertex(5);

        vertex1.neighbours.add(vertex2);
        vertex1.neighbours.add(vertex3);
        vertex2.neighbours.add(vertex3);
        vertex2.neighbours.add(vertex4);
        vertex3.neighbours.add(vertex5);
        vertex4.neighbours.add(vertex5);

        bfsMain(vertex1);
    }

    static void bfsMain(BFSVertex v) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<BFSVertex> queue = new LinkedList<>();
        visited.add(v.value);
        queue.add(v);
        while (!queue.isEmpty()) {
            BFSVertex pop = queue.poll();
            System.out.print(pop.value+",");
            for(BFSVertex neigh : pop.neighbours){
                if(!visited.contains(neigh.value)){
                    visited.add(neigh.value);
                    queue.add(neigh);
                }
            }
        }
    }
}
