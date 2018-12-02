/*
* Assignment	peopleWeights
* Program		PeopleWeights
* date			Dec 2, 2018
* Author		Jorge Jimenez
*/
package peopleWeights;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PeopleWeights {
   public static void main(String[] args) {
		// DELETE
		try
		{
			System.setIn(new FileInputStream("newRoster.txt"));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		double[] weights = new double[5];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 5; i++)
		{
			System.out.printf("Enter weight %d:\n", i);
			weights[i] = input.nextDouble();
		}

		System.out.print("You entered: ");
		for (double e : weights)
			System.out.print(e + " ");
   }
}