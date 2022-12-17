/*
 * Names: Shayan, Pareesh, & Kabir
 * Date: December 15th, 2022
 * Description: a grid class to represent the 50x50 grid of squares.
 */
package pathfindingvisualizer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid {

    // Class variables
    public static final int NUM_ROWS = 50;
    public static final int NUM_COLS = 50;

    // Instance variables
    private Node[][] grid;
    private JButton[][] buttons;
    private int startCol, startRow;
    private int endCol, endRow;

    /**
     * Primary constructor method to create matrices of nodes and buttons
     */
    public Grid() {
        // Instantiate the grid and buttons to size 50 x 50
        grid = new Node[NUM_ROWS][NUM_COLS];
        buttons = new JButton[NUM_ROWS][NUM_COLS];
    }

    // Accessor and mutator methods
    
    /**
     * Method to get grid
     *
     * @return the grid
     */
    public Node[][] getGrid() {
        return grid;
    }

    /**
     * Method to get the buttons
     *
     * @return - returns the buttons
     */
    public JButton[][] getButtons() {
        return buttons;
    }

    /**
     * Method to get the column of the starting point
     *
     * @return - returns the column of the starting point
     */
    public int getStartCol() {
        return startCol;
    }

    /**
     * Method to get the row of the starting point
     *
     * @return - returns the row of the starting point
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * Method to set the position of the starting point
     *
     * @param startRow - row of the starting point
     * @param startCol - column of the ending point
     */
    public void setStartPoint(int startRow, int startCol) {
        // Set the colour of the old starting point back to white
        grid[this.startRow][this.startCol].setColor(Color.WHITE, buttons[this.startRow][this.startCol]);

        // Set the coordinate of the new starting point
        this.startRow = startRow;
        this.startCol = startCol;
    }

    /**
     * Method to get the column of the ending point
     *
     * @return - returns the column of the ending point
     */
    public int getEndCol() {
        return endCol;
    }

    /**
     * Method to get the row of the ending point
     *
     * @return - returns the row of the ending point
     */
    public int getEndRow() {
        return endRow;
    }

    /**
     * Method to set the position of the ending point
     *
     * @param endRow - row of the ending point
     * @param endCol - column of the ending point
     */
    public void setEndPoint(int endRow, int endCol) {
        // Set the colour of the old ending point back to white
        grid[this.endRow][this.endCol].setColor(Color.WHITE, buttons[this.endRow][this.endCol]);

        // Set the coordinates of the new ending point
        this.endRow = endRow;
        this.endCol = endCol;
    }

    // Instance methods
    public void saveGrid() {

    }

    public void loadGrid() {

    }

    /**
     * Method to display the buttons in a formatted 50 by 50 grid.
     *
     * @param frame - the frame the mouse listener should be attached to
     * @return - JPanel object to be displayed to the frame
     */
    public JPanel displayGrid(JFrame frame) {

        // Instantiate a new panel for the grid of buttons
        JPanel gridPanel = new JPanel();

        // Set the layout of the panel to grid layout of size 50 x 50
        gridPanel.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

        // Loop through each row
        for (int i = 0; i < NUM_ROWS; i++) {
            // Loop through each column
            for (int j = 0; j < NUM_COLS; j++) {
                // Instantiate new button and node at that position
                buttons[i][j] = new JButton();
                grid[i][j] = new Node(i, j);

                // Set the color of the button
                buttons[i][j].setBackground(grid[i][j].getColor());

                // Add the mouse and mouse motion listener for each button
                buttons[i][j].addMouseListener((MouseListener) frame);
                buttons[i][j].addMouseMotionListener((MouseMotionListener) frame);

                // Add the button the grid panel
                gridPanel.add(buttons[i][j]);
            }
        }
        return gridPanel;
    }

    /**
     * Method to get the attributes of the class and represent them as strings
     *
     * @return - the formatted string
     */
    @Override
    public String toString() {
        return "Grid{" + "grid=" + Arrays.deepToString(grid) + ", buttons=" + Arrays.deepToString(buttons) + ", startCol=" + startCol + ", startRow=" + startRow + ", endCol=" + endCol + ", endRow=" + endRow + '}';
    }

}
