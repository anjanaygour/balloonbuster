import java.util.Collections;
import java.util.ArrayList;
public class board {
	
	public String[][] ballonsboard=new String[10][10];
	public int playerpointcount=0;
	public board() {
		ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<100; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        
        for(int i=0;i<45;i+=9) {
        	
	       	int firstno=list.get(i)/10;
	       	int secondno=list.get(i)%10;
	       	this.ballonsboard[firstno][secondno]="Dog";
	        	
	        	
	       	int firstno1=list.get(i+1)/10;
	       	int secondno1=list.get(i+1)%10;
	       	this.ballonsboard[firstno1][secondno1]="Cat";
	        	
	       	int firstno2=list.get(i+2)/10;
	       	int secondno2=list.get(i+2)%10;
	       	this.ballonsboard[firstno2][secondno2]="Rabbit";
	        	
	       	int firstno3=list.get(i+3)/10;
	       	int secondno3=list.get(i+3)%10;
	       	this.ballonsboard[firstno3][secondno3]="Kit-Kat";
	        	
	        	
	       	int firstno4=list.get(i+4)/10;
	       	int secondno4=list.get(i+4)%10;
	       	this.ballonsboard[firstno4][secondno4]="Snickers";
	        	
	        int firstno5=list.get(i+5)/10;
	        int secondno5=list.get(i+5)%10;
	       	this.ballonsboard[firstno5][secondno5]="Five-Star";
	        	
	        int firstno6=list.get(i+6)/10;
	       	int secondno6=list.get(i+6)%10;
	       	this.ballonsboard[firstno6][secondno6]="Pen";
	        	
	        int firstno7=list.get(i+7)/10;
	        int secondno7=list.get(i+7)%10;
	        this.ballonsboard[firstno7][secondno7]="Pencil";
	        	
	        int firstno8=list.get(i+8)/10;
	        int secondno8=list.get(i+8)%10;
	        this.ballonsboard[firstno8][secondno8]="Eraser";
        	
        }
        
        	int firstno0=list.get(45)/10;
	       	int secondno0=list.get(45)%10;
	        this.ballonsboard[firstno0][secondno0]="Dog";
	        	
	       	
	       	int firstno10=list.get(46)/10;
	       	int secondno10=list.get(46)%10;
	       	this.ballonsboard[firstno10][secondno10]="Cat";
	       	
	       	int firstno20=list.get(47)/10;
	       	int secondno20=list.get(47)%10;
	       	this.ballonsboard[firstno20][secondno20]="Rabbit";
	        	
	       	int firstno30=list.get(48)/10;
	       	int secondno30=list.get(48)%10;
	       	this.ballonsboard[firstno30][secondno30]="Kit-Kat";
	        	
	        	
	       	int firstno40=list.get(49)/10;
	       	int secondno40=list.get(49)%10;
	       	this.ballonsboard[firstno40][secondno40]="Snickers";
        	
        
	}
	public boolean checkballonprize(int x, int y) {
		if(this.ballonsboard[x][y]!=null) {
			return false;
		}
		else {
			return true;
		}
	}
	public String destroyballon(int x, int y) {
		if(!this.ballonsboard[x][y].equals("Nothing")) {
			String s=this.ballonsboard[x][y];
			ballonsboard[x][y]="Nothing";
			return s;
		}
		else {
			return "destroyed";
		}
	}
}
