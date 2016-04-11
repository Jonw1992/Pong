import javax.swing.JFrame;
import javax.swing.JPanel;

public class PongFrame extends JFrame
{

	public PongFrame()
	{
		setTitle("Pong");
		setSize(1366+25,768+25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PongController pong = new PongController();
		setResizable(false);
		add(pong);
		setVisible(true);	
	}

}