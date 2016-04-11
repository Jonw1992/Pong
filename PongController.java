import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.lang.Math;
import javax.swing.JPanel;
import java.lang.Object;

public class PongController extends Game
{
		private int testStart = 0;
		private int testPaint = 0;
		private int testCalculate = 0;
		private Paddle player;
		private Paddle enemy;
		private Ball ball;
		private boolean ballCollision = true;
		

		public void checkCollisions()
		{
			Rectangle p = player.getRect();
			Rectangle b = ball.getRect();
			Rectangle e = enemy.getRect();
			
			if(p.intersects(b) || b.intersects(p))
			{
				if(ballCollision)
				{
					ball.checkBoundaries(true);
					ballCollision = false;
				}
			}	
			
			else if(e.intersects(b) || b.intersects(e))
			{
				if(ballCollision)
				{
					ball.checkBoundaries(true);
					ballCollision = false;
				}
			}	
			else 
			{
				ballCollision = true;
			}
		}
		
		public void handleAI()
		{
			int num = 0;
			int count =0;
			if(ball.cx <= ScreenProperties.WIDTH/3)
			{
				enemy.setVelocity(1);
			}
			else if(ball.cx <= ScreenProperties.WIDTH/2)
			{
				enemy.setVelocity(4);
			}
			else if(ball.cx <= ScreenProperties.WIDTH/1.5)
			{
				enemy.setVelocity(7);
			}

				if(ball.cy >= enemy.cy -50)
				{
					if(enemy.velocity < 0)
					{
						enemy.setVelocity(-enemy.velocity);
					}
				}
				else if(ball.cy < enemy.cy +50)
				{
					if(enemy.velocity > 0)
					{
						enemy.setVelocity(-enemy.velocity);
					}
				}


		}
		
		
		//Initializion here -------------------------------------------------------------------		
		public PongController()
		{

			setBackground(Color.BLACK);
			player = new Paddle(50,SCREENY/2 - 50,25,100);
			enemy = new Paddle(ScreenProperties.WIDTH- 50,SCREENY/2 - 50,25,100);
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
			
			g.setColor(Color.BLACK);
			g.fillRect(ScreenProperties.X,ScreenProperties.Y,ScreenProperties.WIDTH,ScreenProperties.HEIGHT);
			checkCollisions();

			handleAI();
			ball.checkBoundaries(false);
			ball.paint(g);
			player.paint(g);
			enemy.autoMove();
			enemy.paint(g);
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
					if(player.y >= ScreenProperties.Y)
					{
						player.up();					
					}				
			}
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
			{
					if(player.y <= ScreenProperties.HEIGHT - player.h)
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