package Tester;

import static utils.HibernateUtils.getSf;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.FlightDaoImpl;
import pojos.Flight;

/*private Integer flightId;
private String airlineName, departureCity , arrivalCity;
private LocalDate departureDate*/

public class LaunchNewFlight {

	public static void main(String args[])
	{
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			FlightDaoImpl dao = new FlightDaoImpl();
			System.out.println("enter flight details : airlineName departCity arrivalCity DepartureDate ");
			Flight f1 = new Flight(sc.next(), sc.next(), sc.next(), parse(sc.next()));
			System.out.println(dao.LaunchNewflight(f1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
