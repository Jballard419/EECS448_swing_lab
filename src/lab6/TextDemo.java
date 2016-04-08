package lab6;

import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TextDemo 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	private ButtonGroup group;
	
	
	public TextDemo()
	{
		
		JMenuBar menuBar; 
		JMenu menu;
		JRadioButtonMenuItem rbMenuItem;
		menuBar = new JMenuBar();
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A); //Allows for hotkey access, Alt+a
		menuBar.add(menu); 
		
		
		
		
		 group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("F to C");
		rbMenuItem.setActionCommand("0");
		
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		
		rbMenuItem = new JRadioButtonMenuItem("F to K");
		rbMenuItem.setActionCommand("1");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("C to F");
		rbMenuItem.setActionCommand("2");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("C to K");
		rbMenuItem.setActionCommand("3");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("K to F");
		rbMenuItem.setActionCommand("4");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("K to C");
		rbMenuItem.setActionCommand("5");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		
		
		panel = new JPanel();
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");
		
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(menuBar);
		panel.add(text);
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
				String input = text.getText();
				
				
				
				
				int mode = Integer.parseInt(group.getSelection().getActionCommand());
				if(input.matches("-?\\d+(\\.\\d+)?")){
				 
				double tempInC =conversion( mode, Double.parseDouble(input));//convert F to C
				String newText = " New Temp" + String.format("%.2f",tempInC);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				
				}else if(!(input.isEmpty()))
					{
						label.setText("not a number");
						
					}
				else
				{
				
					label.setText("Please insert a number");
					
				}
				
				}
			};
		
		
		return listener;
	}	
}