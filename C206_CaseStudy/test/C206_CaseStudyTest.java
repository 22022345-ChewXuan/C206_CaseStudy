import static org.junit.Assert.*;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Comparator;
=======
>>>>>>> branch 'master' of https://github.com/22022345-ChewXuan/C206_CaseStudy.git

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Auction a1;
	private Auction a2;
	
	private ArrayList<Auction> auctionList;
	
	public C206_CaseStudyTest() {
		super();
	}

<<<<<<< HEAD
    private Items item1;
    private Items item2;
    private Items item3;
=======
	@Test
    public void testValidRegistration() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "johndoe@example.com", "bidder", "password1234");
        assertTrue(result);
    }

	@Before
	public void setUp() throws Exception {
		a1 = new Auction("Jade", "made from pure material", 300, "19-07-1890", "A001", "don't overspend!", "09-09-2023", "5:00pm",
				"8:00pm", 10, 5000);
		a2 = new Auction("Art", "created by famous painter", 850, "20-07-1890", "A002", "don't overspend!", "10-09-2023", "6:00pm",
				"9:00pm", 20, 4000);
		
		auctionList= new ArrayList<Auction>();
	}

    @Test
    public void testInvalidEmail() {
    	C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "invalidemail", "bidder", "password1234");
        assertFalse(result);
    }
    
    @Test
    public void testValidRole() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "johndoe@example.com", "bidder", "password1234");
        assertTrue(result);
    }
    
    @Test
    public void testValidRole1() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "johndoe@example.com", "administrator", "password1234");
        assertTrue(result);
    }
    
    @Test
    public void testValidRole2() {
		C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "johndoe@example.com", "Auction Organizers", "password1234");
        assertTrue(result);
    }
>>>>>>> branch 'master' of https://github.com/22022345-ChewXuan/C206_CaseStudy.git

<<<<<<< HEAD
    private ArrayList<Items> itemsList;
=======
    @Test
    public void testWeakPassword() {
    	C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "johndoe@example.com", "bidder", "weak");
        assertFalse(result);
    }

    @Test
    public void testMissingName() {
    	C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("", "johndoe@example.com", "bidder", "password1234");
        assertFalse(result);
    }

    @Test
    public void testMissingEmailAndPassword() {
    	C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "", "bidder", "");
        assertFalse(result);
    }
    
    @Test
    public void testMissingRole() {
    	C206_CaseStudy userRegistration = new C206_CaseStudy();
        boolean result = userRegistration.registerUser("John Doe", "johndoe@example.com", "", "password1234");
        assertFalse(result);
    }

>>>>>>> branch 'master' of https://github.com/22022345-ChewXuan/C206_CaseStudy.git

<<<<<<< HEAD
    public C206_CaseStudyTest() {
        super();
    }
