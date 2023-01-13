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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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

        // No starting or ending point
        this.startCol = -1;
        this.startRow = -1;
        this.endCol = -1;
        this.endRow = -1;
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
        // Check if there is already a starting point
        if (this.startRow != -1 && this.startCol != -1) {
            // Set the colour of the old starting point back to white
            grid[this.startRow][this.startCol].setColor(Color.WHITE, buttons[this.startRow][this.startCol]);
        }

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
        // Check if there is already an ending point
        if (this.endRow != -1 && this.endCol != -1) {
            // Set the colour of the old ending point back to white
            grid[this.endRow][this.endCol].setColor(Color.WHITE, buttons[this.endRow][this.endCol]);
        }

        // Set the coordinates of the new ending point
        this.endRow = endRow;
        this.endCol = endCol;
    }

    // Instance methods
    /**
     * Method to save the grid layout as a comma separated value (CSV) file.
     */
    public void saveGrid() {
        //Selects the path in which the file will be saved
        JFileChooser fileChooser = new JFileChooser("src/pathfindingvisualizer");
        
        // Filter so user can only choose .csv files
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
        fileChooser.setAcceptAllFileFilterUsed(true);
        
        // Displays save dialog for the user
        fileChooser.showSaveDialog(null);

        // Try the following code
        try {

            // Writes to the file
            FileWriter fileWriter;
            fileWriter = new FileWriter(fileChooser.getSelectedFile() + ".csv");

            //Runs for each row in the grid
            for (Node[] nodes : grid) {
                // Declares string variable to hold info
                String data = "";

                // Iterates through the grid
                for (Node node : nodes) {
                    // If the node is white or yellow save as none
                    if (node.getColor().equals(Color.WHITE)) {
                        data += "none,";
                    } // If node is black save as wall
                    else if (node.getColor().equals(Color.BLACK)) {
                        data += "wall,";
                    } // If node is green save as start
                    else if (node.getColor().equals(Color.GREEN)) {
                        data += "start,";
                    } // If node is red save as end
                    else if (node.getColor().equals(Color.RED)) {
                        data += "end,";
                    }
                }

                // Add new line to the data string variable
                data += "\n";

                //Writes the data variable to the selected file
                fileWriter.write(data);
            }
            //Closes the file writer
            fileWriter.close();

        } catch (java.io.IOException e) {
            // Print the error message
            System.out.println("Error: " + e);
        }

    }

    /**
     * Method to load the CSV file.
     */
    public void loadGrid() {
        // Using this process to invoke the constructor,
        // JFileChooser points to project directory
        JFileChooser fileChooser = new JFileChooser("src/pathfindingvisualizer");
        
        // Filter so user can only choose .csv files
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        // Open the save dialog  
        fileChooser.showOpenDialog(null);

        // Try the following code
        try {

            // Retrives the file selected by user
            File chosenFile = fileChooser.getSelectedFile();

            // Scanner scans the file selected by user
            Scanner s = new Scanner(chosenFile);

            // Loops through each row
            for (int k = 0; k < NUM_ROWS; k++) {
                // Seperates the words using the comma and stores them in the array
                String values[] = s.nextLine().split(",");

                // Loops through each value in the values array
                for (int i = 0; i < values.length; i++) {
                    // Check if the word is none 
                    if (values[i].equals("none")) {
                        // Replace original node with a new white node
                        grid[k][i] = new Node(k, i);
                        grid[k][i].setColor(Color.WHITE, buttons[k][i]);
                    } // Check if the word is wall
                    else if (values[i].equals("wall")) {
                        // Replace original node with a new black node
                        grid[k][i] = new Node(k, i);
                        grid[k][i].setColor(Color.BLACK, buttons[k][i]);
                    } // Check if the word is start
                    else if (values[i].equals("start")) {
                        // Replace original node with a new green node
                        grid[k][i] = new Node(k, i);
                        grid[k][i].setColor(Color.GREEN, buttons[k][i]);

                        //Set the startcol to the i value
                        startCol = i;
                        //Set the startrow to the k value
                        startRow = k;

                    } // Check if the word is end 
                    else if (values[i].equals("end")) {
                        // Replace original node with a new red node
                        grid[k][i] = new Node(k, i);
                        grid[k][i].setColor(Color.RED, buttons[k][i]);
                        //Set the endcol to the i value
                        endCol = i;
                        //Set the endrow to the k value
                        endRow = k;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
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
        return "Grid{" + "grid=" + Arrays.deepToString(grid) + ", startCol=" + startCol + ", startRow=" + startRow + ", endCol=" + endCol + ", endRow=" + endRow + '}';
    }

}
