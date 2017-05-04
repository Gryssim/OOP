package gameObject;

import commons.Commons;

import java.awt.*;

public class PowerBrick extends Brick implements Commons{

    PowerBrick(int _x, int _y, Color _color){
        super(_x, _y, _color);
        type = 2;
    }
    @Override
    public int setDestroyed(boolean _destroyed){
        this.isDestroyed = _destroyed;
        return 500;
    }

}
