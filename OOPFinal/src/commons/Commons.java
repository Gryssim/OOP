package commons;

public interface Commons {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 20;
    public static final int BOTTOM_OF_WINDOW = 590;
    public static final int BRICKS_PER_ROW = (Math.floorDiv(WINDOW_WIDTH, WIDTH) - 1);
    public static final int BRICK_ROWS = 10;
    public static final int NUM_BRICKS = BRICKS_PER_ROW * BRICK_ROWS;
    public static final int PADDLE_X_START = WINDOW_WIDTH / 2 - WIDTH;
    public static final int PADDLE_Y_START = 560;
    public static final int BALL_X_START = 230;
    public static final int BALL_Y_START = 530;
    public static final int BALL_RADIUS = 10;
    public static final int DELAY = 1000;
    public static final int PERIOD = 10;
}
