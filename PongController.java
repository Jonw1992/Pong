import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.lang.Math;
import javax.swing.JPanel;

public class PongController extends Game
{
		private int testStart = 0;
		private int testPaint = 0;
		private int testCalculate = 0;
		private Paddle player;
		private Ball ball;
		private boolean ballPaddle = false;

		public void checkCollisions()
		{
			Rectangle p = new Rectangle(player.xPos+5,player.yPos,player.width,player.height);
			Rectangle b = new Rectangle(ball.xPos,ball.yPos,ball.width,ball.height);
			
			if(p.intersects(b) || b.intersects(p))
			{
				if(!ballPaddle)
				{
				double xp = p.getX() + p.getWidth()/2;
				double yp = p.getY() + p.getHeight()/2;
				
				double xb = b.getX() + b.getWidth()/2;
				double yb = b.getY() + b.getHeight()/2;
				
				double dx = xp - xb;
				double dy = yp - yb;
				double angle = Math.atan2(dy,dx) * 180 / Math.PI;
				
				
				ball.setDir(angle-180);
				ballPaddle = true;
				}
			}	
			
			if(ball.yPos <= 0+1)
			{
				if(!ballPaddle)
				{
				double cx = 0 + SCREENX/2;
				double cy = 0 + SCREENY/2;
				
				double xb = b.getX() + b.getWidth()/2;
				double yb = b.getY() + b.getHeight()/2;
				
				double dx = cx - xb;
				double dy = cy - yb;
				
				
				double angle = Math.atan2(dy,dx) * 180 / Math.PI;
				
				
				ball.setDir(angle + 90);
				ballPaddle = true;
				}
				
			}
				
		}
		
		
		//Initializion here -------------------------------------------------------------------		
		public PongController()
		{
			setBackground(Color.BLACK);
			player = new Paddle(50,SCREENY/2 - 50,25,100);
			ball = new Ball(SCREENX/2 - 25 ,SCREENY/2 - 25 ,25,25);
			testStart=testPaint=testCalculate=0;
			testStart++;
			
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			
			super.startTheGame();
			
			
		}
		
	
		
		//Handle all painting here -----------------------------------------------------------
		@Override
		public void paintIt(Graphics g)
		{
			checkCollisions();
			ball.update();
			g.setColor(ball.color);
			g.fillRect(ball.xPos,ball.yPos,ball.width,ball.height);
			
			g.setColor(player.color);
			g.fillRect(player.xPos,player.yPos,player.width,player.height);
			
			g.setColor(Color.GREEN);
			g.drawRect(ball.xPos,ball.yPos,ball.width,ball.height);
			
			g.setColor(Color.GREEN);
			g.drawRect(player.xPos,player.yPos,player.width,player.height);
			
			testPaint++;
			if(testPaint> 10)
			{
				testPaint = 0;
				ballPaddle = false;
			}

		}
		
		//Handle all calculations here--------------------------------------------------------
		@Override
		public void calculateIt()
		{
						checkCollisions();
		}
		
		//A better method of moving and object than Keylistener provides. It is updated every frame. 
		@Override
		public void onKeyHeld(KeyEvent e)
		{
			//System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
			{
					if(player.yPos > 0)
					{
						player.up();					
					}				
			}
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
			{
					if(player.yPos < (SCREENY - player.height*1.5))
					{
						player.down();					
					}			
			}
			
		}		
		@Override
		public void onKeyDown(KeyEvent e)
		{

			
		}
		
		@Override
		public void onKeyReleased(KeyEvent e)
		{
			//System.out.println("Released");
		}
		
		@Override
		public void onKeyTyped(KeyEvent e)
		{
		}		



}