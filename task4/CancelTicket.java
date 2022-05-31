package task4;

import java.util.ArrayList;
import java.util.List;

public class CancelTicket 
{
	
	
	public static Object cancelticket(int bookingid)
	{
		if(Booking.hash.containsKey(bookingid) )
			return CancelStatus.cancelled;
		
		
		return CancelStatus.Nobookingexist;
	}
	
}
