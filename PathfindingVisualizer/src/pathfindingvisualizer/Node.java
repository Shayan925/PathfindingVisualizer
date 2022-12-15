/*
Names: Shayan, Pareesh, & Kabir
Date: December 15th, 2022
Description: a node class to represent each square.
 */

package pathfindingvisualizer;

import java.awt.Color;

public class Node {
    
    // Instance variables
    private boolean obstacle;
    private Color color;
    private boolean startingNode;
    private boolean destinationNode;
    private int row;
    private int col;
    
    /**
     * Primary constructor method that sets all default attribute values except for row and column number.
     */
    public Node() {
        obstacle = false;
        color = Color.WHITE;
        startingNode = false;
        destinationNode = false;
    }
    
    /**
     * Secondary constructor that sets the row and column number.
     * @param row - int representing the row number
     * @param col - int representing the column number
     */
    public Node(int row, int col) {
        this();
        this.row = row;
        this.col = col;
    }

    // Accessor and mutator methods
    
    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isStartingNode() {
        return startingNode;
    }

    public void setStartingNode(boolean startingNode) {
        this.startingNode = startingNode;
    }

    public boolean isDestinationNode() {
        return destinationNode;
    }

    public void setDestinationNode(boolean destinationNode) {
        this.destinationNode = destinationNode;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    // Instance methods

    @Override
    public String toString() {
        return "Node{" + "obstacle=" + obstacle + ", color=" + color + ", startingNode=" + startingNode + ", destinationNode=" + destinationNode + ", row=" + row + ", col=" + col + '}';
    }
}
