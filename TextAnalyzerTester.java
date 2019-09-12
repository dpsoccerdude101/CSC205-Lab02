import java.util.Scanner;
/**
 *this class runs the text analyzer and prompts the user for input
 *
 *@author (Kurt Mueller Dennis Pavlyuk)
 *@version Sep 12, 2019
 */
public class TextAnalyzerTester{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //initialize your scanner before declaring a text analyzer object
        System.out.println("Enter the name of the file: ");
        String fileName = sc.next(); //put filename into the TextAnalyzer initialization as a parameter
        //create TextAnalyzer object
        TextAnalyzer ta = new TextAnalyzer(fileName); //text analyzer constructor requires a string as a parameter

        System.out.println("\nNumber of Lines: " + ta.getLineCount());
        System.out.println("Number of Words: "+ ta.getWordCount());
        System.out.println("Letter Counts");
        
        int[] frequencies = ta.getFrequencies();
        for (int i=0; i< frequencies.length; i++){
            System.out.println("Frequency of "+ (char)('A' + i)+ ": "+frequencies[i] + " ");
        }
        System.out.println();
    }
}
