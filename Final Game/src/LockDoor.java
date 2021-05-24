
public class LockDoor extends Door
{
	private boolean lock;
	public int numKeys = 0;
	
	public LockDoor()
	{
		lock = true;
	}
	
	public void Lock()
	{
		if (numKeys != 3)
		{
			if(open == false)
			{
				lock = true;
			}
			else
				System.out.print("You don't have all the keys!");
		}
	}
	
	public void UnLock()
	{
		if (numKeys >= 3)
		{
			if(lock = true)
			{
				lock = false;
				open = true;
			}
			else
				System.out.print("You have already gathered all the keys!");
			
		}
	}	
}
