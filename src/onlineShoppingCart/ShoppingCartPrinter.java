/*
* Assignment	onlineShoppingCart
* Program		ShoppingCartPrinter
* date			Dec 3, 2018
* Author		Jorge Jimenez
*/

//package onlineShoppingCart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShoppingCartPrinter
{
	public static String name  = "";
	public static int price    = 0;
	public static int quantity = 0;
	
	public static void main(String[] args)
	{
//		
//		// DELETE
//		try
//		{
//			System.setIn(new FileInputStream("tester.txt"));
//		} catch (FileNotFoundException e)
//		{
//			System.out.println("File not found");
//		}
//		
		ItemToPurchase item1 = new ItemToPurchase();
		ItemToPurchase item2 = new ItemToPurchase();
		
		Scanner input = new Scanner(System.in);

		
		System.out.println("Item 1");
		//set item1
		getUserItems(input);
		initItem(item1);
		input.nextLine();
		
		System.out.println();
		System.out.println("Item 2");
		// set item2
		getUserItems(input);
		initItem(item2);
		
		System.out.println();
		printTotal(item1, item2);
		
		//print(item1, item2);
		// close Scanner
		input.close();
	}

	private static void print(ItemToPurchase ...items)
	{
		for (ItemToPurchase item : items)
			System.out.println(item);
	}
	private static void printTotal(ItemToPurchase ...items)
	{
		int total = 0;
		System.out.println("TOTAL COST");
		for (ItemToPurchase item : items)
		{
			System.out.printf("%s %d @ $%d = $%d", 
					item.getName(), item.getQuantity(), item.getPrice(), 
					(item.getQuantity() * item.getPrice())
				);
			System.out.println();
			total += (item.getQuantity() * item.getPrice());
		}
		
		System.out.println();
		System.out.println("Total: $" + total);
	}
	private static void getUserItems(Scanner input)
	{
		System.out.println("Enter the item name:");
		name = input.nextLine();
		System.out.println("Enter the item price:");
		price = input.nextInt();
		System.out.println("Enter the item quantity:");
		quantity = input.nextInt();
		
	}

	private static void initItem(ItemToPurchase item)
	{
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
	}
	
}
