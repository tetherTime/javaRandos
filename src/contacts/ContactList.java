/*
* Assignment	ch8
* Program		ContactList
* date			Oct 17, 2018
* Author		Jorge Jimenez
*/

package contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ContactList
{
	public static void main(String[] args) throws IOException
	{
//		System.setIn(new FileInputStream("test.txt"));
		/*
		 	Person 1
			Enter name:
			Roxanne Hughes
			Enter phone number:
			443-555-2864
			You entered: Roxanne Hughes, 443-555-2864
		 */	
		ContactNode contact;
		
		String name;
		String phoneNumber;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Person 1");
		System.out.println("Enter name:");
		name = scan.nextLine();
		
		System.out.println("Enter phone number:");
		phoneNumber = scan.nextLine();
		
		System.out.printf("You entered: %s, %s\n", name, phoneNumber);
		
		contact = new ContactNode(name, phoneNumber);
		
		ContactNode head;
		ContactNode tail;
		head = contact;
		for (int i = 2; i < 4; i++)
		{
			System.out.println("\nPerson " + i);
			System.out.println("Enter name:");
			name = scan.nextLine();
			
			System.out.println("Enter phone number:");
			phoneNumber = scan.nextLine();
			
			System.out.printf("You entered: %s, %s\n", name, phoneNumber);
			contact.setNext(new ContactNode(name, phoneNumber));
			contact = contact.getNext();
		}
		
		System.out.println();
		System.out.println("CONTACT LIST");
		ContactNode current = head;
		while (current != null)
		{
			current.printContactNode();
			current = current.getNext();
			System.out.println();
		}
	}
}
