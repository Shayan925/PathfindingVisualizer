/*
 * Names: Shayan, Pareesh, & Kabir
 * Date: December 15th, 2022
 * Description: the main graphics class to visualize pathfinding algorithms.
 */
package pathfindingvisualizer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.*;


public class PathfindingVisualizer extends javax.swing.JFrame implements MouseListener, MouseMotionListener {

    // Constant global variables
    final int BUTTON_WIDTH = 18;
    final int BUTTON_HEIGHT = 16;

    // Other global variables
    Credits creditWindow;
    Grid appGrid;
    JLabel seconds, numNodes;
    boolean selectingStart = false;
    boolean selectingEnd = false;
    boolean placeWalls = true;

    public PathfindingVisualizer() {
        initComponents();

        // Set some properties for the window
        setSize(920, 905);
        setLayout(new BorderLayout());
        setResizable(false);

        URL iconURL = getClass().getResource("/pathfindingvisualizer/Images/pathwayNEW.png");

        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());

        // Instantiate new application grid
        appGrid = new Grid();

        // Add and display the grid and control panels to the frame
        add(appGrid.displayGrid(this), BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AlgorithmButtonGroup = new javax.swing.ButtonGroup();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        menuItemLoad = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        spacing1 = new javax.swing.JMenu();
        EditMenu = new javax.swing.JMenu();
        menuItemSetStart = new javax.swing.JMenuItem();
        menuItemSetEnd = new javax.swing.JMenuItem();
        spacing2 = new javax.swing.JMenu();
        AlgorithmMenu = new javax.swing.JMenu();
        cBoxAStar = new javax.swing.JCheckBoxMenuItem();
        cBoxBfs = new javax.swing.JCheckBoxMenuItem();
        cBoxDepth = new javax.swing.JCheckBoxMenuItem();
        spacing3 = new javax.swing.JMenu();
        MoreMenu = new javax.swing.JMenu();
        menuEducation = new javax.swing.JMenu();
        menuEduLink1 = new javax.swing.JMenuItem();
        menuEduLink2 = new javax.swing.JMenuItem();
        menuEduLink3 = new javax.swing.JMenuItem();
        menuEduLink4 = new javax.swing.JMenuItem();
        menuEduLink5 = new javax.swing.JMenuItem();
        menuItemCredits = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pathfinding Visualizer");
        setBackground(new java.awt.Color(255, 255, 255));

        FileMenu.setText("File");

        menuItemLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/download.png"))); // NOI18N
        menuItemLoad.setText("Load Map");
        menuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLoadActionPerformed(evt);
            }
        });
        FileMenu.add(menuItemLoad);

        menuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/floppy-disk.png"))); // NOI18N
        menuItemSave.setText("Save Map");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        FileMenu.add(menuItemSave);

        MenuBar.add(FileMenu);

        spacing1.setEnabled(false);
        spacing1.setFocusable(false);
        MenuBar.add(spacing1);

        EditMenu.setText("Edit");

        menuItemSetStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/play-button.png"))); // NOI18N
        menuItemSetStart.setText("Set Starting Point");
        menuItemSetStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSetStartActionPerformed(evt);
            }
        });
        EditMenu.add(menuItemSetStart);

        menuItemSetEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/finish-flag.png"))); // NOI18N
        menuItemSetEnd.setText("Set Ending Point");
        menuItemSetEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSetEndActionPerformed(evt);
            }
        });
        EditMenu.add(menuItemSetEnd);

        MenuBar.add(EditMenu);

        spacing2.setEnabled(false);
        spacing2.setFocusable(false);
        MenuBar.add(spacing2);

        AlgorithmMenu.setText("Algorithm");

        AlgorithmButtonGroup.add(cBoxAStar);
        cBoxAStar.setSelected(true);
        cBoxAStar.setText("A* Search");
        AlgorithmMenu.add(cBoxAStar);

        AlgorithmButtonGroup.add(cBoxBfs);
        cBoxBfs.setText("Breadth First Search");
        AlgorithmMenu.add(cBoxBfs);

        AlgorithmButtonGroup.add(cBoxDepth);
        cBoxDepth.setText("Depth First Search");
        AlgorithmMenu.add(cBoxDepth);

        MenuBar.add(AlgorithmMenu);

        spacing3.setEnabled(false);
        spacing3.setFocusable(false);
        MenuBar.add(spacing3);

        MoreMenu.setText("More");

        menuEducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/education.png"))); // NOI18N
        menuEducation.setText("Educational Resources");

        menuEduLink1.setText("Stanford A*");
        menuEduLink1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEduLink1ActionPerformed(evt);
            }
        });
        menuEducation.add(menuEduLink1);

        menuEduLink2.setText("Baeldund Breath-First");
        menuEduLink2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEduLink2ActionPerformed(evt);
            }
        });
        menuEducation.add(menuEduLink2);

        menuEduLink3.setText("Geeksfor Geeks Depth-First");
        menuEduLink3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEduLink3ActionPerformed(evt);
            }
        });
        menuEducation.add(menuEduLink3);

        menuEduLink4.setText("Medium - Pathfinding");
        menuEduLink4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEduLink4ActionPerformed(evt);
            }
        });
        menuEducation.add(menuEduLink4);

        menuEduLink5.setText("neo4j - Pathfinding");
        menuEduLink5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEduLink5ActionPerformed(evt);
            }
        });
        menuEducation.add(menuEduLink5);

        MoreMenu.add(menuEducation);

        menuItemCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/stage.png"))); // NOI18N
        menuItemCredits.setText("Credits");
        menuItemCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreditsActionPerformed(evt);
            }
        });
        MoreMenu.add(menuItemCredits);

        MenuBar.add(MoreMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method to be executed when the user selects the load map option in the
     * menu
     *
     * @param evt - event
     */
    private void menuItemLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoadActionPerformed
        // Call the grid's load grid method
        appGrid.loadGrid();
    }//GEN-LAST:event_menuItemLoadActionPerformed

    /**
     * Method to be executed when the user selects the credits option in the
     * menu
     *
     * @param evt - event
     */
    private void menuItemCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreditsActionPerformed
        // Check if the other window is not open
        if (creditWindow == null) {
            // Instantiate new credit window
            creditWindow = new Credits(this);
        }

        // Set the new window to be visible and the origianl window to be hidden
        creditWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemCreditsActionPerformed

    /**
     * Method to be executed when the user selects the save map option in the
     * menu
     *
     * @param evt - event
     */
    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        // Call the grid's save grid method
        appGrid.saveGrid();
    }//GEN-LAST:event_menuItemSaveActionPerformed

    /**
     * Method to be executed when the user selects the set starting point option
     * in the menu
     *
     * @param evt - event
     */
    private void menuItemSetStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSetStartActionPerformed
        // Display instructions to place starting node
        JOptionPane.showMessageDialog(this, "Select any square to place the starting point.");

        // Set the selecting start variable to true and the other one to false
        selectingStart = true;
        selectingEnd = false;
    }//GEN-LAST:event_menuItemSetStartActionPerformed

    /**
     * Method to be executed when the user selects the set ending point option
     * in the menu
     *
     * @param evt - event
     */
    private void menuItemSetEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSetEndActionPerformed
        // Display instructions to place ending node
        JOptionPane.showMessageDialog(this, "Select any square to place the ending point.");

        // Set the selecting end variable to true and the other one to false
        selectingEnd = true;
        selectingStart = false;
    }//GEN-LAST:event_menuItemSetEndActionPerformed

    /**
     * Method to be executed when the user selects "Stanford A*"
     *
     * @param evt - event
     */
    private void menuEduLink1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEduLink1ActionPerformed
        // Instantiate new desktop object
        Desktop browser = Desktop.getDesktop();
        try {
            // Try opening the link with the default browser
            browser.browse(new URI("http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html"));
            //catch errors
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_menuEduLink1ActionPerformed

    /**
     * Method to be executed when the user selects Baeldung Breadth First Search
     *
     * @param evt - event
     */
    private void menuEduLink2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEduLink2ActionPerformed
        // Instantiate new desktop object
        Desktop browser = Desktop.getDesktop();
        try {
            // Try opening the link with the default browser
            browser.browse(new URI("https://www.baeldung.com/java-breadth-first-search"));
            //catch errors
        } catch (IOException | URISyntaxException err) {

        }
    }//GEN-LAST:event_menuEduLink2ActionPerformed

    /**
     * Method to be executed when the user selects Geeks for Geeks Depth first
     * search
     *
     * @param evt - event
     */
    private void menuEduLink3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEduLink3ActionPerformed
        // Instantiate new desktop object
        Desktop browser = Desktop.getDesktop();
        try {
            // Try opening the link with the default browser
            browser.browse(new URI("https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/"));
            //catch errors
        } catch (IOException | URISyntaxException err) {

        }
    }//GEN-LAST:event_menuEduLink3ActionPerformed

    /**
     * Method to be executed when the user selects medium.com pathfinding
     * 
     * @param evt - event
     */
    private void menuEduLink4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEduLink4ActionPerformed
        // Instantiate new desktop object
        Desktop browser = Desktop.getDesktop();
        try {
            // Try opening the link with the default browser
            browser.browse(new URI("https://medium.com/@urna.hybesis/pathfinding-algorithms-the-four-pillars-1ebad85d4c6b"));
            //catch errors
        } catch (IOException | URISyntaxException err) {

        }
    }//GEN-LAST:event_menuEduLink4ActionPerformed

    /**
     * Method to be executed when the user selects neo4j.com pathfinding
     * 
     * @param evt - event 
     */
    private void menuEduLink5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEduLink5ActionPerformed
        // Instantiate new desktop object
        Desktop browser = Desktop.getDesktop();
        try {
            // Try opening the link with the default browser
            browser.browse(new URI("https://neo4j.com/developer/graph-data-science/path-finding-graph-algorithms/"));
            //catch errors
        } catch (IOException | URISyntaxException err) {

        }
    }//GEN-LAST:event_menuEduLink5ActionPerformed

    /**
     * Method to be executed when the search button is clicked
     */
    private void searchButtonActionPerformed() {
        int path;
        long startTime, endTime, duration;

        // Record the current time in milliseconds
        startTime = System.currentTimeMillis();

        // Check if A* is the selected check box
        if (AlgorithmButtonGroup.getSelection() == cBoxAStar.getModel()) {
            path = Search.aStarSearch(appGrid);
        }// Check if depth first is the selected check box
        else if (AlgorithmButtonGroup.getSelection() == cBoxDepth.getModel()) {
            path = Search.depthFirstSearch(appGrid);
        } // Otherwise the breadth first search is the selected check box
        else {
            path = Search.breadthFirstSearch(appGrid);
        }

        // Record the time after the search is performed
        endTime = System.currentTimeMillis();

        // Check if the path exists
        if (path != -1) {
            // Display the shortest path starting from the ending node
            Search.displayShortestPath(appGrid.getGrid()[appGrid.getEndRow()][appGrid.getEndCol()], appGrid);

            // Calculate the duration the search took
            duration = (endTime - startTime);

            // Display the time the search took
            seconds.setText((double) duration / 1000.0 + " sec ");

            // Display the number of nodes searched
            numNodes.setText(path + " ");

        } // Otherwise path does not exist
        else {
            // Display message to the user to place starting or ending points or remove walls
            JOptionPane.showMessageDialog(this, "A path could not be found. Either remove some obstacles or place both the starting and ending points");
        }
    }

    /**
     * Method to clear the search path.
     */
    private void clearPathButtonActionPerformed() {
        //loop through double for loop for each tile in the colums and rows
        for (int i = 0; i < Grid.NUM_ROWS; i++) {
            for (int j = 0; j < Grid.NUM_COLS; j++) {
                // Check if the node color is yellow
                if (appGrid.getGrid()[i][j].getColor() == Color.YELLOW) {
                    // Set it back to white
                    appGrid.getGrid()[i][j].setColor(Color.WHITE, appGrid.getButtons()[i][j]);
                }
            }
        }
    }

    /**
     * Resets board tiles, and start and end points
     */
    private void resetButtonActionPerformed() {
        //loop through double for loop for each tile in the colums and rows
        for (int i = 0; i < Grid.NUM_ROWS; i++) {
            for (int j = 0; j < Grid.NUM_COLS; j++) {
                //Create a new node for each tile
                appGrid.getGrid()[i][j] = new Node(i, j);
                //change the colour of the tile to white
                appGrid.getGrid()[i][j].setColor(Color.WHITE, appGrid.getButtons()[i][j]);
                //Get rid of start point
                appGrid.setStartPoint(-1, -1);
                //Get rid of end point
                appGrid.setEndPoint(-1, -1);
            }
        }
    }

    public static void main(String args[]) {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PathfindingVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PathfindingVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PathfindingVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PathfindingVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PathfindingVisualizer p = new PathfindingVisualizer();
                p.setVisible(true);

                // Display the welcome message
                JOptionPane.showMessageDialog(p, "To begin click the 'Edit' menu and set the starting and ending points.\n"
                        + "Next, left click on the mouse to place obstacles and right click to remove them.\n"
                        + "Once you are satisfied with the layout of the grid select the desired\n"
                        + "sorting algorithm under 'Algorithm' and press the search button.",
                        "Welcome to the Pathfinding Visualizer Application!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * Method to create the panel at the bottom of the application.
     *
     * @return - JPanel object representing the panel to be displayed
     */
    private JPanel createControlPanel() {
        // Instantiate a new panel
        JPanel controlPanel = new JPanel();

        // Instantiate the search, clear path, and reset buttons
        JButton searchButton = new JButton("Search");
        JButton clearPathButton = new JButton("Clear Path");
        JButton resetButton = new JButton("Reset");

        // Add an action listener for the search button to detect when it is clicked
        searchButton.addActionListener((ActionEvent e) -> {
            // Call the method to handle the search button action
            searchButtonActionPerformed();
        });

        // Add an action listener for the clear path button to detect when it is clicked
        clearPathButton.addActionListener((ActionEvent e) -> {
            // Call the method to handle the clear path button action
            clearPathButtonActionPerformed();
        });

        // Add an action listener for reset button to detect when it is clicked
        resetButton.addActionListener((ActionEvent e) -> {
            // Call the method to handle the reset button action
            resetButtonActionPerformed();
        });

        // Instantiate the time and nodes searched labels
        JLabel searchTime = new JLabel(" Time: ");
        JLabel nodesSearched = new JLabel("Nodes Searched: ");
        seconds = new JLabel(" ");
        numNodes = new JLabel(" ");

        // Set font of label and button text
        searchTime.setFont(new Font("Courier New", Font.BOLD, 20));
        nodesSearched.setFont(new Font("Courier New", Font.BOLD, 20));
        seconds.setFont(new Font("Courier New", Font.PLAIN, 20));
        numNodes.setFont(new Font("Courier New", Font.PLAIN, 20));
        searchButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        resetButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        clearPathButton.setFont(new Font("Courier New", Font.PLAIN, 20));

        // Add the buttons and labels to the panel
        controlPanel.add(searchTime);
        controlPanel.add(seconds);
        controlPanel.add(nodesSearched);
        controlPanel.add(numNodes);
        controlPanel.add(searchButton);
        controlPanel.add(clearPathButton);
        controlPanel.add(resetButton);

        return controlPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Get the button that was clicked
        JButton button = (JButton) e.getSource();

        // Calculate the row and column of the button that was clicked
        int row = button.getY() / BUTTON_HEIGHT;
        int col = button.getX() / BUTTON_WIDTH;

        // Check if user is trying to place the starting node
        if (selectingStart) {
            // Check if the square is a valid starting point
            if (appGrid.getGrid()[row][col].setColor(Color.GREEN, appGrid.getButtons()[row][col])) {
                // Store the starting point coordinates
                appGrid.setStartPoint(row, col);

                // User is no longer selecting the starting point
                selectingStart = false;
            }
        } // Check if user is trying to place the destination node
        else if (selectingEnd) {
            // Check if the square is a valid ending point
            if (appGrid.getGrid()[row][col].setColor(Color.RED, appGrid.getButtons()[row][col])) {
                // Store the ending point coordinates
                appGrid.setEndPoint(row, col);

                // User is no longer selecting the ending point
                selectingEnd = false;
            }
        } // Check if user is placing a wall
        else if (placeWalls) {
            // Color the square black
            appGrid.getGrid()[row][col].setColor(Color.BLACK, appGrid.getButtons()[row][col]);
        } // Check if user is removing a wall
        else if (!placeWalls) {
            // Check if we are trying to remove a starting or ending point
            if (!((col == appGrid.getStartCol() && row == appGrid.getStartRow()) || (col == appGrid.getEndCol() && row == appGrid.getEndRow()))) {
                // Remove the wall by coloring the square white because square is not a starting or ending point
                appGrid.getGrid()[row][col].setColor(Color.WHITE, appGrid.getButtons()[row][col]);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Check if left mouse button is pressed down
        if (e.getButton() == MouseEvent.BUTTON1) {
            // User wants to place walls
            placeWalls = true;
        } // Check if right mouse button is pressed down
        else if (e.getButton() == MouseEvent.BUTTON3) {
            // User wants to remove walls
            placeWalls = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int col, row;

        // Get the position of the mouse
        Point p1 = MouseInfo.getPointerInfo().getLocation();

        // Get the position of the frame
        Point p2 = this.getLocation();

        // Calculate the mouse coordinates relative to frame and adjust the location by a few pixels
        col = (int) p1.getX() - (int) p2.getX() - 10;
        row = (int) p1.getY() - (int) p2.getY() - 54;

        // Calculate the row and column of the button that the mouse is 
        col /= BUTTON_WIDTH;
        row /= BUTTON_HEIGHT;

        // Check if the button is on the grid and the left mouse button is being held down
        if (Search.isValid(col, row) && placeWalls) {
            // Place a wall by coloring the square black
            appGrid.getGrid()[row][col].setColor(Color.BLACK, appGrid.getButtons()[row][col]);
        } // Check if the button is on the grid and the right mouse button is being held down
        else if (Search.isValid(col, row) && !placeWalls) {
            // Check if we are trying to remove a starting or ending point
            if (!((col == appGrid.getStartCol() && row == appGrid.getStartRow()) || (col == appGrid.getEndCol() && row == appGrid.getEndRow()))) {
                // Remove the wall by coloring the square white because square is not a starting or ending point
                appGrid.getGrid()[row][col].setColor(Color.WHITE, appGrid.getButtons()[row][col]);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup AlgorithmButtonGroup;
    private javax.swing.JMenu AlgorithmMenu;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MoreMenu;
    private javax.swing.JCheckBoxMenuItem cBoxAStar;
    private javax.swing.JCheckBoxMenuItem cBoxBfs;
    private javax.swing.JCheckBoxMenuItem cBoxDepth;
    private javax.swing.JMenuItem menuEduLink1;
    private javax.swing.JMenuItem menuEduLink2;
    private javax.swing.JMenuItem menuEduLink3;
    private javax.swing.JMenuItem menuEduLink4;
    private javax.swing.JMenuItem menuEduLink5;
    private javax.swing.JMenu menuEducation;
    private javax.swing.JMenuItem menuItemCredits;
    private javax.swing.JMenuItem menuItemLoad;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSetEnd;
    private javax.swing.JMenuItem menuItemSetStart;
    private javax.swing.JMenu spacing1;
    private javax.swing.JMenu spacing2;
    private javax.swing.JMenu spacing3;
    // End of variables declaration//GEN-END:variables
}
