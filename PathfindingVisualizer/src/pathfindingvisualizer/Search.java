/*
 * Names: Kabir, Shayan, Pareesh
 * Date: December 16, 2022
 * Description: A search class to represent the searching algorithms being used in the visualizer
 */
package pathfindingvisualizer;

import java.awt.Color;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Search {

    public static int aStarSearch(Grid g) {
        return -1;
    }
    
    /**
     * Method to perform and visualize the breadth-first search algorithm.
     * @param g - the grid where the nodes are located
     * @return - the number of nodes traversed during the search.
     */
    public static int breadthFirstSearch(Grid g) {
        Node start = g.getGrid()[g.getStartRow()][g.getStartCol()];
        Node end = g.getGrid()[g.getEndRow()][g.getEndCol()];
        Node current, neighbour;
        
        // Check if both starting and ending node exist
        if(start.getRow() == -1 || end.getRow() == -1){
            // Cannot form a path
            return -1;
        }
        
        // Queue to keep track of which node to process next
        Queue<Node> queue = new LinkedList<>();
        
        // Set to keep track of which nodes have been visited
        Set<Node> visited = new HashSet<>();
        
        // Counter for number of nodes visited
        int count = 0;
        
        // Add the root node to the queue and set it to visited
        queue.add(start);
        visited.add(start);

        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Remove the node from the queue and store it in current
            current = queue.poll();
            
            // Increase counter
            count++;

            // Loop through the surrounding rows
            for (int i = -1; i < 2; i++) {
                // Loop through the surrounding cols
                for (int j = -1; j < 2; j++) {
                    // Check if the neighbouring node is a valid
                    if (isValid(current.getRow() + i, current.getCol() + j)) {
                        // Store the neighbour node
                        neighbour = g.getGrid()[current.getRow() + i][current.getCol() + j];

                        // Check if adjacent node has not already been visited and is not a wall
                        if (!visited.contains(neighbour) && (Math.abs(i-j) == 1) && neighbour.getColor() != Color.BLACK) {
                            // Add the neighbour node to the queue and set it to visited
                            queue.add(neighbour);
                            visited.add(neighbour);
                            
                            // Click the button to visualize the searching path as the button colour changes to blue
                            // Change the number will speed up or slow down how fast the visualization is
                            g.getButtons()[neighbour.getRow()][neighbour.getCol()].doClick(5);

                            // Set the parent node to the previous one to keep track of the shortest path
                            neighbour.setParent(current);

                            // Check if the next node is the destination node
                            if (neighbour.equals(end)) {
                                // Search has been completed
                                return count;
                            }
                        }
                    }
                }
            }
        }
        // Otherwise there is no path that connects start and end points
        return -1;
    }

    public static int dijkstraSearch(Grid g) {
        return -1;
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
    
    /**
     * Recursive method to display the shortest path from the start to end.
     * @param n - the current node in the path
     * @param g - the grid the nodes are located on
     */
    public static void displayShortestPath(Node n, Grid g){
        // Base case
        // Check if parent node is the starting node
        if(n.getParent().equals(g.getGrid()[g.getStartRow()][g.getStartCol()])){
            // Stop recursion because path has been finished
            return;
        }
        // Otherwise set the colour of the parent node to yellow
        n.getParent().setColor(Color.YELLOW, g.getButtons()[n.getParent().getRow()][n.getParent().getCol()]);
        
        // Recursively call method using the parent node
        displayShortestPath(n.getParent(), g);
    }

    // Accessor and mutator methods
    // Instance methods
}
