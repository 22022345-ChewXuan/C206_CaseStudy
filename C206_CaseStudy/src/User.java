public class User {
	String name;
	String email;
	String role;
	String password;

	public User(String name, String email, String role, String password) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public String toString() {
		String info = String.format("%-15s %-25s %-10s", name, email, role);
		return info;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}