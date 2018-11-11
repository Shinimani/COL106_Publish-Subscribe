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
  	User tempuser = this.userTable.findUser(userid);
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
  	User tempuser = this.userTable.findUser(userid);
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
  		tempuser.Unsubscribe(temppublisher, time);
  	}
  }

  public void UnSubscribe(String time, String userid, String pubid) throws Exception
  {
  	int inttime = Integer.parseInt(time);
  	int intuserid = Integer.parseInt(userid);
  	int intpubid = Integer.parseInt(pubid);
  	UnSubscribe(inttime, intuserid, intpubid);
  }

  private void NewPublish(int time, int userid, String text, int tid)
  {
  	User tempuser = this.userTable.findUser(userid);
  	if (tempuser==null)
  	{
  		// throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{
  		// if (tempuser.returnPostById(tid) == null)
  		// {
  			Post temppost = new Post(time, userid, text, tid);
                // System.out.println(temppost);
                // System.out.println(tempuser);
        // System.out.println("here");
  			tempuser.addPost(temppost);
  		// }
  		// else
  		// {
  			// throw new Exception("Post with id " + tid + " already exists");
  		// }

  	}

  }

  public void NewPublish(String time, String userid, String text, String tid)
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
  			throw new Exception("Post with id " + tid + " already exists");
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
  	User tempuser = this.userTable.findUser(userid);
  	if (tempuser==null)
  	{
  		throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{

  		if (tempuser.returnPostById(tid) == null)
  		{
  			Post temppost = new Post(time, userid, origpostid, text, tid);
  			tempuser.addPost(temppost);
  		}
  		else
  		{
  			throw new Exception("Post with id " + tid + " already exists");
  		}
  	}
  }

  public void Reply(String time, String userid, String origpostid, String text, String tid) throws Exception
  {
    int inttime = Integer.parseInt(time);
    int intuserid = Integer.parseInt(userid);
    int intorigpostid = Integer.parseInt(origpostid);
    int inttid = Integer.parseInt(tid);  	
    Reply(inttime, intuserid, intorigpostid, text, inttid);
  }

  private void Read(int time, int userid) throws Exception
  {
          String string = "[";
  	User tempuser = this.userTable.findUser(userid);
  	int tm = tempuser.getTime();
  	if (tempuser==null)
  	{
  	// System.out.println("Yaha excepahucha?");
    	throw new Exception("User with id" + userid + "does not exist");
  	} else
  	{
    // System.out.println("Yaha pahucha?");
// System.out.println("yohoo" + tempuser.Subscriptions.size() + "yoohoo");

  		for (int i = 0; i < tempuser.Subscriptions.size(); i++)
  		{
  			User temp1user = this.userTable.findUser(tempuser.Subscriptions.get(i).getUser());

  			int timesubs = tempuser.Subscriptions.get(i).getTimeStamp();
        // System.out.println("Hello");

        // System.out.println("yohoo" + temp1user.PostList + "yoohoo");

  			for (int j = 0; j < temp1user.PostList.size(); j++)
  			{
  				Post temppost = temp1user.PostList.get(j);
  				if (temppost.getTime() >= tm && timesubs <= temppost.getTime())
  				{
  					string = string + temppost.getText() + ",";
  				}
  			}
  		}
      if (string.length() <= 1)
        System.out.println("No text found");
      else
  		System.out.println(string.substring(0,string.length()-1) + "]");
      // System.out.println(string);
  	}
  }

  public void Read (String time, String userid) throws Exception
  {
    int inttime = Integer.parseInt(time);
    int intuserid = Integer.parseInt(userid);
    Read(inttime, intuserid);
  }

    public void performAction(String st) {
        String st1 = st.replace("(", ",");
        String string = st1.replace(")", "");
        String[] word = string.split(",");
try
{

        //To Subscribe a user
        if (word[0].toLowerCase().equals("subscribe")) {
            System.out.print(st);
            Subscribe(word[1], word[2], word[3]);
            System.out.println();
        }

        //To unsubscribe a user
        if (word[0].toLowerCase().equals("unsubscribe")) {
            System.out.print(st);
            UnSubscribe(word[1], word[2], word[3]);
            System.out.println();
        }

        //To read the text from the publishers
        if (word[0].toLowerCase().equals("read")) {
            System.out.print(st);
            Read(word[1], word[2]);
            System.out.println();
        }

        //To publish NEW text from the publisher
        if (word[0].toLowerCase().equals("publish") && word[3].toLowerCase().equals("new")) {
            System.out.println(st);
            NewPublish(word[1], word[2], word[4], word[5]);
            System.out.println();
        } else {
            //To Repost a text published initially by another publishers
            if (word[0].toLowerCase().equals("publish") && word[3].toLowerCase().equals("repost")) {
                System.out.print(st);
            	Repost(word[1], word[2], word[4], word[5]);
            System.out.println();
            }

            //To reply to a text published by a user
            if (word[0].toLowerCase().equals("publish") && word[3].toLowerCase().equals("reply")) {
                System.out.println(st);
                Reply(word[1], word[2], word[4], word[5], word[6]);
            System.out.println();
            }
        }

    }
    catch (Exception e)
{
  e.getMessage();
            System.out.println();
}


}

}
