import java.util.Scanner;
import java.util.ArrayList;

public class Game_Simulation {
	
	public static int prizeweight(String award) {
		if(award.equals("Dog")){
			return 50;
		}
		else if(award.equals("Cat")) return 40;
		else if(award.equals("Rabbit")) return 20;
		else if(award.equals("Kit-Kat")) return 10;
		else if(award.equals("Snickers")) return 5;
		else if(award.equals("Five-Star")) return 7;
		else if(award.equals("Pen")) return 2;
		else if(award.equals("Pencil")) return 1;
		else return 7;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int no=scan.nextInt();
		board ballon=new board();
		String[] players=new String[no];
		for(int i=0;i<no;i++) {
			String Name=scan.next();
			players[i]=Name;
			
		}
		for(int i=0;i<no;i++) {
			player p=new player(players[i]);
			System.out.println(players[i]+"  has started playing ");
			
			ArrayList<String> prizes=new ArrayList<String>();
			
			for(int j=0;j<5;j++) {
				String pa=scan.next();
				prizetype pw=new prizetype(pa,prizeweight(pa));
				p.addprizes(pw);
				
			}
			
			for(int j=0;j<10;j++) {
				
				System.out.println("Choose a coordinate");
				int x=scan.nextInt();
				int y=scan.nextInt();
				
				if(ballon.checkballonprize(x,y)!=true) {
					
					System.out.println("Guess the prize");
					System.out.println(ballon.ballonsboard[x][y]);
					int index=scan.nextInt();
					
					if(p.getPlayerprizeswishlist().get(index).prize.equals(ballon.ballonsboard[x][y])) {
						prizetype pbr=new prizetype(ballon.ballonsboard[x][y],prizeweight(ballon.ballonsboard[x][y]));
						prizetype pri=(prizetype)pbr.clone();
						System.out.println("You Guess correct");
						System.out.println("You got a "+p.getPlayerprizeswishlist().get(index).prize);
						p.getPlayerprizes().add (pri);
						
						if(ballon.ballonsboard[x][y].equals("Cat") || ballon.ballonsboard[x][y].equals("Dog") || ballon.ballonsboard[x][y].equals("Rabbit")){
							
							float po=p.getPlayer_score();
							float point=(po*2)+10;
							p.setPlayer_score(point);
							System.out.print("Points: ");
							System.out.println(point-po);	
						}
						else if(ballon.ballonsboard[x][y].equals("Kit-Kat") || ballon.ballonsboard[x][y].equals("Snickers") || ballon.ballonsboard[x][y].equals("Five-Star")) {
							
							float po=p.getPlayer_score();
							float point=po+20;
							p.setPlayer_score(point);
							System.out.print("Points: ");
							System.out.println(point-po);	
						}
						else if(ballon.ballonsboard[x][y].equals("Pen") || ballon.ballonsboard[x][y].equals("Pencil") || ballon.ballonsboard[x][y].equals("Eraser")) {
							
							float po=p.getPlayer_score();
							float point=(float) ((po*1.10) +5);
							p.setPlayer_score(point);
							System.out.print("Points: ");
							System.out.println(point);
						}
						
					}
					else {
						System.out.println("You Guessed Wrong, it was "+ballon.ballonsboard[x][y]);
						float po=p.getPlayer_score();
						prizetype guessaward=p.getPlayerprizeswishlist().get(index);
						prizetype actualaward=new prizetype(ballon.ballonsboard[x][y],prizeweight(ballon.ballonsboard[x][y]));
						float point=po-Math.abs((guessaward.weight-actualaward.weight));
						if(point>0) {
							p.setPlayer_score(point);
							System.out.print("Points: ");
							System.out.println(point);
						}
						else {
							p.setPlayer_score(0);
							System.out.print("Points: ");
							System.out.println(0);
						}
						
						
					}
				}
				else {
					System.out.println("No prizes in this balloon");
					float po=p.getPlayer_score();
					float point=po/2;
					p.setPlayer_score(point);
					System.out.print("Points: ");
					System.out.print(point);
				}
			}
			System.out.println("Summary of "+p.getName());
			System.out.print("Prizes won: ");
			for(int k=0;k<p.getPlayerprizes().size();k++) {
				System.out.print(p.getPlayerprizes().get(k).prize+" ");
			}
			System.out.print("Points: ");
			System.out.println(p.getPlayer_score());
			
		}

	}

}
