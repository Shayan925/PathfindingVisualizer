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
    private Node parent;

    /**
     * Primary constructor method that sets the default color of the node to
     * white
     */
    public Node() {
        this.color = Color.WHITE;
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
    public Color getColor() {
        return color;
    }

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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    // Instance methods
    
    public boolean equals(Node other) {
        return this.row == other.getRow() && this.col == other.getCol();
    }

    @Override
    public String toString() {
        return "Node{" + "color=" + color + ", row=" + row + ", col=" + col + '}';
    }

}
