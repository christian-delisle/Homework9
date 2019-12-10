package gui_view;

import java.awt.*;
import javax.swing.*;

public class GameView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	//Build view members
	public static JButton [] [] squares;
	
	//Constructor
	public GameView() {
		//Task 1: Set the grid layout and background color
		setLayout(new GridLayout(3, 3, 5, 5));
		setBackground(Color.CYAN);
		
		//Task 2: Instantiate squares
		squares = new JButton[3][3];
		
		//Task 3: Add buttons to the array
		for (int i = 0; i < 3; i++) {
			for (int e = 0; e < 3; e++) {
				JButton button = new JButton(" "); //create new blank button
				button.setFont(new Font("Arial", Font.BOLD, 100));
				button.setBorderPainted(true);
				squares[i][e] = button; //set all the buttons to the blank
				this.add(squares[i][e]); //add the button to all squares
			}
		}
	}
}
