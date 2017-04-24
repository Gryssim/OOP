import javax.swing.*;
import java.awt.*;
import window.Window;
import window.GamePanel;
import commons.Commons;
import gameObject.*;

public class Main extends Object implements Commons {

  static final String WINDOW_TITLE = "BreakoutOOP";

  public static void main(String[] args){
    //Do main stuff here
    //JPanel newPanel = new JPanel();
    Window window = new Window(
        Commons.WINDOW_WIDTH,
        Commons.WINDOW_HEIGHT,
        WINDOW_TITLE);

    //GamePanel gamePanel = new GamePanel(new Color(80, 108, 128));
    window.getFrame().add(new GamePanel(new Color(80, 108, 128)));
  }

}
