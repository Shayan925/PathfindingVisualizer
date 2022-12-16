/*
Names: Shayan, Pareesh, & Kabir
Date: December 15th, 2022
Description: a grid class to represent the 50x50 grid of squares.
 */
package pathfindingvisualizer;

import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid {

    // Class variables
    public static final int ROWS = 50;
    public static final int COLS = 50;

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
        grid = new Node[ROWS][COLS];
        buttons = new JButton[ROWS][COLS];
    }

    // Accessor and mutator methods
    /**
     * Method to get grid
     * @return the grid
     */
    public Node[][] getGrid() {
        return grid;
    }
    /**
     * Method to set the grid
     * @param grid - new grid being set as the grid
     */
    public void setGrid(Node[][] grid) {
        this.grid = grid;
    }

    /**
     * Method to get the buttons
     * @return - returns the buttons
     */
    public JButton[][] getButtons() {
        return buttons;
    }

    /**
     * Method to set the buttons
     * @param buttons - new buttons being set as buttons
     */
    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    /**
     * Method to get the column of the starting point
     * @return - returns the column of the starting point
     */
    public int getStartCol() {
        return startCol;
    }

    /**
     * Method to set the column of the starting point
     * @param startCol - column of the starting point
     */
    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }

    /**
     * Method to get the row of the starting point
     * @return - returns the row of the starting point
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * Method to set the row of the starting point
     * @param startRow - row of the starting point
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    /**
     * Method to get the column of the ending point
     * @return - returns the column of the ending point
     */
    public int getEndCol() {
        return endCol;
    }

    /**
     * Method to set the column of the ending point
     * @param endCol - column of the ending point
     */
    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }

    /**
     * Method to get the row of the ending point
     * @return - returns the row of the ending point
     */
    public int getEndRow() {
        return endRow;
    }
    
    /**
     * Method to set the row of the ending point
     * @param endRow - row the ending point
     */
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    // Instance methods
    public void saveGrid() {

    }

    public void loadGrid() {

    }

    /**
     * Method to display the buttons in a formatted 50 by 50 grid.
     * @return - JPanel object to be displayed to the frame
     */
    public JPanel displayGrid() {
        
        // Instantiate a new panel for the grid of buttons
        JPanel gridPanel = new JPanel();

        // Set the layout of the panel to grid layout of size 50 x 50
        gridPanel.setLayout(new GridLayout(ROWS, COLS));

        // Loop through each row
        for (int i = 0; i < ROWS; i++) {
            // Loop through each column
            for (int j = 0; j < COLS; j++) {
                // Instantiate new button and node at that position
                buttons[i][j] = new JButton();
                grid[i][j] = new Node(i, j);

                // Set the color of the button
                buttons[i][j].setBackground(grid[i][j].getColor());

                // Add the button the grid panel
                gridPanel.add(buttons[i][j]);
            }
        }
        return gridPanel;
    }

    /**
     * Method to get the attributes of the class and represent them as strings
     * @return - the formatted string
     */
    @Override
    public String toString() {
        return "Grid{" + "grid=" + Arrays.deepToString(grid) + ", buttons=" + Arrays.deepToString(buttons) + ", startCol=" + startCol + ", startRow=" + startRow + ", endCol=" + endCol + ", endRow=" + endRow + '}';
    }

}
