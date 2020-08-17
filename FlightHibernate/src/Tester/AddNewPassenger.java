package Tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.PassengerDaoImpl;
import pojos.Passenger;

public class AddNewPassenger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
		PassengerDaoImpl dao = new PassengerDaoImpl();
		System.out.println("Enter flight Id and  passenger details: name , email , password ,phone ");
		System.out.println(dao.addNewPassenger(sc.nextInt(),new Passenger( sc.next(), sc.next(), sc.next(), sc.next())));
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

}
