import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int ITEM_VIEW = 1;
	private static final int ITEM_ADD = 2;
	private static final int ITEM_DELETE = 3;
	private static final int ITEM_QUIT = 4;
	private static final int AUCTION_TYPE = 1;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 1;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_QUIT = 4;
	private static final int USER_ADD = 1;
	private static final int USER_VIEW = 2;
	private static final int USER_DELETE = 3;
	private static final int USER_QUIT = 4;
	private static final int APP_QUIT = 6;
	
	public static ArrayList<Items> itemsList = new ArrayList<Items>();
	private static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Auction> auctionList = new ArrayList<Auction>();

	public static void main(String[] args) {
		int option = 0;
		
		//items
		itemsList.add(new Items(1, "Necklace", "Silver Long Necklace", 10, 5));
	
		//auction
		auctionList.add(new Auction("Jade", "made from pure material", 300, "19-07-1890", "A001", "don't overspend!", "09-09-2023", "5:00pm",
				"8:00pm", 10, 5000));
		auctionList.add(new Auction("Art", "created by famous painter", 850, "20-07-1890", "A002", "don't overspend!", "10-09-2023", "6:00pm",
				"9:00pm", 20, 4000));
		
		C206_CaseStudy userRegistration = new C206_CaseStudy();

		while (option != USER_QUIT) {

		      C206_CaseStudy.menuUser();
		      option = Helper.readInt("Enter an option > ");

		      if (option == USER_ADD) {
		        // Add a new item
		        C206_CaseStudy.setHeader("ADD");

		        // Add a User
		        User newUser = inputUser();
		        boolean result = C206_CaseStudy.addUser(users, newUser);
		        if (result == false) {
		          System.out.println("User registration failed");
		        } 
		        else {
		          result = C206_CaseStudy.addUser(true);
		          System.out.println("User added");
		          menu();
		          int choice = Helper.readInt("Enter Option > ");
		          while (choice != APP_QUIT) {
			          if (choice == 1) {
							int auction_choice = 0;
							while (auction_choice != OPTION_QUIT) {
								menuAuction();
								auction_choice = Helper.readInt("Enter Option > ");
								if (auction_choice == OPTION_VIEW) {
									// View all items
									C206_CaseStudy.viewAllAuction(auctionList);
	
								} 
								else if (auction_choice == OPTION_ADD) {
									// Add a new item
									C206_CaseStudy.setHeader("ADD");	
									
									int itemType = Helper.readInt("Enter option to select item type > ");
	
									if (itemType == AUCTION_TYPE) {
										// Add a Auction
										Auction a = inputAuction();
										C206_CaseStudy.addAuction(auctionList, a);
										System.out.println("Auction added");
	
									} 
									else {
										System.out.println("Invalid type");
									}
	
								} 
								else if (auction_choice == OPTION_DELETE) {
									// Delete Auction
									C206_CaseStudy.setHeader("DELETE");			
									
									int itemType = Helper.readInt("Enter option to select item type > ");
									
									if( itemType == AUCTION_TYPE) {
										// Delete Auction
										C206_CaseStudy.deleteAuction(auctionList);
									} 
									else {
										System.out.println("Invalid type");
									}
	
								} 
								else {
									System.out.println("Bye!");
								}
							}
								menu();
								choice = Helper.readInt("Enter an option > ");
							}
						else if (choice == 2) {
							int item_option = 0;
							while (item_option != ITEM_QUIT) {
	
								itemsMenu();
								item_option = Helper.readInt("Enter an option > ");
	
								if (item_option == ITEM_VIEW) {
									// View all items
									C206_CaseStudy.viewAllItems(itemsList);
	
								} else if (item_option == ITEM_ADD) {
									// Add a new item
									C206_CaseStudy.setHeader("ADD ITEM");	
									
									Items it = inputItems();
									C206_CaseStudy.addItems(itemsList, it);
									System.out.println("Item added");
	
	
								} 
								else if (item_option == ITEM_DELETE) {
								    // Delete item
								    C206_CaseStudy.setHeader("DELETE ITEM");    
								    int itemIdToDelete = Helper.readInt("Enter the ID of the item to delete > ");
								    boolean isDeleted = C206_CaseStudy.deleteItems(itemsList, itemIdToDelete);
	
								    if (isDeleted) {
								        System.out.println("Item with ID " + itemIdToDelete + " has been successfully deleted.");
								    } else {
								        System.out.println("Item with ID " + itemIdToDelete + " was not found or deletion was cancelled.");
								    }
								} 
								else {
									System.out.println("Bye!");
								}
							} 
							menu();
								choice = Helper.readInt("Enter an option > ");
						}
		        }
					
		          System.out.println("Bye!");
					
		          
				continue; // this to bypass the "Invalid Option"
		        }

		      } else if (option == USER_VIEW) {
		        // View all items
		        C206_CaseStudy.viewUsers(users);

		      } else if (option == USER_DELETE) {
		        // Delete item
		        C206_CaseStudy.deleteUser(users);

		      } else if (option == 4) {
		        System.out.println("Bye!");
		      } else {
		        System.out.println("Invalid option");
		      }
		    }  
	}

	//set header
	  public static void setHeader(String header) {
		    Helper.line(80, "-");
		    System.out.println(header);
		    Helper.line(80, "-");
		  }

	//================================= USERS =================================
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
		System.out.println("1. Auction");
		System.out.println("2. Item");
		System.out.println("3. Bid");
		System.out.println("4. Payment");
		System.out.println("5. Notification");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}
	
	// ================================= Option 1 Add user (CRUD - Create)
	  // =================================
	  public static User inputUser() {
	    String name = Helper.readString("Enter name: ");
	    String email = Helper.readString("Enter email: ");
	    String role = Helper.readString("Enter role: ");
	    String pw = Helper.readString("Enter password: ");

	    User newUser = new User(name, email, role, pw);
	    return newUser;

	  }

	  private static boolean addUser(boolean b) {
	    return false;
	  }

	  // valid password
	  private static boolean checkPassword(String password) {
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

	public static boolean addUser(ArrayList<User> users, User newUser) {
	    User newUser1;
	    for (int i = 0; i < users.size(); i++) {
	      newUser1 = users.get(i);
	      if (newUser1.getEmail().equalsIgnoreCase(newUser.getEmail()))
	        return false;
	    }
	    if ((newUser.getName().isEmpty()) || (newUser.getEmail().isEmpty()) || (newUser.getRole().isEmpty()) ||
	         (newUser.getPassword().isEmpty())) {
	      return false;
	    }
	    if (!checkPassword(newUser.getPassword())) {
	      return false;
	    }
	    if (!newUser.getEmail().contains("@")) {
	      return false;
	    }

	    String validRoles = "bidder, administrator, organizer"; // Add other valid roles separated by spaces if needed
	    String newUserRole = newUser.getRole().toLowerCase();
	    if (!validRoles.contains(newUserRole)) {
	      System.out.println("Invalid role! Available roles are: bidder, administrator, organizer");
	      return false;
	    }

	    users.add(newUser);
	    return true;
	  }

	// ================================= Option 2 View user (CRUD- Read)
	  // =================================
	  public static String retrieveUsers(ArrayList<User> users) {
	    String output = "";

	    for (int i = 0; i < users.size(); i++) {
	      if (!users.get(i).getEmail().isEmpty()) {
	        output += String.format("%-50s\n", users.get(i).toString());
	      }
	    }
	    return output;
	  }

	  public static void viewUsers(ArrayList<User> users) {
	    String output = "USERS";
	    output = String.format("%-15s %-25s %-10s\n", "NAME", "EMAIL", "ROLE");
	    output += retrieveUsers(users);
	    System.out.println(output);
	  }
	
	  
	// ================================= Option 3 Delete  user (CRUD - Delete)
	  // =================================

	  public static boolean deleteUser(ArrayList<User> users) {
	    System.out.println("DELETE USER");
	    String emailDelete = Helper.readString("Enter email of the user: ");
	    String passwordDelete = Helper.readString("Enter password of the user: ");

	    User userDelete = null;

	    for (int i = 0; i < users.size(); i++) { // Search for the user by email n password
	      User user = users.get(i);
	      if (user.getEmail().equalsIgnoreCase(emailDelete) && user.getPassword().equals(passwordDelete)) {
	        userDelete = user;
	        break;
	      }
	    }
	    if (userDelete != null) { // Confirm the deletion
	      boolean confirmDeletion = Helper.readBoolean("Are you sure you want to delete this user (Y/N)? ");
	      if (confirmDeletion) {
	        users.remove(userDelete);
	        System.out.println("User deleted successfully.");
	      } else {
	        System.out.println("User deletion canceled.");
	      }
	    } else {
	      System.out.println("User not found or Incorrect Password");
	    }
	    return false;
	  }

	  public static boolean doDeleteUser(ArrayList<User> users, String email, String password) {

	    boolean isDelete = false;

	    if (email.isEmpty() || password.isEmpty())
	      return false;

	    for (int i = 0; i < users.size(); i++) {

	      if (email.equalsIgnoreCase(users.get(i).getEmail()) && password.equalsIgnoreCase(users.get(i).getPassword())) {

	        users.remove(i);

	        isDelete = true;

	      }
	    }
	    return isDelete;
	  }
	


	//================================= AUCTION =================================
	public static void menuAuction() {
		C206_CaseStudy.setHeader("ONLINE AUCTION SHOP");
		System.out.println("1. Add Auction");
		System.out.println("2. View Auction");
		System.out.println("3. Delete Auction");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	
	//================================= Option 1 Add Auction =================================
	public static Auction inputAuction() {
		
		String name = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter item description > ");
		int startBid = Helper.readInt("Enter item starting Bid > ");
		String manufactureDate = Helper.readString("Enter item manufactureDate > ");
		String title = Helper.readString("Enter auction title > ");
		String auctionDesc = Helper.readString("Enter auction description > ");
		String auctionDate = Helper.readString("Enter auction Date > ");
		String startTime = Helper.readString("Enter auction start time > ");
		String endTime = Helper.readString("Enter auction end time > ");
		int bidIncrement = Helper.readInt("Enter auction bid increment > ");
		int maxBid = Helper.readInt("Enter auction max Bid > ");

		Auction a = new Auction(name, description, startBid, manufactureDate, title,
				auctionDesc, auctionDate, startTime, endTime, bidIncrement, maxBid);
		return a;
		
	}
	
	public static void addAuction(ArrayList<Auction> auctionList, Auction a) {
		Auction item;
		for(int i = 0; i < auctionList.size(); i++) {
			item = auctionList.get(i);
			if (item.getTitle().equalsIgnoreCase(a.getTitle()) )
				return;
		}
		if ((a.getTitle().isEmpty()) || (a.getAuctionDesc().isEmpty()) ) {
			return;
		}
		auctionList.add(a);
		
	}

	//================================= Option 2 View Auction =================================
	public static String retrieveAllAuction(ArrayList<Auction> auctionList) {
		String output = "";

		for (int i = 0; i < auctionList.size(); i++) {

			output += String.format("%-10s %-20s %-15s %-15s %-15s %-15d %-15d\n", auctionList.get(i).getTitle(),
					auctionList.get(i).getAuctionDesc(), auctionList.get(i).getAuctionDate(),
					auctionList.get(i).getStartTime(), auctionList.get(i).getEndTime(),
					auctionList.get(i).getBidIncrement(), auctionList.get(i).getMaxBid());
		}
		return output;
	}
	
	public static void viewAllAuction(ArrayList<Auction> auctionList) {
		C206_CaseStudy.setHeader("AUCTION LIST");
		String output = String.format("%-10s %-20s %-15s %-15s %-15s %-15s %-15s\n", "TITLE", "DESCRIPTION",
				"AUCTION DATE", "START TIME", "END TIME", "BID INCREMENT", "MAX BID");
		 output += retrieveAllAuction(auctionList);	
		System.out.println(output);
	}
	

	
	//================================= Option 3 Delete Auction =================================
	public static boolean doDeleteAuction(ArrayList<Auction> auctionList, String title, String auctionDesc) {
		
		boolean isDelete = false;

		if (title.isEmpty() || auctionDesc.isEmpty())
			return false;
		
		for (int i = 0; i < auctionList.size(); i++) {
					
			if (title.equalsIgnoreCase(auctionList.get(i).getTitle())				
					&& auctionList.get(i).getIsAvailable() == true) {

				auctionList.remove(i);
				
				isDelete = true;
				
			}
		}
		return isDelete;
	}

	public static void deleteAuction(ArrayList<Auction> auctionList) {
		C206_CaseStudy.viewAllAuction(auctionList);
		String title = Helper.readString("Enter title > ");
		String auctionDesc = Helper.readString("Enter auction desc > ");
		Boolean isDelete =doDeleteAuction(auctionList, title, auctionDesc);
		if (isDelete == false) {
			System.out.println("Invalid title");
		} else {
			System.out.println("Auction " + title + " deleted");
		}
	}
	
	
	//================================= ITEMS =================================
	
	public static void itemsMenu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop");
		System.out.println("1. Display Items");
		System.out.println("2. Add item");
		System.out.println("3. Delete item");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	//================================= View Items =================================
	public static String retrieveAllItems(ArrayList<Items> itemsList) {
		String output = "";
		for (int i = 0; i < itemsList.size(); i++) {

			output += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", itemsList.get(i).getId(),
					itemsList.get(i).getName(), itemsList.get(i).getDescription(), itemsList.get(i).getStarting_bid(),
					itemsList.get(i).getMinimum_bid_increment());
		}
		return output;
	}
	
	public static void viewAllItems(ArrayList<Items> itemsList) {
		
		C206_CaseStudy.setHeader("ITEMS LIST");
		String output = String.format("%-5s %-20s %-30s %-15s %-20s\n", "ID", "NAME",
				 "DESCRIPTION", "STARTING BID","MIN BID INCREMENT");
		 output += retrieveAllItems(itemsList);
		System.out.println(output);
	}
	
	
	//================================= Add Item =================================
	public static Items inputItems() {
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");
		double start_bid = Helper.readDouble("Enter starting bid > ");
		double min_bid = Helper.readDouble("Enter minimum bidding increment > ");

		Items items= new Items(id, name, description, start_bid, min_bid);
		return items;
		
	}	
	
	public static void addItems(ArrayList<Items> itemsList, Items items) {
		Items item;
		for(int i = 0; i < itemsList.size(); i++) {
			item = itemsList.get(i);
			if (item.getId() == (items.getId()))
				return;
		}
		if ((items.getId() == 0) || (items.getDescription().isEmpty()) ) {
			return;
		}
		
		itemsList.add(items);
		
	}
	
	
	//================================= Delete Items =================================
	public static boolean deleteItems(ArrayList<Items> itemsList, int itemId) {
	    for (int i = 0; i < itemsList.size(); i++) {
	        if (itemsList.get(i).getId() == itemId) {
	            char delete = Helper.readChar("Confirm deletion (y/n) > ");
	            if (delete == 'y') {
	                itemsList.remove(i);
	                System.out.println("\n*** Item has been deleted ***");
	                return true; // Item was successfully deleted
	            } else {
	                System.out.println("\n*** Deletion cancelled ***");
	                return false; // Item deletion was cancelled
	            }
	        }
	    }
	    System.out.println("\n*** Item not found ***");
	    return false; // Item was not found in the list
	}
}