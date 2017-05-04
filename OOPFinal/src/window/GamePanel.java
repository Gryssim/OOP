package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import gameObject.*;
import commons.Commons;

public class GamePanel extends JPanel implements Commons{

    private Random rand = new Random();
    private BrickFactory BrickFactory = new BrickFactory();
    private BallFactory BallFactory = new BallFactory();
    private int count = 0;
    private int lives = 5;
    private int score = 0;
    private String message = "Game Over";
    private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks = new Brick[Commons.NUM_BRICKS];
    private boolean inGame = true;
    private Color[] colors = {
            Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
            Color.YELLOW
    };

    GamePanel(Color backColor){
        setBackground(backColor);
        initPanel();
    }

    private void initPanel(){

        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);
    }

    @Override
    public void addNotify(){
        super.addNotify();
        gameInit();
    }

    private void gameInit(){
        Random rand = new Random();
        ball =  BallFactory.createBall("BALL");
        paddle = new Paddle(150, Commons.HEIGHT, Color.BLACK);
        int k = 0;
        for (int i = 0; i < Commons.BRICK_ROWS; i++ ) {
            for (int j = 0; j < Commons.BRICKS_PER_ROW; j++){
                int nextInt = rand.nextInt(101);
                String nextBrickType = "STANDARD";
                if(nextInt >= 98){
                    nextBrickType = "POWER";
                } else if(nextInt >= 90 && nextInt < 98){
                    nextBrickType = "SOLID";
                }
                bricks[k] = BrickFactory.createBrick(nextBrickType, (j * Commons.WIDTH + 37),  (i * Commons.HEIGHT + 30), colors[i % 9]);
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

        Font font = new Font("Courier New", Font.BOLD, 15);
        g2d.setFont(font);
        String scoreString = "Score: " + score;
        g2d.drawString("Lives: " + lives, 10, 22);
        g2d.drawString(scoreString, WINDOW_WIDTH - (scoreString.length() * font.getSize()), 22);
        //Bricks from 25 to 775
        try{
            for(int i = 0; i < NUM_BRICKS; i++){
                if (!bricks[i].getDestroyed()){
                    if(bricks[i].getType() == 2) {
                        int r = bricks[i].getColor().getRed();
                        int g = bricks[i].getColor().getGreen();
                        int b = bricks[i].getColor().getBlue();
                        bricks[i].setColor(new Color((r + 2) % 255, (g + 3) % 255, (b + 4) % 255));
                    }

                    g2d.setColor(bricks[i].getColor());
                    g2d.fillRoundRect(bricks[i].getLocX(), bricks[i].getLocY(),
                            bricks[i].getWidth() - 2, bricks[i].getHeight() - 2,
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
        g2d.drawString(message ,(WINDOW_WIDTH - metr.stringWidth(message)) / 2, WINDOW_WIDTH / 2);
        g2d.drawString("Score: " + Integer.toString(score), (WINDOW_WIDTH - metr.stringWidth("Score: " + Integer.toString(score))) / 2, (WINDOW_WIDTH / 2) + 100);


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
            count += 1;
            paddle.move();
            ball.move();
            checkCollision();
            repaint();
            if (score > 0 && count % 100 == 0){
                score -= 10;
            }
        }
    }

    private void stopGame(){
        inGame = false;
        timer.cancel();
    }

    private void checkCollision() {

        if (ball.getRect().getMaxY() > BOTTOM_OF_WINDOW) {
            if (lives > 0) {
                lives -= 1;
                if ((score - 1000) > 0)
                    score -= 1000;
                else
                    score = 0;
                ball = BallFactory.createBall("BALL");
            } else {
                stopGame();
            }
        }

        for (int i = 0, j = 0; i < NUM_BRICKS; i++) {
            if (bricks[i].getDestroyed()) {
                j++;
            }

            if (j == NUM_BRICKS) {
                message = "Victory";
                stopGame();
            }
        }

        if ((ball.getRect()).intersects(paddle.getRect())) {
            int paddleLeftPos = (int) paddle.getRect().getMinX();
            int ballLeftPos = (int) ball.getRect().getMinX();

            int quad1 = paddleLeftPos + 30;
            int quad2 = paddleLeftPos + 60;
            int quad3 = paddleLeftPos + 90;
            int quad4 = paddleLeftPos + 120;

            if (ballLeftPos < quad1) {
                ball.setXDir(-2);
                ball.setYDir(-2);
            }

            if (ballLeftPos >= quad1 && ballLeftPos < quad2) {
                ball.setXDir(-2);
                ball.setYDir(-2 * ball.getYDir());
            }

            if (ballLeftPos >= quad2 && ballLeftPos < quad3) {
                ball.setXDir(0);
                ball.setYDir(-4);
            }

            if (ballLeftPos >= quad3 && ballLeftPos < quad4) {
                ball.setXDir(2);
                ball.setYDir(-2 * ball.getYDir());
            }

            if (ballLeftPos > quad4) {
                ball.setXDir(2);
                ball.setYDir(-2);
            }
        }

        for (int i = 0; i < NUM_BRICKS; i++) {
            if ((ball.getRect()).intersects(bricks[i].getRect())) {
                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].getDestroyed()) {
                    if (bricks[i].getRect().contains(pointRight)) {
                        ball.setXDir(2);
                    } else if (bricks[i].getRect().contains(pointLeft)) {
                        ball.setXDir(-2);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {
                        ball.setYDir(2);
                    } else if (bricks[i].getRect().contains(pointBottom)) {
                        ball.setYDir(-2);
                    }
                    if (bricks[i].setDestroyed(true) == 500) {
                        BallFactory.createBall("BALL");
                    }

                    score += bricks[i].setDestroyed(true);
                }
            }
        }
    }
}
