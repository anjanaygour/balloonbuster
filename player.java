import java.util.ArrayList;

public class player {
	private String name="";
	private ArrayList<prizetype> playerprizeswishlist=new ArrayList<prizetype>();
	private float player_score=0;
	private ArrayList<prizetype> playerprizes=new ArrayList<prizetype>();

	
	public player(String name) {
		this.name=name;
		
		
	}
	public String getName() {
		return name;
	}
	public void addprizes(prizetype p) {
		this.playerprizeswishlist.add(p);
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPlayer_score() {
		return player_score;
	}
	public void setPlayer_score(float player_score) {
		this.player_score = player_score;
	}
	public ArrayList<prizetype> getPlayerprizes() {
		return playerprizes;
	}
	public void setPlayerprizes(ArrayList<prizetype> playerprizes) {
		this.playerprizes = playerprizes;
	}
	public ArrayList<prizetype> getPlayerprizeswishlist() {
		return playerprizeswishlist;
	}
	public void setPlayerprizeswishlist(ArrayList<prizetype> playerprizeswishlist) {
		this.playerprizeswishlist = playerprizeswishlist;
	}
	
}

