package pojos;

import javax.persistence.*;

@Entity
@Table(name="passengers")
public class Passenger {
	
	private Integer id;
	private String name , email , password ,phone ;
	
	private Flight selectedFlight;

	public Passenger() {
		super();
	}

	public Passenger(String name, String email, String password, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ManyToOne
	@JoinColumn(name = "f_id")
	public Flight getSelectedFlight() {
		return selectedFlight;
	}

	public void setSelectedFlight(Flight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + "]";
	}
	
	
	
	
	

}
