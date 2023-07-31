import static org.junit.Assert.*;

import java.util.ArrayList;

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

}

