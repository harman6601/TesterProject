package dao;

import pojos.Passenger;

public interface IPassengerDao {

	String addNewPassenger(int flightId , Passenger p);
}
