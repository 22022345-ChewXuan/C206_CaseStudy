
public class Items {
	private int id;
	private String name;
	private String description;
	private double starting_bid;
	private double minimum_bid_increment;
	
	public Items(int id, String name, String description, double starting_bid, double minimum_bid_increment) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.starting_bid = starting_bid;
		this.minimum_bid_increment = minimum_bid_increment;
	}
	
	public Items(String name, String description, double starting_bid, double minimum_bid_increment) {
		this.name = name;
		this.description = description;
		this.starting_bid = starting_bid;
		this.minimum_bid_increment = minimum_bid_increment;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getStarting_bid() {
		return starting_bid;
	}

	public double getMinimum_bid_increment() {
		return minimum_bid_increment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStarting_bid(double starting_bid) {
		this.starting_bid = starting_bid;
	}

	public void setMinimum_bid_increment(double minimum_bid_increment) {
		this.minimum_bid_increment = minimum_bid_increment;
	}

}
