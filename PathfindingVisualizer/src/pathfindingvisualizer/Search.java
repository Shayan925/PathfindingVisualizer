/*
 * Names: Kabir, Shayan, Pareesh
 * Date: December 16, 2022
 * Description: A search class to represent the searching algorithms being used in the visualizer
 */
package pathfindingvisualizer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Search {

    // Class variable
    private static ArrayList<Node> shortestPath = new ArrayList<Node>();

    public static void aStarSearch(Node[][] grid) {

    }
    
    /**
     * Method to perform the breadth first search algorithm to find the shortest path
     * @param g - Grid instance to perform the search on
     * @return - boolean stating whether a path was found
     */
    public static boolean breadthFirstSearch(Grid g) {
        int nodesTraversed = 0;
        Node temp = new Node();
        boolean[][] visited = new boolean[Grid.NUM_ROWS][Grid.NUM_COLS];
        Queue<Node> q = new LinkedList<Node>();

        // Add the starting position as the root node
        q.add(g.getGrid()[g.getStartRow()][g.getStartCol()]);

        // The root node has been visited
        visited[q.element().getRow()][q.element().getCol()] = true;

        // Loop until the queue is empty
        while (!q.isEmpty()) {
            // Remove the node from the queue
            temp = q.poll();

            // Loop through the surrounding rows
            for (int i = -1; i < 2; i++) {
                // Loop through the surrounding cols
                for (int j = -1; j < 2; j++) {

                    // Check if the next node is a valid node on the grid and is not a wall
                    if (isValid(temp.getRow() + i, temp.getCol() + j) && g.getGrid()[temp.getRow() + i][temp.getCol() + j].getColor() == Color.BLACK) {
                        // Check if surrounding nodes have not already been visited
                        if (!visited[temp.getRow() + i][temp.getCol() + j] && !(i == 0 && j == 0)) {
                            // Add the surrounding nodes to the queue
                            q.add(g.getGrid()[temp.getRow() + i][temp.getCol() + j]);

                            // Nodes have now been visited
                            visited[temp.getRow() + i][temp.getCol() + j] = true;

                            // Set the parent node to the previous one
                            g.getGrid()[temp.getRow() + i][temp.getCol() + j].setParent(g.getGrid()[temp.getRow()][temp.getCol()]);

                            // Check if the next node is the destination node
                            if (g.getGrid()[temp.getRow() + i][temp.getCol() + j].equals(g.getGrid()[g.getEndRow()][g.getEndCol()])) {
                                // Search has been complete
                                return true;
                            }
                        }
                    }
                }
            }
        }
        // Otherwise there is no path that connects start and end points
        return false;
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
    public static boolean isValid(int i, int j) {
        return (i >= 0 && i < 50) && (j >= 0 && j < 50);
    }
    
    
    
    // Accessor and mutator methods
    
    // Instance methods
}
