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
		private Pong pong;

		
		//Initializion here -------------------------------------------------------------------
		@Override
		public void startIt()
		{
			setBackground(Color.BLACK);
			testStart=testPaint=testCalculate=0;
			testStart++;
			pong = new Pong();

			
		}
		
		
		//Handle all painting here -----------------------------------------------------------
		@Override
		public void paintIt(Graphics g, Graphics bufferGraphics)
		{
			bufferGraphics.setColor(pong.player.color);
			bufferGraphics.fillRect(pong.player.xPos,pong.player.yPos,pong.player.width,pong.player.height);
			
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
					if(pong.player.yPos > 0)
					{
						pong.player.up();					
					}				
			}
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
			{
					if(pong.player.yPos < (SCREENY - pong.player.height))
					{
						pong.player.down();					
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