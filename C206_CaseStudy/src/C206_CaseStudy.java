import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int AUCTION_TYPE = 1;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Auction> auctionList = new ArrayList<Auction>();

		auctionList.add(new Auction("Jade", "made from pure material", 300, "19-07-1890", "A001", "don't overspend!", "09-09-2023", "5:00pm",
				"8:00pm", 10, 5000));
		auctionList.add(new Auction("Art", "created by famous painter", 850, "20-07-1890", "A002", "don't overspend!", "10-09-2023", "6:00pm",
				"9:00pm", 20, 4000));

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menuAuction();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				C206_CaseStudy.viewAllAuction(auctionList);


			} else if (option == OPTION_ADD) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");	
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == AUCTION_TYPE) {
					// Add a Auction
					Auction a = inputAuction();
					C206_CaseStudy.addAuction(auctionList, a);
					System.out.println("Auction added");

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_DELETE) {
				// Delete Auction
				C206_CaseStudy.setHeader("DELETE");			
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if( itemType == AUCTION_TYPE) {
					// Delete Auction
					C206_CaseStudy.deleteAuction(auctionList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}



	public static void menuAuction() {
		C206_CaseStudy.setHeader("ONLINE AUCTION SHOP");
		System.out.println("1. Display Auctions");
		System.out.println("2. Add Auction");
		System.out.println("3. Delete Auction");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
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

	//================================= Option 1 View Auction =================================
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


	//================================= Option 2 Add Auction =================================
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
}
