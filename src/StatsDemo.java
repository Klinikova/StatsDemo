import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;


// TASK #3 Add the file I/O import statement here
/**
   This class reads numbers from a file, calculates the
   mean and standard deviation, and writes the results
   to a file.
*/

public class StatsDemo
{ 
   // TASK #3 Add the throws clause
   public static void main(String[] args) throws IOException
{
      double sum = 0;      // The sum of the numbers
      int count = 0;       // The number of numbers added
      double mean = 0;     // The average of the numbers
      double stdDev = 0;   // The standard deviation
      String line;         // To hold a line from the file
      double difference;   // The value and mean difference

      //create an object of type Decimal Format
      DecimalFormat threeDecimals = new DecimalFormat("#0.000");
      // Create an object of type Scanner
      Scanner keyboard = new Scanner (System.in);
      String filename;     // The user input file name
           
      // Prompt the user and read in the file name
      System.out.println("This program calculates " +
                         "statistics on a file " +
                         "containing a series of numbers");
      //PrintWriter outputFile = new PrintWriter(fwriter);
       FileWriter fileWriter = new FileWriter("Results.txt", true); /* Create a FileWriter object passing it the filename Results.txt (Don’t
forget the needed import statement). */
       PrintWriter printWriter = new PrintWriter(fileWriter); //Create a PrintWriter object passing it the FileWriter object. 
       DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
       NumberFormat numberFormatter = new DecimalFormat("#0.000" , otherSymbols);     
       String formattedMean = numberFormatter.format(mean);
       String formattedStdDev = numberFormatter.format(stdDev);
       
       //String formattedMean = String.format("%.3f", mean);
       //String formattedStdDev = String.format("%.3f", stdDev);
       System.out.println(formattedMean);
       System.out.println(formattedStdDev);
       
       printWriter.println(formattedMean);
       printWriter.println(formattedStdDev);
       printWriter.close();
       
        System.out.print("Enter the file name:  ");
       //String filename = keyboard.nextLine();

      // ADD LINES FOR TASK #4 HERE
      FileReader fileReader = new FileReader("Numbers.txt"); // Create a FileReader object passing it the filename
      BufferedReader bufferedReader = new BufferedReader(fileReader); // Create a BufferedReader object passing FileReader object
      // Perform a priming read to read the first line of
      // the file
      String firstLineString = bufferedReader.readLine();      
      Double firstLineDouble = Double.parseDouble(firstLineString);
      sum += firstLineDouble;
      count++;
      // Loop until you are at the end of the file
      for (String nextLine = bufferedReader.readLine(); nextLine != null; nextLine = bufferedReader.readLine())
      {
          // Convert the line to a double value
          Double nextLineDouble = Double.parseDouble(nextLine);
          
          // Add the value to  the sum
          sum += nextLineDouble;
          
          // Increment the counter
          count++;
          // Read a new line from the file
      }
        
      // Close the input file
      bufferedReader.close();
      fileReader.close();
      
      // Store the calculated mean
      mean = sum/count;
      System.out.println("Assignment 4: mean: "+mean+", " + stdDev);
      
      // ADD LINES FOR TASK #5 HERE
      
      // Reconnect FileReader object passing it the
      fileReader = new FileReader("Numbers.txt"); //fileReader object
      // filename
      // Reconnect BufferedReader bject passing
      bufferedReader = new BufferedReader(fileReader); 
      
      sum = 0;                                  //reinitialize the sum of the numbers
      count = 0;                                //reinitialize the number of numbers added
      firstLineString = bufferedReader.readLine();      
      firstLineDouble = Double.parseDouble(firstLineString);
      difference = firstLineDouble - mean;
      sum += Math.pow(difference, 2);
      count++;
      for (String nextLine = bufferedReader.readLine(); nextLine != null; nextLine = bufferedReader.readLine())
      {
          // Convert the line to a double value
          Double nextLineDouble = Double.parseDouble(nextLine);
     
      /*convert the line into a double value and subtract the mean, store the result
in difference*/
        difference = nextLineDouble - mean;
          sum+=Math.pow(difference, 2);       
          // Increment the counter
          count++;
          // Read a new line from the file
      }
      bufferedReader.close();
      fileReader.close();
      
      double variance = sum/count;
      stdDev = Math.sqrt(variance);
      System.out.println("stdDev: " + stdDev);
      
      // Perform a priming read to read the first line of
      // the file
      // Loop until you are at the end of the file
      // Convert the line into a double value and
      // subtract the mean
      // Add the square of the difference to the sum
      // Increment the counter
      // Read a new line from the file
      // Close the input file
      // Store the calculated standard deviation

      // ADD LINES FOR TASK #3 HERE
      // Create a FileWriter object using "Results.txt"
      // Create a PrintWriter object passing the
      // FileWriter object
      // Print the results to the output file
      // Close the output file
   }
}
