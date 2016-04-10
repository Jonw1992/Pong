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
		private boolean up;
		private boolean down;
		
		public void handleMovement()
		{
			if(up)
			{
				pong.player.up();		
			}
			if(down)
			{
				pong.player.down();
				
			}
		}
		
		//Initializion here -------------------------------------------------------------------
		@Override
		public void startIt()
		{
			setBackground(Color.BLACK);
			testStart=testPaint=testCalculate=0;
			testStart++;
			pong = new Pong();
			up = false;
			down = false;

			
		}
		
		
		//Handle all painting here -----------------------------------------------------------
		@Override
		public void paintIt(Graphics g, Graphics bufferGraphics)
		{
			handleMovement();
			bufferGraphics.setColor(pong.player.color);
			bufferGraphics.fillRect(pong.player.xPos,pong.player.yPos,pong.player.width,pong.player.height);
			
			testPaint++;
		}
		
		//Handle all calculations here--------------------------------------------------------
		@Override
		public void calculateIt()
		{

			
		}
			
		@Override
		public void onKeyDown(KeyEvent e)
		{
			//System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
			{
					this.up = true;
			}
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
			{
					this.down = true;
			}
			
		}
		
		@Override
		public void onKeyReleased(KeyEvent e)
		{
			up = down = false;
			
			System.out.println("Released");
		}
		
		@Override
		public void onKeyTyped(KeyEvent e)
		{
		}		



}