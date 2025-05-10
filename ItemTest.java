package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testEqualsTrue();
		testEqualsFalse();
		testToString();
	}
	
	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("-->testConstructor");
		
		Item item = new Item("Apple", 0.5);
		
		String expectedName = "Expected Item name: Apple";
		String expectedWeight = "Expected Item weight: 0.5";
		System.out.println(expectedName);
		System.out.println(expectedWeight);
		System.out.println("Item name: " + item.getName());
		System.out.println("Item weight: " + item.getWeight());
		
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		
		Item item = new Item("Apple", 0.5);
		
		String expected = "Expected Item cost: 1.0";
		System.out.println(expected);
		System.out.println("Item cost: " + item.cost());

	}
	
	/**
	 * Verify that the equals method works correctly.
	 */
	public static void testEqualsTrue()
	{
		System.out.println("-->testequals");

		Item item = new Item("Apple", 0.5);

		String expected = "Expected: true";
		System.out.println(expected);
		System.out.println("Actual: " + item.equals("Apple"));
	}
	
	public static void testEqualsFalse()
	{
		System.out.println("-->testequals");

        Item item = new Item("Apple", 0.5);

        String expected = "Expected: false";
        System.out.println(expected);
        System.out.println("Actual: " + item.equals("Banana"));
		
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item item = new Item("Apple", 0.5);
		String expected = "name=Apple, cost=$1.00, weight=0.50";
		System.out.println("Expected: " + expected);
		String actual = item.toString();
		System.out.println("Actual: " + actual);
		
	}

}
