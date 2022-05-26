package railwayreservation;

import java.util.Scanner;

public class RailwayReservationSystem 
{
	static Scanner sc = new Scanner(System.in);
	public static void bookTicket(User s)
	{
		
		if(Ticket.availwaiting==0)
		{
			System.out.println("No Ticket Available");
			return;
		}
		else if(s.getAge() > 60 && Ticket.availlowerberth > 0)
		{
			System.out.println("As you're senior citizen so we have allocated a lower berth for you");
			
			Ticket.bookTicket(s, Ticket.lowerberthpostin.get(0), "l");
			Ticket.lowerberthpostin.remove(0);
			Ticket.availlowerberth--;
		}
		else if(s.getCname()!=("null") && Ticket.availlowerberth>0)
		{
			System.out.println("You have a child so we have allocated the lower berth");
			Ticket.bookTicket(s,Ticket.lowerberthpostin.get(0),"l");
			Ticket.lowerberthpostin.remove(0);
			Ticket.availlowerberth--;
		}
		else if( (s.getBirthprefre().equals("l") && Ticket.availlowerberth > 0) || 
				(s.getBirthprefre().equals("m") && Ticket.availmiddleberth > 0)|| 
				(s.getBirthprefre().equals("u") && Ticket.availupperberth > 0))
			{
			
				System.out.println("Preffered Berth Available");
				if(s.getBirthprefre().equals("l") && Ticket.availlowerberth > 0)
				{
					System.out.println("Lower Berth Allocated");
					
					Ticket.bookTicket(s,Ticket.lowerberthpostin.get(0),"l");
					Ticket.lowerberthpostin.remove(0);
					Ticket.availlowerberth--;
				}
				else if(s.getBirthprefre().equals("m") && Ticket.availmiddleberth > 0)
				{
					System.out.println("Middle Berth Allocated");
					
					Ticket.bookTicket(s,Ticket.middleberthpositn.get(0),"m");
					Ticket.middleberthpositn.remove(0);
					Ticket.availmiddleberth--;
				}
				else if(s.getBirthprefre().equals("u") && Ticket.availupperberth > 0)
				{
					System.out.println("Upper Berth Allocated");
					
					Ticket.bookTicket(s,Ticket.upperberthpositn.get(0),"u");
					Ticket.upperberthpositn.remove(0);
					Ticket.availupperberth--;
				}
				
		}
		
		else if(Ticket.availlowerberth > 0)
		{
			System.out.println("Preffered berth not available");
			System.out.println("Lower Berth Allocated");
		
			Ticket.bookTicket(s,Ticket.lowerberthpostin.get(0),"l");
			Ticket.lowerberthpostin.remove(0);
			Ticket.availlowerberth--;
		}
		
		
		else if(Ticket.availmiddleberth > 0)
		{
			System.out.println("Preffered berth not available");
			System.out.println("Middle Berth Allocated");
		
			Ticket.bookTicket(s,Ticket.middleberthpositn.get(0),"m");
			Ticket.middleberthpositn.remove(0);
			Ticket.availmiddleberth--;
		}
		else if(Ticket.availupperberth > 0)
		{
			System.out.println("Preffered berth not available");
			System.out.println("Upper Berth Allocated");
		
			Ticket.bookTicket(s,Ticket.upperberthpositn.get(0),"u");
			Ticket.upperberthpositn.remove(0);
			Ticket.availupperberth--;
		}
		else if(Ticket.availrac > 0)
		{
			System.out.println("Preffered berth not available");
			System.out.println("RAC available");
			Ticket.racTicket(s, Ticket.racpositn.get(0), "RAC");
			Ticket.racpositn.remove(0);
			Ticket.availrac--;
		}
		else if(Ticket.availwaiting > 0)
		{
			System.out.println("Preffered berth not available");
			System.out.println("Added to Waiting list");
			Ticket.bookTicket(s, Ticket.waitinglistpositn.get(0), "WL");
			Ticket.waitinglistpositn.remove(0);
			Ticket.availwaiting--;
		}
	}
	public static void cancelTicket(int id)
	{
		if(!Ticket.user.containsKey(id))
		{
			System.out.println("Passenger Id is not found");
		}
		else
		{
			Ticket.cancelTicket(id);
		}
		
	}
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		boolean loop=true;
		while(loop)
		{
			User uc = new User();
			System.out.println("\nRailway Reservation System");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Show Booked Tickets");
			System.out.println("4. Show Available Tickets");
			System.out.println("5. Exit");
			
			int choice=sc.nextInt();
			
			switch (choice) 
			{
			case 1:
			{
				String name;
				int age;
				String gender;
				String berthpref;
				System.out.println("Enter your Name: ");
				name=sc.next();
				uc.setName(name);
				System.out.println("Enter your Age: ");
				age=sc.nextInt();
				uc.setAge(age);
				System.out.println("Enter your Gender(m|f): ");
				gender=sc.next();
				uc.setGender(gender);
				
				if(uc.getGender().equals("f"))
				{
					System.out.println("Do you have a child \n 1.Yes \n 2.NO ");
					int ch=sc.nextInt();
					if(ch==1)
					{
						System.out.println("Enter your child Name:");
						uc.setCname(sc.next());
						System.out.println("Enter your child Age");
						uc.setCage(sc.nextInt());
						System.out.println("Enter your child Gender");
						uc.setCgender(sc.next());
						System.out.println("Enter your Berth Prefrence[ l | m | u ]");
						berthpref=sc.next();
						uc.setBirthprefre(berthpref);
						
						bookTicket(uc);
					}
					else
					{
						System.out.println("Enter your Berth Prefrence[ l | m | u ]");
						berthpref=sc.next();
						uc.setBirthprefre(berthpref);
						uc.setCname("null");
						bookTicket(uc);
					}
					
				}
				if(uc.getGender().equals("m"))
				{
					System.out.println("Enter your Berth Prefrence[ l | m | u ]");
					berthpref=sc.next();
					uc.setBirthprefre(berthpref);
					uc.setCname("null");
					bookTicket(uc);
				}
				
				
				break;
			}
			case 2:
			{
				System.out.println("Enter your Passenger id");
				int id;
				id=sc.nextInt();
				cancelTicket(id);
				
			}
			case 3:
			{
				Ticket.passengerDetails();
				break;
			}
			case 4:
			{
				Ticket.printAvailableTicket(uc);
			}
			case 5: 
			{
				loop=false;
				break;
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
		}
	}
}