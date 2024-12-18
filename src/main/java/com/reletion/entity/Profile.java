package com.reletion.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private String department;
    
    @Column(nullable = false)
    private String designation;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long id, String address, String phoneNumber, String department, String designation) {
		super();
		this.id = id;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", address=" + address + ", phoneNumber=" + phoneNumber + ", department="
				+ department + ", designation=" + designation + "]";
	}
    
    
    
}

