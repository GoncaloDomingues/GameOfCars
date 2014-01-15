package gameView;

import gameLogic.GameOfCars;
import gameLogic.House;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appManager.Images;

public class HouseView extends JPanel implements Images {

	JPanel players;

	public HouseView(House h) {
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setVisible(true);
		imageView(h);
		gridView(h);
		numberView(h);
	}

	private void imageView(House h) {
		JLabel image = new JLabel();

		if (h.getPos() == 0)
			image.setIcon(Images.tileStart);
		else if (h.getPos() % 9 == 0 || (h.getPos() - 5) % 9 == 0)
			image.setIcon(Images.tileCar);
		else if (h.getPos() % 6 == 0)
			image.setIcon(Images.tileHighway);
		else if (h.getPos() % 19 == 0)
			image.setIcon(Images.tileStop);
		else if (h.getPos() % 31 == 0)
			image.setIcon(Images.tilePriority);
		else if (h.getPos() % 39 == 0)
			image.setIcon(Images.tileQuestion);
		else if (h.getPos() % 42 == 0)
			image.setIcon(Images.tileRoadEnd);
		else if (h.getPos() % 52 == 0)
			image.setIcon(Images.tilePolice);
		else if (h.getPos() % 58 == 0)
			image.setIcon(Images.tileCrash);
		else if (h.getPos() % 63 == 0)
			image.setIcon(Images.tileFinish);
		else
			image.setIcon(Images.tileEmpty);
		image.setSize(new Dimension(70, 70));
		add(image);
	}

	private void gridView(House h) {
		players = new JPanel();
		JLabel imag = new JLabel();
		GridLayout g = new GridLayout(1, 5, 1, 1);
		players.setBackground(Color.white);
		players.setLayout(g);

		for (int i = 0; i < GameOfCars.getNumberOfPlayers(); i++) {
			imag = new JLabel(Images.smallImages[i]);

			if (h.pos != GameOfCars.getPlayerOfIndex(i).getPos())
				imag.setIcon(Images.tileEmpty);

			players.add(imag);
			add(players, BorderLayout.SOUTH);
		}
	}

	private void numberView(House h) {
		JLabel number = new JLabel("" + h.getPos());
		number.setBackground(Color.white);
		add(number, BorderLayout.EAST);
	}

}
