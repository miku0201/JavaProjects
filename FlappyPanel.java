package Projects;


//all imports are necessary
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



//import motionGraphics.MotionPanel.MoveListener;

import java.awt.Color;

//must 'extend' JPanel 
public class FlappyPanel extends JPanel
{
	//variables for the overall width and height
	private int w, h;
	private int pX, pY, jump;
	private int SPEED = 10;
	private int FREE_FALL_SPEED_Y = 8;
	private int MoveSpeedX = -5;
	private Timer fallTimer;
	private Timer moveTimer;
	private Boolean space;
	private int box1Y, box2Y, box1length, box2length, rando;
	private int boxX, L;
	private Rectangle bird;
	private Rectangle box1;
	private Rectangle box2;
	private int count;
	private JLabel score;
	
	 private static final long serialVersionUID = 1L;
	    private final int WIDTH = 800;
	    private final int HEIGHT = 800;
	    private final int TILE_SIZE = 15;
	    private int[][] map;
	//sets up the initial panel for drawing with proper size
	public FlappyPanel(int w, int h)
	{
		
		
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		pX = 100;
		pY = 100;
		
		fallTimer = new Timer(40, new MoveListener() );

		fallTimer.start();
		
		moveTimer = new Timer(10, new MoveListener());
		
		jump = 10;   
		
		
		int boxYPosition = 300;//generator.nextInt(650)+1;
	
		//box1Y = generator.nextInt(150)+650;
		//box2Y = generator.nextInt(650)+1;
		
		
		
	
		int boxXPosition = 700;
		boxX = boxXPosition;
		
		//box1length = box1Y+800;
	//	box2length = box2Y+800;
		
		this.addKeyListener(new KL());
		this.setFocusable(true);
		
		bird = new Rectangle(pX, pY, 75, 50);
		box1 = new Rectangle(boxX, 0, 70, box1Y);
		box2 = new Rectangle(boxX, 150+box1Y, 70, 800);
		
		count = 0;
		
		score = new JLabel("Score is "+count);

      add(score);
      
      map = new int[HEIGHT / TILE_SIZE][WIDTH / TILE_SIZE];
      for (int i = 0; i < map.length; i++) {
          for (int j = 0; j < map[0].length; j++) {
              map[i][j] = (int) (Math.random() * 3);
          }
      }
      
	}

	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics g)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(g);
		
		//all drawings below here:
		
		this.setBackground(Color.WHITE);
		
		  for (int i = 0; i < map.length; i++) {
	            for (int j = 0; j < map[0].length; j++) {
	                switch (map[i][j]) {
	                    case 0:
	                        g.setColor(Color.MAGENTA);
	                        break;
	                    case 1:
	                        g.setColor(Color.cyan);
	                        break;
	                    case 2:
	                        g.setColor(Color.white);
	                        break;
	                }
	                g.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	            }
	        }
		  
		//body
		g.setColor(Color.yellow);
		g.fillOval(pX, pY, 75, 50);
		//eye
		g.setColor(Color.black);
		g.fillOval(pX+50, pY+10, 10, 10);
		
		//beak
		g.setColor(Color.orange);
		int[] xpoints = {pX+70, pX+75, pX+90};
		int[] ypoints = {pY+10, pY+25, pY+30};
		
		g.fillPolygon(xpoints, ypoints, xpoints.length);
		
		
		
		//barrel 1
		
		g.setColor(Color.black);
			g.fillRect(boxX, 0, 70, box1Y);//320);
		
				
		//barrel 2
		g.setColor(Color.black);
	g.fillRect(boxX, 150+box1Y, 70, 800);//330);

	//barrier for bird
	g.setColor(Color.yellow);
	g.drawRect(pX, pY, 75, 50);
		
	//barrier for barrel1
	g.setColor(Color.red);
	g.drawRect(boxX, 0, 70, box1Y);
	
	//barrier for barrel2
	g.setColor(Color.red);
	g.drawRect(boxX, 150+box1Y, 70, 800);
	
	
	
	
	}
	
	private class AL implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			 
			// TODO Auto-generated method stub
			update();
		}
		
	}
	//For the timer:
		private class MoveListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Random generator = new Random();

			
				pY+=FREE_FALL_SPEED_Y;
				//moveY+=5;
				  if(pY >= h-50)
				  {
					 pY = h-50;
					    // System.exit(0);
				  }
				//update graphics
				  
				boxX+=MoveSpeedX;  
				if(boxX == 0)
				{
					boxX = 650;
					count++;
					score.setText("Score is "+count);
			
				box1Y = generator.nextInt(650)+1;
				box2Y = generator.nextInt(650)+1;
				}
				
				
				
			
				
				
				
				bird.setBounds(pX, pY, 75, 50);
				box1.setBounds(boxX, 0, 70, L+box1Y);
				box2.setBounds(boxX, 150+box1Y, 70, L+800);
				
				if(bird.intersects(box1))
				{
					pX = pX-50;
					System.exit(0);
				}
				
				if(bird.intersects(box2))
				{
					pX = pX-50;
					System.exit(0);
				}
			

			
				
				if(pY <= 0)
				{
					pY = 50;
				System.exit(0);
				}
			
								
				
				
			
				
				repaint();
			}
		}
		

		 
		
		//updates directional speed via the keylistener 
		private void update() 
		{
		   
		    if(space) 
		    {
		 		  jump++;
		 		  pY = pY -50;
		 		  
		    }
		    	
		    repaint();
		}
		
		private class KL implements KeyListener
		{

			@Override
			public void keyTyped(KeyEvent e)
			{
				
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
					space = true; 
			//	System.out.println("Space");
				//System.out.println("moveY " + FREE_FALL_SPEED_Y);
			//	System.out.println("SPEED " + SPEED);
		//		System.out.println("pX " + pX);
		//		System.out.println("pY " + pY);
		//		System.out.println("moveTimer " + fallTimer);
				update();
		
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

		
			
		}
		
		
}




