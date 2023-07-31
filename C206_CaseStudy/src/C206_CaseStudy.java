import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_ADD = 1;

	private ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) {

		C206_CaseStudy userRegistration = new C206_CaseStudy();

		int option = 0;

		while (option != OPTION_QUIT) {

			boolean addUser = true;
			C206_CaseStudy.menuUser();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ADD) {
				while (addUser) {
					String name = Helper.readString("Enter name: ");
					String email = Helper.readString("Enter email: ");
					String role = Helper.readString("Enter role: ");
					String pw = Helper.readString("Enter password: ");

					boolean result = userRegistration.registerUser(name, email, role, pw);

					if (result) {
						System.out.println("User registration is successful.");
					} else {
						System.out.println("User registration failed.");
					}

					addUser = Helper.readBoolean("Do you want to register another user (Y/N)?");
				}
				continue; // this to bypass the "Invalid Option"
			}

			if (option == OPTION_VIEW) {

				System.out.println("USERS");
				String output = String.format("%-15s %-30s %-10s\n", "NAME", "EMAIL", "ROLE");
				for (int i = 0; i < userRegistration.users.size(); i++) {
					User user = userRegistration.users.get(i);
					output += String.format("%-15s %-30s %-10s\n", user.getName(), user.getEmail(), user.getRole());
				}
				System.out.println(output);
				continue; // this to bypass the "Invalid Option"
			}

			if (option == OPTION_DELETE) {
				System.out.println("DELETE USER");
				String emailDelete = Helper.readString("Enter email of the user: ");
				String passwordDelete = Helper.readString("Enter password of the user: ");

				User userDelete = null;

				for (int i = 0; i < userRegistration.users.size(); i++) { // Search for the user by email n password
					User user = userRegistration.users.get(i);
					if (user.getEmail().equalsIgnoreCase(emailDelete) && user.getPassword().equals(passwordDelete)) {
						userDelete = user;
						break;
					}
				}
				if (userDelete != null) { // Confirm the deletion
					boolean confirmDeletion = Helper.readBoolean("Are you sure you want to delete this user (Y/N)? ");
					if (confirmDeletion) {
						userRegistration.users.remove(userDelete);
						System.out.println("User deleted successfully.");
					} else {
						System.out.println("User deletion canceled.");
					}
				} else {
					System.out.println("User not found or Incorrect Password");
				}
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid Option");
			}
		}

	}

	//valid password
	private boolean checkPassword(String password) {
		boolean correctLength = false;
		if (password.length() >= 12) {
			correctLength = true;
		}
		String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean checkAlphabets = false;
		for (int i = 0; i < alphabets.length(); i++) {
			if (password.contains(String.valueOf(alphabets.charAt(i)))) {
				checkAlphabets = true;
			}
		}
		String numbers = "1234567890";
		boolean checkNumber = false;
		for (int i = 0; i < numbers.length(); i++) {
			if (password.contains(String.valueOf(numbers.charAt(i)))) {
				checkNumber = true;
			}
		}
		return checkNumber && checkAlphabets && correctLength;
	}
	
	//register user
	public boolean registerUser(String name, String email, String role, String password) {
		// Empty information
		if (name.isEmpty() || email.isEmpty() || password.isEmpty())
			return false;

		if (role.isEmpty())
			return false;

		if (!checkPassword(password))
			return false;

		if (!email.contains("@"))
			return false;

		for (User user : users) { // duplicate emails
			if (user.getEmail().equalsIgnoreCase(email)) {
				return false; // Email address already exists
			}
		}

		users.add(new User(name, email, role, password));
		return true;
	}
	
	//menu for user
	public static void menuUser() {
		Helper.line(80, "-");
		System.out.println("USERS");
		System.out.println("1. Add New User");
		System.out.println("2. View all User");
		System.out.println("3. Delete User");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void menu() {
		Helper.line(80, "-");
		System.out.println("Campus Online Auction Shop (COAS)");
		System.out.println("1. User");
		System.out.println("2. Auction");
		System.out.println("3. Item");
		System.out.println("4. Bid");
		System.out.println("5. Payment");
		System.out.println("6. Notification");
		System.out.println("7. Quit");
		Helper.line(80, "-");
	}

}
