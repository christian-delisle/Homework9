package gui_view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Controller {

	public static void main(String[] args) {
		buildGameViews();
	}
	
	public static void buildGameViews() {
		//Task 1: Create a frame, set the title and dimensions. Make it VISIBLE.
		JFrame frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe");												//frame title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 						//what frame does on x button click
		frame.setVisible(true);														//frame visibility
		frame.setSize(500, 550);													//frame dimensions
		
		//Task 2: Instantiate a GameView Object and add it to the frame
		GameView gameView = new GameView();
		frame.add(gameView);
		
		
		//Task 3: Register listener event for each of the buttons in the game view.
			for (int i = 0; i < 3; i++) {
				for (int e = 0; e < 3; e++) {
					GameView.squares[i][e].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							changeSquareX(evt); //changes the square clicked
						}
					});
				}
			}
	}
	
	//Method for changing and disabling square for player's turn
	public static void changeSquareX(ActionEvent evt) {
		for (int i = 0; i < 3; i++) {
			for (int e = 0; e < 3; e++) {
				if(evt.getSource() == GameView.squares[i][e]) {
					GameView.squares[i][e].setText("X"); //sets the square clicked to X
					GameView.squares[i][e].setEnabled(false); //makes the square unable to be changed
				}
			}
		}
		computerTurn(); //calls computer turn method following click from player
	}
	
	public static void computerTurn() {
		//code for testing filling of computer turns on squares
		/*
		for (int i = 0; i < 3; i++) {
			for (int e = 0; e < 3; e++) {
				if (GameView.squares[i][e].isEnabled()) {
					GameView.squares[i][e].setText("O");
					GameView.squares[i][e].setEnabled(false);
					return;
				}
			}
		}
		*/
		
		//iterate until square that is enabled is found
		for (;;) {
			int a = (int)(Math.random() * 3);
			int b = (int)(Math.random() * 3);
			if (GameView.squares[a][b].isEnabled()) {
				GameView.squares[a][b].setText("O"); //sets the square clicked to O
				GameView.squares[a][b].setEnabled(false); //makes the square unable to be changed
				return; //exit the method because a legal move has been able to be made
			}
		}
		
	}
}
