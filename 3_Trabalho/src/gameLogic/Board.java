package gameLogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

	public static ArrayList<House> houses;

	private static int numberOfHouses;

	public Board(int numberOfHouses) throws IOException {
		this.numberOfHouses = numberOfHouses;
		houses = new ArrayList<House>(numberOfHouses);
		create();
	}

	private void create() throws IOException {

		BufferedReader br;
		String line = "";
		int posicao = 0;
		try {
			br = new BufferedReader(new FileReader("tab.txt"));

			while ((line = br.readLine()) != null) {

				for (int i = 0; i < line.length(); i++) {
					char caracter = line.charAt(i);
					house(caracter, posicao++);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	private void house(char caracter, int posicao) {
		switch (caracter) {

		case 'I':
			houses.add(new Start(posicao));
			break;

		case 'E':
			houses.add(new EmptySpace(posicao));
			break;

		case 'C':
			houses.add(new Car(posicao));
			break;

		case 'S':
			houses.add(new Stop(posicao));
			break;

		case 'K':
			houses.add(new Priority(posicao));
			break;

		case 'Q':
			houses.add(new Question(posicao));
			break;

		case 'T':
			houses.add(new EndRoad(posicao));
			break;

		case 'P':
			houses.add(new Police(posicao));
			break;

		case 'Y':
			houses.add(new CrashCar(posicao));
			break;

		case 'F':
			houses.add(new Finish(posicao));
			break;
		}
	}

	public ArrayList<House> getHouses() {
		return houses;
	}

	public static int getNumberOfHouses() {
		return numberOfHouses;
	}
}
