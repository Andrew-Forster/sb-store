package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Class representing user entity
 * The class is mapped to the "USERS" table
 */
@Table("USERS")
public class UserEntity {
	
    @Id
    private Long id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Column("phone_number")
    private String phoneNumber;

	@Column("role")
	private String role;
    
    /**
     * Parameterless constructor
     */
	public UserEntity() {
        super();
    }
    
    /**
     * Constructor with multiple parameters
     * @param id User's id
     * @param username User's username
     * @param password User's password
     */
	public UserEntity(Long id, String username, String password) {
    	this.id = id;
    	this.username = username;
    	this.password = password;
    }
    
    /**
     * Constructor with multiple parameters
     * @param id User's id
     * @param username User's username
     * @param password User's password
     * @param firstName User's firs name
     * @param lastName User's last name
     * @param email User's email
     * @param phoneNumber User's phone number
     * @param role User's authority
     */
	public UserEntity(Long id,
                      String username,
                      String password,
                      String firstName,
                      String lastName,
                      String email,
                      String phoneNumber,
					  String role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
		this.role = role;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
