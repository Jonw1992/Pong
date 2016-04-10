import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class PongController extends Game
{
		private int testStart = 0;
		private int testPaint = 0;
		private int testCalculate = 0;
		private Paddle player;
		private Ball ball;

		
		//Initializion here -------------------------------------------------------------------
		@Override
		public void startIt()
		{
			
			setBackground(Color.BLACK);
			player = new Paddle(50,50,25,100);
			ball = new Ball(SCREENX/2 - 25 ,SCREENY/2 - 25 ,25,25);
			testStart=testPaint=testCalculate=0;
			testStart++;


			
		}
		
		
		//Handle all painting here -----------------------------------------------------------
		@Override
		public void paintIt(Graphics g, Graphics bufferGraphics)
		{
			bufferGraphics.setColor(ball.color);
			bufferGraphics.fillRect(ball.xPos,ball.yPos,ball.width,ball.height);
			
			bufferGraphics.setColor(player.color);
			bufferGraphics.fillRect(player.xPos,player.yPos,player.width,player.height);
			
			testPaint++;
		}
		
		//Handle all calculations here--------------------------------------------------------
		@Override
		public void calculateIt()
		{

			
		}
		
		//A better method of moving and object than Keylistener provides. It is updated every frame. 
		@Override
		public void onKeyHeld(KeyEvent e)
		{
			System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
			{
					if(player.yPos > 0)
					{
						player.up();					
					}				
			}
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
			{
					if(player.yPos < (SCREENY - player.height))
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
			System.out.println("Released");
		}
		
		@Override
		public void onKeyTyped(KeyEvent e)
		{
		}		



}