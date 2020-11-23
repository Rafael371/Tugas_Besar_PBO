/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class Garis extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    public Garis(){
        setPreferredSize(new Dimension(500, 400));
    }
    public void paint(Graphics g){
        g.drawLine(0, 66, 400, 66);
        g.drawLine(0, 88, 400, 88);
        g.drawLine(200, 66, 200, 400);
    }

    @Override
    public void run() {
    
    }
}
