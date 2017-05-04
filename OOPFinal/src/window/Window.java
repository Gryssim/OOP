package window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{


    private GamePanel gamePanel = new GamePanel(new Color(80, 108, 128));

    public Window(int width, int height, String title){

        add(gamePanel);
        setTitle(title);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }
}
