
public class Item {
	private String name;
	private String description;
	private int startBid;
	private String manufactureDate;
	private boolean isAvailable;

	public Item(String name, String description, int startBid, String manufactureDate) {
		this.name = name;
		this.description = description;
		this.startBid = startBid;
		this.manufactureDate = "";
		this.isAvailable = true;
	}

	public String toString() {

		return null;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getStartBid() {
		return startBid;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}