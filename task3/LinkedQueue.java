package task3;


class LinkedQueue
{
    protected Node rear,front ;
    protected int size ;
 
    public LinkedQueue()
    {
        rear = null;
        front=null;
        size = 0;
    }    
 
    public boolean isEmpty()
    {
        return front == null;
    }    
 
    public int getSize()
    {
        return size;
    }    
 
    public void enque(String data)
    {
        Node node = new Node (data, null);
        if (front == null)
            front = node;
        else
        {
            rear.setnextnode(node);
            
        }
        rear = node;
        size++ ;
    }    
 
    public String deque()
    {
        if (isEmpty() )
            System.out.println("Underflow") ;
        Node temp = front;
        front = temp.getLink();
        size-- ;
        return temp.getData();
    }    
    
    public String peek()
    {
        if (isEmpty() )
            System.out.println("Underflow") ;
        return front.getData();
    }    
    
    public void display()
    {
        System.out.print("\nQueue = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        Node currentnode = front;
        while (currentnode != null)
        {
            System.out.print(currentnode.getData()+" ");
            currentnode = currentnode.getLink();
        }
        System.out.println();        
    }
}
