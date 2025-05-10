package prob1;

public class RefrigeratedItem extends Item
{
	private double temperature;

	public RefrigeratedItem(String name, double weight, double temperature) 
	{
		super(name, weight);
		this.temperature = temperature;
	}
	
	public RefrigeratedItem (Item item, double temperature)
	{
		super(item.getName(), item.getWeight());
        this.temperature = temperature;
    }
	
	public double getTemp() 
	{
		return temperature;
	}
	
	public double cost()
	{
		double RFItemCost;
		RFItemCost = getWeight() * 2 + ((100 - getTemp()) * 0.1);
		return RFItemCost;
	}
	
	@Override
	public String toString() 
	{
		String msg;
		msg = "name=" + getName() 
			+ ", cost=$" + String.format("%.2f", cost()) 
			+ ", weight=" + String.format("%.2f", getWeight())
			+ ", temperature=" + String.format("%.2f", temperature) 
			+ " degrees";
		return msg;
	}
}
