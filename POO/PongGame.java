import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new PongFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class Ball {

    private static final int DIAMETER = 15;
    private static final int INITIAL_X = 200;
    private static final int INITIAL_Y = 200;

    private double x = INITIAL_X;
    private double y = INITIAL_Y;
    private double dx = 1;
    private double dy = 1;

    public void move(Rectangle2D limits) {
        x += dx;
        y += dy;

        if (x < limits.getMinX() || x + DIAMETER >= limits.getMaxX()) {
            dx = -dx;
        }

        if (y < limits.getMinY() || y + DIAMETER >= limits.getMaxY()) {
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, DIAMETER, DIAMETER);
    }

    public void invertDx() {
        dx = -dx;
    }

    public void reset() {
        x = INITIAL_X;
        y = INITIAL_Y;
    }
}

class Paddle {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 60;
    private static final int INITIAL_X = 380;
    private static final int INITIAL_Y = 170;

    private int x = INITIAL_X;
    private int y = INITIAL_Y;
    private int dy = 0;

    public void move() {
        y += dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void reset() {
        y = INITIAL_Y;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}

class PaddlePanel extends JPanel {

    private Paddle paddle;

    public PaddlePanel(Paddle aPaddle) {
        paddle = aPaddle;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(paddle.getBounds());
    }

    public Paddle getPaddle() {
        return paddle;
    }
}

class PaddleThread implements Runnable {

    private Paddle paddle;
    private PaddlePanel paddlePanel;

    public PaddleThread(Paddle aPaddle, PaddlePanel aPaddlePanel) {
        paddle = aPaddle;
        paddlePanel = aPaddlePanel;
    }

    public void run() {
        while (true) {
            paddle.move();
            paddlePanel.repaint();

            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BallThread implements Runnable {

    private Ball ball;
    private PongPanel pongPanel;
    private Paddle paddle;

    public BallThread(Ball aBall, PongPanel aPongPanel, Paddle aPaddle) {
        ball = aBall;
        pongPanel = aPongPanel;
        paddle = aPaddle;
    }

    public void run() {
        while (true) {
            ball.move(pongPanel.getBounds());
            checkPaddleCollision();
            checkRestart();
            pongPanel.repaint();

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkPaddleCollision() {
        if (ball.getShape().intersects(paddle.getBounds())) {
            ball.invertDx();
        }
    }

    private void checkRestart() {
        Rectangle2D bounds = pongPanel.getBounds();
        if (ball.getShape().getMaxX() >= bounds.getMaxX()) {
            ball.reset();
        }
    }
}

class PongPanel extends JPanel {

    private Ball ball;
    private Paddle paddle;

    public PongPanel(Ball aBall, Paddle aPaddle) {
        ball = aBall;
        paddle = aPaddle;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e);
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    private void handleKeyPress(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            paddle.setDy(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            paddle.setDy(1);
        }
    }

    private void handleKeyRelease(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            paddle.setDy(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(ball.getShape());
        g2.fill(paddle.getBounds());
    }

    public Paddle getPaddle() {
        return paddle;
    }
}

class PongFrame extends JFrame {

    private PongPanel pongPanel;
    private PaddlePanel paddlePanel;

    public PongFrame() {
        setBounds(600, 300, 415, 415);
        setResizable(false);
        setTitle("Pong Game");

        Ball ball = new Ball();
        Paddle paddle = new Paddle();
        pongPanel = new PongPanel(ball, paddle);
        paddlePanel = new PaddlePanel(paddle);

        add(pongPanel, BorderLayout.CENTER);
        add(paddlePanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                startGame();
            }
        });
        addButton(buttonPanel, "Quit", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }

    private void startGame() {
        Ball ball = new Ball();
        Paddle paddle = new Paddle();
        pongPanel = new PongPanel(ball, paddle);
        paddlePanel = new PaddlePanel(paddle);

        add(pongPanel, BorderLayout.CENTER);
        add(paddlePanel, BorderLayout.EAST);
        revalidate();

        pongPanel.requestFocusInWindow();

        Runnable ballThread = new BallThread(ball, pongPanel, paddle);
        Thread ballThreadInstance = new Thread(ballThread);
        ballThreadInstance.start();

        Runnable paddleThread = new PaddleThread(paddle, paddlePanel);
        Thread paddleThreadInstance = new Thread(paddleThread);
        paddleThreadInstance.start();
    }
}
