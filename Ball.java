import java.awt.*;
import java.lang.Math;
import java.awt.geom.Rectangle2D;

public class Ball
{
	protected Color color = new Color(255,255,255,255);
	protected int x =0; 
	protected int y = 0;
	protected int w = 0;
	protected int h = 0;
	protected int cx = 0;
	protected int cy = 0 ;
	private double speedX  = -10;
	private double speedY  = 7;
	private boolean deflected = false;
	private int eScore;
	private int pScore;

	
	public Ball()
	{

	}
	
	public Ball(int x, int y, int w, int h)
	{
		pScore = 0;
		eScore = 0;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		cx = this.x +this.x/2;
		cy = this.y + this.y/2;
	}
	

	public void update()
	{


		x += (int)(speedX);
		y += (int)(speedY);
		cx = this.x +this.x/2;
		cy = this.y + this.y/2;		
		
		
	}
	
	public void setDir(double theta)
	{
		
	}
	
	public void checkBoundaries(boolean collided)
	{

		
		if(x<=0)
		{	
			x = ScreenProperties.WIDTH/2;
			y = ScreenProperties.HEIGHT/2;
			eScore++;
		}				
		if(x >= (ScreenProperties.WIDTH - w ))
		{
			x = ScreenProperties.WIDTH/2;
			y = ScreenProperties.HEIGHT/2;
			pScore++;
		}
		if(y<=0)
		{
			y = 1;
			deflectY();
		}
		if(y >= (ScreenProperties.HEIGHT -h))
		{
			y = ScreenProperties.HEIGHT - h-1;
			deflectY();		
		}
		
		if(collided)
		{
			deflectX();
			collided = false;
		}
		
	}

	
	public void deflectX()
	{
		speedX = - speedX;
	}
	
	public void deflectY()
	{
		speedY= -speedY;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,w,h);
	}
	
	public void paint(Graphics g)
	{
			update();
			g.setColor(color);
			g.fillRect(x,y,w,h);
			if(eScore == 10)
			{
				ScreenProperties.GAMEOVER = true;
				ScreenProperties.PAUSED = true;
				String s = "YOU LOSE!";
				Font f = new Font("Helvetica", Font.BOLD, 40);
				g.setFont(f); 
				g.drawString(s, ScreenProperties.WIDTH/2 - 100, 150); 
				
			}
			if(pScore == 10)
			{
				ScreenProperties.GAMEOVER = true;
				ScreenProperties.PAUSED = true;
				String s = "YOU WIN!";
				Font f = new Font("Helvetica", Font.BOLD, 40);
				g.setFont(f); 
				g.drawString(s, ScreenProperties.WIDTH/2 - 90, 150); 		
			}

				String s = pScore + "  |  " + eScore;
				Font f = new Font("Helvetica", Font.BOLD, 40);
				g.setFont(f); 
				g.drawString(s, ScreenProperties.WIDTH/2 - 45, 100); 				
		
		
	}
	
	public void showHitBox(Graphics g)
	{
			Rectangle r = getRect();
			g.setColor(Color.GREEN);
			g.fillRect(r.x,r.y,r.width,r.height);		
	}
}