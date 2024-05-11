public class User {
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String contact;
	// Constructor, getters, and setters

	// Constructor
	public User(String username, String password, String email, String fullname, String contact) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.contact = contact;
	}

	// Getters and Setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
