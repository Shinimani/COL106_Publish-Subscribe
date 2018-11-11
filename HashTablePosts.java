
class HashEntryPost
{
	Post value;
	int key;
	HashEntryPost next;

	HashEntryPost(Text value)
	{
		this.value = value;
		this.next = null;
		this.key = value.getId();
	}

}

public class HashTablePosts{

	public HashEntryPost[] table;
//	public int noOfElements;


	public HashTablePosts()
	{
		table = new HashEntryPost[101];
		for (int i = 0;i<101;i++)
		{
			table[i] = null;
		}

	}

	public void addPost(Post u)
	{
		int hash = getHashIndex(u.getId());
		if (table[hash]==null)
		{
			table[hash] = new HashEntryPost (u);
		}
		else
		{
			HashEntryPost entry = table[hash];
			while (entry.next!=null && entry.key != u.getId())
			{
				entry=entry.next;
			}
			if (entry.key != (u.getId()))
				entry.next = new HashEntryPost(u);
		}
	}

	public int getHashIndex(int x)
	{
		// return x%101;
		return 0;
	}

	public boolean hasPost(int postid)
	{
		boolean ans = false;
		int hash = this.getHashIndex(postid);
		HashEntryPost hashe = this.table[hash];
		while (hashe!=null)
		{
			if (hashe.value.getId() == postid)
			{
				ans = true;
				break;
			}
			else hashe = hashe.next;
		}
		return ans;
	}

	}
	public Post findPost(int Uid)
	{
		Post ans = null;
		int hash = this.getHashIndex(Uid);
		HashEntryPost hashe = this.table[hash];
		while (hashe!=null)
		{
			if (hashe.value.getId() == Uid)
			{
				ans = hashe.value;
				break;
			}
			else hashe = hashe.next;
		}
		return ans;
	}

}
