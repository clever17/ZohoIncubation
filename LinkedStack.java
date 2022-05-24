package task3;


public class LinkedStack
{
    protected Node top ;
    protected int size ;
 
    public LinkedStack()
    {
        top = null;
        size = 0;
    }    
 
    public boolean isEmpty()
    {
        return top == null;
    }    
 
    public int getSize()
    {
        return size;
    }    
 
    public void push(String data)
    {
        Node head = new Node (data, null);
        if (top == null)
            top = head;
        else
        {
            head.setnextnode(top);
            top = head;
        }
        size++ ;
    }    
 
    public String pop()
    {
        if (isEmpty() )
            System.out.println("Underflow") ;
        Node temp = top;
        top = temp.getLink();
        size-- ;
        return temp.getData();
    }    
    
    public String peek()
    {
        if (isEmpty() )
            System.out.println("Underflow") ;
        
        return top.getData();
    }    
    
    public void display()
    {
        System.out.print("\nStack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        Node currentnode = top;
        while (currentnode != null)
        {
            System.out.print(currentnode.getData()+" ");
            currentnode = currentnode.getLink();
        }
        System.out.println();        
    }
}