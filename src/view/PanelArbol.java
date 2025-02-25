/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import data.Pokemon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.BinarySearchTree;


/**
 *
 * @author Windows 10
 */
public class PanelArbol extends JPanel {

    BinarySearchTree<Pokemon> arbol;

    public PanelArbol(BinarySearchTree<Pokemon> arbol) {
        this.arbol = arbol;
        setPreferredSize(new Dimension(600,400));
    }
    
    public int dibujarArbol(Graphics g, BinarySearchTree.Node x, int x0, int x1, int y) {

        int m = (x0 + x1) / 2;
        if (x != null) {
            g.setColor(Color.blue);
            g.fillOval(m, y, 50, 40);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            String t = String.valueOf(x.data.toString());
            g.drawString(t, m + 20, y + 30);
            if (x.left != null) {
                int x2 = dibujarArbol(g, x.left, x0, m, y + 50);
                g.drawLine(m + 25, y + 40, x2 + 25, y + 50);
            }
            if (x.right != null) {
                int x2 = dibujarArbol(g, x.right, m, x1, y + 50);
                g.drawLine(m + 25, y + 40, x2 + 25, y + 50);
            }
            return m;
        }
        return m = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dibujarArbol(g, arbol.getRaiz(), 0, this.getWidth() - 25, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
