package task5;

import java.util.Scanner;

public class Main 
{
	public static <V> void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> hashmap = new HashMap<>();
		
			
		while(true)
		{	
			String str;
			str=sc.next();
			
			if(str.equals("set"))
			{
				String st;
				String num;
				st=sc.next();
				num=sc.next();
				hashmap.set(st, num);
				System.out.println("inserted");
			}
			else if(str.equals("get"))
			{
				String st;
				st=sc.next();
				String s =hashmap.get(st);
				System.out.println(s);
			}
			else if(str.equals("count"))
			{
				String st;
				st=sc.next();
				System.out.println(hashmap.count(st));
			}
			else if(str.equals("unset"))
			{
				String st;
				st=sc.next();
				hashmap.unset(st);
				System.out.println("deleted");
			}
			else if(str.equals("begin"))
			{
				hashmap.begin();
				
			}
			else if(str.equals("rollback"))
			{
				hashmap.rollback();
			}
			else if(str.equals("commit"))
			{
				hashmap.commit();
			}
			else if(str.equals("update"))
			{
				String st;
				String num;
				st=sc.next();
				num=sc.next();
				String s=hashmap.get(st);
				if( s == null)
				{
					System.out.println("No variable named "+st);
				}
				else
				{
					hashmap.set(st, num);
					System.out.println("updated");
				}
			}
			
		
		}
		
	}
}
