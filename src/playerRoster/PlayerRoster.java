/*
* Assignment	playerRoster
* Program		PlayerRoster
* date			Dec 1, 2018
* Author		Jorge Jimenez
*/
package playerRoster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlayerRoster
{

	public static void main(String[] args)
	{

		// DELETE
		try
		{
			System.setIn(new FileInputStream("tester.txt"));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		Scanner input = new Scanner(System.in);
		int[] jerseys = new int[5];
		int[] ratings = new int[5];

		for (int i = 1; i <= 5; i++)
		{
			System.out.printf("Enter player %d's jersey number:\n", i);
			jerseys[i - 1] = input.nextInt();
			System.out.printf("Enter player %d's rating:\n", i);
			ratings[i - 1] = input.nextInt();
			System.out.println();
		}

		outputRoster(jerseys, ratings);
		System.out.println();

		String userInput = "";
		do
		{
			System.out.println("MENU\n" + 
					"u - Update player rating\n" + 
					"a - Output players above a rating\n"+ 
					"r - Replace player\n" + 
					"o - Output roster\n" + 
					"q - Quit\n" + 
					"\nChoose an option:"
				);
			//System.out.println();
			userInput = input.nextLine();

			switch (userInput)
			{
				case "u":
				updateRating(input, jerseys, ratings);
					break;
				case "a":
					outputAbove(input, jerseys, ratings);
					System.out.println();
					break;
				case "r":
				changeRoster(input, jerseys, ratings);
					break;
				case "o":
					outputRoster(jerseys, ratings);
					System.out.println();
					break;
				case "q":
					break;
				default:
					break;
			}
		} while (!userInput.equals("q"));
	}

	private static void changeRoster(Scanner input, int[] jerseys, int[] ratings)
	{
		
		System.out.println("Enter a jersey number:");
		int jersey = input.nextInt();
		int jerseyIndex = 0;
		boolean found = false;
		for (int i = 0; i < jerseys.length; i++)
		{
			if (jerseys[i] == jersey)
			{
				jerseyIndex = i;
				found = true;
			}
		}
		if (found)
		{
			System.out.println("Enter a new jersey number:");
			jerseys[jerseyIndex] = input.nextInt();
			
			System.out.println("Enter a rating for the new player:");
			ratings[jerseyIndex] = input.nextInt();
			input.nextLine();
		}
	}

	private static void outputAbove(Scanner input, int[] jerseys, int[] ratings)
	{
		System.out.println("Enter a rating:");
		int rating = input.nextInt();
		input.nextLine();
		System.out.println("ABOVE " + rating);
		for (int i = 0; i < jerseys.length; i++)
		{
			if (ratings[i] > rating)
				printPlayer(jerseys, ratings, i);
		}
	}

	private static void updateRating(Scanner input, int[] jerseys, int[] ratings)
	{
		System.out.println("Enter a jersey number:");
		int jerseyNum = input.nextInt();
		System.out.println("Enter a new rating for player:");
		int newRating = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < jerseys.length; i++)
		{
			if (jerseys[i] == jerseyNum)
			{
				ratings[i] = newRating;
				return;
			}
		}
		return;
	}

	private static void outputRoster(int[] jersey, int[] ratings)
	{
		System.out.println("ROSTER");
		for (int i = 0; i < jersey.length; i++)
		{
			printPlayer(jersey, ratings, i);
		}
	}

	private static void printPlayer(int[] jersey, int[] ratings, int i)
	{
		System.out.printf("Player %d -- Jersey number: %d, Rating: %d\n", 
				i + 1, jersey[i], ratings[i]);
	}
}