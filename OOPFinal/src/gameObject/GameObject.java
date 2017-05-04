package gameObject;

import java.awt.Color;
import java.awt.Rectangle;

public class GameObject{
    protected int locX;
    protected int locY;

    protected int objWidth;
    protected int objHeight;

    protected Color color;

    public int getLocX(){
        return locX;
    }

    public void setLocX(int _locX){
        this.locX = _locX;
    }

    public int getLocY(){
        return locY;
    }

    public void setLocY(int _locY){
        this.locY = _locY;
    }

    public int getWidth(){
        return objWidth;
    }

    public void setWidth(int _width){
        this.objWidth = _width;
    }

    public int getHeight(){
        return objHeight;
    }

    public void setHeight(int _height){
        this.objHeight = _height;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color _color){
        this.color = _color;
    }

    public Rectangle getRect(){
        return new Rectangle(locX , locY, objWidth - 2, objHeight - 2);
    }

}
