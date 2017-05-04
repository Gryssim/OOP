package gameObject;

import java.awt.Color;
import java.util.Random;

import commons.Commons;

public class Ball extends GameObject implements Commons{

    private float xDir;
    private float yDir;
    private int radius;

    public Ball(int _radius, Color _color){
        this.xDir = 2;
        this.yDir = -2;
        this.radius = _radius;
        this.color = _color;
        this.objWidth = 2 * this.radius;
        this.objHeight = 2 * this.radius;

        resetState();
    }

    public Ball(int _radius, Color _color, int _x, int _y){
        this.xDir = 2;
        this.yDir = -2;
        this.radius = _radius;
        this.color = _color;
        this.objWidth = 2 * this.radius;
        this.objHeight = 2 * this.radius;
        this.locX = _x;
        this.locY = _y;
    }

    public void move(){
        locX += xDir;
        locY += yDir;

        if(locX <= 0){
            setXDir(2);
        }
        if(locX >= WINDOW_WIDTH - objWidth){
            setXDir(-2);
        }
        if(locY <= 0){
            setYDir(2);
        }
    }

    public void resetState(){
        Random rand = new Random();
        int xDir = 2;
        setYDir(-2);
        if(rand.nextInt(2) == 1) {
            setXDir(-2);
        }
        locX = BALL_X_START;
        locY = BALL_Y_START;
    }

    public void setXDir(float _xDir){
        xDir = _xDir;
    }

    public float getXdir(){
        return xDir;
    }

    public void setYDir(float _yDir){
        yDir = _yDir;
    }

    public float getYDir(){
        return yDir;
    }

}
