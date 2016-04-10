import java.awt.*;

public class Ball
{
	protected Color color = new Color(255,255,255,255);
	protected int xPos =0; 
	protected int yPos = 0;
	protected int width = 0;
	protected int height = 0;
	private int speed  = 10;
	
	public Ball()
	{
		
		
	}
	
	public Ball(int x, int y, int width, int height)
	{
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public void update()
	{
		
		
	}

}