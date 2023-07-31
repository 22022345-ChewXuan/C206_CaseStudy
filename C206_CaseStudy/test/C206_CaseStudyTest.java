import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

    private Items item1;
    private Items item2;
    private Items item3;

    private ArrayList<Items> itemsList;

    public C206_CaseStudyTest() {
        super();
    }

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