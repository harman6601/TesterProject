package dao;

import pojos.Flight;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;
public class FlightDaoImpl implements IFlightDao{

	@Override
	public String LaunchNewflight(Flight flight) {

		// course : transient
				String mesg = "Course launching failed!!!!";
				// get session from SF
				Session session = getSf().getCurrentSession();
				// begin Tx
				Transaction tx = session.beginTransaction();
				try {
					session.persist(flight);// flight : persistent
					tx.commit();// dirty checking : insert , L1 cache destroyed , cn rets to CP
					mesg = "course launched successfully " + flight.getFlightId();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					throw e;
				}
				return mesg;	
				}

}
