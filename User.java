import java.util.ArrayList;
//import java.util.LinkedList;

public class User {
	public int tminus1;
	public int userid;
	public Master master;
	public ArrayList<User_tuple> Subscriptions;
	public ArrayList<Post> PostList;

	User(int time, int uid, Master master)
	{
		this.master = master;
		this.tminus1 = time;
		this.userid = uid;
		master.userTable.addUser(this);
		this.Subscriptions = new ArrayList<User_tuple>(2);
		this.PostList = new ArrayList<Post>(1);
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
		User_tuple temp = new User_tuple(user.getId(),time);
		if (!this.CheckSubscriber(user))
		{
			this.Subscriptions.add(temp);
		}
	}

	public boolean CheckSubscriber(User user)
	{
		boolean ans = false;
		for (int i = 0; i<this.Subscriptions.size();i++)
		{
			if (this.Subscriptions.get(i).getUser()==user.getId())
			{
				ans = true;
				break;
			}
		}
//		while(!ans && )
		return ans;
	}

	//returns null if not found
	public Post returnPostById(int postId)
	{
//		Post ans = new Post();
		for (int i = 0; i < this.PostList.size(); i++)
		{
			if (this.PostList.get(i).postId == postId)
				return this.PostList.get(i);
//			else continue;
		}
		return null;
	}





}
