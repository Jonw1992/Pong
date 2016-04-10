import javax.swing.JFrame;

public class PongFrame extends JFrame
{

	public PongFrame()
	{
		setTitle("Pong");
		setSize(1366,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new PongController());
		setVisible(true);	
	}

}