package org.example;

import org.example.components.GamePanel;

import java.awt.*;

import static org.example.components.CustomizationFrame.colorRandom;
import static org.example.components.CustomizationFrame.randomColor;

public class BodyPart {
    private int x;
    private int y;
    private Color color = UniversalColor.colorBody;

    public BodyPart(int x, int y){
        this.x = x;
        this.y = y;
    }

    //========== GETTERS ==========

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }


    //========== SETTERS ==========

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, getX(), getY(), color);
    }
}