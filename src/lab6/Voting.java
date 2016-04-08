
package lab6;

import javax.swing.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.nio.file.*;


public class Voting 
{
	private JPanel panel;
	private JButton button;
	private JTextField fname,lname;
	private JLabel label;
	private ButtonGroup group;
	
	
	public Voting()
	{
		
		JMenuBar menuBar; 
		JMenu menu;
		JRadioButtonMenuItem rbMenuItem;
		menuBar = new JMenuBar();
		menu = new JMenu("Choose a candite");
		menu.setMnemonic(KeyEvent.VK_A); //Allows for hotkey access, Alt+a
		menuBar.add(menu); 
		
		
		
		
		 group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("The Liar");
		rbMenuItem.setActionCommand("0");
		
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		
		rbMenuItem = new JRadioButtonMenuItem("The Cronk");
		rbMenuItem.setActionCommand("1");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("The Cheater");
		rbMenuItem.setActionCommand("2");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("The crazy one");
		rbMenuItem.setActionCommand("3");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		
		
		
		
		panel = new JPanel(new GridLayout(0,1)
				);
		button = new JButton("Vote");
		fname = new JTextField(20);
		fname.setText("first name");
		lname = new JTextField(20);
		lname.setText("Last name");
		label = new JLabel("Your Vote matters/ unless you live North Korea");//3 cols, not 20 chars
		
		
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(menuBar);
		panel.add(fname);
		panel.add(lname);
		panel.add(button);
		panel.add(label);
		
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	public static double conversion(int mode, double temp){
		
		switch (mode)
		
		{
		case 0: 
			 temp = (temp-32)*(5.0/9.0);
			 break;
		case 1: 
			 temp = (temp-32)*(5.0/9.0)+273.15;
			 break;
		case 2: 
			 temp = (temp*9.0/5.0)+32;
			 break;
		case 3: 
			 temp = temp+273.15;
			 break;
		case 4: 
			 temp = (temp-273.15)*(9.0/5.0)+32;
			 break;
		case 5: 
			 temp = temp-273.15;
			 break;
			 
		
		}
		
		
		
		return temp;
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			String first = fname.getText();
			String last = lname.getText();
			int mode =0;
			try{
		 mode = Integer.parseInt(group.getSelection().getActionCommand());
			}
			catch(NumberFormatException dude){
		        label.setText("Pick someone to vote");
		        return;
		    }
			String ballot= last.toLowerCase()+ "_"+ first.toLowerCase()+"_ballot.txt";
			
			try{
				FileReader sealed= new FileReader(ballot);
				
			}catch(FileNotFoundException youvoted){
				
				try{
					FileWriter thevote = new FileWriter(ballot);
					PrintWriter boyscout = new PrintWriter(thevote);
					
					

					switch (mode)
					
					{
					case 0: 
						boyscout.println("The Liar"); 
						 
						 break;
					case 1: 
						boyscout.println("The Cronk"); 
						 break;
					case 2: 
						boyscout.println("The Cheater"); 
						 break;
					case 3: 
						boyscout.println("The Crazy one"); 
						
					
						 break;
					
						 
					
					}
					
					boyscout.close();
					label.setText("vote  counted");
					return;
				
				}
				
				catch(IOException bad){
					label.setText("vote not counted");
					return;
				}
				
			}
			System.out.println("you cant program");
			
				
				
//				
				
				}
			};
		
		
		return listener;
		
}
}

