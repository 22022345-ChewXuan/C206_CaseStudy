
public class Auction extends Item{
		private String title;
		private String auctionDesc;
		private String auctionDate;
		private String startTime;
		private String endTime;
		private int bidIncrement;
		private int maxBid;
		

		public Auction(String name, String description, int startBid, String manufactureDate, String title, String auctionDesc, 
				String auctionDate, String startTime, String endTime, int bidIncrement, int maxBid) {
			super(name, description, startBid, manufactureDate);
			this.title = title;
			this.auctionDesc = auctionDesc;
			this.auctionDate = auctionDate;
			this.startTime = startTime;
			this.endTime = endTime;
			this.bidIncrement = bidIncrement;
			this.maxBid = maxBid;
			
		}

		public String getTitle() {
			return title;
		}
		public String getAuctionDesc() {
			return auctionDesc;
		}
		
		public void setAuctionDate(String auctionDate) {
			this.auctionDate = auctionDate;
		}
		
		public String getAuctionDate() {
			return auctionDate;
		}
		
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		
		public String getStartTime() {
			return startTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		
		public String getEndTime() {
			return endTime;
		}
		
		public int getBidIncrement() {
			return bidIncrement;
		}
		
		public int getMaxBid() {
			return maxBid;
		}

		public String toString(){
			String output = "";

			return output;
		}
	}


