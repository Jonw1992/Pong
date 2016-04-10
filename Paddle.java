import java.awt.*;

public class Paddle
{
	protected Color color = new Color(255,255,255,255);
	protected int xPos =0; 
	protected int yPos = 0;
	protected int width = 0;
	protected int height = 0;
	private int speed  = 10;
	
	public Paddle()
	{
		
	}
	
	public Paddle(int x, int y, int width, int height)
	{
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public void up()
	{
		this.yPos -= speed;
	}
	
	public void down()
	{
		this.yPos += speed;
	}
	
}