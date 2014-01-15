package appManager;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import gameLogic.GameOfCars;
import gameView.GameView;

public class APP {

	public static void main(String[] args) throws IOException {

		GameOfCars game=new GameOfCars();
		
		GameView gv= new GameView(game);
		gv.setVisible(true);
		
		

	}
}
