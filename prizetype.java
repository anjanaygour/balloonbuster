
public class prizetype implements Cloneable{
	public String prize;
	public int weight;
	public prizetype(String prize,int weight) {
		this.prize=prize;
		this.weight=weight;
	}
	@Override
	public boolean equals(Object o1) {
		if(o1!=null && getClass()==o1.getClass()) {
			prizetype o=(prizetype) (o1);
			return (this.prize.equals(o.prize) && this.weight==o.weight);
		}
		else {
			return false;
		}
	}
	@Override 
	public  prizetype clone() {
		try {
			prizetype copy=(prizetype) super.clone();
			
			return copy;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
