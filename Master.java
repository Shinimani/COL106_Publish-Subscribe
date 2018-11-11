// class UserNotFound extends Exception
// {
// 	  private String message;
// 		public UserNotFound(String message)
// 		{
// 	    this.message=message;
// 	  }
// 	  public String getMessage()
// 	  {
// 	    return message;
// 	  }
// }


public class Master {
  public HashTableUsers userTable = new HashTableUsers();
  // public HashTablePosts postTable = new HashTablePosts();



  private void Subscribe(int time, int userid, int pubid)
  {
  	User tempuser = this.userTable.findUser(uid);
  	if (tempuser==null)
  	{
  		tempuser = new User(time,userid,this);
  	}

  	User temppublisher = this.userTable.findUser(pubid);
  	if (temppublisher==null)
  	{
  		temppublisher = new User(time,pubid,this);
  	}

  	tempuser.SubscribeTo(temppublisher,time);
  }

  public void Subscribe(String time, String userid, String pubid)
  {
  	int inttime = Integer.parseInt(time);
  	int intuserid = Integer.parseInt(userid);
  	int intpubid = Integer.parseInt(pubid);
  	Subscribe(inttime, intuserid, intpubid);
  }

  private void UnSubscribe(int time, int userid, int pubid) throws Exception
  {
  	User tempuser = this.userTable.findUser(uid);
  	User temppublisher = this.userTable.findUser(pubid);
  	if (tempuser==null)
  	{
  		throw new Exception("User with id" + userid + "does not exist");
  	}
  	else if (temppublisher==null)
  	{
  		throw new Exception("User with id" + pubid + "does not exist");
  	}
  	else if (!tempuser.CheckSubscriber(temppublisher))
  	{
  		throw new Exception("User with id" + userid + "has not subscribed to publisher with id " + pubid);
  	}
  	else
  	{
  		tempuser.UnSubscribe(temppublisher, time);
  	}
  }

  public void UnSubscribe(String time, String userid, String pubid) throws Exception
  {
  	int inttime = Integer.parseInt(time);
  	int intuserid = Integer.parseInt(userid);
  	int intpubid = Integer.parseInt(pubid);
  	UnSubscribe(inttime, intuserid, intpubid);
  }

  private void NewPublish(int time, int uid, String text, int tid) throws Exception
  {
  	User tempuser = this.userTable.findUser(uid);
  	if (tempuser==null)
  	{
  		throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{
  		if (tempuser.returnPostById(tid) == null)
  		{
  			Post temppost = new Post(time, uid, text, tid);
  			tempuser.addPost(temppost);
  		}
  		else
  		{
  			throw new Exception("Post with id " + textid + " already exists");
  		}

  	}

  }

  public void NewPublish(String time, Sring userid, String text, String tid) throws Exception
  {
        int inttime = Integer.parseInt(time);
        int intuserid = Integer.parseInt(userid);
        int inttid = Integer.parseInt(tid);  	
        NewPublish(inttime,intuserid,text,inttid);
  }

  private void Repost(int time, int userid, int origpostid, int tid) throws Exception
  {
  	User tempuser = this.userTable.findUser(userid);
  	if (tempuser==null)
  	{
  		throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{
  		if (tempuser.returnPostById(tid) == null)
  		{
  			Post temppost = new Post(time, userid, origpostid, tid);
  			tempuser.addPost(temppost);
  		}
  		else
  		{
  			throw new Exception("Post with id " + textid + " already exists");
  		}
  	}
  }

  public void Repost(String time, String userid, String origpostid, String tid) throws Exception
  {
    int inttime = Integer.parseInt(time);
    int intuserid = Integer.parseInt(userid);
    int intorigpostid = Integer.parseInt(origpostid);
    int inttid = Integer.parseInt(tid);  	
    Repost(inttime, intuserid, intorigpostid, inttid);
  }

  private void Reply(int time, int userid, int origpostid, String text, int tid) throws Exception
  {
  	User tempuser = this.userTable.findUser(uid);
  	if (tempuser==null)
  	{
  		throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{

  		if (tempuser.returnPostById(tid) == null)
  		{
  			Post temppost = new Post(time, uid, origpostid, text, tid);
  			tempuser.addPost(temppost);
  		}
  		else
  		{
  			throw new Exception("Post with id " + textid + " already exists");
  		}
  	}
  }

  public void Reply(String time, String userid, String origpostid, String text, String tid) throws Exception
  {
    int inttime = Integer.parseInt(time);
    int intuserid = Integer.parseInt(userid);
    int intorigpostid = Integer.parseInt(origpostid);
    int inttid = Integer.parseInt(tid);  	
    Repost(inttime, intuserid, intorigpostid, text, inttid);
  }

  private void Read(int time, int uid)
  {
  	User tempuser = this.userTable.findUser(uid);
  	int tm = tempuser.getTime();
  	if (tempuser==null)
  	{
  		throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{
  		String string = "[";
  		for (int i = 0; i < tempuser.Subscriptions.size(); i++)
  		{
  			User temp1user = this.userTable.findUser(tempuser.Subscriptions.get(i).getUser());
  			int timesubs = tempuser.Subscriptions.get(i).getTimeStamp();
  			for (int j = 0; j < temp1user.PostList.size(); j++)
  			{
  				Post temppost = temp1user.PosList.get(j);
  				if (temppost.getTime() >= tm && temppost.getTime() < timesubs <= temppost.getTime())
  				{
  					string = string + temppost.getText() + ",";
  				}
  			}
  		}
  		System.out.println(string.substring(0,string.length()-1) + "]");
  	}
  }


    public void performAction(String st) {
        String st1 = st.replace("(", ",");
        String string = st1.replace(")", "");
        String[] word = string.split(",");

        //To Subscribe a user
        if (word[0].toLowerCase().equals("subscribe")) {
            System.out.print(st);
            Subscribe(word[1], word[2], word[3]);
        }

        //To unsubscribe a user
        if (word[0].toLowerCase().equals("unsubscribe")) {
            System.out.print(st);
            UnSubscribe(word[1], word[2], word[3]);
        }

        //To read the text from the publishers
        if (word[0].toLowerCase().equals("read")) {
            System.out.print(st);
            Read(word[1], word[2]);
        }

        //To publish NEW text from the publisher
        if (word[0].toLowerCase().equals("publish") && word[3].toLowerCase().equals("new")) {
            System.out.println(st);
            NewPublish(word[1], word[2], word[4], word[5]);
        } else {
            //To Repost a text published initially by another publishers
            if (word[0].toLowerCase().equals("publish") && word[3].toLowerCase().equals("repost")) {
                System.out.print(st);
            	Repost(word[1], word[2], word[4], word[5]);
            }

            //To reply to a text published by a user
            if (word[0].toLowerCase().equals("publish") && word[3].toLowerCase().equals("reply")) {
                System.out.println(st);
                Reply(word[1], word[2], word[4], word[5], word[6]);
            }
        }

    }



}
