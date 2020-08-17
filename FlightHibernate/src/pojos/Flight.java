package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;     

@Entity
@Table(name = "flights")
public class Flight {
	private Integer flightId;
	private String airlineName, departureCity , arrivalCity;
	private LocalDate departureDate;
	
	private List<Passenger>passengers = new ArrayList<>();
	
	public Flight() {

	}
	public Flight(String airlineName, String departureCity, String arrivalCity, LocalDate departureDate) {
		super();
		this.airlineName = airlineName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
	@Column(name = "flight_id")
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	
	@Column(name ="airline_name" ,unique = true)
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	@Column(length = 30)
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	@Column(length = 30)
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	@OneToMany(mappedBy="selectedFlight" ,cascade= CascadeType.ALL)
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	//helper methods for adding and removing passengers
	public void addPassengers(Passenger p)
	{
		passengers.add(p);
		p.setSelectedFlight(this);
	}
	
	public void removePassengers(Passenger p)
	{
		passengers.remove(p);
		p.setSelectedFlight(null);
	}
	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineName=" + airlineName + ", departureCity=" + departureCity
				+ ", arrivalCity=" + arrivalCity + ", departureDate=" + departureDate + "]";
	}
	
	
	

}
