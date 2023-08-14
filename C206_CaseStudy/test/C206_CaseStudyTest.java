import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// users
	private User validUser1;
	private User validUser2;
	private User validUser3;
	private User invalidEmail;
	private User weakPw;
	private User missingName;
	private User missEmailnPw;
	private User missingRole;

	// auction
	private Auction a1;
	private Auction a2;

	// items
	private Items item1;
	private Items item2;
	private Items item3;

	// auction
	private Bid bid1;
	private Bid bid2;

	// arraylist
	private ArrayList<User> user;
	private ArrayList<Auction> auctionList;
	private ArrayList<Items> itemsList;
	private ArrayList<Bid> bidList;
	private ArrayList<Payment> paymentList;
	private ArrayList<Notification> users;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp_user() throws Exception {
		user = new ArrayList<User>();
		validUser1 = new User("John Lim", "johnlim@example.com", "bidder", "password1234");
		validUser2 = new User("John Doe", "johndoe@example.com", "administrator", "password1234");
		validUser3 = new User("John Doe", "johndoe@example.com", "Organizer", "password1234");
		invalidEmail = new User("John Doe", "invalidemail", "bidder", "password1234");
		weakPw = new User("John Doe", "johndoe@example.com", "bidder", "weak");
		missingName = new User("", "johndoe@example.com", "bidder", "password1234");
		missEmailnPw = new User("John Doe", "", "bidder", "");
		missingRole = new User("John Doe", "johndoe@example.com", "", "password1234");
	}

	@Test
	public void testValidRegistration() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, validUser1);
		assertTrue(result);
	}

	@Test
	public void testInvalidEmail() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, invalidEmail);
		assertFalse(result);
	}

	@Test
	public void testValidRole() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, validUser1);
		assertTrue(result);
	}

	@Test
	public void testValidRole2() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, validUser2);
		assertTrue(result);
	}

	@Test
	public void testValidRole3() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, validUser3);
		assertTrue(result);
	}

	@Test
	public void testWeakPassword() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, weakPw);
		assertFalse(result);
	}

	@Test
	public void testRetrieveAllUser() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid User arraylist to add to", user);
		assertEquals("Test that the User arraylist is empty.", 0, user.size());
		// Attempt to retrieve the Users
		String allUser = C206_CaseStudy.retrieveUsers(user);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);

		// Test Case 2
		C206_CaseStudy.addUser(user, validUser1);
		C206_CaseStudy.addUser(user, validUser2);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, user.size());
		// Attempt to retrieve the Users
		allUser = C206_CaseStudy.retrieveUsers(user);

		// Create the expected output string with correct formatting
		testOutput = String.format("%-15s %-25s %-10s\n", "John Lim", "johnlim@example.com", "bidder");
		testOutput += String.format("%-15s %-25s %-10s\n", "John Doe", "johndoe@example.com", "administrator");

		assertEquals("Test that the display is correct.", testOutput, allUser);

		// Test Case 3
		// missingName
		C206_CaseStudy userRegistration = new C206_CaseStudy();
		boolean result = userRegistration.addUser(user, missingName);
		assertFalse(result);

		// missing EmailnPw
		result = userRegistration.addUser(user, missEmailnPw);
		assertFalse(result);

		// missingRole
		result = userRegistration.addUser(user, missingRole);
		assertFalse(result);

		// Test case with all missing values
		User missingAll = new User("", "", "", "");
		result = userRegistration.addUser(user, missingAll);
		assertFalse(result);
	}

	@Test
	public void testDoDeleteUser() {
		assertNotNull("test if there is valid User arraylist to delete from", user);
		C206_CaseStudy.addUser(user, validUser1);

		// Test1 (delete valid user)
		Boolean result = C206_CaseStudy.doDeleteUser(user, validUser1.getEmail(), validUser1.getPassword());
		assertTrue("Test if an available item is ok to Delete?", result);

		// Test2 (delete user that has already been deleted)
		result = C206_CaseStudy.doDeleteUser(user, validUser1.getEmail(), validUser1.getPassword());
		assertFalse("Test if the same user is available to delete again", result);

		// Test3 (delete user that is non-existing)
		result = C206_CaseStudy.doDeleteUser(user, "maryjohnlim@gmail.com", "password123456789");
		assertFalse("Test that non-esiting user is NOT ok to delete?", result);

	}

	@After
	public void tearDown_user() throws Exception {
		user = null;
		validUser1 = null;
		validUser2 = null;
		validUser3 = null;
		invalidEmail = null;
		weakPw = null;
		missingName = null;
		missEmailnPw = null;
		missingRole = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Before
	public void setUp_auction() throws Exception {
		a1 = new Auction("Jade", "made from pure material", 300, "19-07-1890", "A001", "don't overspend!", "09-09-2023",
				"5:00pm", "8:00pm", 10, 5000);
		a2 = new Auction("Art", "created by famous painter", 850, "20-07-1890", "A002", "don't overspend!",
				"10-09-2023", "6:00pm", "9:00pm", 20, 4000);

		auctionList = new ArrayList<Auction>();
	}

	@Test
	public void testAddAuction() {
		// Item list is not null, so that can add a new auction - boundary
		assertNotNull("Check if there is valid Auction arraylist to add to", auctionList);
		// Given an auction list, after adding 1 auction, the size of the list is 1 -
		// normal
		// The auction just added is as same as the first auction of the list
		C206_CaseStudy.addAuction(auctionList, a1);
		assertEquals("Check that Auction arraylist size is 1", 1, auctionList.size());
		assertSame("Check that Auction is added", a1, auctionList.get(0));

		// Add another auction. test The size of the list is 2? -normal
		// The auction just added is as same as the second auction of the list
		C206_CaseStudy.addAuction(auctionList, a2);
		assertEquals("Check that Auction arraylist size is 2", 2, auctionList.size());
		assertSame("Check that Auction is added", a2, auctionList.get(1));
	}

	@Test
	public void testRetrieveAllAuction() {
		// Test if auction list is not null but empty -boundary
		assertNotNull("Test if there is valid Auction arraylist to retrieve item", auctionList);

		// test if the list of Auction retrieved from the caseStudy is empty - boundary
		String allAuction = C206_CaseStudy.retrieveAllAuction(auctionList);
		String testOutput = "";
		assertEquals("Check that ViewAllAuctionlist", testOutput, allAuction);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addAuction(auctionList, a1);
		C206_CaseStudy.addAuction(auctionList, a2);
		assertEquals("Test that Auction arraylist size is 2", 2, auctionList.size());

		// test if the expected output string same as the list of Auction retrieved from
		// the CaseStudy
		allAuction = C206_CaseStudy.retrieveAllAuction(auctionList);
		testOutput = String.format("%-10s %-20s %-15s %-15s %-15s %-15d %-15d\n", "A001", "don't overspend!",
				"09-09-2023", "5:00pm", "8:00pm", 10, 5000);
		testOutput += String.format("%-10s %-20s %-15s %-15s %-15s %-15d %-15d\n", "A002", "don't overspend!",
				"10-09-2023", "6:00pm", "9:00pm", 20, 4000);

		assertEquals("Test that ViewAllAuctionlist", testOutput, allAuction);

	}

	@Test
	public void testDoDeleteAuction() {
		// boundary
		assertNotNull("test if there is valid Auction arraylist to delete from", auctionList);

		C206_CaseStudy.addAuction(auctionList, a1);
		// normal
		Boolean ok = C206_CaseStudy.doDeleteAuction(auctionList, "A001");
		assertTrue("Test if an available auction is ok to loan?", ok);
		// error condition
		ok = C206_CaseStudy.doDeleteAuction(auctionList, "A001");
		assertFalse("Test if an same auction is NOT ok to loan again?", ok);
		// error condition
		C206_CaseStudy.addAuction(auctionList, a2);
		a2.setIsAvailable(false);
		ok = C206_CaseStudy.doDeleteAuction(auctionList, "A002");
		assertFalse("Test that un-available auction is NOT ok to delete?", ok);
		// error condition
		ok = C206_CaseStudy.doDeleteAuction(auctionList, "A002");
		assertFalse("Test that non-exisiting auction is NOT ok to delete?", ok);

	}

	@After
	public void tearDown_auction() throws Exception {
		a1 = null;
		a2 = null;
		auctionList = null;
	}

	@Before
	public void setUp_items() throws Exception {
		// prepare test data
		item1 = new Items(1, "Necklace", "Silver Long Necklace", 100, 10);
		item2 = new Items(2, "Gold Bar", "24K Gold", 100000, 100);
		item3 = new Items(3, "Poster", "100cm x 50cm", 30, 5);

		itemsList = new ArrayList<Items>();
	}

	@Test
	public void testAddItems() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is a valid item array list to add to", itemsList);
		assertEquals("Test that the item array list is empty.", 0, itemsList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addItems(itemsList, item1);
		assertEquals("Test that the item array list size is 1.", 1, itemsList.size());

		// Add an item
		C206_CaseStudy.addItems(itemsList, item2);
		assertEquals("Test that the item array list size is now 2.", 2, itemsList.size());

		// The item just added is the same as the last item in the list
		assertSame("Test that the item is added to the end of the list.", item2, itemsList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addItems(itemsList, item2);
		assertEquals("Test that the item array list size remains unchanged.", 2, itemsList.size());

		// Add an item that has missing detail
		Items item_missing = new Items(4, "Diamond Ring", "", 2000, 50);
		C206_CaseStudy.addItems(itemsList, item_missing);
		assertEquals("Test that the item array list size remains unchanged.", 2, itemsList.size());
	}

	@Test
	public void testRetrieveAllItems() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is a valid item array list to add to", itemsList);
		assertEquals("Test that the item array list is empty.", 0, itemsList.size());

		// Attempt to retrieve the item
		String allItems = C206_CaseStudy.retrieveAllItems(itemsList);
		String testOutput = "";
		// Test that the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allItems);

		// Test Case 2
		// Add the items in the desired order
		C206_CaseStudy.addItems(itemsList, item1);
		C206_CaseStudy.addItems(itemsList, item2);
		// Test that the list is not empty
		assertEquals("Test that the item array list size is 2.", 2, itemsList.size());
		// Attempt to retrieve the items
		allItems = C206_CaseStudy.retrieveAllItems(itemsList);
		testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item1.getId(), item1.getName(),
				item1.getDescription(), item1.getStarting_bid(), item1.getMinimum_bid_increment());
		testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item2.getId(), item2.getName(),
				item2.getDescription(), item2.getStarting_bid(), item2.getMinimum_bid_increment());
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allItems);

		// Test Case 3
		// Add the third item after the first two
		C206_CaseStudy.addItems(itemsList, item3);
		assertEquals("Test that the item array list size is 3.", 3, itemsList.size());
		// Attempt to retrieve the item
		allItems = C206_CaseStudy.retrieveAllItems(itemsList);
		testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item1.getId(), item1.getName(),
				item1.getDescription(), item1.getStarting_bid(), item1.getMinimum_bid_increment());
		testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item2.getId(), item2.getName(),
				item2.getDescription(), item2.getStarting_bid(), item2.getMinimum_bid_increment());
		testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item3.getId(), item3.getName(),
				item3.getDescription(), item3.getStarting_bid(), item3.getMinimum_bid_increment());
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allItems);
	}

	@Test
	public void testDeleteItems() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is a valid item array list to add to", itemsList);
		assertEquals("Test that the item array list is empty.", 0, itemsList.size());

		// Test Case 2
		C206_CaseStudy.addItems(itemsList, item1);
		C206_CaseStudy.addItems(itemsList, item2);
		assertEquals("Test that the item array list size is 2.", 2, itemsList.size());

		// Delete an item that exists in the list
		boolean isDeleted = C206_CaseStudy.deleteItems(itemsList, item1.getId());
		assertTrue("Test that the item is deleted", isDeleted);
		assertEquals("Test that the item array list size is now 1.", 1, itemsList.size());

		// Attempt to retrieve the items after deletion
		String allItems = C206_CaseStudy.retrieveAllItems(itemsList);
		String testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item1.getId(), item1.getName(),
				item1.getDescription(), item1.getStarting_bid(), item1.getMinimum_bid_increment());
		// Test that the deleted item is not in the list
		assertFalse("Test that the deleted item is not in the list", allItems.contains(testOutput));

		// Delete an item that does not exist in the list (this should not delete
		// anything)
		int nonExistingItemId = 99; // Assuming 99 is not a valid item ID
		isDeleted = C206_CaseStudy.deleteItems(itemsList, nonExistingItemId);
		assertFalse("Test that the item is not deleted", isDeleted);
		assertEquals("Test that the item array list size remains unchanged.", 1, itemsList.size());
	}

	@After
	public void tearDown_items() throws Exception {
		item1 = null;
		item2 = null;
		item3 = null;
		itemsList = null;
	}

	@Before
	public void setUp_bid() throws Exception {
		// prepare test data
		bid1 = new Bid(1, "A001", "Silver Long Necklace", 10, 5, "19-07-2023", "26-07-2023");
		bid2 = new Bid(2, "A002", "Soft and Fluffy Cushion", 5, 5, "19-07-2023", "26-07-2023");
		bidList = new ArrayList<Bid>();
	}

	@Test
	public void testAddBid() {
		// bid list is not null, so that can add a new bid - boundary
		assertNotNull("Check if there is valid bid arraylist to add to", bidList);
		// Given an empty list, after adding 1 bid, the size of the list is 1 - normal
		// The bid just added is as same as the first bid of the list
		C206_CaseStudy.addBid(bidList, bid1);
		assertEquals("Check that bid arraylist size is 1", 1, bidList.size());
		assertSame("Check that bid is added", bid1, bidList.get(0));

		// Add another bid. test The size of the list is 2? -normal
		// The bid just added is as same as the second bid of the list
		C206_CaseStudy.addBid(bidList, bid2);
		assertEquals("Check that bid arraylist size is 2", 2, bidList.size());
		assertSame("Check that bid is added", bid2, bidList.get(1));
	}

	@Test
	public void testRetrieveAllBids() {
		// Test if bid list is not null but empty -boundary
		assertNotNull("Test if there is valid bid arraylist to retrieve bid", bidList);

		// test if the list of bids retrieved from the SourceCentre is empty - boundary
		String allBids = C206_CaseStudy.retrieveAllBids(bidList);
		String testOutput = "";
		assertEquals("Check that ViewAllBidlist", testOutput, allBids);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addBid(bidList, bid1);
		C206_CaseStudy.addBid(bidList, bid2);
		assertEquals("Test that bid arraylist size is 2", 2, bidList.size());

		// test if the expected output string same as the list of bids retrieved from
		// the SourceCentre
		allBids = C206_CaseStudy.retrieveAllBids(bidList);
		testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f %-20s %-20s\n", bid1.getbidID(),
				bid1.getitemTitle(), bid1.getitemName(), bid1.getcurrentBid(), bid1.getminBidIncrement(),
				bid1.getstartingBidDate(), bid1.getclosingBidDate());
		testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f %-20s %-20s\n", bid2.getbidID(),
				bid2.getitemTitle(), bid2.getitemName(), bid2.getcurrentBid(), bid2.getminBidIncrement(),
				bid2.getstartingBidDate(), bid2.getclosingBidDate());

		assertEquals("Test that ViewAllBidlist", testOutput, allBids);
	}

	@Test
	public void testDeleteBid() {
		// Test Case 1
		// Test if Item list is not null and empty - Boundary
		assertNotNull("Test if there is a valid bid arraylist to add to", bidList);
		assertEquals("Test that the bid array list is empty.", 0, bidList.size());

		// Test Case 2 - Normal
		C206_CaseStudy.addBid(bidList, bid1);
		C206_CaseStudy.addBid(bidList, bid2);
		assertEquals("Test that the bid array list size is 2.", 2, bidList.size());

		// Delete a bid that exists in the list - Normal
		boolean isDeleted = C206_CaseStudy.deleteBid(bidList, bid1.getbidID());
		assertTrue("Test that the bid is deleted", isDeleted);
		assertEquals("Test that the bid array list size is now 1.", 1, bidList.size());

		// Attempt to retrieve the bids after deletion
		String allBids = C206_CaseStudy.retrieveAllBids(bidList);
		String testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f %-20s %-20s\n", bid1.getbidID(),
				bid1.getitemTitle(), bid1.getitemName(), bid1.getcurrentBid(), bid1.getminBidIncrement(),
				bid1.getstartingBidDate(), bid1.getclosingBidDate());
		// Test that the deleted item is not in the list
		assertFalse("Test that the deleted bid is not in the list", allBids.contains(testOutput));

		// Delete a bid that does not exist in the list - Error
		int nonExistingBidID = 99; // Assuming 99 is not a valid item ID
		isDeleted = C206_CaseStudy.deleteBid(bidList, nonExistingBidID);
		assertFalse("Test that the bid is not deleted", isDeleted);
		assertEquals("Test that the bid array list size remains unchanged.", 1, bidList.size());
	}

	@After
	public void tearDown_bid() throws Exception {
		bid1 = null;
		bid2 = null;
		bidList = null;
	}

	@Before
	public void setUp_payment() throws Exception {

		paymentList = new ArrayList<Payment>();

		p1 = new Payment("ggg", "llll");
		p2 = new Payment("eee", "www");
	}

	private Payment p1;
	private Payment p2;

	@Test
	public void testAddPayment() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Payment arraylist to add to", paymentList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addPayment(paymentList, p1);
		assertEquals("Check that Payment arraylist size is 3", 1, paymentList.size());
		assertSame("Check that Camcorder is added", p1, paymentList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		Payment.addPayment(paymentList, p2);
	}

	@Test
	public void testViewPayment() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Payment arraylist to add to", paymentList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.viewPayment(paymentList, p1);
		assertEquals("Check that Payment arraylist size is 3", 1, paymentList.size());
		assertSame("Check that Camcorder is added", p1, paymentList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		Payment.viewPayment(paymentList, p2);
	}

	@Test
	public void testDeletePayment() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Payment arraylist to add to", paymentList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.deletePayment(paymentList, p1);
		assertEquals("Check that Payment arraylist size is 3", 1, paymentList.size());
		assertSame("Check that Camcorder is added", p1, paymentList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		Payment.deletePayment(paymentList, p2);
	}

	@After
	public void tearDown_payment() throws Exception {

		p1 = null;
		p2 = null;
		paymentList = null;
	}

	@Before
	public void setUp() {
		users = new ArrayList<Notification>();
	}

	@After
	public void tearDown() {
		users.clear();
	}

	@Test
	public void testAddNotification() {
		C206_CaseStudy.addNotification(users, new Notification("John", "Admin1", "01/01/2023", "Test Notification"));
		assertEquals(1, users.size());
	}

	@Test
	public void testAddNotificationEmptyFields() {
		C206_CaseStudy.addNotification(users, new Notification("", "Admin1", "01/01/2023", "Test Notification"));
		assertEquals(0, users.size());
	}

	@Test
	public void testViewNotification() {
		Notification nt1 = new Notification("Alice", "Admin2", "02/02/2023", "Test Notification 1");
		Notification nt2 = new Notification("Bob", "Admin2", "03/02/2023", "Test Notification 2");
		users.add(nt1);
		users.add(nt2);

		assertEquals(2, users.size());

		String output = "SHOWING ALL NOTIFICATIONS";
		output += "\nUsername: Alice\nAdmin: Admin2\nDate: 02/02/2023\nNotification: Test Notification 1\n";
		output += "\nUsername: Bob\nAdmin: Admin2\nDate: 03/02/2023\nNotification: Test Notification 2\n";

	}

	@Test
	public void testDeleteNotificationConfirmed() {
		Notification nt1 = new Notification("Alice", "Admin2", "02/02/2023", "Test Notification 1");
		Notification nt2 = new Notification("Bob", "Admin2", "03/02/2023", "Test Notification 2");
		users.add(nt1);
		users.add(nt2);

		assertEquals(2, users.size());

	}

	@Test
	public void testDeleteNotificationCancelled() {
		Notification nt1 = new Notification("Alice", "Admin2", "02/02/2023", "Test Notification 1");
		Notification nt2 = new Notification("Bob", "Admin2", "03/02/2023", "Test Notification 2");
		users.add(nt1);
		users.add(nt2);

		assertEquals(2, users.size());

		assertEquals(2, users.size());

	}
}
