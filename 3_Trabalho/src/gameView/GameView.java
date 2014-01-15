package gameView;

import gameLogic.GameOfCars;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appManager.Images;

public class GameView extends JFrame implements Images {

	JLabel dice1, dice2;
	JLabel currPlayer, name;

	public GameView(GameOfCars game) {
		setTitle("Game of cars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardView bv = new BoardView(game);
		Container c = getContentPane();
		c.add(bv);
		JPanel East = new JPanel();
		fillEastPanel(East, c);
		pack();
	}

	private void fillEastPanel(JPanel East, Container c) {

		East.setPreferredSize(new Dimension(200, 200));
		JLabel players = new JLabel("All Players");
		JLabel currentPlayer = new JLabel("Current Players");
		East.add(dicePanel());
		East.add(diceRoll());
		East.add(players);
		East.add(currentPlayer);
		East.add(playerView());
		East.add(currentPlayer());
		c.add(East, BorderLayout.EAST);
	}

	private JPanel playerView() {

		JPanel pView = new JPanel();
		pView.setLayout(new GridLayout(0,2,0,0));
		pView.setPreferredSize(new Dimension(200,200));
		
		for(int i=0; i<GameOfCars.getNumberOfPlayers();i++){
			JPanel p=new JPanel();
			JLabel player= new JLabel(Images.normalImages[i]);
			JLabel name=new JLabel(GameOfCars.getPlayerOfIndex(i).getName());
			p.add(player);
			p.add(name);
			pView.add(p);
		}
		return pView;
	}

	public JPanel dicePanel() {
		
		JPanel dice_panel = new JPanel();

		JLabel dices = new JLabel("Dices");

		dice1 = new JLabel();
		dice2 = new JLabel();
		BorderLayout b = new BorderLayout();
		dice_panel.setLayout(b);

		dice1.setIcon(Images.dice[3]);
		dice2.setIcon(Images.dice[2]);

		dice_panel.add(dices, b.NORTH);
		dice_panel.add(dice1, b.WEST);
		dice_panel.add(dice2, b.EAST);

		return dice_panel;
	}

	public JButton diceRoll() {
		JButton roll = new JButton(
				"                  Roll                     ");
		// roll.addActionListener(new StepListener());
		// roll.addActionListener(new HouseListener());
		return roll;
	}

	public JPanel currentPlayer() {
		JPanel currentPlayer = new JPanel();
		for (int i = 0; i < Images.normalImages.length; i++) {
			currPlayer = new JLabel(Images.normalImages[i]);
			currentPlayer.add(currPlayer);
		}
		return currentPlayer;

	}
}
