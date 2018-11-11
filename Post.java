
public class Post {
	public int type;
	//for new Post, type =1
	//for repost, type = 2
	//for reply, type = 3
	public String text;
	public int timeStamp;
	public int publisherId;
	public int postId;
	// public Post referencePost;
	public int referencePost;

	//Constructor for dummy post
	Post()
	{
		this.timeStamp = (-100);
	}
	
	//constructor for New post
	Post(int time,int uid,String text,int tid)
	{
		this.type = 1;
		this.timeStamp = time;
		this.publisherId = uid;
		this.text = text;
		this.postId = tid;
	}
	//constructor for repost
	Post(int time,int uid,int ref,int tid)
	{
		this.type = 2;
		this.timeStamp = time;
		this.publisherId = uid;
		this.referencePost=ref;
		this.postId = tid;
	}
	//constructor for reply
	Post(int time,int uid,int ref,String text, int tid)
	{
		this.type = 3;
		this.timeStamp = time;
		this.publisherId = uid;
		this.referencePost=ref;
		this.text = text;
		this.postId = tid;
	}

	public int getId()
	{
		return this.postId;
	}

	public int getUid()
	{
		return this.publisherId;
	}

	public int getTime()
	{
		return this.timeStamp;
	}

	public String getText()
	{
		return this.text;
	}
	

}
