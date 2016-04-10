import java.awt.*;
import java.lang.Math;

public class Ball
{
	protected Color color = new Color(255,255,255,255);
	protected int xPos =0; 
	protected int yPos = 0;
	protected int width = 0;
	protected int height = 0;
	private double speed  = 10;
	private double angle = 180;
	private double xDir = 0;
	private double yDir = 0;
	
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
		xDir = Math.cos(Math.toRadians(angle));
		yDir = Math.sin(Math.toRadians(angle));
		
		xPos += (int)(xDir*speed);
		yPos += (int)(yDir*speed);
		

		
		//System.out.println(xDir);
		//xPos += speed;
		//yPos += speed;
		
	}
	
	public void setDir(double theta)
	{
		
		angle = theta;
	}
	
	public void deflect()
	{
		angle = angle- 45;
	}

}