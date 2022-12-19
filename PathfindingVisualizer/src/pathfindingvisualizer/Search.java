/*
 * Names: Kabir, Shayan, Pareesh
 * Date: December 16, 2022
 * Description: A search class to represent the searching algorithms being used in the visualizer
 */
package pathfindingvisualizer;

import java.util.LinkedList;
import java.util.Queue;

public class Search {

    //attributes of the search class
    private Node[] shortestPath;

    /**
     * Primary Constructor to set default attribute values
     */
    public Search() {
        shortestPath = new Node[50];
    }

    public static void aStarSearch(Node[][] grid) {

    }

    public static void breadthFirstSearch(Grid g) {
        int nodesTraversed = 0;
        Queue<Node> q = new LinkedList<Node>();
        
        // Add the starting position as the root node
        q.add(g.getGrid()[g.getStartRow()][g.getStartCol()]);
        
        // Loop until the queue is empty
        while(q.size() != 0){
            // Remove the node from the queue
            q.poll();
            
            
        }

    }

    public static void dijkstraSearch(Node[][] grid) {

    }

    /**
     * This method checks if a node is inside of the board
     *
     * @param i - an integer representing the row index
     * @param j - an integer representing the column index
     * @return - whether the node is within the board's boundaries
     */
    public boolean isValid(int i, int j) {
        return (i >= 0 && i < 50) && (j >= 0 && j < 50);
    }

    /**
     * Method to get the shortest path
     *
     * @return - returns the shortest path
     */
    public Node[] getShortestPath() {
        return shortestPath;
    }

    /**
     * Method to set the shortest path
     *
     * @param shortestPath - node with the shortest path being set as shortest
     * path
     */
    public void setShortestPath(Node[] shortestPath) {
        this.shortestPath = shortestPath;
    }

}
