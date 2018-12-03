/*
* Assignment	onlineShoppingCart2
* Program		ShoppingCartManager
* date			Dec 3, 2018
* Author		Jorge Jimenez
*/


//package onlineShoppingCart2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShoppingCartManager
{
	public static boolean wrongInput = false;
	public static ShoppingCart cart;
	
	public static void main(String[] args)
	{
		
//		// DELETE
//		try
//		{
//			System.setIn(new FileInputStream("test.txt"));
//		} catch (FileNotFoundException e)
//		{
//			System.out.println(e);
//		}

		Scanner input = new Scanner(System.in);
		String name  = "";
		String date  = "";
		
		
		System.out.println("Enter Customer's Name:");
		name = input.nextLine();
		System.out.println("Enter Today's Date:");
		date = input.nextLine();
		System.out.println();
		System.out.println("Customer Name: " + name);
		System.out.println("Today's Date: " + date);
		System.out.println();
		cart = new ShoppingCart(name, date);
		
		printMenu(input);
		
		// close scanner
		input.close();
	}
	
	/**
	 * METHOD - printMenu
	 *<p>printMenu() has a ShoppingCart parameter, 
	 *<p>and outputs a menu of options to manipulate the shopping cart. Each option is 
	 *<p>represented by a single character. Build and output the menu within the method.
	 * Return Type - void	void
	 * @return 
	 */
	private static void printMenu(Scanner input)
	{
		/*
		If the an invalid character is entered, continue to prompt for a 
		valid choice. Hint: Implement Quit before implementing other options.
		Call printMenu() in the main() method. Continue to execute the menu until 
		the user enters q to Quit. (3 pts) 
		*/
		String userInput = "";
		do {
			
			System.out.println("MENU");
			System.out.println("a - Add item to cart");
			System.out.println("d - Remove item from cart");
			System.out.println("c - Change item quantity");
			System.out.println("i - Output items' descriptions");
			System.out.println("o - Output shopping cart");
			System.out.println("q - Quit");
			System.out.println();
			
			System.out.println("Choose an option: ");
			userInput = input.nextLine();
			do {
				processInput(userInput, input);
			}while (wrongInput);
				
		}while (!userInput.equals("q"));
	}

	private static void processInput(String userInput, Scanner input)
	{
		switch (userInput)
		{
			case "a":
				addItem(input);
				wrongInput = false;
				break;
			case "d":
				removeItem(input);
				wrongInput = false;
				break;
			case "c":
				changeQty(input);
				wrongInput = false;
				break;
			case "i":
				outputDescriptions();
				wrongInput = false;
				break;
			case "o":
				outputShoppingCart();
				wrongInput = false;
				break;
			case "q":
				wrongInput = false;
				break;
			default:
				wrongInput = true;
				break;
		}
	}

	private static void changeQty(Scanner input)
	{
		
		String name = "";
		int    qty  = 0;
		
		System.out.println("CHANGE ITEM QUANTITY");
		System.out.println("Enter the item name:");
		name = input.nextLine();
		System.out.println("Enter the new quantity:");
		qty = input.nextInt();
		
		ItemToPurchase item = new ItemToPurchase();
		item.setQuantity(qty);
		item.setName(name);
		
		cart.modifyItem(item);
	}

	private static void removeItem(Scanner input)
	{
		System.out.println("REMOVE ITEM FROM CART");
		System.out.println("Enter name of item to remove:");
		String name = input.nextLine();

		cart.removeItem(name);
	}

	private static void addItem(Scanner input)
	{
		String name  = "";
		String desc  = "";
		int    price = 0;
		int    qty   = 0;
		
		System.out.println("ADD ITEM TO CART");
		name = input.nextLine();
		System.out.println("Enter the item name:");
		desc = input.nextLine();
		System.out.println("Enter the item description:");
		price = input.nextInt();
		System.out.println("Enter the item price:");
		qty = input.nextInt();
		System.out.println("Enter the item quantity:");	
		input.nextLine();
		
		cart.addItem(new ItemToPurchase(desc, name, price, qty));
	}

	/**
	 * METHOD - outputDescriptions
	 *
	 * Return Type - void	void
	 */
	private static void outputDescriptions()
	{
		System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
		cart.printDescriptions();
	}

	/**
	 * METHOD - outputShoppingCart
	 *
	 * Return Type - void	void
	 */
	private static void outputShoppingCart()
	{
		System.out.println("OUTPUT SHOPPING CART");
		cart.printTotal();
	}
}
