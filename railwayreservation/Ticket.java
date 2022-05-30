package railwayreservation;
import java.util.*;
public class Ticket 
{
	static  int availlowerberth=2; 
	static  int availmiddleberth=1;
	static  int availupperberth=1;  
	static  int availrac=1; 
	static  int availwaiting=1;
	
	static List<Integer> lowerberthpostin = new ArrayList<Integer>(Arrays.asList(1, 2));   
	static List<Integer> middleberthpositn = new ArrayList<Integer>(Arrays.asList(1));    
	static List<Integer> upperberthpositn = new ArrayList<Integer>(Arrays.asList(1));   
	static List<Integer> racpositn = new ArrayList<Integer>(Arrays.asList(1));   
	static List<Integer> waitinglistpositn = new ArrayList<Integer>(Arrays.asList(1));  
	
	
	static Queue<Integer> raclist = new LinkedList<>();
	static Queue<Integer> waitnglist = new LinkedList<>();
	static List<Integer> bookedlist = new ArrayList<Integer>();
	static Map<Integer, User> user = new HashMap<>();
	
	static public void bookTicket(User s, int number, String allotberth)
	{
		
		s.number=number;
		s.alloted=allotberth;
		user.put(s.getPassengerid(), s);
		bookedlist.add(s.getPassengerid());
		System.out.println("Passenger Id:"+s.getPassengerid());
		System.out.println("Passenger Name: "+s.getName());
		System.out.println("Passenger Age: "+s.getAge());
		System.out.println("Passenger Gender: "+s.getGender());
		System.out.println("Alloted berth:"+number+allotberth);
		System.out.println("Booked Succeessfully");
	}
	
	static public void cancelTicket(int passid)
	{
		User s= user.get(passid);
		
		user.remove(passid);
		bookedlist.remove(passid);
		int num=s.number;
		System.out.println("Cancelled Successfully");
		
		if(s.alloted.equals("l"))
		{
			lowerberthpostin.add(num);
			availlowerberth++;
			
		}
		else if(s.alloted.equals("m"))
		{
			middleberthpositn.add(num);
			availmiddleberth++;
		}
		else if(s.alloted.equals("u"))
		{
			upperberthpositn.add(num);
			availupperberth++;
		}
		if(raclist.size()>0)
		{
			User userac=user.get(raclist.poll());
			int racnum=userac.number;
			racpositn.add(racnum);
			raclist.remove(userac.getPassengerid());
			availrac++;
			if(waitnglist.size()>0)
			{
				User userwl=user.get(waitnglist.poll());
				int numwl=userwl.number;
				waitinglistpositn.add(numwl);
				waitnglist.remove(userwl.getPassengerid());
			
				userwl.number=racpositn.get(0);
				userwl.alloted="RAC";
				userwl.number=numwl+1;
				racpositn.remove(0);
				raclist.add(userwl.getPassengerid());
				availwaiting++;
				availrac--;
			}
			RailwayReservationSystem.bookTicket(userac);
		}
		if(raclist.size()>0)
		{
			for(int i=1;i<=raclist.size();i++)
			{
				User chnge = user.get(raclist.poll());
				change.number=i;
				if(waitinglist.size()>0)
				{
					User chan = user.get(waitinglist.poll());
					chan.number=i;
				}
			}	
		}
	}
	
	static public void racTicket(User s, int number , String RACberth)
	{
		s.number=number;
		s.alloted=RACberth;
		user.put(s.getPassengerid(), s);
		raclist.add(s.getPassengerid());
		System.out.println("Passenger Id:"+s.getPassengerid());
		System.out.println("Passenger Name: "+s.getName());
		System.out.println("Passenger Age: "+s.getAge());
		System.out.println("Passenger Gender: "+s.getGender());
		System.out.println("Alloted berth:"+number+RACberth);
		System.out.println("RAC Berth Given");
		
	}
	
	static public void waitingTicket(User s, int number, String WLberth)
	{
		s.number=number;
		s.alloted=WLberth;
		user.put(s.getPassengerid(), s);
		waitnglist.add(s.getPassengerid());
		System.out.println("Passenger Id:"+s.getPassengerid());
		System.out.println("Passenger Name: "+s.getName());
		System.out.println("Passenger Age: "+s.getAge());
		System.out.println("Passenger Gender: "+s.getGender());
		System.out.println("Alloted berth:"+number+WLberth);
		System.out.println("You're in Waiting List");
	}
	
	static public void passengerDetails()
	{
		if(user.size() == 0)
		{
			System.out.println("No seat allocated");
		}
		else
		{
			for(User s: user.values())
			{
				System.out.println("\nPassenger Id:"+s.getPassengerid());
				System.out.println("Passenger Name:"+s.getName());
				System.out.println("Passenger Age:"+s.getAge());
				System.out.println("Passenger Gender:"+s.getGender());
				System.out.println("Child Name:"+s.getCname());
				System.out.println("Child Age:"+s.getCage());
				System.out.println("Child Gender:"+s.getCgender());
				System.out.println("Allocated Berth:"+s.number+s.alloted);
				
			}
		}
	}
	static public void printAvailableTicket(User s)
	{
		System.out.println("Avaialable Lower Berth:"+availlowerberth);
		System.out.println("Avaialable Middle Berth:"+availmiddleberth);
		System.out.println("Avaialable Upper Berth:"+availupperberth);
		System.out.println("Available Rac:"+availrac);
		System.out.println("Available Waiting List:"+availwaiting);
		int sum=availlowerberth+availmiddleberth+availupperberth;
		System.out.println("Total Number of Tickets Available"+sum);
	}
	
}
