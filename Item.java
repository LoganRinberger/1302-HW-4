package prob1;

public class Item 
{
	private String name;
	private double weight;
	
	public Item(String name, double weight) 
	{
		this.name = name;
		this.weight = weight;
	}

	public String getName() 
	{
		return name;
	}
	
	public double getWeight() 
	{
		return weight;
	}
	
	public double cost()
	{
		double itemCost;
		itemCost = weight * 2;
		return itemCost;
	}
	
	public boolean equals(String name)
	{
		if (this.name.equals(name))
		{
			return true;
		}
		else 
		{
			return false;
		}	
	}
	
	@Override
	public String toString() 
	{
		String msg;
		msg = "name=" + name 
			   + ", cost=$" + String.format("%.2f", cost()) 
			   + ", weight=" + String.format("%.2f", weight);
		return msg;
	}
}
