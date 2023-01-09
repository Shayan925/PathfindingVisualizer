/*
 * Names: Shayan, Pareesh, & Kabir
 * Date: December 15th, 2022
 * Description: a node class to represent each square on the grid.
 */
package pathfindingvisualizer;

import java.awt.Color;
import javax.swing.JButton;

public class Node {

    // Instance variables
    private Color color;
    private int row;
    private int col;
    private double f, g, h;
    private Node parent;
    private char direction;

    /**
     * Primary constructor method that sets the default values
     */
    public Node() {
        this.color = Color.WHITE;
        this.g = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.direction = ' ';
    }

    /**
     * Secondary constructor that sets the row and column number.
     *
     * @param row - int representing the row number
     * @param col - int representing the column number
     */
    public Node(int row, int col) {
        this();
        this.row = row;
        this.col = col;
    }

    // Accessor and mutator methods
    
    /**
     * Method to get the color of the node
     * @return - Color object representing the color
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Method to set the color of the node
     * @param color - the new color
     * @param btn - the button object which needs to be updated
     * @return - boolean stating whether the color was successfully changed
     */
    public boolean setColor(Color color, JButton btn) {

        // Check if current node is starting or ending point
        if (this.color == Color.GREEN || this.color == Color.RED) {

            // Check if new color to be set is either green or red or black
            if (color == Color.GREEN || color == Color.RED || color == Color.BLACK) {
                // Not a valid position for the wall or starting or ending point
                return false;
            }
        }
        // Otherwise set the node color
        this.color = color;

        // Change the button colour
        btn.setBackground(this.color);

        return true;
    }

    /**
     * Method to get the row of the node
     * @return - int representing the row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Method to get the column of the node
     * @return  - int representing the column
     */
    public int getCol() {
        return col;
    }
    
    /**
     * Method to get the previous node in the search
     * @return - Node objecting representing the parent node
     */
    public Node getParent() {
        return parent;
    }
    
    /**
     * Method to set the previous node in the search
     * @param parent - the parent Node
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    /**
     * Method to get the f value of the node
     * @return - double representing the f value
     */
    public double getF() {
        return f;
    }
    
    /**
     * Method to set the f value of the node
     * @param f - the new f score
     */
    public void setF(double f) {
        this.f = f;
    }
    
    /**
     * Method to get the g value of the node
     * @return - double representing the g value
     */
    public double getG() {
        return g;
    }
    
    /**
     * Method to set the g value of the node
     * @param g - the new g value
     */
    public void setG(double g) {
        this.g = g;
    }
    
    /**
     * Method to get the heuristic value of the node
     * @return - double representing the h value
     */
    public double getH() {
        return h;
    }

    /**
     * Method to set the heuristic value
     * @param h - the new h value
     */
    public void setH(double h) {
        this.h = h;
    }
    
    /**
     * Method to get the direction the node is facing
     * @return - character representing either up, down, left, or right
     */
    public char getDirection() {
        return direction;
    }
    
    /**
     * Method to set the direction the node is facing
     * @param direction - the new direction
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }

    // Instance methods
    
    /**
     * Method to check if two nodes are equal
     * @param other - the other node
     * @return - whether the nodes are equal or not
     */
    public boolean equals(Node other) {
        return this.row == other.getRow() && this.col == other.getCol();
    }
    
    /**
     * Method to convert the main attributes into a string
     * @return - the formatted string
     */
    @Override
    public String toString() {
        return "Node{" + "color=" + color + ", row=" + row + ", col=" + col + '}';
    }
}
