package dao;

import org.hibernate.*;

import pojos.Flight;
import pojos.Passenger;
import static utils.HibernateUtils.getSf;

public class PassengerDaoImpl implements IPassengerDao {

	@Override
	public String addNewPassenger(int flightId, Passenger p) {
		// TODO Auto-generated method stub
		String mesg = "Passenger could not be added!!";
		Session session =getSf().getCurrentSession();
		//tx
		Transaction tx = session.beginTransaction();
		try {
			Flight f1 = session.get(Flight.class , flightId);
			if(f1 !=null)
			{
				f1.addPassengers(p);
				mesg = "Passenger added successfully";
				
			}
			
			//CRUD
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

}
