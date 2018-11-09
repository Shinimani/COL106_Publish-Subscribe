import java.util.LinkedList;

public class User {
	public int tminus1;
	public int userid;
	public LinkedList<User_tuple> Subscriptions;
	
	User(int time, int uid)
	{
		this.tminus1 = time;
		this.userid = uid;
		this.Subscriptions = new LinkedList<User_tuple>();
	}
	
	

}
