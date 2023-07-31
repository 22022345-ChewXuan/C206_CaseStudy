import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		
		ArrayList<Items> itemsList = new ArrayList<Items>();
		
		//itemsList.add(new Items(1, "Necklace", "Silver Long Necklace", 10, 5));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				C206_CaseStudy.viewAllItems(itemsList);

			} else if (option == OPTION_ADD) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD ITEM");	
				
				Items it = inputItems();
				C206_CaseStudy.addItems(itemsList, it);
				System.out.println("Item added");


			} else if (option == OPTION_DELETE) {
			    // Delete item
			    C206_CaseStudy.setHeader("DELETE ITEM");    
			    int itemIdToDelete = Helper.readInt("Enter the ID of the item to delete > ");
			    boolean isDeleted = C206_CaseStudy.deleteItems(itemsList, itemIdToDelete);

			    if (isDeleted) {
			        System.out.println("Item with ID " + itemIdToDelete + " has been successfully deleted.");
			    } else {
			        System.out.println("Item with ID " + itemIdToDelete + " was not found or deletion was cancelled.");
			    }
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop");
		System.out.println("1. Display Items");
		System.out.println("2. Add item");
		System.out.println("3. Delete item");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
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
