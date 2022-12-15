/*
Name: 
Date: 
Description:
 */

package pathfindingvisualizer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PathfindingVisualizer extends javax.swing.JFrame {

    private JToolBar toolbar = new JToolBar();
    private JButton button1 = new JButton("Button 1");
    private JButton button2 = new JButton("Button 2");
    private JButton button3 = new JButton("Button 3");
    private JTextArea textArea = new JTextArea(10, 40);

    private int rows = 50;
    private int cols = 50;
    private JButton[][] buttons = new JButton[rows][cols];
    private int[][] grid = new int[rows][cols];
    private JButton startButton = new JButton("Search");
    private JButton resetButton = new JButton("Reset");
    
    public PathfindingVisualizer() {
        initComponents();
        
        setTitle("Pathfinding Visualizer");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // add the buttons to the toolbar
        toolbar.add(button1);
        toolbar.add(button2);
        toolbar.add(button3);

        // create a panel for the grid of buttons
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));

        // create the buttons and add them to the grid panel
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.WHITE);
                gridPanel.add(buttons[i][j]);
            }
        }

        // add the grid panel and control panel to the frame
        add(toolbar, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new PathfindingVisualizer().setVisible(true);
            }
        });
    }
    
        // create a panel for the start and reset buttons

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(resetButton);
        return controlPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
