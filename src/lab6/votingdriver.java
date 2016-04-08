package lab6;
import javax.swing.JFrame;


public class votingdriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting");
		Voting vote = new Voting();
		
		frame.getContentPane().add(vote.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
