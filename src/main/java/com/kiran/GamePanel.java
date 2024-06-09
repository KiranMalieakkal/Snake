package com.kiran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

   static final int SCREEN_WIDTH = 600;
   static final int SCREEN_HEIGHT = 600;
   static final int UNIT_SIZE = 25;
   static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
   static final int DELAY = 75;
   //These Arrays are going to hold all the coordinates of the snake body parts
   final int[] x = new int[GAME_UNITS];
   final int[] y = new int[GAME_UNITS];
   int bodyParts = 6;
   int applesEaten = 0;
   int AppleX;
   int AppleY;
   char direction = 'R'; // direction is used to set the direction of the snake, and we initilized it to R(for right) so that the sanke moves right when the game begins.
   boolean running = false;
   Timer timer;
   Random random;

   public GamePanel(){
   random = new Random();
   this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
   this.setBackground(Color.black);
   this.setFocusable(true);
   this.addKeyListener(new MyKeyAdapter());
   startgame();
   }

   public void startgame(){

   }

   public void paintComponent(Graphics g){

   }

   public void draw(Graphics g){

   }

   public void newApple(){

   }

   public void move(){

   }
   //this method checks if the snake eats the apple
   public void checkApple(){

   }
   public void checkCollision(){

   }
   public void gameOver(Graphics g){

   }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{
       @Override
       public void keyPressed(KeyEvent e){

       }
    }

}
