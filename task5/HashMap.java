package task5;

import java.util.LinkedList;

public class HashMap <k,v>
{
	
	private int size=16;
	
	private Entry<k, v>[] orignalmap=null; 
	private Entry<k, v>[] tempmap=null;   

	
    public HashMap()
    {
        orignalmap = new Entry[size];
        tempmap = new Entry[size];
    }

    public HashMap(int size)
    {
        this.size = size;
        orignalmap = new Entry[size];
        tempmap = new Entry[size];
    }
	
	private int hashfunction(k key)
	{
		if(key ==null)
			return 0;
		return Math.abs(key.hashCode() % size);
	}
	
	public void set(k key, v value)
	{
		int index =hashfunction(key);
		Entry<k, v> entry = new Entry<>( key, value, null);
		
		if(orignalmap[index] == null)
		{
			
			orignalmap[index]=entry;
		}
		else
		{
			
			Entry<k, v> presentnode=null;
			Entry<k, v> currentnode=orignalmap[index];
			while(currentnode!=null)
			{
				if(currentnode.getKey().equals(key))
				{
			
					currentnode.setValue(value);
					break;
				}
				presentnode=currentnode;
				currentnode=currentnode.getNextnode();
			}
			if(presentnode!=null)
			{
				
				presentnode.setNextnode(entry);
			}
		}
		
	}
	
	
	public v get(k key)
	{
		
		int tempindex=hashfunction(key);
		if(orignalmap[tempindex]!=null)
		{
			v value=null;
			int index = hashfunction(key);
			Entry<k, v> entry = orignalmap[index];
			
			while(entry!=null)
			{
				if(entry.getKey().equals(key))
				{
					value = entry.getValue();
					break;
				}
				entry=entry.getNextnode();
			}
			return value;
		}
		else
		{
			v value=null;
			int index = hashfunction(key);
			Entry<k, v> entry = tempmap[index];
			
			while(entry!=null)
			{
				if(entry.getKey().equals(key))
				{
					value = entry.getValue();
					break;
				}
				entry=entry.getNextnode();
			}
			return value;
		}
		
		
	}
	
	public void unset(k key)
	{
		
		int index = hashfunction(key);
		
		Entry<k, v> presentnode =null;
		Entry<k, v> entry=orignalmap[index];
		
		while(entry != null)
		{
			if(entry.getKey().equals(key))
			{
				if(presentnode==null)
				{
					entry = entry.getNextnode();
					orignalmap[index]=entry;
					return ;
				}
				else
				{
					presentnode.setNextnode(entry.getNextnode());
					return ;
				}
			}
			presentnode=entry;
			entry=entry.getNextnode();
		}
		
		
	}

	public int count(v st)
	{
		int count=0;
		for(int i=0;i<size;i++)
		{
			if(orignalmap[i]!=null)
			{
				Entry<k, v> currentNode = orignalmap[i];
			    
				while (currentNode != null)
				{
			        if(currentNode.getValue().equals(st))
			        	count++;
			                
                    
			        currentNode = currentNode.getNextnode();
			    }
		    }
		}
		return count;
	}
	
	private void setoldmap(k key, v value)
	{
		int index =hashfunction(key);
		Entry<k, v> entry = new Entry<>( key, value, null);
		
		if(tempmap[index] == null)
		{
			tempmap[index]=entry;
		}
		else
		{
			Entry<k, v> presentnode=null;
			Entry<k, v> currentnode=tempmap[index];
			while(currentnode!=null)
			{
				if(currentnode.getKey().equals(key))
				{
					currentnode.setValue(value);
					break;
				}
				presentnode=currentnode;
				currentnode=currentnode.getNextnode();
			}
			if(presentnode!=null)
			{
				presentnode.setNextnode(entry);
			}
		}

	}
	
	boolean  begin;
	public void begin()  
	{
		begin=true;
		
		if(orignalmap==null)
		{
			return;
		}
		else
		{
			for(int i=0;i<orignalmap.length;i++)
			{
				Entry<k, v> currentnode = orignalmap[i];
				while(currentnode!=null)
				{
					setoldmap(currentnode.getKey(), currentnode.getValue());
					currentnode=currentnode.getNextnode();
				}
			}
	    }
		rollback();
		
		
	}
	
	public void rollback() 
	{
	
	
			if(begin==true)
			{
				for(int i=0;i<size;i++)
				{
					if(orignalmap[i]!=null)
					{
						Entry<k, v> currentnode = orignalmap[i];
						while(currentnode!=null)
						{
							unset(currentnode.getKey());
							currentnode=currentnode.getNextnode();
						}
					}
				}
			}
			else
				System.out.println("Can't rollback before begin");
				
		}
		
	
	public void commit()
	{
		
		for(int i=0;i<size;i++)
		{
			Entry<k, v> currentnode = tempmap[i];
			
			while(currentnode!=null)
			{
					commitset(currentnode.getKey(), currentnode.getValue());
					currentnode=currentnode.getNextnode();	
				
			}
		}
		
    }
	private void commitset(k key, v value)
	{
		int index =hashfunction(key);
		Entry<k, v> entry = new Entry<>( key, value, null);
		
		if(orignalmap[index] == null)
		{
			
			orignalmap[index]=entry;
		}
		else
		{
			
			Entry<k, v> presentnode=null;
			Entry<k, v> currentnode=orignalmap[index];
			while(currentnode!=null)
			{
				if(currentnode.getKey().equals(key))
				{
			
					break;
				}
				presentnode=currentnode;
				currentnode=currentnode.getNextnode();
			}
			if(presentnode!=null)
			{
				
				presentnode.setNextnode(entry);
			}
		}
	}
}
	