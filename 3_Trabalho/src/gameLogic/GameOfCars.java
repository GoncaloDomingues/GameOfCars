package gameLogic;

import java.io.IOException;

public class GameOfCars {

	private Board board;

	private static int numberOfHouses = 64;
	private static Player[] listOfPlayers = { new Player("Bart", 0),
			new Player("Lisa", 0), new Player("Hommer", 0),
			new Player("Marge", 0) };
	private static int numberOfPlayers = listOfPlayers.length;
	public static boolean isEnd = false;

	public GameOfCars() throws IOException {
		board = new Board(numberOfHouses);
	}

	public Board getBoard() {
		return board;
	}

	public static int rollDice() {
		int nDice = 1 + (int) (Math.random() * 6);
		return nDice;
	}

	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public static Player[] getListOfPlayers() {
		return listOfPlayers;
	}

	public static Player getPlayerOfIndex(int index) {
		return listOfPlayers[index];
	}

	public static int getNumberOfHouses() {
		return numberOfHouses;
	}

	public static void setEnd() {
		isEnd = true;
	}

	public static boolean getIsEnd() {
		return isEnd;
	}

}
