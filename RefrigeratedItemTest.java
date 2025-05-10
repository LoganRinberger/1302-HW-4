package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
		testConstructorAcceptsItem();
		testItemCost();
		testEqualsTrue();
		testEqualsFalse();
		testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("-->testConstructorMain");
		
		RefrigeratedItem rItem = new RefrigeratedItem("Apple", 0.5, 40.0);
		
		String expectedName = "Expected Item name: Apple";
		String expectedWeight = "Expected Item weight: 0.5";
		String expectedTemp = "Expected Item temperature: 40.0";
		
		System.out.println(expectedName);
		System.out.println(expectedWeight);
		System.out.println(expectedTemp);
		System.out.println("Item name: " + ((Item) rItem).getName());
		System.out.println("Item weight: " + ((Item) rItem).getWeight());
		System.out.println("Item temperature: " + rItem.getTemp());
	}

	/**
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("-->testConstructorAcceptsItem"); 
		
		RefrigeratedItem rItem = new RefrigeratedItem(new Item("Apple", 0.5), 40.0);
		
		String expectedName = "Expected Item name: Apple";
		String expectedWeight = "Expected Item weight: 0.5";
		String expectedTemp = "Expected Item temperature: 40.0";
		
		System.out.println(expectedName);
		System.out.println(expectedWeight);
		System.out.println(expectedTemp);
		System.out.println("Item name: " + ((Item) rItem).getName());
		System.out.println("Item weight: " + ((Item) rItem).getWeight());
		System.out.println("Item temperature: " + rItem.getTemp());
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 

		RefrigeratedItem rItem = new RefrigeratedItem("Apple", 0.5, 40.0);
		
		String expected = "Expected Item cost: 7.0";
		
		System.out.println(expected);
        System.out.println("Item cost: " + rItem.cost());

	}
	
	public static void testEqualsTrue()
	{
		System.out.println("-->testequals");

		RefrigeratedItem rItem = new RefrigeratedItem("Apple", 0.5, 40.0);

		String expected = "Expected: true";
		System.out.println(expected);
		System.out.println("Actual: " + rItem.equals("Apple"));
	}
	
	public static void testEqualsFalse()
	{
		System.out.println("-->testequals");
		
		RefrigeratedItem rItem = new RefrigeratedItem("Apple", .5, 40.0);
		
		String expected = "Expected: false";
		System.out.println(expected);
		System.out.println("Actual: " + rItem.equals("Banana"));
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 

		RefrigeratedItem rItem = new RefrigeratedItem("Apple", 0.5, 40.0);
		
		String expected = "name=Apple, cost=$7.00, weight=0.50, temperature=40.00 degrees";
		String actual = rItem.toString();

		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + actual);
		
	}

}
