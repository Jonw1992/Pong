import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


	public abstract class Game extends JPanel
	{
		protected final int SCREENX = 1366;
		protected final int SCREENY = 768;
		protected final int FRAMERATE = 60;
		private KeyEvent event;
		private boolean keyHeld;
		
		
		public abstract void paintIt(Graphics g);
		public abstract void calculateIt();
		public abstract void onKeyDown(KeyEvent e);
		public abstract void onKeyReleased(KeyEvent e);
		public abstract void onKeyTyped(KeyEvent e);
		public abstract void onKeyHeld(KeyEvent e);
		
		//Call this upon initialization of the extending class to start the game
		public void startTheGame()
		{
			addKeyListener(new KeyListener());
			new PaintThread().start();
			
			setBackground(Color.black);

			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
		}
		
		public void paintComponent(Graphics g)
		{
				super.paintComponent(g);
				Toolkit kit = Toolkit.getDefaultToolkit();
				Dimension screenSize = kit.getScreenSize();

				paintIt(g);
	
		}
			
		public class PaintThread extends Thread 
		{
			public void run() 
			{			
				new CalculateThread().start();
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
						e.printStackTrace();
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
		}		
		


		
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
				if(event.getKeyCode() == e.getKeyCode())
				{
				keyHeld = false;
				}
				onKeyReleased(e);
			}

		}
		
	} 