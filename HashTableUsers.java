
class HashEntry
{
	User value;
	int key;
	HashEntry next;

	HashEntry(User value)
	{
		this.value = value;
		this.next = null;
		this.key = value.getId();
	}

}

public class HashTableUsers{

	public HashEntry[] table;
//	public int noOfElements;


	public HashTableUsers()
	{
		table = new HashEntry[101];
		for (int i = 0;i<101;i++)
		{
			table[i] = null;
		}

	}

	public void addUser(User u)
	{
		int hash = getHashIndex(u.getId());
		if (table[hash]==null)
		{
			table[hash] = new HashEntry (u);
		}
		else
		{
			HashEntry entry = table[hash];
			while (entry.next!=null && entry.key != u.getId())
			{
				entry=entry.next;
			}
			if (entry.key != (u.getId()))
				entry.next = new HashEntry(u);
		}
	}

	public int getHashIndex(int x)
	{
		return x%101;
	}

	public User findUser(int Uid)
	{
		User ans = null;
		int hash = this.getHashIndex(Uid);
		HashEntry hashe = this.table[hash];
		while (hashe!=null)
		{
			if (hashe.value.userid == Uid)
			{
				ans = hashe.value;
				break;
			}
			else hashe = hashe.next;
		}
		return ans;
	}

}
