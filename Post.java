
public class Post {
	public int type;
	//for new Post, type =1
	//for repost, type = 2
	//for reply, type = 3
	public String text;
	public int timeStamp;
	public int publisherId;
	public int postId;
	public Post referencePost;

	
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
	Post(int time,int uid,Post ref,int tid)
	{
		this.type = 2;
		this.timeStamp = time;
		this.publisherId = uid;
		this.referencePost=ref;
		this.postId = tid;
	}
	//constructor for reply
	Post(int time,int uid,Post ref,String text, int tid)
	{
		this.type = 3;
		this.timeStamp = time;
		this.publisherId = uid;
		this.referencePost=ref;
		this.text = text;
		this.postId = tid;
	}
	

}
