package com.kiran;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(){
    //all these are done to setup the jFrame. These are methods of JFrame and these methods returntype is void
    this.add(new GamePanel());
    this.setTitle("__SnakeGame__");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    }
}
