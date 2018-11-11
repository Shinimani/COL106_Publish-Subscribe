public class User_tuple implements Comparable<User_tuple>{
	int userID;
	int timeStamp;
	User_tuple(int u, int t)
	{
		this.userID = u;
		this.timeStamp = t;
	}
	
	public int getUser()
	{
		return this.userID;
	}
	
	public int getTimeStamp()
	{
		return this.timeStamp;
	}
	
	public int compareTo(User_tuple other)
	{
		if (this.timeStamp > other.timeStamp)
		{
			return 1;
		}
		else if (this.timeStamp < other.timeStamp)
		{
			return -1;
		}
		else return 0;
	}

}

