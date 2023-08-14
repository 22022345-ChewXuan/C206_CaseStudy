
public class Notification {
	private String username;
	private String adminname;
	private String date;
	private String notification;

	public Notification(String username, String adminname, String date, String notification) {
		this.username = username;
		this.adminname = adminname;
		this.date = date;
		this.notification = notification;
	}

	public String getNotification() {
		return notification;
	}

	public String getUsername() {
		return username;
	}

	public String getAdminname() {
		return adminname;
	}

	public String getDate() {
		return date;
	}

	public void display() {
		System.out.println("Username: " + username);
		System.out.println("Admin name: " + adminname);
		System.out.println("Date: " + date);
		System.out.println("Notification: " + notification);

	}
}
