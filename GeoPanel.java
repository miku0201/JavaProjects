package Projects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GeoPanel extends JPanel implements ActionListener, KeyListener {

    private int width;
    private int height;
    private int squareX;
    private int squareY;
    private int squareWidth;
    private int squareHeight;
    private int enemyX;
    private int enemyY;
    private int enemywidth;
    private int enemyheight;
    private int jumpDistance;
    private boolean jumping;
    private Timer timer;
    private JLabel score,ending;
    private int count;

    public GeoPanel(int w, int h) {
        super();
        width = w;
        height = h;
        squareWidth = 50;
        squareHeight = 50;
        squareX = width / 2 - squareWidth / 2;
        squareY = height - squareHeight - 50;
        enemywidth = 50;
        enemyheight = 50;
        enemyX = 0;
        enemyY = height - enemyheight - 50;
        jumpDistance = 200;
        jumping = false;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(10, this);
        timer.start();
        
        
        ending = new JLabel("");
        count = 0;
        score = new JLabel("Score is "+count);
        add(score);
        add(ending);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.cyan);
        g.setColor(Color.BLACK);
        g.fillRect(squareX, squareY, squareWidth, squareHeight);
        g.setColor(Color.RED);
        g.fillRect(enemyX, enemyY, enemywidth, enemyheight);
        g.setColor(Color.green);
        g.fillRect(0, 750, 800, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (jumping) {
            squareY -= 5;
        	count++;
        	
			score.setText("Score is "+count/30 );
            if (squareY <= height - jumpDistance - squareHeight) {
                jumping = false;
            }
        } else {
            squareY += 5;
            if (squareY >= height - squareHeight - 50) {
                squareY = height - squareHeight - 50;
            }
        }
        enemyX += 5;
        if (enemyX > width) {
            enemyX = 0 - enemywidth;
        }
        if (checkCollision()) {
            System.out.println("Collision!");
            timer.stop();
            ending.setText("Game Over");
        }
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
            jumping = true;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    private boolean checkCollision() {
        if (squareX + squareWidth > enemyX && squareX < enemyX + enemywidth && squareY + squareHeight > enemyY) {
            return true;
        }
        return false;
    }
}




