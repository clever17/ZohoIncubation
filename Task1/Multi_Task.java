package Task1;


import java.util.*;

class Multi_Task
{	
	static class Node {
	int coeff, power;
	String var;
	Node next;
};
static Node add(Node start, int coeff, String var, int power)
{
	Node newnode = new Node();
	newnode.coeff = coeff;
	newnode.power = power;
	newnode.var=var;
	newnode.next = null;
	if (start == null)
		return newnode;
	Node ptr = start;
	while (ptr.next != null)
		ptr = ptr.next;
	ptr.next = newnode;
	return start;
} 
static void print( Node ptr)
{
	while (ptr.next != null) 
	{
		if(ptr.next.coeff>0)
			System.out.print( ptr.coeff+ptr.var+ptr.power+"+");
		else if(ptr.next.coeff<0)
			System.out.print( ptr.coeff+ptr.var+ptr.power+"");

		ptr = ptr.next;
	}
	System.out.print( ptr.coeff+ptr.var +ptr.power+"\n");
}
static void adding_similar(Node start)
{
	Node ptr1, ptr2, dup;
	ptr1 = start;
	while (ptr1 != null && ptr1.next != null) 
	{
		ptr2 = ptr1;
		while (ptr2.next != null) 
		{
			if (ptr1.var.equals(ptr2.next.var)) 
			{
				ptr1.coeff = ptr1.coeff + ptr2.next.coeff;
				dup = ptr2.next;
				ptr2.next = ptr2.next.next;
			}
			else
				ptr2 = ptr2.next;
		}
		ptr1 = ptr1.next;
	}
} 
static Node multiply(Node eqn1, Node eqn2, Node eqn3)
	{
	
	Node ptr1, ptr2;
	ptr1 = eqn1;
	ptr2 = eqn2;
	while (ptr1 != null) 
	{
		
		while (ptr2 != null) 
		{
			int coeff, power = 0;
			String var = null;
			
			coeff = ptr1.coeff * ptr2.coeff;
			if(ptr1.var.equals(ptr2.var))
			{
				power = ptr1.power + ptr2.power;
				var=ptr1.var;
			}
			else
				var=ptr1.var+ptr2.var;
				

			eqn3 = add(eqn3 ,coeff , var, power);
			ptr2 = ptr2.next;
		}
		ptr2 = eqn2;
		ptr1 = ptr1.next;
	}
	adding_similar(eqn3);
	
	return eqn3;
}



public static void main(String args[])
	{
		Node eqn1 = null, eqn2 = null, eqn3 = null;
		eqn1 = add(eqn1,3,"x", 1);  
		eqn1 = add(eqn1, 5,"y", 1); //3x+5y
											//6x2-8xy-30y2	
		eqn2 = add(eqn2, 2,"x", 1); //2x-6y
		eqn2 = add(eqn2, -6,"y", 1);
		
		print(eqn1);
		print(eqn2);
		eqn3 = multiply(eqn1, eqn2, eqn3);
		print(eqn3);
	}
}