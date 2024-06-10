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
   int appleX;
   int appleY;
   char direction = 'R'; // direction is used to set the direction of the snake, and we initilized it to R(for right) so that the snake moves right when the game begins.
   boolean running = false;
   Timer timer;
   Random random;

   public GamePanel(){
   random = new Random();
   this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
   this.setBackground(Color.red);
   this.setFocusable(true);
   this.addKeyListener(new MyKeyAdapter());
   x[0]= 1*UNIT_SIZE;
   y[0]= 12*UNIT_SIZE;
      for (int i = bodyParts; i > 0 ; i--) {
         x[i] = x[0]-UNIT_SIZE; // initialising all x to one less than head
         y[i] = y[0]; // initialising all y of the body to head so that it is all in same line
      }
   startgame();

   }

   public void startgame(){
   newApple();
   running = true;
   timer = new Timer(DELAY,this); // the timer function keeps triggering the actionlistener after every set DELAY
   timer.start();
   }

   @Override
   public void paintComponent(Graphics g){
   super.paintComponent(g);
   draw(g);
   }

   public void draw(Graphics g){

      for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
         g.setColor(Color.black);
         g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
         g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
      }
      g.setColor(Color.blue);
      g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);

      for (int i = 0; i < bodyParts ; i++) {
         if(i==0) {
            g.setColor(Color.BLACK);
            g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
         } else {
            g.setColor(Color.white);
            g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);

         }

      }

   }

   public void newApple(){
   appleX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
   appleY = random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
   }

   public void move(){
      for (int i = bodyParts; i > 0 ; i--) {
         x[i] = x[i-1];
         y[i] = y[i-1];
      }
      switch (direction){
         case 'U':
            y[0] = y[0] - UNIT_SIZE;
            break;
         case 'D':
            y[0] = y[0] + UNIT_SIZE;
            break;
         case 'L':
            x[0] = x[0] - UNIT_SIZE;
            break;
         case 'R':
            x[0] = x[0] + UNIT_SIZE;
            break;

      }

   }
   //this method checks if the snake eats the apple
   public void checkApple(){

   }
   public void checkCollision(){
      for(int i = 1; i< bodyParts;i++){
         if(x[0] == x[i] && y[0]==y[i]) running =false; //checks if the snake has eaten itself
      }
      if((x[0] >= SCREEN_WIDTH) || (y[0] >= SCREEN_HEIGHT)|| (x[0] <= 0) || (y[0] <= 0)) {    // checks if the head reaches the boundary.
         running = false;
      }
      if(!running){
         timer.stop();
      }


   }
   public void gameOver(Graphics g){

   }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(running){
         move();
//         for (int i = 0; i < bodyParts; i++) {
//            System.out.println(x[i]);   // for visualising the movement of the snake
//         }
         checkCollision();
      }
      repaint();// repaint will trigger the paintComponent to re render the painting

    }

    public class MyKeyAdapter extends KeyAdapter{
       @Override
       public void keyPressed(KeyEvent e){
          switch (e.getKeyCode()){
             case KeyEvent.VK_LEFT:
                if(direction != 'R'){  //if the sanke is moving right then it shouldnt be able to turn left.
                   direction = 'L';
                }
                break;
             case KeyEvent.VK_RIGHT:
                if(direction != 'L'){
                   direction = 'R';
                }
                break;
             case KeyEvent.VK_UP:
                if(direction != 'D'){
                   direction = 'U';
                }
                break;
             case KeyEvent.VK_DOWN:
                if(direction != 'U'){
                   direction = 'D';
                }
                break;
          }

       }
    }

}
