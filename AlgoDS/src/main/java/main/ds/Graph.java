/*
Useful to visualize data that is non-hierarchical
visual relationships and connections b/w non-numerical connections
can do math operations for ex. path finding
 */
package main.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    Map<Integer, ArrayList<Integer>> adj; //adjacency map, all adjacent nodes are listed for a node

    public Graph() {
        this.adj = new HashMap<>(); //hash map -> node key, adjacency vertexes as a list
    }

    /**
     * Add a new vertex to the map
     *
     * @param i {int}
     */
    public void addVertex(int i) {
        adj.put(i, new ArrayList<>()); //add to the graph, and initialize an empty arraylist for its adjacencies
    }

    /**
     * Add a connection for a node of graph
     *
     * @param i {int} first edge
     * @param j {int} second edge
     */
    public void addEdge(int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    /**
     * Remove a vertex from graph
     *
     * @param i {int}
     */
    public void removeVertex(int i) {
        //clean all relationships
        ArrayList<Integer> currentVertex = adj.get(i);
        for (int j = 0; j < currentVertex.size(); j++) {
            //grab neighbor's adj map and scrub relationships to the node to be removed
            int neighbor = currentVertex.get(j);
            this.adj.get(neighbor).remove(this.adj.get(neighbor).indexOf(i));
        }

        //then remove node
        adj.remove(i);
    }

    /**
     * Remove a connection to node
     *
     * @param i {int} first edge
     * @param j {int} second edge
     */
    public void removeEdge(int i, int j) {

        adj.get(i).remove(adj.get(i).indexOf(j));
        adj.get(j).remove(adj.get(j).indexOf(i));
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph();

        for (int i = 0; i < 5; i++) {
            myGraph.addVertex(i);
        }

        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 4);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 4);
        myGraph.removeEdge(1, 2);
        myGraph.removeVertex(1);

        System.out.println(myGraph.adj);
    }
}
