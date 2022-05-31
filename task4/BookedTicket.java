package task4;

import java.util.HashMap;
import java.util.Map;

public class BookedTicket 
{
	
	public static Object printBookedTicket()
	{
		if(Booking.hash.size()==0)
			return "No seat Booked";
		else
		{
			return Booking.hash;
		}
	}
	
	
}