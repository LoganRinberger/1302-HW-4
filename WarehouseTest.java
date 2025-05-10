package prob1;
import java.util.ArrayList;

public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem(); 						
		testAddItem_Multiple(); 			
		testAddItem_Multiple_11(); 			
		testGetItem_WithIndex(); 			
		testGetItem_WithInvalidIndex(); 	
		testGetItem_WithName(); 			
		testGetItem_WithInvalidName(); 		
		testGetAverageTemp(); 				
		testGetRefrigeratedItems(); 		
		testGetTotalCost(); 				
		testGetTotalCostRefrigerated();	   	
		testRemoveItem_WithIndex(); 		
		testRemoveItem_WithIndex_invalid(); 
		testRemoveItem_WithName(); 			
		testRemoveItem_WithoutName(); 
		testAddItem_Duplicate();
		testGetItemsWithName();
		testHasItem_Find();
		testHasItem_NoFind();
		testToString();						
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("-->testAddItem"); 

		Warehouse w = new Warehouse();
		Item item = new Item("item1", 1.0);
		
		String expected = "Expected Number of Items: 1";
		System.out.println(expected);
		
		w.addItem(item);
		System.out.println("Number of Items: " + w.getNumItems());
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("-->testAddItem_Multiple"); 

		Warehouse w = new Warehouse();
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -10);
		
		String expected = "Expected Number of Items: 3";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		System.out.println("Number of Items: " + w.getNumItems());
	}
	
	/**
	 * Add eleven items and check the number of items to verify. This goes over the max number of items, and therefore
	 * shouldn't increase after 10 At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple_11() {
		System.out.println("-->testAddItem_Multiple_11"); 

		Warehouse w = new Warehouse();
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -10);
		Item item4 = new Item("item4", 4.0);
		Item item5 = new Item("item5", 5.0);
		RefrigeratedItem item6 = new RefrigeratedItem("item6", 6.0, -20);
		Item item7 = new Item("item7", 7.0);
		Item item8 = new Item("item8", 8.0);
		RefrigeratedItem item9 = new RefrigeratedItem("item9", 9.0, -30);
		Item item10 = new Item("item10", 10.0);
		Item item11 = new Item("item11", 11.0);
		
		String expected = "Expected Number of Items: 10";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		w.addItem(item6);
		w.addItem(item7);
		w.addItem(item8);
		w.addItem(item9);
		w.addItem(item10);
		w.addItem(item11);
		System.out.println("Number of Items: " + w.getNumItems());
	}

	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("-->testGetItem_WithIndex"); 

		Warehouse w = new Warehouse();
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		Item item3 = new Item("item3", 3.0);
		
		String expected = "Expected: item2";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		
		Item item = w.getItem(1);
		String actual = item.getName();
		System.out.println("Actual: " + actual);
		
	}

	/**
	 * Add three items and retrieve the one at index -3.
	 */
	public static void testGetItem_WithInvalidIndex() {
		System.out.println("-->testGetItem_WithInvalidIndex"); 

		Warehouse w = new Warehouse();
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		Item item3 = new Item("item3", 3.0);
		
		String expected = "Expected: null";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		
		Item item = w.getItem(-3);
		String actual = item + "";
		System.out.println("Actual: " + actual);
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("-->testGetItem_WithName"); 

		Warehouse w = new Warehouse();
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		Item item3 = new Item("item3", 3.0);
		
		String expected = "Expected: item2";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		
		Item item = w.getItem("item2");
		String actual = item.getName();
		System.out.println("Actual: " + actual);
	}

	/**
	 * Add three items and try to find one with a name that does not exist.
	 */
	public static void testGetItem_WithInvalidName() {
		System.out.println("-->testGetItem_WithInvalidName"); 

		Warehouse w = new Warehouse();
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		Item item3 = new Item("item3", 3.0);
		
		String expected = "Expected: null";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		
		Item item = w.getItem("item4");
		String actual = item + "";
		System.out.println("Actual: " + actual);
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("-->testGetAverageTemp"); 

		Warehouse w = new Warehouse();
		RefrigeratedItem item1 = new RefrigeratedItem("item1", 1.0, -10);
		RefrigeratedItem item2 = new RefrigeratedItem("item2", 2.0, -20);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -30);
		Item item4 = new Item("item4", 4.0);
		Item item5 = new Item("item5", 5.0);
		
		String expected = "Expected Average Temp: -20.0";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		double avgTemp = w.getAverageTemp();
		String actual = "Actual Average Temp: " + avgTemp;
		System.out.println(actual);
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("-->testGetRefrigeratedItems"); 

		Warehouse w = new Warehouse();
		RefrigeratedItem item1 = new RefrigeratedItem("item1", 1.0, -10);
		RefrigeratedItem item2 = new RefrigeratedItem("item2", 2.0, -20);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -30);
		Item item4 = new Item("item4", 4.0);
		Item item5 = new Item("item5", 5.0);
		
		String expected = "Expected: item1, item2, item3";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		ArrayList<RefrigeratedItem> items = w.getRefrigeratedItems();
		String actual = "Actual: ";
		for (Item item : items)
		{
			if (item != null)
			{
				actual += item.getName() + ", ";
			}
		}
		
		if (actual.endsWith(", "))
		{
			actual = actual.substring(0, actual.length() - 2);
		}
		
		System.out.println(actual);
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("-->testGetTotalCostRefrigerated"); 
		//System.out.println("NOT IMPLEMENTED"); 
		Warehouse w = new Warehouse();
		RefrigeratedItem item1 = new RefrigeratedItem("item1", 1.0, -10);
		RefrigeratedItem item2 = new RefrigeratedItem("item2", 2.0, -20);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -30);
		Item item4 = new Item("item4", 4.0);
		Item item5 = new Item("item5", 5.0);
		
		String expected = "Expected Total Cost: $66.00";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		double totalCost = w.getTotalCost();
		String actual = "Actual Total Cost: $" + String.format("%.2f", totalCost);
		System.out.println(actual);
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("-->testGetTotalCostRefrigerated"); 

		Warehouse w = new Warehouse();
		RefrigeratedItem item1 = new RefrigeratedItem("item1", 1.0, -10);
		RefrigeratedItem item2 = new RefrigeratedItem("item2", 2.0, -20);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -30);
		Item item4 = new Item("item4", 4.0);
		Item item5 = new Item("item5", 5.0);
		
		String expected = "Expected Total Cost: $48.00";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		double totalCost = w.getTotalCostRefrigerated();
		String actual = "Actual Total Cost: $" + String.format("%.2f", totalCost);
		System.out.println(actual);
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("-->testRemoveItem_WithIndex"); 

		Warehouse w = new Warehouse();
		
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -10);
		RefrigeratedItem item4 = new RefrigeratedItem("item4", 4.0, -20);
		RefrigeratedItem item5 = new RefrigeratedItem("item5", 5.0, -30);
		
		String expected = "Expected: item 3, count: 4";
		System.out.println(expected);

		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);

		Item item = w.removeItem(2);
		System.out.println("Removed: " + item.getName() + ", count: " + w.getNumItems());
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position -2 and 
	 * verify: the item is not returned, and the number of items is not decremented.
	 */
	public static void testRemoveItem_WithIndex_invalid() {
		System.out.println("-->testRemoveItem_WithIndex_invalid"); 

		Warehouse w = new Warehouse();
		
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -10);
		RefrigeratedItem item4 = new RefrigeratedItem("item4", 4.0, -20);
		RefrigeratedItem item5 = new RefrigeratedItem("item5", 5.0, -30);
		
		String expected = "Expected: null, count: 5";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		Item item = w.removeItem(-2);
		if (item != null)
		{
			System.out.println("Removed: " + item.getName() + ", count: " + w.getNumItems());
		}
		else 
		{
			System.out.println("Removed: null, count: " + w.getNumItems());
		}
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("-->testRemoveItem_WithName"); 

		Warehouse w = new Warehouse();
		
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -10);
		RefrigeratedItem item4 = new RefrigeratedItem("item4", 4.0, -20);
		RefrigeratedItem item5 = new RefrigeratedItem("item5", 5.0, -30);
		
		String expected = "Expected: item 3, count: 4";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		Item item = w.removeItem("item3");
		System.out.println("Removed: " + item.getName() + ", count: " + w.getNumItems());
		
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that does not exist and
	 * verify: the item returns null, and the number of items is not decremented.
	 */
	public static void testRemoveItem_WithoutName() {
		System.out.println("-->testRemoveItem_WithoutName"); 

		Warehouse w = new Warehouse();
		
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		RefrigeratedItem item3 = new RefrigeratedItem("item3", 3.0, -10);
		RefrigeratedItem item4 = new RefrigeratedItem("item4", 4.0, -20);
		RefrigeratedItem item5 = new RefrigeratedItem("item5", 5.0, -30);
		
		String expected = "Expected: null, count: 5";
		System.out.println(expected);
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		
		Item item = w.removeItem("item6");
		if (item != null) 
		{
			System.out.println("Removed: " + item.getName() + ", count: " + w.getNumItems());
		} else 
		{
			System.out.println("Removed: null, count: " + w.getNumItems());
		}
	
	}
	
	public static void testAddItem_Duplicate() 
	{
		System.out.println("-->testAddItem_Duplicate");

		Warehouse w = new Warehouse();
		
		Item item1 = new Item("item1", 1.0);

		String expected = "Expected: 1";
		System.out.println(expected);

		w.addItem(item1);
		w.addItem(item1);
		
		System.out.println("Actual: " + w.getNumItems());
	}
	
	public static void testGetItemsWithName()
	{
		System.out.println("-->testGetItemsWithName");

		Warehouse w = new Warehouse();

		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		Item item3 = new Item("item3", 3.0);

		String expected = "Expected: 3";
		System.out.println(expected);

		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);

		System.out.println("Actual: " + w.getNumItems());
	}
	

	public static void testHasItem_Find() 
	{
		System.out.println("-->testHasItem_Find");

		Warehouse w = new Warehouse();
		Item item = new Item("item1", 1.0);

		String expected = "Expected: true";
		System.out.println(expected);

		w.addItem(item);
		boolean hasItem = w.hasItem("item1");
		System.out.println("Actual: " + hasItem);
	}

	public static void testHasItem_NoFind()
	{
		System.out.println("-->testHasItem_NoFind");

		Warehouse w = new Warehouse();
		Item item = new Item("item1", 1.0);

		String expected = "Expected: false";
		System.out.println(expected);

		w.addItem(item);
		boolean hasItem = w.hasItem("item2");
		System.out.println("Actual: " + hasItem);
	}


	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		
		Warehouse w = new Warehouse();
		
		Item item1 = new Item("item1", 1.0);
		Item item2 = new Item("item2", 2.0);
		Item item3 = new Item("item3", 3.0);
		Item item4 = new Item("item4", 4.0);
		Item item5 = new Item("item5", 5.0);
		RefrigeratedItem item6 = new RefrigeratedItem("item6", 6.0, -10);
		RefrigeratedItem item7 = new RefrigeratedItem("item7", 7.0, -20);
		RefrigeratedItem item8 = new RefrigeratedItem("item8", 8.0, -30);
		RefrigeratedItem item9 = new RefrigeratedItem("item9", 9.0, -40);
		RefrigeratedItem item10 = new RefrigeratedItem("item10", 10.0, -50);
		
		String expected;
		expected = "\n"
				 + "name=item1, cost=$2.00 , weight=1.00\n" 
				 + "name=item2, cost=$4.00, weight=2.00\n"
				 + "name=item3, cost=$6.00, weight=3.00\n"
				 + "name=item4, cost=$8.00, weight=4.00\n"
				 + "name=item5, cost=$10.00, weight=5.00\n"
				 + "name=item6, cost=$23.00, weight=6.00, temp=-10.00 degrees\n"
				 + "name=item7, cost=$26.00, weight=7.00, temp=-20.00 degrees\n"
				 + "name=item8, cost=$29.00, weight=8.00, temp=-30.00 degrees\n"
				 + "name=item9, cost=$32.00, weight=9.00, temp=-40.00 degrees\n"
				 + "name=item10, cost=$30.00, weight=10.00, temp=-50.00 degrees";
		
		System.out.println("Expected: " + expected + "\n");
		
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		w.addItem(item6);
		w.addItem(item7);
		w.addItem(item8);
		w.addItem(item9);
		w.addItem(item10);
		
		String actual = w.toString();
		System.out.println("Actual: " + "\n" + actual);
	}

}