=======
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Auction arraylist to add to", auctionList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addAuction(auctionList, a1);
		assertEquals("Check that Auction arraylist size is 1", 1, auctionList.size());
		assertSame("Check that Auction is added", a1, auctionList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addAuction(auctionList, a2);
		assertEquals("Check that Auction arraylist size is 2", 2, auctionList.size());
		assertSame("Check that Auction is added", a2, auctionList.get(1));
	}
	
	@Test
	public void testRetrieveAllAuction() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Auction arraylist to retrieve item", auctionList);
		
		//test if the list of Auction retrieved from the caseStudy is empty - boundary
		String allAuction= C206_CaseStudy.retrieveAllAuction(auctionList);
		String testOutput = "";
		assertEquals("Check that ViewAllAuctionlist", testOutput, allAuction);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addAuction(auctionList, a1);
		C206_CaseStudy.addAuction(auctionList, a2);
		assertEquals("Test that Auction arraylist size is 2", 2, auctionList.size());
		
		//test if the expected output string same as the list of Auction retrieved from the CaseStudy	
		allAuction= C206_CaseStudy.retrieveAllAuction(auctionList);
		testOutput = String.format("%-10s %-20s %-15s %-15s %-15s %-15d %-15d\n","A001", "don't overspend!", "09-09-2023", "5:00pm", "8:00pm",10, 5000);
		testOutput += String.format("%-10s %-20s %-15s %-15s %-15s %-15d %-15d\n","A002", "don't overspend!", "10-09-2023", "6:00pm", "9:00pm", 20, 4000);
	
		assertEquals("Test that ViewAllAuctionlist", testOutput, allAuction);
		
	}
	
	@Test
	public void testDoDeleteAuction() {
		//boundary
		assertNotNull("test if there is valid Auction arraylist to delete from", auctionList);
		
		C206_CaseStudy.addAuction(auctionList, a1);
		// normal
		Boolean ok = C206_CaseStudy.doDeleteAuction(auctionList, "A001", "don't overspend!" );
		assertTrue("Test if an available item is ok to loan?", ok);
		//error condition
		ok = C206_CaseStudy.doDeleteAuction(auctionList, "A001", "don't overspend!" );
		assertFalse("Test if an same item is NOT ok to loan again?", ok);	
		//error condition
		C206_CaseStudy.addAuction(auctionList, a2);	
		a2.setIsAvailable(false);
		ok = C206_CaseStudy.doDeleteAuction(auctionList, "A002", "don't overspend!" );
		assertFalse("Test that un-available item is NOT ok to delete?", ok);
		//error condition
		ok = C206_CaseStudy.doDeleteAuction(auctionList, "A002", "don't overspend!" );
		assertFalse("Test that non-esiting item is NOT ok to delete?", ok);
		
	}
	
	@After
	public void tearDown() throws Exception {
		a1 = null;
		a2 = null;
		auctionList = null;
	}
>>>>>>> branch 'master' of https://github.com/22022345-ChewXuan/C206_CaseStudy.git

<<<<<<< HEAD
    @Before
    public void setUp() throws Exception {
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
        testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item1.getId(), item1.getName(), item1.getDescription(), item1.getStarting_bid(), item1.getMinimum_bid_increment());
        testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item2.getId(), item2.getName(), item2.getDescription(), item2.getStarting_bid(), item2.getMinimum_bid_increment());
        // Test that the details are displayed correctly
        assertEquals("Test that the display is correct.", testOutput, allItems);

        // Test Case 3
        // Add the third item after the first two
        C206_CaseStudy.addItems(itemsList, item3);
        assertEquals("Test that the item array list size is 3.", 3, itemsList.size());
        // Attempt to retrieve the item
        allItems = C206_CaseStudy.retrieveAllItems(itemsList);
        testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item1.getId(), item1.getName(), item1.getDescription(), item1.getStarting_bid(), item1.getMinimum_bid_increment());
        testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item2.getId(), item2.getName(), item2.getDescription(), item2.getStarting_bid(), item2.getMinimum_bid_increment());
        testOutput += String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item3.getId(), item3.getName(), item3.getDescription(), item3.getStarting_bid(), item3.getMinimum_bid_increment());
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
        String testOutput = String.format("%-5d %-20s %-30s %-15.2f %-20.2f\n", item1.getId(), item1.getName(), item1.getDescription(), item1.getStarting_bid(), item1.getMinimum_bid_increment());
        // Test that the deleted item is not in the list
        assertFalse("Test that the deleted item is not in the list", allItems.contains(testOutput));

        // Delete an item that does not exist in the list (this should not delete anything)
        int nonExistingItemId = 99; // Assuming 99 is not a valid item ID
        isDeleted = C206_CaseStudy.deleteItems(itemsList, nonExistingItemId);
        assertFalse("Test that the item is not deleted", isDeleted);
        assertEquals("Test that the item array list size remains unchanged.", 1, itemsList.size());
    }

    @After
    public void tearDown() throws Exception {
        item1 = null;
        item2 = null;
        item3 = null;
        itemsList = null;
    }
}
=======
}

>>>>>>> branch 'master' of https://github.com/22022345-ChewXuan/C206_CaseStudy.git
