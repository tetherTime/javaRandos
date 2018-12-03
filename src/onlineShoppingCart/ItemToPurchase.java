/*
* Assignment	onlineShoppingCart
* Program		ItemToPurchase
* date			Dec 3, 2018
* Author		Jorge Jimenez
*/

package onlineShoppingCart;

public class ItemToPurchase
{
	private String itemName = "none";
	private int itemPrice = 0;
	private int itemQuantity = 0;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ItemToPurchase [itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity=" + itemQuantity
				+ "]";
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
}