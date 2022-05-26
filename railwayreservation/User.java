package railwayreservation;

import java.util.*;

public class User 
{
	static int id=1;
	private String name;
	private int age;
	private String gender;
	private String birthprefre;
	private int passenid=id++;
	
	private String cname;
	private int cage;
	private String cgender;
	String alloted;
	int number;
	
	public User()
	{
		
	}
	public String getCname() 
	{
		return cname;
	}

	public void setCname(String cname) 
	{
		this.cname = cname;
	}

	public int getCage() 
	{
		return cage;
	}

	public void setCage(int cage) 
	{
		this.cage = cage;
	}

	public String getCgender() 
	{
		return cgender;
	}

	public void setCgender(String cgender) 
	{
		this.cgender = cgender;
	}

	public int getPassengerid()
	{
		return passenid;
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
	
	public String getBirthprefre() 
	{
		return birthprefre;
	}
	
	public void setBirthprefre(String birthprefre) 
	{
		this.birthprefre = birthprefre;
	}
	
	
}
