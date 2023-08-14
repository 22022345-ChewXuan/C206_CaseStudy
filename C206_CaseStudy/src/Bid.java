
public class Bid {
	private int bidID;
	private String itemTitle;
	private String itemName;
	private double currentBid;
	private double minBidIncrement;
	private String startingBidDate;
	private String closingBidDate;

	public Bid(int bidID, String itemTitle, String itemName, double currentBid, double minBidIncrement,
			String startingBidDate, String closingBidDate) {
		this.bidID = bidID;
		this.itemTitle = itemTitle;
		this.itemName = itemName;
		this.currentBid = currentBid;
		this.minBidIncrement = minBidIncrement;
		this.startingBidDate = startingBidDate;
		this.closingBidDate = closingBidDate;
	}

	public int getbidID() {
		return bidID;
	}

	public String getitemTitle() {
		return itemTitle;
	}

	public String getitemName() {
		return itemName;
	}

	public double getcurrentBid() {
		return currentBid;
	}

	public double getminBidIncrement() {
		return minBidIncrement;
	}

	public String getstartingBidDate() {
		return startingBidDate;
	}

	public String getclosingBidDate() {
		return closingBidDate;
	}
}
