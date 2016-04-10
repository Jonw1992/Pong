import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;


	public abstract class Game extends Applet
	{
		protected final int SCREENX = 1366;
		protected final int SCREENY = 768;
		protected final int FRAMERATE = 60;
		private Graphics bufferGraphics; 
		private Image offscreen;
		private KeyEvent event;
		private boolean keyHeld;
		
		public void init() 
		{
			startIt();
			addKeyListener(new KeyListener());
			new CalculateThread().start();
			new PaintThread().start();
			offscreen = createImage(SCREENX,SCREENY); 
			bufferGraphics = offscreen.getGraphics(); 
		}
		
		public void update(Graphics g) 
		{
				bufferGraphics.clearRect(0,0,SCREENX,SCREENY);
				paintIt(g,bufferGraphics);
				g.drawImage(offscreen,0,0,this); 
		}

		public void paint(Graphics g) 
		{
			update(g);
		}
		
		
			
		public class PaintThread extends Thread 
		{
			public void run() 
			{
				while(true)
				{
					if(keyHeld)
					{
						onKeyHeld(event);
					}
					repaint();

					try 
					{
						Thread.sleep(1000/FRAMERATE);
					} catch (InterruptedException e) 
					{
						//the VM doesn’t want us to sleep anymore,
						//so get back to work
					}
				}
			}
		}		
		
		public class CalculateThread extends Thread 
		{
			public void run() 
			{
				while(true)
				{
					calculateIt();
				}
			}
		}
			
		public abstract void paintIt(Graphics g, Graphics bufferGraphics);
		public abstract void calculateIt();
		public abstract void startIt();
		public abstract void onKeyDown(KeyEvent e);
		public abstract void onKeyReleased(KeyEvent e);
		public abstract void onKeyTyped(KeyEvent e);
		public abstract void onKeyHeld(KeyEvent e);
		
		class KeyListener extends KeyAdapter
		{
			public KeyListener(){}
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				onKeyTyped(e);
			}
			@Override
			public void keyPressed(KeyEvent e)
			{
				event = e;
				keyHeld = true;
				onKeyDown(e);
			}
			@Override
			public void keyReleased(KeyEvent e)
			{
				keyHeld = false;
				onKeyReleased(e);
			}

		}
		
	} 