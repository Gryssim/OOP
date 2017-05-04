package gameObject;

import java.awt.Color;
import commons.Commons;

public class Ball extends GameObject{

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

  public void move(){
    locX += xDir;
    locY += yDir;

    if(locX == 0){
      setXDir(2);
    }
    if(locX == Commons.WINDOW_WIDTH - objWidth){
      setXDir(-2);
    }
    if(locY == 0){
      setYDir(2);
    }
  }

  public void resetState(){
    locX = Commons.BALL_X_START;
    locY = Commons.BALL_Y_START;
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
