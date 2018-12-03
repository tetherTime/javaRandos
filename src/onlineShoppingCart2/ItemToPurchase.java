/*
* Assignment	onlineShoppingCart
* Program		ItemToPurchase
* date			Dec 3, 2018
* Author		Jorge Jimenez
*/
//package onlineShoppingCart2;

public class ItemToPurchase
{

//	Public member methods
//	setDescription() mutator & getDescription() accessor (2 pts)
//	printItemCost() - 
//	printItemDescription() - Outputs the item name and description

	private String 	itemDescription = "none";
	private String	itemName 		= "none";
	private int 	itemPrice 		= 0;
	private int 	itemQuantity 	= 0;
	
	
	
	/**
	 * Constructor - ItemToPurchase
	 *
	 * @param itemDescription
	 * @param itemName
	 * @param itemPrice
	 * @param itemQuantity
	 */
	public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity)
	{
		super();
		this.itemDescription = itemDescription;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}
	
	public ItemToPurchase()
	{
		
	}
	/**
	 * METHOD - printCost
	 *	<p>Outputs the item name followed by the quantity, price, and subtotal
	 * Return Type - void	void
	 */
	public void printCost()
	{
		System.out.printf("%s %d @ $%d = $%d\n",
				this.getName(),
				this.getQuantity(),
				this.getPrice(),
				(this.getQuantity() * this.getPrice())
			);
	}
	
	/**
	 * METHOD - printItemDescription
	 * <p>Outputs the item name and description
	 * <p>example output (Bottled Water: Deer Park, 12 oz.)
	 * Return Type - void	void
	 */
	public void printItemDescription()
	{
		System.out.printf("%s: %s", 
				this.getName(), this.getDescription());
	}
	/**
	 * Field getter
	 * 
	 * @return the itemDescription
	 */
	public String getDescription()
	{
		return itemDescription;
	}

	/**
	 * Field setter
	 * 
	 * @param itemDescription the itemDescription to set
	 */
	public void setDescription(String itemDescription)
	{
		this.itemDescription = itemDescription;
	}

	/**
	 * Field getter
	 * 
	 * @return the itemName
	 */
	public String getName()
	{
		return itemName;
	}

	/**
	 * Field getter
	 * 
	 * @return the itemPrice
	 */
	public int getPrice()
	{
		return itemPrice;
	}

	/**
	 * Field getter
	 * 
	 * @return the itemQuantity
	 */
	public int getQuantity()
	{
		return itemQuantity;
	}

	/**
	 * Field setter
	 * 
	 * @param itemName the itemName to set
	 */
	public void setName(String itemName)
	{
		this.itemName = itemName;
	}

	/**
	 * Field setter
	 * 
	 * @param itemPrice the itemPrice to set
	 */
	public void setPrice(int itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	/**
	 * Field setter
	 * 
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setQuantity(int itemQuantity)
	{
		this.itemQuantity = itemQuantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ItemToPurchase [itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity=" + itemQuantity
				+ "]";
	}
}