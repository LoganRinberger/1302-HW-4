/*This homework represents my own work. I understand that I may receive help, 
but I did not copy any portion of this assignment from anywhere. 
I understand that a violation of this will result in a Report of Academic Dishonesty.—Logan Rinberger”
*/

package prob1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Warehouse 
{
	protected Item[] items = new Item[10];
	private int numItems = 0;
	
	public Warehouse() {}
	
	public boolean addItem(Item item)
	{
		if (numItems < items.length) 
		{
			for (int i = 0; i < numItems; i++) 
			{
				if (items[i].getName().equals(item.getName())) 
				{
					return false;
				}
			}
			items[numItems] = item;
			numItems++;
			return true;
		}
		return false;
	}
	
	public int getNumItems() 
	{
		return numItems;
	}
	
	public Item getItem(int i) 
	{
		if (i >= 0 && i < numItems) 
		{
			return items[i];
		}
		else 
		{
			return null;
		}
	}
	
	public Item getItem(String name) 
	{
		List<Item> itemList = Arrays.asList(items);
		Item dummyItem = new Item(name, 0);
		
		if (itemList.contains(dummyItem)) 
		{
			return items[itemList.indexOf(dummyItem)];
		} 
		else 
		{
			return null;
		}
	}
	
	public double getAverageTemp()
	{
		double temp = 0;
		int count = 0;
		double avgTemp = 0;
		for (int i = 0; i < numItems; i++) 
        {
			if(items[i] instanceof RefrigeratedItem)
			{
				temp += ((RefrigeratedItem) items[i]).getTemp();
				count++;
            }
        }
		avgTemp = temp / count;
		return avgTemp;
	}
	
	public double getTotalCost()
	{
		double totalCost = 0;
		for (int i = 0; i < numItems; i++) 
		{
			totalCost += items[i].cost();
		}
		return totalCost;
	}
	
	public double getTotalCostRefrigerated()
	{
		double totalCost = 0;
        for (int i = 0; i < numItems; i++) 
        {
            if(items[i] instanceof RefrigeratedItem)
            {
                totalCost += items[i].cost();
            }
        }
        return totalCost;
	}
	
	public ArrayList<RefrigeratedItem> getRefrigeratedItems() 
	{
		ArrayList<RefrigeratedItem> refItems = new ArrayList<>();
		for (int i = 0; i < numItems; i++) 
		{
			if (items[i] instanceof RefrigeratedItem) 
			{
				refItems.add((RefrigeratedItem) items[i]);
			}
		}
		return refItems;
	}
	
	public Item removeItem(int i)
	{
		if (i >= 0 && i < numItems) 
        {
            Item item = items[i];
            for (int j = i; j < numItems - 1; j++) 
            {
                items[j] = items[j - 1];
            }
            numItems--;
            return item;
        }
        else 
        {
            return null;
        }
	}
	
	public Item removeItem(String name) 
	{
		List<Item> itemList = new ArrayList<>(Arrays.asList(items));
		Item dummyItem = new Item(name, 0);
		
		if (itemList.contains(dummyItem))
		{
			int index = itemList.indexOf(dummyItem);
			Item item = itemList.remove(index);
			items = itemList.toArray(new Item[0]);
			numItems--;
			return item;
		}
		else
		{
			return null;
		}
	}
	
	public ArrayList<Item> getItemsWithName(String partialName)
	{
		ArrayList<Item> matchedItems = new ArrayList<>();
		for (int i = 0; i < numItems; i++) 
		{
			if (items[i].getName().startsWith(partialName)) 
			{
				matchedItems.add(items[i]);
			}
		}
		return matchedItems;
	}
	
	public boolean hasItem (String name)
	{
		for (int i = 0; i < numItems; i++) 
		{
			if (items[i].getName().equals(name)) 
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString()
	{
		String msg = "";
		for (int i = 0; i < numItems; i++)
		{
			if (items[i] instanceof RefrigeratedItem)
			{
				msg += "name=" + items[i].getName() 
					+ ", cost=$" + String.format("%.2f", items[i].cost()) 
					+ ", weight=" + String.format("%.2f", items[i].getWeight()) 
					+ ", temperature=" + String.format("%.2f",((RefrigeratedItem) items[i]).getTemp()) 
					+ " degrees"
					+ "\n";
			}
			else
			{
				msg += "name=" + items[i].getName() 
					+ ", cost=$" + String.format("%.2f", items[i].cost()) 
					+ ", weight=" + String.format("%.2f",items[i].getWeight())
					+ "\n";
			}
		}
		return msg;
	}

}
