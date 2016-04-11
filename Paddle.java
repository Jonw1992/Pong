import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle
{
	protected Color color = new Color(255,255,255,255);
	protected int x =0; 
	protected int y = 0;
	protected int w = 0;
	protected int h = 0;
	protected int cx = 0;
	protected int cy = 0 ;
	private int speed  = 15;
	protected int velocity = 20;
	
	public Paddle()
	{
		
	}
	
	public Paddle(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		cx = this.x +this.x/2;
		cy = this.y + this.y/2;
	}
	
	public void update()
	{
		
		cx = this.x +this.x/2;
		cy = this.y + this.y/2;		
	}
	
	public void setVelocity(int velocity)
	{
		this.velocity = velocity;
	}
	
	public void up()
	{
		this.y -= speed;
	}
	
	public void down()
	{
		this.y += speed;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,w,h);
	}

	public void autoMove()
	{
			y+= velocity;
	}
	
	public void paint(Graphics g)
	{
			update();
			g.setColor(color);
			g.fillRect(x,y,w,h);
			
			
	}
	public void showHitBox(Graphics g)
	{
			Rectangle r = getRect();
			g.setColor(Color.GREEN);
			g.fillRect(r.x,r.y,r.width,r.height);		
	}
	
	
}