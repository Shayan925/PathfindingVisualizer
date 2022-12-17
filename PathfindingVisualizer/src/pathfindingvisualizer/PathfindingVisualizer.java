/*
 * Names: Shayan, Pareesh, & Kabir
 * Date: December 15th, 2022
 * Description: an application to visualize pathfinding algorithms.
 */
package pathfindingvisualizer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class PathfindingVisualizer extends javax.swing.JFrame implements MouseListener, MouseMotionListener {

    // Constant global variables
    final int BUTTON_WIDTH = 18;
    final int BUTTON_HEIGHT = 16;

    // Other global variables
    Credits otherWindow;
    Grid applicationGrid;
    boolean selectingStart = false;
    boolean selectingEnd = false;

    public PathfindingVisualizer() {
        initComponents();

        // Set some properties for the window
        setSize(920, 905);
        setLayout(new BorderLayout());

        // Instantiate new application grid
        applicationGrid = new Grid();

        // Add and display the grid and control panels to the frame
        add(applicationGrid.displayGrid(this), BorderLayout.CENTER);
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
        applicationGrid.loadGrid();
    }//GEN-LAST:event_menuItemLoadActionPerformed

    /**
     * Method to be executed when the user selects the credits option in the
     * menu
     *
     * @param evt
     */
    private void menuItemCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreditsActionPerformed
        // Check if the other window is not open
        if (otherWindow == null) {
            // Instantiate new credit window
            otherWindow = new Credits(this);
        }

        // Set the new window to be visible and the origianl window to be hidden
        otherWindow.setVisible(true);
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
        applicationGrid.saveGrid();
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

    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
            if (applicationGrid.getGrid()[row][col].setColor(Color.GREEN, applicationGrid.getButtons()[row][col])) {
                // Store the starting point coordinates
                applicationGrid.setStartPoint(row, col);
                
                // User is no longer selecting the starting point
                selectingStart = false;
            }
        } // Check if user is trying to place the destination node
        else if (selectingEnd) {
            // Check if the square is a valid ending point
            if (applicationGrid.getGrid()[row][col].setColor(Color.RED, applicationGrid.getButtons()[row][col])) {
                // Store the ending point coordinates
                applicationGrid.setEndPoint(row, col);

                // User is no longer selecting the ending point
                selectingEnd = false;
            }
        }// Otherwise user is placing or removing an obstacle
        else{
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
