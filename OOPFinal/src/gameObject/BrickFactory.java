package gameObject;

import java.awt.*;

public class BrickFactory {

    public Brick createBrick(String brickType, int x, int y, Color color){
        if(brickType.equalsIgnoreCase("STANDARD")) {
            return new Brick(x, y, color);
        }
        else if(brickType.equalsIgnoreCase("POWER")){
            return new PowerBrick(x, y, color);
        }
        else if(brickType.equalsIgnoreCase("SOLID")){
            return new SolidBrick(x, y);
        }
        return null;
    }
}
