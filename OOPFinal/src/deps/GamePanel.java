package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import gameObject.Paddle;
import gameObject.Brick;
import gameObject.Ball;
import commons.Commons;

public class GamePanel extends JPanel implements Commons{

  private String message = "Game Over";
  private Timer timer;
  private Ball ball;
  private Paddle paddle;
  private Brick bricks[];
  private boolean inGame = true;
  private Color[] colors = {
    Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
    Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
    Color.YELLOW
  };

  public GamePanel(Color backColor){
    this.setBackground(backColor);
    initPanel();

  }

  public void initPanel(){

    addKeyListener(new TAdapter());
    setFocusable(true);


    bricks = new Brick[Commons.NUM_BRICKS];
    setDoubleBuffered(true);
    timer = new Timer();
    timer.scheduleAtFixedRate(new ScheduleTask(), Commons.DELAY, Commons.PERIOD);
  }

  @Override
  public void addNotify(){
    super.addNotify();
    gameInit();
  }

  public void gameInit(){
    ball = new Ball(Commons.BALL_RADIUS, new Color(180, 180, 180));
    paddle = new Paddle(Commons.WIDTH, Commons.HEIGHT, Color.BLACK);
    int k = 0;
    for (int i = 0; i < 10; i++ ) {
      for (int j = 0; j < 5; j++){
        bricks[k] = new Brick((j * 155 + 17),  (i * 25 + 25), colors[i % 9]);
        k++;
      }
    }
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    if (inGame){

      drawObjects(g2d);
    }
    else {
      gameFinished(g2d);
    }

    Toolkit.getDefaultToolkit().sync();
  }

  private void drawObjects(Graphics2D g2d){
    //Bricks from 25 to 775
    try{
      for(int i = 0; i < Commons.NUM_BRICKS; i++){
        if (!bricks[i].getDestroyed()){
          g2d.setColor(bricks[i].getColor());
          g2d.fillRoundRect(bricks[i].getLocX(), bricks[i].getLocY(),
          bricks[i].getWidth(), bricks[i].getHeight(),
          2, 2 );
        }
      }
    } catch (NullPointerException e){
      //System.out.println(bricks[1]);
    }
    g2d.setColor(ball.getColor());
    g2d.fillOval(ball.getLocX(), ball.getLocY(), ball.getWidth(), ball.getHeight());

    g2d.setColor(paddle.getColor());
    Rectangle rect = paddle.getRect();
    //g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
    g2d.fillRoundRect(rect.x, rect.y, rect.width, rect.height, 10, 10);
  }

  private void gameFinished(Graphics2D g2d){
    Font font = new Font("Courier New", Font.BOLD, 20);
    FontMetrics metr = this.getFontMetrics(font);

    g2d.setColor(Color.BLACK);
    g2d.setFont(font);
    g2d.drawString(message ,(Commons.WINDOW_WIDTH - metr.stringWidth("Game Over")) / 2, Commons.WINDOW_WIDTH / 2);


  }

  private class TAdapter extends KeyAdapter{
    @Override
    public void keyReleased(KeyEvent e){
      paddle.keyReleased(e);
    }

    @Override
    public void keyPressed(KeyEvent e){
      paddle.keyPressed(e);
    }
  }
  private class ScheduleTask extends TimerTask{
    @Override
    public void run(){
      paddle.move();
      ball.move();
      checkCollision();
      repaint();
    }
  }

  private void stopGame(){
      inGame = false;
      timer.cancel();
  }

  private void checkCollision(){
    if (ball.getRect().getMaxY() > Commons.BOTTOM_OF_WINDOW){
      stopGame();
    }

    for (int i = 0, j = 0; i < Commons.NUM_BRICKS; i++){
      if (bricks[i].getDestroyed()){
        j++;
      }

      if (j == Commons.NUM_BRICKS){
        message = "Victory";
        stopGame();
      }
    }

    if ((ball.getRect()).intersects(paddle.getRect())){
      int paddleLeftPos = (int) paddle.getRect().getMinX();
      int ballLeftPos = (int) ball.getRect().getMinX();

      int quad1 = paddleLeftPos + 30;
      int quad2 = paddleLeftPos + 60;
      int quad3 = paddleLeftPos + 90;
      int quad4 = paddleLeftPos + 120;

      if(ballLeftPos < quad1){
        ball.setXDir(-1);
        ball.setYDir(-1);
      }

      if(ballLeftPos >= quad1 && ballLeftPos < quad2){
        ball.setXDir(-1);
        ball.setYDir(-1 * ball.getYDir());
      }

      if(ballLeftPos >= quad2 && ballLeftPos < quad3){
        ball.setXDir(0);
        ball.setYDir(-1);
      }

      if(ballLeftPos >= quad3 && ballLeftPos < quad4){
        ball.setXDir(1);
        ball.setYDir(-1);
      }

      if (ballLeftPos > quad4){
        ball.setXDir(1);
        ball.setYDir(-1);
      }
    }

    for (int i = 0; i < NUM_BRICKS; i++){
      if ((ball.getRect()).intersects(bricks[i].getRect())){
        int ballLeft = (int) ball.getRect().getMinX();
        int ballHeight = (int) ball.getRect().getHeight();
        int ballWidth = (int) ball.getRect().getWidth();
        int ballTop = (int) ball.getRect().getMinY();

        Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
        Point pointLeft = new Point(ballLeft - 1, ballTop);
        Point pointTop = new Point(ballLeft, ballTop - 1);
        Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

        if (!bricks[i].getDestroyed()){
          if (bricks[i].getRect().contains(pointRight)){
            ball.setXDir(1);
          } else if(bricks[i].getRect().contains(pointLeft)){
            ball.setXDir(-1);
          }

          if(bricks[i].getRect().contains(pointTop)){
            ball.setYDir(1);
          } else if(bricks[i].getRect().contains(pointBottom)) {
            ball.setYDir(-1);
          }
          bricks[i].setDestroyed(true);
        }
      }
    }
  }
}
