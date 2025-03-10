/*
 * Name: Harshit Rangu
 * Section Number: 2336-002
 * 
 * Analysis: 
 * 		It's required to write code to make an Ultimate Tic-Tac-Toe game. In each of the 9 squares of the original 
 * 		Tic-Tac-Toe game, there is a another Tic-Tac-Toe game. To win the game, a player must first win each of the
 * 		smaller boards until they have a three-board line (won boards). To make the game more engaging, several new 
 * 		rules have been added. One of them is that a player can only place a mark on his or her opponent's most recent mark. 
 * 		An opponent player can force a player to go to a board that has already been won or tied. If a board is already filled, 
 * 		the player has the option of going to any other board and position (provided it is available). The rules for 
 * 		winning a game of Tic-Tac-Toe on any of the Tic-Tac-Toe boards remain the same. One of the players in this project is human, 
 * 		while the other is artificial intelligence (the computer).
 * 
 * Design:
 * 		I attempted to improve upon the code used in various in-class assignments for the class. To make the Ultimate Tic-Tac-Toe game, 
 * 		I generated multiple methods all within one class. I created a 9 by 9 2 dimensional array in a way that each row of the 2 dimensional  	
 * 		array was each individual board of the game. I then used an algorithm inside a print board method to print each line of array 
 * 		into a 3 by 3 box(tic Tac Toe board). I created all the necessary functions in one class as I didn't need separate classes one 
 * 		for each board due to the algorithm that displays all 9 boards for me. the game starts and ends in the main function using a do while loop. 
 * 		Players are allowed to make moves accordingly and play to win. The board is printed after each move to simplify the process for the player, 
 * 		and possible moves on a given board are also listed. If a game is won on a board, it is also displayed, and the overall game winner 
 * 		is displayed once all of the games have been completed.  After each move, the board is checked to see if it is full, and therefore 
 * 		if the game is ended. I attempted to keep the output as close to the sample output as possible.
 * Test:
 * 		The program only accepts valid inputs. If the user submits an invalid value as input, for example if the board is full or if the move 
 * 		is impossible to complete, the user will be prompted to enter it again until a number in the valid spot is entered. 
 * */

