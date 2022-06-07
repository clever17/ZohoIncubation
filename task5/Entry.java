package task5;

public class Entry<k,v>
{
	private  k key;
	private v value;
	private Entry<k, v> nextnode;
	
	public Entry()
	{
		
		
	}
	
	public Entry(k key, v value, Entry<k, v> nextnode) 
	{
		super();
		this.key = key;
		this.value = value;
		this.nextnode = nextnode;
	}
	

	public k getKey() {
		return key;
	}

	public void setKey(k key) {
		this.key = key;
	}

	public v getValue() {
		return value;
	}

	public void setValue(v value) {
		this.value = value;
	}

	public Entry<k, v> getNextnode() {
		return nextnode;
	}

	public void setNextnode(Entry<k, v> nextnode) {
		this.nextnode = nextnode;
	}

}
