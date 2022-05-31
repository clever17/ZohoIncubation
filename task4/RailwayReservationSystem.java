package task4;

import java.awt.print.Book;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class RailwayReservationSystem 
{
	
	public static void main()
	{
		boolean loop=true;
		while(loop)
		{
			
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nRailway Reservation System");
		System.out.println("1. Book Ticket");
		System.out.println("2. Cancel Ticket");
		System.out.println("3. Show Booked Tickets");
		System.out.println("4. Show Available Tickets");
		System.out.println("5. Exit");
		int choice;
		choice = sc.nextInt();
		switch (choice) 
		{
		case 1: 
		{	
			Passenger passenger = new Passenger();
			
			System.out.println("Enter the name");
			passenger.setName(sc.next());
			System.out.println("Enter the age");
			passenger.setAge(sc.nextInt());
			System.out.println("Enter the gender");
			passenger.setGender(sc.next());
			System.out.println("Enter the Bethprefrence");
			passenger.setBerthprefrence(sc.next());				
			
		}
		case 2:
		{
			int id;
			System.out.println("Enter the id");
			id=sc.nextInt();
			CancelTicket.cancelticket(id);
		}
		case 3:
		{
			BookedTicket.printBookedTicket();
		}
		case 4:
		{
			AvailableTickets.printAvailableTickets();
		}
		case 5:
		{
			loop=false;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " );
		}
	}
	}
}
