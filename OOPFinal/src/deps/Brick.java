package gameObject;

import javax.swing.*;
import java.awt.Color;
import commons.Commons;

public class Brick extends GameObject{
  private boolean isDestroyed;

  public Brick(int _x, int _y, Color _color){
    this.locX = _x;
    this.locY = _y;
    this.objHeight = Commons.HEIGHT;
    this.objWidth = Commons.WIDTH;
    this.color = _color;

    isDestroyed = false;
  }

  public boolean getDestroyed(){
    return isDestroyed;
  }

  public void setDestroyed(boolean _destroyed){
    this.isDestroyed = _destroyed;
  }
}
