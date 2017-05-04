package gameObject;

import commons.Commons;

import java.awt.*;
import java.util.Random;

public class BallFactory implements Commons{

    private Color[] colors = {
            Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
            Color.YELLOW
    };

    public Ball createBall(String ballType){
        Random rand = new Random();
        if (ballType.equalsIgnoreCase("BALL")){
            return new Ball(Commons.BALL_RADIUS, colors[rand.nextInt(colors.length)] );
        }

        return null;
    }

}
