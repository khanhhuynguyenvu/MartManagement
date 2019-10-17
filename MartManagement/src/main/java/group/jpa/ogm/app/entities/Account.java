package group.jpa.ogm.app.entities;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	@Column(name = "Username")
	private String username;
	@Column(name = "Type")
	private Integer type;
	@Column(name = "Password")
	private String password;
	@Column(name = "StartingDate")
	private Date startingDate;
	@Column(name = "Status")
	private String status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
