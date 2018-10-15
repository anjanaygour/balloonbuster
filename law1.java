import java.util.ArrayList;
import java.util.Scanner;

public class law {	
	public static boolean in(int n,int[] a) {
		boolean c=false;
		for(int i=0;i<a.length;i++) {
			if(a[i]==i) {
				c=true;
				break;
			}
			
		}
		if(c==true) {
			return true; 
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		ArrayList<lawyer> l=new ArrayList<lawyer>();
		ArrayList<client> c=new ArrayList<client>();
		int l1=0;
		for(int i=0;i<n;i++) {
			
			
			String lawyername=scan.next();
			String cat=scan.next();
			l.add(new lawyer(cat,lawyername,l1++));
			System.out.println(l.get(i).lawyerId);
			//System.out.println(l.get(i).category);
		}
		int q=scan.nextInt();
		int c1=0;
		for(int i=0;i<q;i++) {
			int query=scan.nextInt();
			if(query==1) {
				String clientname=scan.next();
				String cate=scan.next();
				int prior=scan.nextInt();				
				c.add(new client(clientname,prior,cate,c1++));
				int flag=0;
				for(int j=0;j<=l.size();j++) {
					if(l.get(j).category.equals(c.get(i).category)) {
						flag=1;
						cases a=new cases(c.get(i).clientid,c.get(i).priority,c.get(i).clientname,c.get(i).category);
						l.get(j).casesforclients.add(a);
						l.get(j).casesort();
						System.out.println(l.get(j).lawyername);
						break;
					}
					else {
						flag=0;
					}
				}
				if(flag==0) {
					System.out.println("No lawyer is available for that job");
					}
				
				
			}
			else if(query==2) {
				int fg=0;
				int lid=scan.nextInt();
				for(int j=0;j<l.size();j++) {
					if(lid==l.get(j).lawyerId) {
						if(l.get(j).casesforclients.size()>1) {
							l.get(j).casesforclients.remove(0);
							System.out.print(l.get(j).casesforclients.get(0).clientname+" ");
							System.out.print(l.get(j).casesforclients.get(0).clientid);
							System.out.println("  "+l.get(j).casesforclients.get(0).category+"  ");
						}
						else if(l.get(j).casesforclients.size()==1){
							System.out.println("No more pending cases");
						}
						fg=1;
						break;
					}
					else {
						fg=0;
					}
				}
				if(fg==0) {
					System.out.println("There is no lawyer of this ID");
				}
			}
			else if(query==3) {
				int fg=0;
				int lid=scan.nextInt();
				for(int j=0;j<l.size();j++) {
					if(lid==l.get(j).lawyerId) {
						if(l.get(j).casesforclients.size()>0) {
							System.out.print(l.get(j).casesforclients.get(0).clientname+"  ");
							System.out.print(l.get(j).casesforclients.get(0).clientid);
							System.out.println("  "+l.get(j).casesforclients.get(0).category+"  ");
						}
						else {
							System.out.println("No running cases");
						}
					fg=1;
					break;
					}
					else {
						fg=0;
						
					}
				}
				if(fg==0) {
					System.out.println("There is no lawyer of this ID");
				}
			}
			else if(query==4) {
				int fg=0;
				int lid=scan.nextInt();
				for(int j=0;j<l.size();j++) {
					if(lid==l.get(j).lawyerId) {
						if(l.get(j).casesforclients.size()>0) {
							for(int k=0;k<l.get(j).casesforclients.size();k++) {
							System.out.print(l.get(j).casesforclients.get(k).clientname+"  ");
							System.out.print(l.get(j).casesforclients.get(k).clientid);
							System.out.print("  "+l.get(j).casesforclients.get(k).category+"  ");
							}
						}	
						else {
							System.out.println("No running cases");
						}
						fg=1;
						break;
					}
					else {
						fg=0;
						
					}
				}
				if(fg==0) {
					System.out.println("There is no lawyer of this ID");
				}
			}
			else if(query==5) {
				for(int j=0;j<l.size();j++) {
					System.out.println(l.get(j).lawyername);
					System.out.println(l.get(j).category);
					System.out.println(l.get(j).lawyerId);
				}
			}
			else if(query==6) {
				int lid=scan.nextInt();
				for(int j=0;j<c.size();j++) {
					if(lid==c.get(j).clientid){
						c.remove(j);
						for(int k=0;k<l.size();k++) {
							if(c.get(j).clientid==l.get(k).lawyerId) {
								for(int m=0;m<l.get(k).casesforclients.size();m++) {
									if(c.get(j).clientid==l.get(k).casesforclients.get(m).clientid) {
										l.get(k).casesforclients.remove(m);
										
									}
								}
							}
						}
					}
				}
				
			}
		}
		
	}

}
class lawyer{
	public int lawyerId=0;
	public String category="";
	public String lawyername="";
	public ArrayList<cases> casesforclients;
	public lawyer(String category,String lawyername,int lawyerId) { //,ArrayList<cases> casesforclients
		this.lawyerId=lawyerId;
		this.category=category;
		this.lawyername=lawyername;
		this.casesforclients=new ArrayList<cases>();
	}
	public int getLawyerId() {
		return lawyerId;
	}
	public void setLawyerId(int lawyerId) {
		this.lawyerId = lawyerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void casesort() {
		int n=casesforclients.size();
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (casesforclients.get(j).priority > casesforclients.get(j+1).priority) {
					int temp=casesforclients.get(j).priority;
					casesforclients.get(j).priority=casesforclients.get(j+1).priority;
					casesforclients.get(j+1).priority=temp;
				}
			}
		}
	}
	
}

class client{
	public int clientid=0;
	public String clientname="";
	public int priority=0;
	public String category="";
	public String lawyern="";
	public int lawyerid=0;
	public client(String clientname,int priority,String category,int clientid) {
		this.clientid=clientid;
		this.clientname=clientname;
		this.priority=priority;
		this.category=category;
		this.lawyern="";
		this.lawyerid=-1;
	}
	public client(String clientname,int priority,String category,String lawyern,int lawyerid) {
		this.clientid++;
		this.clientname=clientname;
		this.priority=priority;
		this.category=category;
		this.lawyern=lawyern;
		this.lawyerid=lawyerid;
	}
	public String getCategory() {
		return category;
	}
	public String getLawyern() {
		return lawyern;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setLawyern(String lawyern) {
		this.lawyern = lawyern;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	
}
class cases{
	public int clientid=0;
	public int priority=0;
	public String clientname="";
	public String category="";
	public cases(int clientid,int priority,String clientname,String category) {
		this.clientid=clientid;
		this.priority=priority;
		this.clientname=clientname;
		this.category=category;
	}
}



