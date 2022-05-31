package task4;

import java.io.Serializable;

public class Passenger implements Serializable
{
	private int i=1;
	private int id=i++;
	private String name;
	private int age;
	private String gender;
	private String berthprefrence;
	String alloted;
	private String childname;
	private int childage;
	private String childgender;
	
	

	public Passenger() {
		
	}

	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public String getBerthprefrence() 
	{
		return berthprefrence;
	}

	public void setBerthprefrence(String berthprefrence) 
	{
		this.berthprefrence = berthprefrence;
	}
	public String getChildname() 
	{
		return childname;
	}


	public void setChildname(String childname) 
	{
		this.childname = childname;
	}


	public int getChildage() 
	{
		return childage;
	}


	public void setChildage(int childage) 
	{
		this.childage = childage;
	}


	public String getChildgender() {
		return childgender;
	}


	public void setChildgender(String childgender) {
		this.childgender = childgender;
	}

}
