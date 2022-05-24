package task3;

public class Node
{
    protected String data;
    protected Node nextNode;
 
    public Node()
    {
        nextNode = null;
        data = null;
    }    
    public Node(String d,Node n)
    {
        data = d;
        nextNode = n;
    }    
    public void setnextnode(Node n)
    {
        nextNode = n;
    }    
    public void setData(String d)
    {
        data = d;
    }    
    public Node getLink()
    {
        return nextNode;
    }    
    public String getData()
    {
        return data;
    }
}

