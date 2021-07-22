


public class players {
	private int [] players;
	players(int x)
	{
		players = new int[x];
		for(int i=0;i<x;i++) players[i]=-1;
	}
	public int [] getPlayers() {
		return players;
	}
	
}
