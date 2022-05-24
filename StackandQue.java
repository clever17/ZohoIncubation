package task3;

import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class StackandQue
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedStack ls = new LinkedStack();
		LinkedQueue  lq = new LinkedQueue();
		char ch = 0;
		
		do
		{
			
			
			System.out.println("Stack and Queue Operations\n");
			System.out.println("1. Stack");
			System.out.println("2. Queue");
			
			int choice;
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				do
		    	{	
					
		    		System.out.println("\nLinked Stack Operations");
		            System.out.println("1. push");
		            System.out.println("2. pop");
		            System.out.println("3. peek");
		            System.out.println("4. check empty");
		            System.out.println("5. size");            
		            int num = sc.nextInt();
		    		
		            switch (num) 
		            {
		            case 1 :
		                System.out.println("Enter integer element to push");
		                
		                ls.push(sc.next()); 
		                break;                         
		            case 2 : 
		                try
		                {
		                    System.out.println("Popped Element = "+ ls.pop());
		                }
		                catch (Exception e)
		                {
		                    System.out.println("Error : " + e.getMessage());
		                }    
		                break;                         
		            case 3 : 
		                try
		                {
		                    System.out.println("Peek Element = "+ ls.peek());
		                }
		                catch (Exception e)
		                {
		                    System.out.println("Error : " + e.getMessage());
		                }
		                break;                         
		            case 4 : 
		                System.out.println("Empty status = "+ ls.isEmpty());
		                break;                
		            case 5 : 
		                System.out.println("Size = "+ ls.getSize()); 
		                break;                
		            case 6 : 
		                System.out.println("Stack = "); 
		                ls.display();
		                break;                        
		            default : 
		                System.out.println("Wrong Entry \n ");
		                break;
		            }           
		                
		            ls.display();            
		            System.out.println("\nDo you want to continue (Type y or n) \n");
		            
		            ch = sc.next().charAt(0);   
		    		
		    	}
		    	while(ch=='y'||ch=='n');

				
			}
			case 2:
			{
				do
		    	{
					
		    		System.out.println("\nLinked Queue Operations");
		            System.out.println("1. Enqueue");
		            System.out.println("2. Dequeue");
		            System.out.println("3. peek");
		            System.out.println("4. check empty");
		            System.out.println("5. size");            
		            int num = sc.nextInt();
		    		
		            switch (num) 
		            {
		            case 1 :
		                System.out.println("Enter integer element to enqueue");
		                lq.enque( sc.next()); 
		                break;                         
		            case 2 : 
		                try
		                {
		                    System.out.println("Dequeue Element = "+ lq.deque());
		                }
		                catch (Exception e)
		                {
		                    System.out.println("Error : " + e.getMessage());
		                }    
		                break;                         
		            case 3 : 
		                try
		                {
		                    System.out.println("Peek Element = "+ lq.peek());
		                }
		                catch (Exception e)
		                {
		                    System.out.println("Error : " + e.getMessage());
		                }
		                break;                         
		            case 4 : 
		                System.out.println("Empty status = "+ ls.isEmpty());
		                break;                
		            case 5 : 
		                System.out.println("Size = "+ ls.getSize()); 
		                break;                
		            case 6 : 
		                System.out.println("Stack = "); 
		                lq.display();
		                break;                        
		            default : 
		                System.out.println("Wrong Entry \n ");
		                break;
		            }           
		                
		            lq.display();            
		            System.out.println("\nDo you want to continue (Type y or n) \n");
		            
		            ch = sc.next().charAt(0);   
		    		
		    	}
		    	while(ch=='y'||ch=='n');
		
			}
			}
			
		ch=sc.next().charAt(0);
		}while(ch=='y' || ch=='n');
		
	
	}
}
