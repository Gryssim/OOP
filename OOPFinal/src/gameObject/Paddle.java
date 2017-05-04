package gameObject;


import commons.Commons;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends GameObject implements Commons{

    private float xVel;

    public Paddle(int _width, int _height, Color _color){
        objWidth = _width;
        objHeight = _height;
        color = _color;

        resetPos();
    }

    public void move(){
        locX += xVel;

        if (locX <= 0){
            locX = 0;
        }

        if (locX >= WINDOW_WIDTH - objWidth ){
            locX = WINDOW_WIDTH - objWidth;
        }
        if (xVel != 0){
            if(xVel < 0){
                xVel += 0.25;
            }
            else if (xVel > 0){
                xVel -= 0.25;
            }
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT){
            if (xVel >= -5){
                xVel = -5;
            }
        }

        if (key == KeyEvent.VK_RIGHT){
            if (xVel <= 5){
                xVel = 5;
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
            if (xVel != 0){
                if(xVel < 0){
                    xVel += 1;
                }
                else{
                    xVel -= 1;
                }
            }
        }
    }
    private void resetPos(){
        locX = PADDLE_X_START;
        locY = PADDLE_Y_START;
    }
}
