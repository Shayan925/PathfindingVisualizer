/*
 * Names: Kabir, Shayan, Pareesh
 * Date: December 16, 2022
 * Description: A search class to represent the searching algorithms being used in the visualizer
 */
package pathfindingvisualizer;

import java.awt.Color;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Search {

    // Class variables
    private static final int[] ROW_OFFSET = {-1, 1, 0, 0};
    private static final int[] COL_OFFSET = {0, 0, 1, -1};
    private static final char[] DIRECTIONS = {'U', 'D', 'R', 'L'};

    /**
     * Method to perform and visualize the a star algorithm.
     *
     * @param g - the grid where the nodes are located
     * @return - the number of nodes traversed during the search.
     */
    public static int aStarSearch(Grid g) {
        // Check if either starting or ending node does not exist
        if (g.getStartRow() == -1 || g.getEndRow() == -1) {
            // Cannot form a path
            return -1;
        }

        // Variable declerations
        Node start = g.getGrid()[g.getStartRow()][g.getStartCol()];
        Node end = g.getGrid()[g.getEndRow()][g.getEndCol()];
        Node current, neighbour;
        boolean inQueue;

        // Priority queue that assigns nodes with smaller f value the highest priority
        PriorityQueue<Node> openSet = new PriorityQueue<>((node1, node2) -> {
            return Double.compare(node1.getF(), node2.getF());
        });

        // Set of nodes that have already been evaluated
        Set<Node> closedSet = new HashSet<>();

        // Add the root node to the priority queue
        openSet.add(start);

        // Set the g value (distance from starting node to current node)
        start.setG(0.0);

        // Set the h value (distance from current node to ending node)
        start.setH(hValue(start, end));

        // Set the f value (sum of g and h value)
        start.setF(start.getG() + start.getH());

        // Loop until the priority queue is empty
        while (!openSet.isEmpty()) {
            // Remove the node with the lowest f value and store it in the closed set
            current = openSet.poll();
            closedSet.add(current);

            // Loop 4 times through the direction vectors
            for (int i = 0; i < 4; i++) {
                // Check if the neighbouring node is valid
                if (isValid(current.getRow() + ROW_OFFSET[i], current.getCol() + COL_OFFSET[i])) {
                    // Store the neighbour node
                    neighbour = g.getGrid()[current.getRow() + ROW_OFFSET[i]][current.getCol() + COL_OFFSET[i]];

                    // Check if adjacent node has not already been visited and is not a wall
                    if (!closedSet.contains(neighbour) && neighbour.getColor() != Color.BLACK) {
                        // Check if the node is in the queue
                        inQueue = openSet.contains(neighbour);

                        // Check if node is not yet in the queue or there is a shorter path to the node
                        if (!inQueue || current.getG() + 1 < neighbour.getG()) {
                            // Set the parent node to the previous one to keep track of the shortest path
                            neighbour.setParent(current);

                            // Update the g value of neighbour node so it is 1 square away from the current
                            neighbour.setG(current.getG() + 1);

                            // Update the h value of neighbour
                            neighbour.setH(hValue(neighbour, end));

                            // Update the f value of neighbour node
                            neighbour.setF(neighbour.getG() + neighbour.getH());

                            // Check if there has been a direction change 
                            if (current.getDirection() != DIRECTIONS[i]) {
                                // Add a penalty for turning to make it more visually appealing
                                neighbour.setF(neighbour.getF() + 0.0001);
                            }

                            // Update the direction
                            neighbour.setDirection(DIRECTIONS[i]);

                            // Check if node is already in queue
                            if (inQueue) {
                                // Remove the node from the queue in order to update its priority
                                openSet.remove(neighbour);
                            }

                            // Add the node to the queue
                            openSet.add(neighbour);

                            // Check if the next node is the destination node
                            if (neighbour.equals(end)) {
                                // Search has been completed
                                return closedSet.size();
                            }

                            // Click the button to visualize the searching path as the button colour changes to blue
                            // Change the number will speed up or slow down how fast the visualization is
                            g.getButtons()[neighbour.getRow()][neighbour.getCol()].doClick(5);
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Method to perform and visualize the breadth-first search algorithm.
     *
     * @param g - the grid where the nodes are located
     * @return - the number of nodes traversed during the search.
     */
    public static int breadthFirstSearch(Grid g) {
        // Check if both starting and ending node exist
        if (g.getStartRow() == -1 || g.getEndRow() == -1) {
            // Cannot form a path
            return -1;
        }

        Node start = g.getGrid()[g.getStartRow()][g.getStartCol()];
        Node end = g.getGrid()[g.getEndRow()][g.getEndCol()];
        Node current, neighbour;

        // Queue to keep track of which node to process next
        Queue<Node> queue = new LinkedList<>();

        // Set to keep track of which nodes have been visited
        Set<Node> visited = new HashSet<>();

        // Add the root node to the queue and set it to visited
        queue.add(start);
        visited.add(start);

        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Remove the next node to be processed from the queue and store it in current
            current = queue.poll();

            // Loop 4 times through the direction vectors
            for (int i = 0; i < 4; i++) {
                // Check if the neighbouring node is valid
                if (isValid(current.getRow() + ROW_OFFSET[i], current.getCol() + COL_OFFSET[i])) {
                    // Store the neighbour node
                    neighbour = g.getGrid()[current.getRow() + ROW_OFFSET[i]][current.getCol() + COL_OFFSET[i]];

                    // Check if adjacent node has not already been visited and is not a wall
                    if (!visited.contains(neighbour) && neighbour.getColor() != Color.BLACK) {
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
                            return visited.size();
                        }
                    }
                }
            }
        }
        // Otherwise there is no path that connects start and end points
        return -1;
    }

    /**
     * Method to perform and visualize the depth-first search algorithm. The
     * path formed is not necessarily the shortest path as this algorithm needs
     * to traverse every single node in order to find the path which is very
     * inefficient.
     *
     * @param g - the grid where the nodes are located
     * @return - the number of nodes traversed during the search.
     */
    public static int depthFirstSearch(Grid g) {
        // Check if both starting and ending node exist
        if (g.getStartRow() == -1 || g.getEndRow() == -1) {
            // Cannot form a path
            return -1;
        }

        Node start = g.getGrid()[g.getStartRow()][g.getStartCol()];
        Node end = g.getGrid()[g.getEndRow()][g.getEndCol()];
        Node current, neighbour;

        // Stack to keep track of which node to process next
        Stack<Node> stack = new Stack<Node>();

        // Set to keep track of which nodes have been visited
        Set<Node> visited = new HashSet<>();

        // Add the root node to the stack and set it to visited
        stack.push(start);
        visited.add(start);

        // Loop until the stack is empty
        while (!stack.isEmpty()) {
            // Remove the next node to be processed from the stack and store it in current
            current = stack.pop();

            // Loop 4 times through the direction vectors
            for (int i = 0; i < 4; i++) {
                // Check if the neighbouring node is valid
                if (isValid(current.getRow() + ROW_OFFSET[i], current.getCol() + COL_OFFSET[i])) {
                    // Store the neighbour node
                    neighbour = g.getGrid()[current.getRow() + ROW_OFFSET[i]][current.getCol() + COL_OFFSET[i]];

                    // Check if adjacent node has not already been visited and is not a wall
                    if (!visited.contains(neighbour) && neighbour.getColor() != Color.BLACK) {
                        // Add the neighbour node to the stack and set it to visited
                        stack.push(neighbour);
                        visited.add(neighbour);

                        // Click the button to visualize the searching path as the button colour changes to blue
                        // Change the number will speed up or slow down how fast the visualization is
                        g.getButtons()[neighbour.getRow()][neighbour.getCol()].doClick(5);

                        // Set the parent node to the previous one to keep track of the shortest path
                        neighbour.setParent(current);

                        // Check if the next node is the destination node
                        if (neighbour.equals(end)) {
                            // Search has been completed
                            return visited.size();
                        }
                    }
                }
            }
        }
        // Otherwise there is no path that connects start and end points
        return -1;
    }

    /**
     * Method to calculate the estimated distance from current node to the end
     * node.
     *
     * @param cur - the current node
     * @param end - the destination node
     * @return - double representing the heuristic value of the node
     */
    public static double hValue(Node cur, Node end) {
        // Calculate using Manhattan distance heurisitic
        return Math.abs(cur.getRow() - end.getRow()) + Math.abs(cur.getCol() - end.getCol());
    }

    /**
     * This method checks if a node is inside of the board
     *
     * @param i - an integer representing the row index
     * @param j - an integer representing the column index
     * @return - whether the node is within the board's boundaries
     */
    public static boolean isValid(int i, int j) {
        return (i >= 0 && i < Grid.NUM_ROWS) && (j >= 0 && j < Grid.NUM_COLS);
    }

    /**
     * Recursive method to display the shortest path from the start to end.
     *
     * @param n - the current node in the path
     * @param g - the grid the nodes are located on
     */
    public static void displayShortestPath(Node n, Grid g) {
        // Base case
        // Check if parent node is the starting node
        if (n.getParent().equals(g.getGrid()[g.getStartRow()][g.getStartCol()])) {
            // Stop recursion because path has been finished
            return;
        }
        // Otherwise set the colour of the parent node to yellow
        n.getParent().setColor(Color.YELLOW, g.getButtons()[n.getParent().getRow()][n.getParent().getCol()]);

        // Recursively call method using the parent node
        displayShortestPath(n.getParent(), g);
    }
}
