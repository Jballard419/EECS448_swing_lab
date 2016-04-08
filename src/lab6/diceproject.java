package lab6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
//Used for menu hotkeys (optional);



public class diceproject implements ActionListener {
	
	
	
		//Create a frame
		private int roll = 0;
		JPanel content;
		JButton button;
		JLabel label;
		private JTextField text;
		
		public diceproject()
		{
			content = new JPanel(new GridLayout(0,1)); //Create with a grid layout of a single column
			button = new JButton("Roll"); //make the button
			label = new JLabel("Roll the die "); //make the label for writing text to
			text = new JTextField(3);
			//Set up the Action Listener
			button.addActionListener(this);//this instance will handle the actions
			
			content.add(text);
			content.add(button);
			content.add(label);	
			
		}
		
		public Component getContent()
		{
			return(content);
		}
		
		private String counterMessage(int num)
		{
			//Create a message based on current counter number
			return (new String("Counter:  " + num + " "));
		}

		public void actionPerformed(ActionEvent e) 
		{
			Random rand=new Random();
	                //When the button is pressed...
			String msg= text.getText() ; 
			int randomroll =rand.nextInt(Integer.parseInt(msg))+1;
			label.setText(Integer.toString(randomroll));	//update label
			System.out.println(randomroll); //update 
		}
		
	}
	
	

