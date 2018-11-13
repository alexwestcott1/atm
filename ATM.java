/**
* Application with a Graphical User Interface to simulate an ATM.
* 
* Code written by Alex Westcott for an assignment at the University of Liverpool in 2017.
*/

//Importing constructors to be used by the program
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ATM extends JFrame{
	
	//Setting variables/constants to be used throughout the program
	private double balance = 10;
	private int action = 0;
	private int attempts = 3;
	private int PIN = 1234;
	
	//Text to be shown to the user in the program
	private String instText = "Please enter your PIN (" + attempts + " attempts remaining)";
	private String dispText = "";
	
	//Setting up JButton constructors from Java Swing, buttons are to be shown on the program
	//'00A3' is the Unicode character for a pound sterling sign (£), and will be used throughout the program
	private JButton wd1 = new JButton("Withdraw \u00A35");
	private JButton wd2 = new JButton("Withdraw \u00A310");
	private JButton wd3 = new JButton("Withdraw \u00A320");
	private JButton num0 = new JButton("0");
	private JButton num1 = new JButton("1");
	private JButton num2 = new JButton("2");
	private JButton num3 = new JButton("3");
	private JButton num4 = new JButton("4");
	private JButton num5 = new JButton("5");
	private JButton num6 = new JButton("6");
	private JButton num7 = new JButton("7");
	private JButton num8 = new JButton("8");
	private JButton num9 = new JButton("9");
	private JButton deposit = new JButton("Deposit");
	private JButton clear = new JButton("Clear");
	private JButton enter = new JButton("Enter");
	private JButton quit = new JButton("Quit");
	private JButton cPIN = new JButton ("Change PIN");
	
	//Declaring JTextFields, which will display text on the program
	private JTextField instructions;
	private JTextField display;
	private JTextField dispBalance;
	
	public static void main(String[] args){
		
		//Setting up the ATM constructor
		ATM atm = new ATM();
		
		//Properties of the program, can't be resized, closes properly, is of a fixed size, and is visible
		atm.setResizable(false);
		atm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		atm.setSize(520,305);
		atm.setVisible(true);
	}
	
	public ATM(){
		
		//Title of the window
		super("Cash Machine");
		
		//Setting up JPanels which will contain more Java Swing elements
		JPanel input = new JPanel();
		JPanel dispWrapper = new JPanel();
		
		//Setting up text fields
		instructions = new JTextField(instText);
		display = new JTextField(dispText);
		dispBalance = new JTextField("");
		
		//Making the 'instructions' text field greyed out and uneditable, also aligning text to centre and giving it a border
		instructions.setEditable(false);
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.setBorder(new TitledBorder(new EtchedBorder(), "Instructions"));
		
		//Making the 'display' text field greyed out and uneditable, also aligning the text to centre and giving it a border
		display.setEditable(false);
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setBorder(new TitledBorder(new EtchedBorder(), "Display"));
		
		//Making the 'dispBalance' text field greyed out and uneditable, also aligning the text to centre and giving it a border
		dispBalance.setEditable(false);
		dispBalance.setHorizontalAlignment(SwingConstants.CENTER);
		dispBalance.setBorder(new TitledBorder(new EtchedBorder(), "Balance"));
		
		//Making the 'dispWrapper' JPanel in a grid layout with 2 elements
		dispWrapper.setLayout(new GridLayout(2,1));
		
		//Adding the 2 elements to the JPanel 'dispWrapper'
		dispWrapper.add(display);
		dispWrapper.add(dispBalance);
		
		//Adding a border to the 'input' JPanel
		input.setBorder(new TitledBorder(new EtchedBorder(), "Input"));
		
		//Making the 'input' JPanel in a grid layout with 20 elements (though not all of these will be used)
		input.setLayout(new GridLayout(5,4));
		
		//Adding the 17 elements to the JPanel 'input'
		input.add(wd1);
		input.add(num1);
		input.add(num2);
		input.add(num3);
		input.add(wd2);
		input.add(num4);
		input.add(num5);
		input.add(num6);
		input.add(wd3);
		input.add(num7);
		input.add(num8);
		input.add(num9);
		input.add(deposit);
		input.add(num0);
		input.add(clear);
		input.add(enter);
		input.add(quit);
		input.add(cPIN);
		
		//Adding the JPanels and the instructions texrt field to the whole program
		add(instructions, BorderLayout.NORTH);
		add(dispWrapper, BorderLayout.CENTER);
		add(input, BorderLayout.SOUTH);
		
		//Adding ActionListeners to all the buttons so they can be interacted with by the users
		quit.addActionListener(new QuitButton());
		num0.addActionListener(new Num0Button());
		num1.addActionListener(new Num1Button());
		num2.addActionListener(new Num2Button());
		num3.addActionListener(new Num3Button());
		num4.addActionListener(new Num4Button());
		num5.addActionListener(new Num5Button());
		num6.addActionListener(new Num6Button());
		num7.addActionListener(new Num7Button());
		num8.addActionListener(new Num8Button());
		num9.addActionListener(new Num9Button());
		clear.addActionListener(new ClearButton());
		enter.addActionListener(new EnterButton());
		wd1.addActionListener(new Withdraw1());
		wd2.addActionListener(new Withdraw2());
		wd3.addActionListener(new Withdraw3());
		deposit.addActionListener(new DepositButton());
		cPIN.addActionListener(new ChangePIN());
		
	}
	class QuitButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the quit button is pressed, reset everything back to default
			attempts = 3;
			action = 0;
			instText = "Please enter your PIN (" + attempts + " attempts remaining)";
			instructions.setText(instText);
			balance = 10;
			dispBalance.setText("");
			dispText = "";
			display.setText(dispText);
			PIN = 1234;
		}
	}

	class Num0Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 0 button is pressed, add a number 0 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "0");
		}
	}

	class Num1Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 1 button is pressed, add a number 1 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "1");
		}
	}

	class Num2Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 2 button is pressed, add a number 2 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "2");
		}
	}

	class Num3Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 3 button is pressed, add a number 3 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "3");
		}
	}

	class Num4Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 4 button is pressed, add a number 4 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "4");
		}
	}

	class Num5Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 5 button is pressed, add a number 5 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "5");
		}
	}

	class Num6Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 6 button is pressed, add a number 6 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "6");
		}
	}

	class Num7Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 7 button is pressed, add a number 7 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "7");
		}
	}

	class Num8Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 8 button is pressed, add a number 8 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "8");
		}
	}

	class Num9Button implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the 9 button is pressed, add a number 9 to the 'display' text field
			dispText = display.getText();
			display.setText(dispText + "9");
		}
	}
	
	class ClearButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//If the clear button is pressed, set the value of the text field to nothing
			display.setText("");
		}
	}
	
	class Withdraw1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//Checks to see if the user is logged in or not (by seeing if they still need to enter their PIN)
			if(action != 0){
			
				//Makes sure the user has at least £5 to withdraw from their account
				if(balance >= 5){
					
					//Take away £5 from the user's balance
					balance = balance - 5;
					
					//Update the balance on the screen
					dispBalance.setText("\u00A3" + String.format("%.2f", balance));
					
					//Update the log of transactions in the command window
					System.out.println("Transaction: -\u00A35\nBalance: " + dispBalance.getText());
					
					//Inform the user of the transaction
					instText = "\u00A35 withdrawn from account";
					instructions.setText(instText);
				} else {
					
					//If the user does not have £5 to withdraw, produce an error message
					instText = "Insufficient balance to withdraw \u00A35, please select another option";
					instructions.setText(instText);
				}
			} else {
				
				//If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
				instText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
				instructions.setText(instText);
			}
		}
	}
	
	class Withdraw2 implements ActionListener{
		public void actionPerformed(ActionEvent e){			
		
			//Checks to see if the user is logged in or not (by seeing if they still need to enter their PIN)
			if(action != 0){
				
				//Makes sure the user has at least £10 to withdraw from their account
				if(balance >= 10){
					
					//Take away £10 from the user's balance
					balance = balance - 10;
					
					//Update the balance on the screen
					dispBalance.setText("\u00A3" + String.format("%.2f", balance));
					
					//Update the log of transactions in the command window
					System.out.println("Transaction: -\u00A310\nBalance: " + dispBalance.getText());
					
					//Inform the user of the transaction
					instText = "\u00A310 withdrawn from account";
					instructions.setText(instText);
				} else {
					
					//If the user does not have £10 to withdraw, produce an error message
					instText = "Insufficient balance to withdraw \u00A310, please select another option";
					instructions.setText(instText);
				}
			} else {
				
				//If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
				instText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
				instructions.setText(instText);
			}
		}
	}
	
	class Withdraw3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//Checks to see if the user is logged in or not (by seeing if they still need to enter their PIN)
			if(action != 0){
				
				//Makes sure the user has at least £20 to withdraw from their account
				if(balance >= 20){
					
					//Take away £20 from the user's balance
					balance = balance - 20;
					
					//Update the balance on the screen
					dispBalance.setText("\u00A3" + String.format("%.2f", balance));
					
					//Update the log of transactions in the command window
					System.out.println("Transaction: -\u00A320\nBalance: " + dispBalance.getText());
					
					//Inform the user of the transaction
					instText = "\u00A320 withdrawn from account";
					instructions.setText(instText);
				} else {
					
					//If the user does not have £20 to withdraw, produce an error message
					instText = "Insufficient balance to withdraw \u00A320, please select another option";
					instructions.setText(instText);
				}
			} else {
				
				//If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
				instText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
				instructions.setText(instText);
			}
		}
	}
	
	class DepositButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//Makes sure user is logged into their account
			if(action != 0){
				
				//Set the 'action' integer to 1
				action = 1;
				
				//Ask the user how much they would like to deposit to their account
				instText = "Enter the amount you would like to deposit (\u00A31000 limit)";
				instructions.setText(instText);
			} else {
				
				//If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
				instText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
				instructions.setText(instText);
			}
		}
	}
	
	class ChangePIN implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//Makes sure the user is logged in
			if(action != 0){
				
				//Set the action to 3
				action = 3;
				
				//Ask the user what they would like to change their PIN to
				instText = "Enter a new 4-digit PIN";
				instructions.setText(instText);
			} else {
				
				//If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
				instText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
				instructions.setText(instText);
			}
		}
	}
	
	class EnterButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//Retrieve the current text in 'dispText'
			dispText = display.getText();
			
			//Using a switch statement to decide what happens during each action
			switch(action){
				
				//Checking to see if the text field is empty or not
				case 0: if(dispText.isEmpty()){
					
							//If it is empty, ask to enter the PIN again but don't decrease the number of attempts the user has left
							instText = "No characters were entered, please try again (" + attempts + " attempts remaining)";
							instructions.setText(instText);
						} else{
							
							//Checks to see if the value entered is '1234' (the PIN)
							if(Integer.parseInt(dispText) == PIN){
								
								//Display the balance, and move on to the next action, with a corresponding change in instruction
								dispBalance.setText("\u00A3" + String.format("%.2f", balance));
								action = 2;
								instText = "Please choose an option";
								instructions.setText(instText);
								display.setText("");
							} else if(dispText.isEmpty() == false){
								
								//If user enters something that isn't '1234', check how many attempts they have left
								if(attempts < 2){
									
									//If the user runs out of attempts, exit the program
									System.exit(0);
								}
								
								//Decrease the number of attempts by 1
								attempts--;
								
								//Inform the user that the PIN entered was wrong, and show how many attempts they have left at it
								instText = "Invalid PIN entered, please try again (" + attempts + " attempts remaining)";
								instructions.setText(instText);
								display.setText("");
							} else {
								
								//An extra check in case something goes wrong
								instText = "No characters were entered, please try again (" + attempts + " attempts remaining)";
								instructions.setText(instText);
							}
						}
						break;
				case 1: if(Integer.parseInt(dispText) <= 1000){
					
							//If amount entered to deposit is less than or equal to 1000, add 1000 to the balance
							balance = balance + Integer.parseInt(dispText);
							dispBalance.setText("\u00A3" + String.format("%.2f", balance));
							
							//Update the log of transactions in the command window
							System.out.println("Transaction: +\u00A3" + Integer.parseInt(dispText) + "\nBalance: " + dispBalance.getText());
							
							//Inform the user of the transaction
							instText = "\u00A3" + Integer.parseInt(dispText) + " deposited into account";
							instructions.setText(instText);
							dispText = "";
							display.setText(dispText);
						} else {
							
							//If amount entered to deposit is over 1000, produce an error
							instText = "Amount to deposit is too large (\u00A31000 limit)";
							instructions.setText(instText);
							dispText = "";
							display.setText(dispText);
						}
						
						//Update the action back to 2 (logged in)
						action = 2;
						break;
				case 3: if(dispText.isEmpty()){
					
							//If it is empty, inform the user that they have not entered anything
							instText = "No characters were entered, please select another action";
							instructions.setText(instText);
							action = 2;
						} else {
							
							//If new PIN isn't 4 digits long, produce an error and return to the previous action
							if(dispText.length() != 4){
								instText = "PIN must be 4 digits long, please select another action";
								instructions.setText(instText);
								dispText = "";
								display.setText(dispText);
								action = 2;
							} else {
								
								//Set the PIN to whatever the user entered and return to the previous action
								PIN = Integer.parseInt(dispText);
								instText = "PIN successfully updated, please select another action";
								instructions.setText(instText);
								dispText = "";
								display.setText(dispText);
								action = 2;
							}
						}
						break;
			}
		}
	}
}