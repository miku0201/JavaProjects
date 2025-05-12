


package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 800;
    private final int UNIT_SIZE = 25;
    private final int GAME_UNITS = (B_WIDTH * B_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    private final int DELAY = 100;
    private final int[] x1 = new int[GAME_UNITS];
    private final int[] y1 = new int[GAME_UNITS];
    private final int[] x2 = new int[GAME_UNITS];
    private final int[] y2 = new int[GAME_UNITS];
    private int bodyParts1 = 6;
    private int bodyParts2 = 6;
    private int fruitsEaten1;
    private int fruitsEaten2;
    private int fruitX;
    private int fruitY;
    private final char[] directions = {'R', 'L', 'U', 'D'};
    private char direction1 = 'R';
    private char direction2 = 'L';
    private boolean running = false;
    private Timer timer;
    private final ArrayList<Point> fruits = new ArrayList<>();
    private final ArrayList<Point> barriers = new ArrayList<>();

    public SnakeGame() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    private void startGame() {
        fruits.clear();
        barriers.clear();
        running = true;
        fruitsEaten1 = 0;
        fruitsEaten2 = 0;
        bodyParts1 = 6;
        bodyParts2 = 6;
        direction1 = 'R';
        direction2 = 'L';
        for (int i = 0; i < bodyParts1; i++) {
            x1[i] = 75 - i * UNIT_SIZE;
            y1[i] = 75;
        }
        for (int i = 0; i < bodyParts2; i++) {
            x2[i] = B_WIDTH - 75 + i * UNIT_SIZE;
            y2[i] = B_HEIGHT - 75;
        }
        timer = new Timer(DELAY, this);
        timer.start();
        addFruit();
        addBarrier();
    }

    private void move() {
        for (int i = bodyParts1; i > 0; i--) {
            x1[i] = x1[i - 1];
            y1[i] = y1[i - 1];
        }
        for (int i = bodyParts2; i > 0; i--) {
            x2[i] = x2[i - 1];
            y2[i] = y2[i - 1];
        }

        switch (direction1) {
            case 'U':
                y1[0] = y1[0] - UNIT_SIZE;
                break;
            case 'D':
                y1[0] = y1[0] + UNIT_SIZE;
                break;
            case 'L':
                x1[0] = x1[0] - UNIT_SIZE;
                break;
            case 'R':
                x1[0] = x1[0] + UNIT_SIZE;
                break;
        }
        switch (direction2) {
            case 'U':
                y2[0] = y2[0] - UNIT_SIZE;
                break;
            case 'D':
                y2[0] = y2[0] + UNIT_SIZE;
                break;
            case 'L':
                x2[0] = x2[0] - UNIT_SIZE;
                break;
            case 'R':
                x2[0] = x2[0] + UNIT_SIZE;
                break;
        }
    }

    private void checkFruit() {
        if (x1[0] == fruitX && y1[0] == fruitY) {
            fruitsEaten1++;
            addFruit();
            bodyParts1++;
        }
        if (x2[0] == fruitX && y2[0] == fruitY) {
            fruitsEaten2++;
            addFruit();
            bodyParts2++;
        }
    }

    private void checkCollisions() {
        // Check if snake 1 collides with the barriers
        for (int i = 0; i < barriers.size(); i++) {
            if (x1[0] == barriers.get(i).x && y1[0] == barriers.get(i).y) {
                running = false;
            }
        }

        // Check if snake 2 collides with the barriers
        for (int i = 0; i < barriers.size(); i++) {
            if (x2[0] == barriers.get(i).x && y2[0] == barriers.get(i).y) {
                running = false;
            }
        }

        // Check if snake 1 collides with itself
        for (int i = bodyParts1; i > 0; i--) {
            if (x1[0] == x1[i] && y1[0] == y1[i]) {
                running = false;
            }
        }

        // Check if snake 2 collides with itself
        for (int i = bodyParts2; i > 0; i--) {
            if (x2[0] == x2[i] && y2[0] == y2[i]) {
                running = false;
            }
        }

        // Check if snake 1 collides with snake 2
        for (int i = 0; i < bodyParts2; i++) {
            if (x1[0] == x2[i] && y1[0] == y2[i]) {
                running = false;
            }
        }

        // Check if snake 2 collides with snake 1
        for (int i = 0; i < bodyParts1; i++) {
            if (x2[0] == x1[i] && y2[0] == y1[i]) {
                running = false;
            }
        }

        // Check if snake 1 collides with the boundaries
        if (x1[0] < 0 || x1[0] >= B_WIDTH || y1[0] < 0 || y1[0] >= B_HEIGHT) {
            running = false;
        }

        // Check if snake 2 collides with the boundaries
        if (x2[0] < 0 || x2[0] >= B_WIDTH || y2[0] < 0 || y2[0] >= B_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    private void addFruit() {
        int randomX = new Random().nextInt(B_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int randomY = new Random().nextInt(B_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        Point fruit = new Point(randomX, randomY);
        fruits.add(fruit);
    }

    private void addBarrier() {
        int randomX = new Random().nextInt(B_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int randomY = new Random().nextInt(B_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        Point barrier = new Point(randomX, randomY);
        barriers.add(barrier);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (running) {
            // Draw the barriers
            for (int i = 0; i < barriers.size(); i++) {
                g.setColor(Color.red);
                g.fillRect(barriers.get(i).x, barriers.get(i).y, UNIT_SIZE, UNIT_SIZE);
            }

            // Draw the fruits
            for (int i = 0; i < fruits.size(); i++) {
                g.setColor(Color.green);
                g.fillOval(fruits.get(i).x, fruits.get(i).y, UNIT_SIZE, UNIT_SIZE);
            }

            // Draw snake 1
            for (int i = 0; i < bodyParts1; i++) {
                if (i == 0) {
                    g.setColor(Color.blue);
                    g.fillRect(x1[i], y1[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x1[i], y1[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            // Draw snake 2
            for (int i = 0; i < bodyParts2; i++) {
                if (i == 0) {
                    g.setColor(Color.yellow);
                    g.fillRect(x2[i], y2[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(255, 255, 0));
                    g.fillRect(x2[i], y2[i], UNIT_SIZE, UNIT_SIZE);
                }
           }

            // Draw the score
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Player 1: " + fruitsEaten1, 10, 30);
            g.drawString("Player 2: " + fruitsEaten2, 10, 60);
        } else {
            gameOver(g);
        }
    }
    

    private void gameOver(Graphics g) {
        // Game over text
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (B_WIDTH - metrics.stringWidth("Game Over")) / 2, B_HEIGHT / 2);

        
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player 1: " + fruitsEaten1, 10, 30);
        g.drawString("Player 2: " + fruitsEaten2, 10, 60);

         }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFruit();
            checkCollisions();
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction1 != 'R') {
                        direction1 = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction1 != 'L') {
                        direction1 = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction1 != 'D') {
                        direction1 = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction1 != 'U') {
                        direction1 = 'D';
                    }
                    break;
                case KeyEvent.VK_A:
                    if (direction2 != 'R') {
                        direction2 = 'L';
                    }
                    break;
                case KeyEvent.VK_D:
                    if (direction2 != 'L') {
                        direction2 = 'R';
                    }
                    break;
                case KeyEvent.VK_W:
                    if (direction2 != 'D') {
                        direction2 = 'U';
                    }
                    break;
                case KeyEvent.VK_S:
                    if (direction2 != 'U') {
                        direction2 = 'D';
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if (!running) {
                        startGame();
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}



