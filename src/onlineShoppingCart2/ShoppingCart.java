/*
* Assignment	ShoppingCart
* Program		ShoppingCart
* date			Dec 3, 2018
* Author		Jorge Jimenez
*/


//package onlineShoppingCart2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
	
	String customerName = "none";
	String currentDate  = "January 1, 2016";
	List<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
	/**
	 * Constructor - ShoppingCart
	 *
	 * @param customerName
	 * @param currentDate
	 * @param cartItems
	 */
	public ShoppingCart(String customerName, String currentDate)
	{
		super();
		this.customerName = customerName;
		this.currentDate = currentDate;
	}
	public ShoppingCart()
	{
		
	}
	/**
	 * METHOD - printDescriptions
	 *<p>Outputs each item's description.
	 * Return Type - void	void
	 */
	public void printDescriptions()
	{
		System.out.printf("%s\'s Shopping Cart - %s\n", 
				this.getCustomerName(), this.getDate());
		System.out.println();
		System.out.println("Item Descriptions");
		for (ItemToPurchase item : this.cartItems)
		{
			item.getDescription();
		}
	}
	/**
	 * METHOD - printTotal
	 *<p>Outputs total of objects in cart. If cart is empty, output this message: SHOPPING CART IS EMPTY
	 * Return Type - void	void
	 */
	public void printTotal()
	{
		if (this.cartItems.isEmpty())
		{
			System.out.println("SHOPPING CART IS EMPTY");
			return;
		}
		
		System.out.printf("%s\'s Shopping Cart - %s\n", 
				this.getCustomerName(), this.getDate());
		System.out.println("Number of Items: " + this.getNumItemsInCart());
		System.out.println();
		for (ItemToPurchase item : this.cartItems)
			item.printCost();
		System.out.println();
		System.out.println("Total: " + this.getCostOfCart());
		
	}
	
	/**
	 * METHOD - getNumItemsInCart
	 * <p>Returns quantity of all items in cart. Has no parameters.
	 * Return Type - int
	 * @return	int
	 */
	public int getNumItemsInCart()
	{
		return this.cartItems.size();
	}
	
	/**
	 * METHOD - getCostOfCart
	 *<p>Determines and returns the total cost of items in cart. Has no parameters.
	 * Return Type - int
	 * @return	int
	 */
	public int getCostOfCart()
	{
		int sum = 0;
		for (ItemToPurchase item : this.cartItems)
		{
			sum += (item.getPrice() * item.getQuantity());
		}
		
		return sum;
	}
	/**
	 * METHOD - modifyItem
	 * <p>Modifies an item's description, price, and/or quantity. Has parameter ItemToPurchase. 
	 * <p>Does not return anything.If item can be found (by name) in cart, check if parameter 
	 * <p>has default values for description, price, and quantity. If not, modify item in cart. 
	 * <p>If item cannot be found (by name) in cart, output this message: Item not found in cart. 
	 * <p>Nothing modified.
	 * Return Type - void	void
	 */
	public void modifyItem(ItemToPurchase item)
	{
		boolean found 	 = false;
		String 	itemName = item.getName();
		int 	size 	 = this.cartItems.size();
		int 	index 	 = 0;
		
		for (int i = 0; i < size || found; i++)
		{
			if (this.cartItems.get(i).getName().equals(itemName))
			{
				index = i;
				found = true;
			}
		}
		
		if (!found)
		{
			System.out.println("Item not found in cart.");
			return;
		}
		
		String desc   = item.getDescription();
		int    price  = item.getPrice();
		int    qty	  = item.getQuantity();
		
		if (!desc.equals("none"))	
			this.cartItems.get(index).setDescription(desc);
		if (price != 0)
			this.cartItems.get(index).setPrice(price);
		if (qty != 0)
			this.cartItems.get(index).setQuantity(qty);

	}
	
	/**
	 * METHOD - removeItem
	 * <p>Removes item from cartItems array. Has a string (an item's name) parameter. 
	 * <p>Does not return anything.If item name cannot be found, output this 
	 * <p>message: Item not found in cart. Nothing removed.
	 * Return Type - void	void
	 */
	public void removeItem(String itemName)
	{
		boolean found = false;
		int size = this.cartItems.size();
		
		for (int i = 0; i < size || found; i++)
		{
			if (this.cartItems.get(i).getName().equals(itemName))
			{
				this.cartItems.remove(i);
				found = true;
			}
		}
		if (!found)
			System.out.println("Item not found in cart. Nothing removed.");
	}
	/**
	 * METHOD - addItem
	 *
	 * Return Type - void
	 * @param cartItem	void
	 */
	public void addItem(ItemToPurchase cartItem)
	{
		this.cartItems.add(cartItem);
	}
	/**
	 * Field getter
	 * 
	 * @return the customerName
	 */
	public String getCustomerName()
	{
		return customerName;
	}
	/**
	 * Field getter
	 * 
	 * @return the currentDate
	 */
	public String getDate()
	{
		return currentDate;
	}
	

}
