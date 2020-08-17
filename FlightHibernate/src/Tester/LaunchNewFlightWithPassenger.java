package Tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.FlightDaoImpl;
import pojos.Flight;
import pojos.Passenger;

public class LaunchNewFlightWithPassenger {

	public static void main(String[] args) {

		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			FlightDaoImpl dao = new FlightDaoImpl();
			System.out.println("enter flight details : airlineName departCity arrivalCity DepartureDate ");
			Flight f1 = new Flight(sc.next(), sc.next(), sc.next(), parse(sc.next()));
//accept 3 passengers
			for(int i=0 ; i<3 ;i++)
			{
				System.out.println("Enter passenger details: name , email , password ,phone ");
				Passenger p1 = new Passenger(sc.next(), sc.next(), sc.next(), sc.next());
				f1.getPassengers().add(p1);
				System.out.println(p1.getSelectedFlight());//null
					// add reverse link
				p1.setSelectedFlight(f1);
				System.out.println(p1.getSelectedFlight());//not null	
			}
			
			System.out.println(dao.LaunchNewflight(f1));
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
