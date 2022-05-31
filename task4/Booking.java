package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking 
{
	
	static Map<Integer, Passenger> hash = new HashMap<Integer, Passenger>();
	
	public static Object bookticket(Passenger s) throws IOException
	{	
	
		if(s.getAge()<5)
		{
			hash.put(s.getId(), s);
			return BookingStatus.created;
		}
		 if(s.getAge()>60 &&  BerthAvaiblity.getavailable_lowerberth() > 0)
		 {
			 hash.put(s.getId(), s);
			return "As you're senior citizen lower berth allotted";
		 }
		
		else if(s.getGender().equals("female"))
		{
			hash.put(s.getId(), s);
			return "you have a child so we have allocated a lower for you";
		}
		else if(s.getBerthprefrence().equals("l") && BerthAvaiblity.getavailable_lowerberth() > 0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		
		else if(s.getBerthprefrence().equals("m") && BerthAvaiblity.getavailable_middleberth() > 0)
		{
			hash.put(s.getId(), s);	
			return BookingStatus.confirmed;
		}
		else if(s.getBerthprefrence().equals("u") && BerthAvaiblity.getavailable_upperberth() >0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		else if(BerthAvaiblity.getavailable_lowerberth()>0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		else if(BerthAvaiblity.getavailable_middleberth() >0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		else if(BerthAvaiblity.getavailable_upperberth() >0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		else if(BerthAvaiblity.getavailable_rac()> 0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		else if(BerthAvaiblity.getavailable_waiting()>0)
		{
			hash.put(s.getId(), s);
			return BookingStatus.confirmed;
		}
		return BookingStatus.Noticketsavailable;
	
	}
}
