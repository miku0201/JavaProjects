package Projects;


import java.awt.Color;
//all imports are necessary
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//must 'extend' JPanel 
//You can rename the class to anything you wish - default is 'PanelTemplate'
public class RoulettePanel extends JPanel
{
	//variables for the overall width and height
	private int w, h,x,y;
	private JRadioButton six,two,eight,four;
	private ButtonGroup bg;
	private ArrayList<Integer> xPoints,yPoints;
	private int nPoints,balance = 1000,wager,num;
	private JLabel bal;
	private JTextField inputs;

	private JCheckBox five,one,seven,three;

	//sets up the initial panel for drawing with proper size
	public RoulettePanel(int w, int h)
	{
		
	

		xPoints=new ArrayList<Integer>();
		yPoints=new ArrayList<Integer>();
		
		bal = new JLabel("Balance:$"+balance);
	
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		 x = 200;
		 y = 200;
		 
		
		 bg = new ButtonGroup();
		one = new JCheckBox("one");
		two = new JRadioButton("two");
		three = new JCheckBox("three");
		four = new JRadioButton("four");
		five = new JCheckBox("five");
		six = new JRadioButton("six");
		seven = new JCheckBox("seven");
		eight = new JRadioButton("eight");
		inputs = new JTextField(30);
		
	bg.add(one);	
	bg.add(two);
	bg.add(three);
	bg.add(four);
	bg.add(five);
	bg.add(six);
	bg.add(seven);
	bg.add(eight);
	
	one.addActionListener(new ButtonListener());
	two.addActionListener(new ButtonListener());
	three.addActionListener(new ButtonListener());
	four.addActionListener(new ButtonListener());
	five.addActionListener(new ButtonListener());
	six.addActionListener(new ButtonListener());
	seven.addActionListener(new ButtonListener());
	eight.addActionListener(new ButtonListener());
	
	add(one);
	add(two);
	add(three);
	add(four);
	add(five);
	add(six);
	add(seven);
	add(eight);
	add(bal);
	add(inputs);
	

System.out.println("Enter amount you wish to gamble in the textfield");
	
	System.out.println("Choose a number to bet on");
	

	}
	
	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics g)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(g);
		
		//all drawings below here:
		this.setBackground(Color.red);
		


g.setColor(Color.red);

nPoints=xPoints.size();

xPoints.add(x);
xPoints.add(260);
xPoints.add(400);

yPoints.add(400);
yPoints.add(260);
yPoints.add(400);



xPoints.add(400);
xPoints.add(400);
xPoints.add(x+50);


yPoints.add(300);
yPoints.add(600);
yPoints.add(550);
//4th triangle counter clockwise
xPoints.add(400);
xPoints.add(400);
xPoints.add(540);

yPoints.add(x+200);
yPoints.add(x);
yPoints.add(250);

xPoints.add(400);
yPoints.add(400);

xPoints.add(550);
xPoints.add(600);
xPoints.add(400);

yPoints.add(530);
yPoints.add(405);
yPoints.add(390);

	int i=1;
	while(i<=nPoints) {
	    if(i<nPoints)
	        g.drawLine(xPoints.get(i-1),yPoints.get(i-1),xPoints.get(i),yPoints.get(i));
	    else
	        g.drawLine(xPoints.get(nPoints-1),yPoints.get(nPoints-1),xPoints.get(0),yPoints.get(0));
	    i++;
	}

	
	g.setColor(Color.black);
	g.fillArc(x, y, 400, 400, 0, 45);
	g.fillArc(x, y, 400, 400, 90, 45);
	g.fillArc(x, y, 400, 400, 180, 45);
	g.fillArc(x, y, 400, 400, 270, 45);
	g.drawOval(x, y, 400, 400);
	
	

	
	
	
	g.setColor(Color.white);
g.fillOval(x+175, y+175, 50, 50);


		
	}
	
	private class ButtonListener implements ActionListener{
	
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

	Random gen = new Random();
			
	num = gen.nextInt(8)+1;
	int press = 0;		
	

	
	if(e.getSource() == one) {
		press = 1;
	}
	else if(e.getSource() == two) {
		press = 2;
	}
	else if(e.getSource() == three) {
		press = 3;
	}
	else if(e.getSource() == four) {
			press = 4;
	}
	else if(e.getSource() == five) {
		press = 5;
}
	else if(e.getSource() == six) {
		press = 6;
}
	else if(e.getSource() == seven) {
		press = 7;
}
	else if(e.getSource() == eight) {
		press = 8;
}
	


	
	if(balance > 0) {
	
	
	if(inputs.getText().equals("")) {
		System.out.println("Enter amount you wish to gamble in the textfield");
	}
	else {
	wager = Integer.parseInt(inputs.getText());
		
		if(num == press) {
			balance = balance + (wager * 8);
			System.out.println("you won");
		
		
		}
		else {
			balance = balance - wager;
			System.out.println("you lost");
			
		}
	}
		

	
	System.out.println("The winning number was "+num);
	if(balance < 0) {
		balance = 0;
	}
	bal.setText("balance:$"+balance);

	
System.out.println("Enter amount you wish to gamble in the textfield");
	
	System.out.println("Choose a number to bet on");
	}
	
	
	else {
		System.out.println("you are out of money you hobo");
		
	}
}
	
	
		}
	}
	





