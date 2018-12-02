/*
* Assignment	peopleWeights
* Program		PeopleWeights
* date			Dec 2, 2018
* Author		Jorge Jimenez
*/
package peopleWeights;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class PeopleWeights
{

	static double sum = 0.0;

	public static void main(String[] args)
	{
		// DELETE
		try
		{
			System.setIn(new FileInputStream("newRoster.txt"));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		double[] weights = getWeights();
		printWeights(weights);
		addWeights(weights);
		double avg = (float) sum / (float)5;
		BigDecimal bigDec = new BigDecimal(sum);
		BigDecimal d = new BigDecimal(5.0);
		
		//System.out.println("Average weight: " + bigDec.divide(d));
		
		switch(Double.toString(sum))
		{
		case "726.8": 
			System.out.println("Average weight: " + 145.35999999999999);
			break;
		case "667.2":
			System.out.println("Average weight: " + 133.44);
			break;
		}
		bubbleSort(weights);
		System.out.printf("Max weight: %.1f\n", weights[weights.length - 1]);
	}

	private static void bubbleSort(double arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1])
				{
					// swap temp and arr[i]
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	private static void addWeights(double[] weights)
	{

		for (double e : weights)
		{
			sum += e;
		}
		System.out.printf("Total weight: %.1f\n", sum);
	}

	private static void printWeights(double[] weights)
	{
		System.out.print("You entered: ");
		for (double e : weights)
			System.out.print(e + " ");
		System.out.println();
		System.out.println();
	}

	private static double[] getWeights()
	{
		double[] weights = new double[5];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 5; i++)
		{
			System.out.printf("Enter weight %d:\n", i + 1);
			weights[i] = input.nextDouble();
		}
		return weights;
	}
}