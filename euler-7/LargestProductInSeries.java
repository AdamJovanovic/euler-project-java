import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.LinkedList;

public class LargestProductInSeries {
    public static final int ZERO_ASCII = 48;
    public static final int MAX_LENGTH = 13; //Number of adjacent digits
    public static void main(String[] args) {
        String filePath;
        if(args.length != 1) {
            PrintUsage();
            return;
        } else {
            filePath = args[0];
        };

        File inputDigitsFile = new File(filePath);
        if(!inputDigitsFile.exists()) {
            System.out.println(String.format("File at path %s does not exist", filePath));
            return;
        } 

        FileReader reader = null;
        //This task lends itself naturally to a FIFO queue
        LinkedList<Integer> currQueue = new LinkedList<Integer>();
            
        try {
            reader = new FileReader(inputDigitsFile);

            int digit;
            Long currProduct = 1L;
            Long largestProduct = 1L;
            char character;
            try{
                while((digit = reader.read())!=-1) {
                    character = (char)digit;
                    if(character<'0' || character>'9') {
                        continue;
                    } else {
                        digit -= LargestProductInSeries.ZERO_ASCII;
                        if(digit == 0) {
                            //No point counting any values near a 0, the product will be 0
                            currQueue.clear();
                            currProduct = 1L;
                        } else if(currQueue.size() == LargestProductInSeries.MAX_LENGTH) {
                            //Pop the last element and remove its product from the current prod.
                            currProduct /= currQueue.removeLast();
                            currProduct *= digit;
                            currQueue.push(digit);
                            if(currQueue.size() == LargestProductInSeries.MAX_LENGTH) {
                                if(currProduct > largestProduct) {
                                    largestProduct = currProduct;
                                }
                            }                            
                        } else {
                            //Keep populating the queue until you reach the MAX_LENGTH
                            currQueue.push(digit);
                            currProduct *= digit;
                            if(currQueue.size() == LargestProductInSeries.MAX_LENGTH) {
                                if(currProduct > largestProduct) {
                                    largestProduct = currProduct;
                                }
                            }
                        }
                    }
                }
                System.out.println(String.format("Largest product = %d", largestProduct));
                
            } catch(IOException er) {
                System.out.println("Failed to read character");
            }

        } catch (FileNotFoundException fe) {
            System.out.println("File not found error");
            return;
        }

        try {
            reader.close();
        } catch(IOException err) {
            System.out.println("Failed to close file");
        }
    }


    public static void PrintUsage() {
        String help = "Correct Usage:\n" +
        "java LargestProductInSeries <path-to-numbers>\n" +
        "\t- path-to-numbers: relative path to the text file containing the series of digits.";

        System.out.println(help);
    }
}