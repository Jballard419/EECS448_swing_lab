package lab6;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;

public class DiceProjectDriver {
	
	
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Click counter");
		diceproject demo = new diceproject();
		
		frame.getContentPane().add( demo.getContent() );
		
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}

}
