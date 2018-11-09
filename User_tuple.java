public class User_tuple implements Comparable<User_tuple>{
	User u;
	int t;
	User_tuple(User u, int t)
	{
		this.u = u;
		this.t = t;
	}
	
	public User getUser()
	{
		return this.u;
	}
	
	public int getTimeStamp()
	{
		return this.t;
	}
	
	public int compareTo(User_tuple other)
	{
		if (this.t > other.t)
		{
			return 1;
		}
		else if (this.t < other.t)
		{
			return -1;
		}
		else return 0;
	}

}

