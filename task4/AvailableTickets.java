package task4;

public class AvailableTickets 
{
	public static Object printAvailableTickets()
	{
		return BerthAvaiblity.getavailable_lowerberth() + BerthAvaiblity.getavailable_middleberth()
		+ BerthAvaiblity.getavailable_middleberth() + BerthAvaiblity.getavailable_upperberth();
	}
}
