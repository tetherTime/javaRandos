package zybooks;
import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualization {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scn = new Scanner(System.in);
      
      ArrayList<String> dataStrings = new ArrayList<String>();
      ArrayList<Integer> dataInts  = new ArrayList<Integer>();
      String[] temp = new String[10];
      
      String title;
      String header;
      String header2;
      
      System.out.println("Enter a title for the data:");
      title = scn.nextLine();
      System.out.printf("You entered: %s\n", title); 
      System.out.println();
      
      System.out.println("Enter the column 1 header:");
      header = scn.nextLine();
      System.out.printf("You entered: %s\n", header); 
      System.out.println();
      
      System.out.println("Enter the column 2 header:");
      header2 = scn.nextLine();
      System.out.printf("You entered: %s\n", header2);
      System.out.println();
      
      while (true)
      {
		  System.out.println("Enter a data point (-1 to stop input):");
		  temp = scn.nextLine().split(",");
		  if (temp[0].equals("-1"))
			  break;
		  if (temp.length > 1)
			  temp[1] = temp[1].trim();

		  if (temp.length == 1)
			System.out.println("Error: No comma in string.");
		  else if (temp.length > 2)
			System.out.println("Error: Too many commas in input.");
		  else if (!isInteger(temp[1], 10))
			  System.out.println("Error: Comma not followed by an integer.");
	         else
	         {
	            System.out.println("Data string: " + temp[0]);
	            System.out.println("Data integer: " + temp[1]);
	            dataStrings.add(temp[0]);
	            dataInts.add(Integer.parseInt(temp[1]));
	         }
          
      }
      
      System.out.printf("%33s\n", title);
      System.out.printf("%-20s|%23s\n", header, header2);
      for (int i = 0; i < dataStrings.size(); i++)
      {
          System.out.printf("%-20s|%23s\n", dataStrings.get(i), dataInts.get(i));
      }
      scn.close();
      return;
   }     
   
   public static boolean isInteger(String s, int radix) {
       Scanner sc = new Scanner(s.trim());
       if(!sc.hasNextInt(radix)) 
       {
    	   sc.close();
    	   return false;
       }
         
       sc.close();
       return true;
   }
}