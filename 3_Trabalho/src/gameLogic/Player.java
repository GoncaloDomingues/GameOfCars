package gameLogic;

public class Player {

	String name;
	int positionPlayer;
	int returns;

	public Player(String name, int pos) {
		this.name = name;
		positionPlayer = pos;
	}

	public int getPos() {
		return positionPlayer;
	}

	public String getName() {
		return name;
	}

	public static void setPosition(int positionPlayer) {
		positionPlayer = positionPlayer;
	}

	public static int newPos(Player p, int dice1, int dice2) {
		int prev = p.positionPlayer;
		int actPosition = prev += dice1 + dice2;
		setPosition(actPosition);
		return actPosition;
	}

	public static void returns(Player p, int n) {
		p.returns = n;
	}
}
