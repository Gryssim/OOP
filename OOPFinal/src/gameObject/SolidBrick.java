package gameObject;

import commons.Commons;

import java.awt.*;

public class SolidBrick extends Brick implements Commons{

    private int hitCount = 0;

    SolidBrick(int _x, int _y){
        super(_x, _y, Color.BLACK);
        type = 1;
    }

    @Override
    public int setDestroyed(boolean _destroyed) {
        if (_destroyed) {
            if (hitCount <= 2) {
                hitCount++;
                this.isDestroyed = false;
                this.setColor(new Color(30, 30, 30));
            } else {
                this.isDestroyed = _destroyed;
                return 200;
            }
        }
        return 0;
    }
}
