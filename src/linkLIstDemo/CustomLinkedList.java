/*
* Assignment	linkLIstDemo
* Program		CustomLinkedList
* date			Oct 19, 2018
* Author		Jorge Jimenez
*/
package linkLIstDemo;

//===== Code from file CustomLinkedList.java =====
import java.util.Random;

public class CustomLinkedList
{
	public static void main(String[] args)
	{
		Random randGen = new Random();
		IntNode headObj; // Create intNode objects
		IntNode currObj;
		IntNode lastObj;
		int i; // Loop index
		int negativeCntr;

		negativeCntr = 0;
		headObj = new IntNode(-1); // Front of nodes list
		lastObj = headObj;

		for (i = 0; i < 10; ++i)
		{ // Append 10 rand nums
			int rand = randGen.nextInt(21) - 10;
			currObj = new IntNode(rand);
			lastObj.insertAfter(currObj); // Append curr
			lastObj = currObj; // Curr is the new last item
		}

		currObj = headObj; // Print the list
		while (currObj != null)
		{
			System.out.print(currObj.getDataVal() + ", ");
			currObj = currObj.getNext();
		}
		System.out.println("");

		currObj = headObj; // Count number of negative numbers
		while (currObj != null)
		{

			/* Your solution goes here */

			currObj = currObj.getNext();
		}
		System.out.println("Number of negatives: " + negativeCntr);
	}
}
//===== end =====
