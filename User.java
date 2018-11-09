import java.util.ArrayList;
//import java.util.LinkedList;

public class User {
	public int tminus1;
	public int userid;
	public ArrayList<User_tuple> Subscriptions;
	
	User(int time, int uid)
	{
		this.tminus1 = time;
		this.userid = uid;
		this.Subscriptions = new ArrayList<User_tuple>(2);
	}
	
	public int getTime()
	{
		return this.tminus1;
	}
	
	public int getId()
	{
		return this.userid;
	}
	
	public void SubscribeTo(User user, int time)
	{
		User_tuple temp = new User_tuple(user,time);
		this.Subscriptions.add(temp);
	}
	
	public boolean CheckSubscriber(User user)
	{
		boolean ans = false;
		for (int i = 0; i<this.Subscriptions.size();i++)
		{
			if (this.Subscriptions.get(i).getUser().getId()==user.getId())
			{
				ans = true;
				break;
			}
		}
//		while(!ans && )
		return ans;
	}
	
	

}
