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
import javax.swing.*;

public class PathfindingVisualizer extends javax.swing.JFrame implements MouseListener, MouseMotionListener {

    // Constant global variables
    final int BUTTON_WIDTH = 18;
    final int BUTTON_HEIGHT = 16;

    // Other global variables
    Credits creditWindow;
    Grid appGrid;
    boolean selectingStart = false;
    boolean selectingEnd = false;
    boolean placeWalls = true;

    public PathfindingVisualizer() {
        initComponents();

        // Set some properties for the window
        setSize(920, 905);
        setLayout(new BorderLayout());
        setResizable(false);

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
        cBoxDijkstra = new javax.swing.JCheckBoxMenuItem();
        cBoxBfs = new javax.swing.JCheckBoxMenuItem();
        spacing3 = new javax.swing.JMenu();
        MoreMenu = new javax.swing.JMenu();
        menuItemResources = new javax.swing.JMenuItem();
        menuItemCredits = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pathfinding Visualizer");

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

        AlgorithmButtonGroup.add(cBoxDijkstra);
        cBoxDijkstra.setText("Dijkstra Search");
        AlgorithmMenu.add(cBoxDijkstra);

        AlgorithmButtonGroup.add(cBoxBfs);
        cBoxBfs.setText("Breadth First Search");
        AlgorithmMenu.add(cBoxBfs);

        MenuBar.add(AlgorithmMenu);

        spacing3.setEnabled(false);
        spacing3.setFocusable(false);
        MenuBar.add(spacing3);

        MoreMenu.setText("More");

        menuItemResources.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pathfindingvisualizer/Images/education.png"))); // NOI18N
        menuItemResources.setText("Educational Resources");
        menuItemResources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemResourcesActionPerformed(evt);
            }
        });
        MoreMenu.add(menuItemResources);

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
     * @param evt
     */
    private void menuItemLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoadActionPerformed
        // Call the grid's load grid method
        appGrid.loadGrid();
    }//GEN-LAST:event_menuItemLoadActionPerformed

    /**
     * Method to be executed when the user selects the credits option in the
     * menu
     *
     * @param evt
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
     * @param evt
     */
    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        // Call the grid's save grid method
        appGrid.saveGrid();
    }//GEN-LAST:event_menuItemSaveActionPerformed

    /**
     * Method to be executed when the user selects the set starting point option
     * in the menu
     *
     * @param evt
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
     * @param evt
     */
    private void menuItemSetEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSetEndActionPerformed
        // Display instructions to place ending node
        JOptionPane.showMessageDialog(this, "Select any square to place the ending point.");

        // Set the selecting end variable to true and the other one to false
        selectingEnd = true;
        selectingStart = false;
    }//GEN-LAST:event_menuItemSetEndActionPerformed

    /**
     * Method to be executed when the user selects the educational resources
     * option in the menu
     *
     * @param evt
     */
    private void menuItemResourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemResourcesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemResourcesActionPerformed

    /**
     * Method to be executed when the search button is clicked
     */
    private void searchButtonActionPerformed() {
        int path;

        // Check if A* is the selected check box
        if (AlgorithmButtonGroup.getSelection() == cBoxAStar.getModel()) {
            path = Search.aStarSearch(null);
        }// Check if Dijsktra is the selected check box
        else if (AlgorithmButtonGroup.getSelection() == cBoxDijkstra.getModel()) {
            path = Search.dijkstraSearch(null);
        } // Otherwise the breadth first search is the selected check box
        else {
            path = Search.breadthFirstSearch(appGrid);
        }

        // Check if the path exists
        if (path != -1) {
            // Display the shortest path starting from the ending node
            Search.displayShortestPath(appGrid.getGrid()[appGrid.getEndRow()][appGrid.getEndCol()], appGrid);
        } // Otherwise path does not exist
        else {
            // Display message to the user to place starting or ending points or remove walls
            JOptionPane.showMessageDialog(this, "A path could not be found. Either remove some obstacles or place both the starting and ending points");
        }
    }

    /**
     * Method to be executed when the reset button is clicked
     */
    private void resetButtonActionPerformed() {

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

        // Instantiate the search and reset buttons
        JButton searchButton = new JButton("Search");
        JButton resetButton = new JButton("Reset");

        // Add an action listener for the search button to detect when it is clicked
        searchButton.addActionListener((ActionEvent e) -> {
            // Call the method to handle the search button action
            searchButtonActionPerformed();
        });

        // Add an action listener for reset button to detect when it is clicked
        resetButton.addActionListener((ActionEvent e) -> {
            // Call the method to handle the reset button action
            resetButtonActionPerformed();
        });

        // Instantiate the time and nodes searched labels
        JLabel searchTime = new JLabel(" Time: ");
        JLabel nodesSearched = new JLabel("Nodes Searched: ");

        // Set font of label and button text
        searchTime.setFont(new Font("Courier New", Font.BOLD, 20));
        nodesSearched.setFont(new Font("Courier New", Font.BOLD, 20));
        searchButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        resetButton.setFont(new Font("Courier New", Font.PLAIN, 20));

        // Add the buttons and labels to the panel
        controlPanel.add(searchTime);
        controlPanel.add(nodesSearched);
        controlPanel.add(searchButton);
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
    private javax.swing.JCheckBoxMenuItem cBoxDijkstra;
    private javax.swing.JMenuItem menuItemCredits;
    private javax.swing.JMenuItem menuItemLoad;
    private javax.swing.JMenuItem menuItemResources;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSetEnd;
    private javax.swing.JMenuItem menuItemSetStart;
    private javax.swing.JMenu spacing1;
    private javax.swing.JMenu spacing2;
    private javax.swing.JMenu spacing3;
    // End of variables declaration//GEN-END:variables
}
