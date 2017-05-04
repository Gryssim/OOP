package gameObject;

import java.awt.Color;
import commons.Commons;

public class Brick extends GameObject implements Commons{

    protected boolean isDestroyed;
    protected int type = 0;

    public Brick(int _x, int _y, Color _color){
        this.locX = _x;
        this.locY = _y;
        this.objHeight = HEIGHT;
        this.objWidth = WIDTH;
        this.color = _color;

        isDestroyed = false;
    }

    public int getType(){ return type; }

    public boolean getDestroyed(){
        return isDestroyed;
    }

    public int setDestroyed(boolean _destroyed){
        this.isDestroyed = _destroyed;
        return 100;
    }
}
