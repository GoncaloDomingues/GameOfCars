package gameView;

import java.awt.GridLayout;

import gameLogic.Board;
import gameLogic.GameOfCars;
import gameLogic.House;
import gameLogic.Player;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardView extends JPanel {
	
	public GameOfCars gameOfCars;
	
	private static HouseView [] hv = new HouseView[Board.getNumberOfHouses()];
	
	public BoardView(GameOfCars gameOfCars){
		
		this.gameOfCars=gameOfCars;
		
		GridLayout gl=new GridLayout(0,8,3,3);
		
		setLayout(gl);
		
		Board b=gameOfCars.getBoard();
		
		for(House h:Board.houses){
			HouseView house=new HouseView(h);
			hv[h.pos]=house;
			add(house);
		}
	}
	
	public static HouseView getHouseView(int idx){
		return hv[idx];
	}
	
//	
//	public static void setImage(Player p){
//		
//		JLabel img = (JLabel)(getHouseView (p.getPos()).players.getComponent(GameOfCar))
//	}
}
