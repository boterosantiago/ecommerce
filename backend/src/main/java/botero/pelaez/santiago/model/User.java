package botero.pelaez.santiago.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user")
	private String user;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "admin")
	private boolean admin;

	public User() {

	}

	public User(String user, String password, String email, boolean admin) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}