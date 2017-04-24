package window;

import javax.swing.*;
import java.awt.*;

public class Window{

  private JFrame frame;
  private JPanel panel;

  public Window(int width, int height, String title){
    frame = new JFrame(title);
    frame.setSize(width, height);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public JFrame getFrame(){
    return frame;
  }
}
