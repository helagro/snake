package org.example;

import org.example.components.GamePanel;

import java.awt.*;
import java.util.Random;


public class Apple {
    private int x;
    private int y;
    private Color color = Settings.getInstance().appleColor;

    //========== CONSTRUCTOR ==========

    public Apple(){
        
    }

    //========== GETTERS ==========

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    //========== LOGIC ==========

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, this.x, this.y, this.color);
    }

    public void getEaten(GamePanel gamePanel){
        if(gamePanel.noEmptySpots()) return;
        moveToEmptySpot(gamePanel);
    }

    public void moveToEmptySpot(GamePanel gamePanel){
        Random random = new Random();
        int x;
        int y;

        do { 
            x = random.nextInt(GamePanel.GRID_WIDTH);
            y = random.nextInt(GamePanel.GRID_HEIGHT);
            gamePanel.repaint();
        } while(!gamePanel.isSpaceEmpty(x, y));

        this.x = x;
        this.y = y;
    }
}