package cs2336_TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class UltimateTicTacToe {
	
	
	//Sets the board by placing the mark 'X' into the spot entered by the user
	public static void setBoardX(char[][] board, int boardNum, int squareNum) {
	
		board[boardNum][squareNum] = 'X';
		
	}
	
	//Sets the board by placing the mark 'O' into the spot randomly generated for artificial intelligence
	public static void setBoardO(char[][] board, int boardNum, int squareNum) {
		
		board[boardNum][squareNum] = 'O';
		
	}
	
	
	//algorithm created to convert each row of 2 dimensional board array into 9 different 3 by 3 boxes as it is played in tic tac toe
	public static void printBoard(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print("Board# " + (i * 3) + " | " + board[i * 3][j * 3] + " | " + board[i * 3][(j * 3) + 1] + " | " + board[i * 3][(j * 3)+ 2] + "|   ");
				System.out.print("Board# " + (i * 3 + 1) + " | " + board[i * 3 + 1][j * 3] + " | " + board[i * 3 + 1][(j * 3) + 1] + " | " + board[i * 3 + 1][(j * 3)+ 2] + " |   ");
				System.out.print("Board# " + (i * 3 + 2) + " | " + board[i * 3 + 2][j * 3] + " | " + board[i * 3 + 2][(j * 3) + 1] + " | " + board[i * 3 + 2][(j * 3)+ 2] + " |   ");
				System.out.println();
			}
		}
		
	}
	
	
	//boolean method that returns true if there aren't anymore empty spaces in the entire ultimate board
	public static boolean emptySpaceBoard(char[][] board) {
		
		int count = 0;
		
		//nested for loop to check through entire 9 by 9 2 dimensional array to see how many non dash values are there
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++){
				if(board[row][col] != '-') {
					
					count++;
				}
			}
		}
		
		//if there aren't any dashes and all 81 values are filled with either x or o then it returns true
		if(count == 81) {
			return true;
		}
		//else false
		else {
			
			return false;
		}
		
	}

	//method to get the board value of X from the user 
	public static int getXBoard() {
		int boardNum = 0;
		
		Scanner input = new Scanner(System.in);
		boardNum = input.nextInt();
		
		return boardNum;
		
	}
	
	//method that gets the square value of a chosen board from the user
	public static int getXSquare() {
		int squareNum = 0;
		
		Scanner input = new Scanner(System.in);
		squareNum = input.nextInt();
		
		return squareNum;
	}
	
	//method that checks to see if there's an empty space or a dash within the selected board
	public static boolean emptySpaceGame(int boardNum, int square, char[][] board){
		if(board[boardNum][square] == '-') {
			return true;
			
		}
		else {
			return false;
			
		}
		
	}
	
	//method that gets the square value for cpu player O using a random generator
	public static int getOSquare() {
		int numRandom;

		Random random = new Random();
		numRandom = random.nextInt(9);
		
		return numRandom;
		
	}
	
	//boolean method to see if the board chosen is completely full without any empty spaces left
	public static boolean isFull(int i, char[][] board) {
		for(int j = 0; j < 9; j++) {
			if(board[i][j] == '-') {
				return false;
			}
		}
		return true;
	}
	
	//method that checks the status of the winner through several combinations of winning. and returns either X or O or Tie based on who won
	public static char checkStatus(char[][] board, char player, int i) {
		
		char dash = '-';
		char tie = 'T';
		

		//list of possible winning combination patters
		if(board[i][0] == player && board[i][3] == player && board[i][6] == player) {
			return player;
		}
		else if(board[i][1] == player && board[i][4] == player && board[i][7] == player) {
			return player;
		}
		else if(board[i][2] == player && board[i][5] == player && board[i][8] == player) {
			return player;
		}
		else if(board[i][0] == player && board[i][1] == player && board[i][2] == player) {
			return player;
		}
		else if(board[i][3] == player && board[i][4] == player && board[i][5] == player) {
			return player;
		}
		else if(board[i][6] == player && board[i][7] == player && board[i][8] == player) {
			return player;
		}
		else if(board[i][0] == player && board[i][4] == player && board[i][8] == player) {
			return player;
		}
		else if(board[i][2] == player && board[i][4] == player && board[i][6] == player) {
			return player;
		}
		else {
			return dash;
		}
		
	}
	
	//method that checks if the big board has been won or not through multiple possible winning combinations
	public static boolean bigBoardWinner(char[] board, char player) {
		if(board[0] == player && board[3] == player && board[6] == player) {
			return true;
		}
		if(board[1] == player && board[4] == player && board[7] == player) {
			return true;
		}
		if(board[2] == player && board[5] == player && board[8] == player) {
			return true;
		}
		if(board[0] == player && board[1] == player && board[2] == player) {
			return true;
		}
		if(board[6] == player && board[7] == player && board[8] == player) {
			return true;
		}
		if(board[0] == player && board[4] == player && board[8] == player) {
			return true;
		}
		if(board[2] == player && board[4] == player && board[6] == player) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//method that checks to see if the big board is full or not through a for loop
	public static boolean isFullBigBoard( char[]board) {
		for(int j = 0; j < 9; j++) {
			if(board[j] == '-') {
				return false;
			}
		}
		return true;
	}
	
	//boolean win status method that closely follows and returns weather there's a winner or not by calling multiple methods within this method
	public static boolean winStatus(char[][] board, char[] boardStatus){
		char playerX = 'X';
		char playerO = 'O';
		
		char dash = '-';
		char tie = 'T';
		
		//for loop that goes through each board and calls the check status method to see who won that specific board which can then be stored in the boardStatus Array
		for(int i = 0; i < 9; i++) {
			if(boardStatus[i] == '-') {
				boardStatus[i] = checkStatus(board, playerX, i);
				
				if(boardStatus[i] != playerX) {
					boardStatus[i] = checkStatus(board, playerO, i);
					if(boardStatus[i] != playerO) {
						if(isFull(i, board) == true) {
							boardStatus[i] = tie;
						}
					}
				}
			}
		}
		
		//checks to see if at all there is a winner for the big board, if yes then returns true, if not then false
		if(bigBoardWinner(boardStatus, playerX) == false) {
			if(bigBoardWinner(boardStatus, playerO) == false) {
				if(isFullBigBoard(boardStatus) == false) {
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return true;
			}
		}
		else {
			return true;
		}
		
		
	}
	
	
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//array and variable declarations
		char [][] board = new char [9][9];
		char [] boardStatus = new char [9];
		int xBoard = 0;
		int xSquare = 0;
		
		int oBoard = 0;
		int oSquare = 0;
		
		//for loop that sets the index values of the entire 2 dimensional array to dashes
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++){
				board[row][col] = '-';
			}
		}
		
		//sets the board status array to dashes
		for(int i = 0; i < 9; i++) {
			boardStatus[i] = '-';
		}
		
		System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
		//prints the empty board
		printBoard(board);
		
		//prints input statements and gets the value for x board and x square
		System.out.println("Current player is: X");
		System.out.println("Please select a valid board:");
		xBoard = getXBoard();
		System.out.println("Selected board is: " + xBoard);
		System.out.println("Please select a valid square on the selected board:");
		xSquare = getXSquare();
		System.out.println("Selected square : " + xSquare);

		//sets the board based on x inputs and prints the board with an 'X' in the appropriate location
		setBoardX(board, xBoard, xSquare);
		printBoard(board);
		
		//prints input statements and gets the value for O board and O square
		System.out.println("Current player is: O");
		oBoard = xSquare;
		System.out.println("Selected board is: " + oBoard);
		System.out.println("Please select a valid square:");
		oSquare = getOSquare();
		System.out.println("Selected square : " + oSquare);
		
		//sets the board based on o inputs and prints the board with an 'O' in the appropriate location
		setBoardO(board, oBoard, oSquare);
		printBoard(board);
		
		
		//code keeps repeating until there's a clear winner
		do {
			
			//prints input statements and gets the value for x board which is O square
			System.out.println("Current player is: X");
			System.out.println("Please select a valid board:");
			xBoard = oSquare;
			System.out.println("Selected board is: " + xBoard);
			
			//keeps repeating the code until a valid square value thats an empty space is entered
			do {
				System.out.println("Please select a valid square on the selected board:");
				xSquare = getXSquare();
			}while(emptySpaceGame(xBoard, xSquare, board) == false);
			System.out.println("Selected square : " + xSquare);
			
			//sets the board based on x inputs and prints the board with an 'X' in the appropriate location
			setBoardX(board, xBoard, xSquare);
			printBoard(board);
			
			//prints input statements and gets the value for O board which is xSquare
			System.out.println("Current player is: O");
			oBoard = xSquare;
			System.out.println("Selected board is: " + oBoard);
			
			//keeps repeating the code until a valid square value thats an empty space is entered
			do {
				System.out.println("Please select a valid square:");
				oSquare = getOSquare();
			}while(emptySpaceGame(oBoard, oSquare, board) == false);
			System.out.println("Selected square : " + oSquare);
			
			//sets the board based on o inputs and prints the board with an 'O' in the appropriate location
			setBoardO(board, oBoard, oSquare);
			printBoard(board);

		}while(winStatus(board, boardStatus) == false);
		
		
		//calls the bigBoardWinner boolean method to determine who the winner is and prints the winner statement accordingly
		if(bigBoardWinner(boardStatus, 'X') == false) {
			if(bigBoardWinner(boardStatus, 'O') == false) {
				System.out.println("game is tied");
			}
			else {
				System.out.println("game winner is O");
			}
		}
		else {
			System.out.println("game winner is X");
		}
		
	}
}
