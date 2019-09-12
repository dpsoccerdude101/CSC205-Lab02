import java.util.*;
import java.io.*;
/**
 *This program reads a text file and counts the number of lines, number of words, and the *frequency of occurrence of each of the 26 letters of the alphabet
 * 
 *
 * @author (Dennis Pavlyuk & Kurt Mueller)
 * @version (September 5, 2019)
 */
public class TextAnalyzer {
    private int lineCount;
    private int wordCount;
    private int[] frequencies = new int[26];
    private String[] info;
    private File input;
    Scanner myFileIn; 

    public TextAnalyzer(String fileName) {
        input = readFile(fileName);
        myFileIn = scanFile(input);
        lineCount = 0;
        wordCount = 0;
        info = setInfoArrayAndSetLineCount(myFileIn);
        for (int count = 0; count < info.length; count++) {
            wordCount += calcWordCount(info[count]);
        }
        this.frequencies = calcFrequencies(info);
    }
    /**
    *take input for file to be scanned
    */
    public File readFile(String fileName) {
        input = new File(fileName);
        return input;
    }
    /**
    *Scan for file, catch for invalid file name
    */
    public Scanner scanFile(File file) {
        myFileIn = null;
        try
        {
            myFileIn= new Scanner(file);
        } catch (FileNotFoundException e)
        {
            System.out.println("File: "+file+" is not found");
        }
        return myFileIn;
    }
    /**
    *
    public String[] setInfoArrayAndSetLineCount(Scanner scan) {
        //make list to be able to populate info array without knowing how many lines we have
        List<String> stats = new ArrayList<String>();
        
        //while there is something to scan
        while (scan.hasNextLine()) {
            stats.add(scan.nextLine());
            lineCount++;
        }
        
        //turn the list back into an array
        String[] wack = stats.toArray(new String[0]);
        return wack;
    }
   /**
   *calculates the word count from scanned line
   */
    public int calcWordCount(String input) {
        String[] words = input.split("\\s+");
        return words.length;
    }
   /**
   *calculates the frequencies of each letter in the alphabet
   */
    public int [] calcFrequencies(String[] input) {
        //initializes the frequency counter to 0, to prevent null pointer errors
        int [] frequencies = new int[26];
        for (int count = 0; count < 26; count++) {
            frequencies[count] = 0;
        }

        //reference for frequency counter
        String alphabet = ("abcdefghijklmnopqrstuvwxyz");

        //first loop, takes the String from a line of the full array and divides it at the white space
        for (int bar = 0; bar < input.length; bar++) {
            String [] words = input[bar].split("\\s+");

            //second loop, takes the word from the string [] 
            for (int count = 0; count < words.length; count++) {
                //counter for letter of the word we are working on
                int log = 0;

                //counter for letter of alphabet
                int log2 = 0;

                String word = words[count].toLowerCase();
                System.out.print(word);
                char letter;
                //third loop, takes the letter from the word
                while (log < word.length()) {
                    //initializes letter
                    letter = word.charAt(log);

                    //makes sure that the character is alphabetic, else it skips it
                    if (Character.isLetter(letter)) {
                        if (((Character)letter).equals(alphabet.charAt(log2))){
                            //adds 1 counter to the frequency of that letter in the frequency array
                            frequencies[log2] += 1;

                            //next letter
                            log++;

                            //start alphabet from beginning
                            log2 = 0;
                        }
                        else {
                            //if not found, move onto next letter in alphabet
                            log2++;
                        }
                    }
                    else {
                        //skip letter
                        log++;
                    }
                }
            }
        }
        return frequencies;
    }
    /**
    *getter methods
    */
    public int getLineCount() {return lineCount;}

    public int getWordCount() {return wordCount;}

    public int[] getFrequencies() {return frequencies;}
}
