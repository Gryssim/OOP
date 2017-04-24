package gameObject;

import java.awt.Color;
import commons.Commons;

public class Ball extends GameObject{

  private int xDir;
  private int yDir;
  private int radius;

  public Ball(int _radius, Color _color){
    this.xDir = 1;
    this.yDir = -1;
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
      setXDir(1);
    }
    if(locX == Commons.WINDOW_WIDTH - objWidth){
      setXDir(-1);
    }
    if(locY == 0){
      setYDir(1);
    }
  }

  public void resetState(){
    locX = Commons.BALL_X_START;
    locY = Commons.BALL_Y_START;
  }

  public void setXDir(int _xDir){
    xDir = _xDir;
  }

  public int getXdir(){
    return xDir;
  }

  public void setYDir(int _yDir){
    yDir = _yDir;
  }

  public   int getYDir(){
    return yDir;
  }

}
