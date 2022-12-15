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
    public Node[][] getGrid() {
        return grid;
    }

    public void setGrid(Node[][] grid) {
        this.grid = grid;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public int getStartCol() {
        return startCol;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndCol() {
        return endCol;
    }

    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }

    public int getEndRow() {
        return endRow;
    }

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
