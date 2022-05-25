package Task2;

import java.util.ArrayList;

public class String_Functions
{

	static char charAt(int index,String string)
	{
		
		char ch[]=string.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(index==i)
			{
				return ch[i];
			}
		
		}
				
		
		return ch[index];
		
	}
	static String concat(String string2)
	{
		String string1="Hello ";
		
		String str3;
		str3=string1+string2;
		
		
		return str3;
	}
	static int length()
	{
		String str="hello";
		char[] ch=str.toCharArray();
		int count = 0;
		for(char c: ch)
		{
			count++;
		}
		
		return count;
	}
	static boolean compareTo(String string1,String string2)
	{
		
		char[] char1=string1.toCharArray();
		char[] char2=string2.toCharArray();
		
		
		if(char1.length!=char2.length)
			return false;
		
		for(int i=0;i<char1.length;i++)
		{
			if(string1.charAt(i)!=string2.charAt(i))
			{
				return false;
			}
		}
		
		
				
		return true;
	}
	static String[] split( String substring)
	{
	 
		String string = "My name is Suyash "; 
		 
		ArrayList<String> list = new ArrayList<String>(); 
				 
		 
		char[] charArray = string.toCharArray(); 
		
		for (int i = 0; i < charArray.length; i++) 
		{ 
			if (charArray[i] != ' ') 
			{ 
				substring = substring + charArray[i]; 
			} 
			else 
			{ 
			 
				list.add(substring); 
				substring = ""; 
			} 
		} 
		String[] split =new String[list.size()];
		for(int i=0;i<list.size();i++)
			split[i]=list.get(i);
		 

		
		return split;
		
	}
	static boolean contains(String main, String substring) 
	{
	    boolean flag=false;
	    
	    if(substring==null) 
	    {
	        return flag;
	    }

	    char full[]=main.toCharArray();
	    char sub[]=substring.toCharArray();
	    int count=0;
	    

	    for(int i=0;i<full.length;i++) 
	    {

	        if(full[i]==sub[count]) 
	        {
	            count++;
	        } else {
	            count=0;
	        }

	        if(count==sub.length) 
	        {
	            flag=true;
	            return flag;
	        }

	    }
	    return flag;

	}
	static boolean equals(String string1,String string2)
	{
		
		char char1[]=string1.toCharArray();
		char char2[]=string2.toCharArray();
		
		int count=0;
		
		if(char1.length!=char2.length)
			return false;
		
		for(int i=0;i<char1.length;i++)
		{
			if(char1[i]==char2[i])
				{
					count++;
				}
				else
					return false;	
		}
		if(char1.length==count)
			return true;
		
		
		return false;
		
	}
	static int IndexOf(String str)
	{
		String string="my name";
		char full[]=string.toCharArray();
		char sub[]=string.toCharArray();
		
		
	    int count=0;
	    

	    for(int i=0;i<full.length;i++) 
	    {

	        if(full[i]==sub[count]) 
	        {
	            count++;
	        } 

	        if(count==sub.length) 
	        {    
	            return count;
	        }

	    }
		
		return count;
	}
	static boolean isEmpty(String string)
	{
		char[] str=string.toCharArray();
		
		if(string.length()==0)
			return true;
		else 
			return false;		
	}
	static int lastIndexOf(String str)
	{
		String string="My name is Suyash";
		char[] st=string.toCharArray(); 
		char[] sub=string.toCharArray();
		
		int count=0;
		int size=sub.length-1;
		int i=1;
		while(st[i]!=sub[size])
		{
			
			i++;
		}
		
		return i;
	}
	static boolean startWith(String chars)
	{
		String st="My name";
		char [] full=st.toCharArray();
		char [] sub=chars.toCharArray();
		
		for(int i=0;i<sub.length;i++)
		{
			if(full[i]!=sub[i])
				return false;
				
		}
		return true;
	}
	static String replace(char searchar, char newchar)
	{
		String str="Hello";
		char[] st=str.toCharArray();
		
		
		for(int i=0;i<st.length;i++)
		{
			if(st[i]==searchar)
			{
				st[i]=newchar;
			}
		}
		str=str.valueOf(st);
		return str;
	}
	static String toUpperCase()
	{
		String str="HELLO";
		char[] st=str.toCharArray();
		for(int i=0;i<st.length;i++) 
		{
			if(st[i]>='a' && st[i]<='z')
				st[i]=(char) (st[i]-32);
		}
		str=str.valueOf(st);
		return str;
	}
	static String toLowerCase()
	{
		String str="HELLO";
		char[] st=str.toCharArray();
		for(int i=0;i<st.length;i++)
		{
			if(st[i]>='A' && st[i]<='Z')
				st[i]=(char) (st[i]+32);
		}
		str=str.valueOf(st);
		return str;
	}
	static boolean endsWith(String chars)
	{
		String str="Hello";
		char[] st=str.toCharArray();
		char[] sub=chars.toCharArray();
		
		int count=0;
		for(int i=0;i<st.length;i++)
		{
			if(st[i]==sub[count])
			{
				count++;
			}
			if(count==sub.length)
				return true;
		}
		
		return false;
	}
	static char[] toCharArray(String chars)
	{
		char[] sub=new char[chars.length()];
		
		for(int i=0;i<sub.length;i++)
		{
			sub[i]=chars.charAt(i);
		}
		
		
		return sub;
		
	}
	public static void main(String [] args)
	{
		System.out.println(charAt(2, "hello"));
		System.out.println(concat("World"));
		System.out.println(length());
		System.out.println(compareTo("Hello","World"));
		String[] res = split(" ");
	    for(String str : res)
	        System.out.println(str);
		System.out.println(contains("Hello", "llo"));
		System.out.println(equals("Hello", "Hello"));
		System.out.println(IndexOf("name"));
		System.out.println(isEmpty("Hello"));
		System.out.println(lastIndexOf("Suyash"));
		System.out.println(startWith("My"));
		System.out.println(replace('l', 's'));
		System.out.println(toUpperCase());
		System.out.println(toLowerCase());
		System.out.println(endsWith("lo"));
		System.out.println(toCharArray("hello"));
		
	}
}
