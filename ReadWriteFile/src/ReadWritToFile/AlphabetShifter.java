package ExamRevision;

//import java.lang.StringBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author pgd-swd
 */
public class AlphabetShifter {
    private final String alphabet = " .ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shifted = "NRSEFOPTUVWQG .AXYZBKLHMCDIJ";

    public String getAlphabet() {
        return alphabet;
    }

    public String getShifted() {
        return shifted;
    }

    public void setShifted(int shift) {
        StringBuilder builder = new StringBuilder(28);
        
        //Cut the last part fo the alphabet
        builder.append(alphabet.substring(shift, alphabet.length()));
        
        //Add the shifted chars onto the end
        builder.append(alphabet.subSequence(0, shift));        
        this.shifted = builder.toString();
    }
    
    /**
     * Demonstrates the encryption of the string
     * @param text text that will be encrypted
     * @return string builder
     */
    public String encode(String text){
        text = text.toUpperCase();
        StringBuilder builder = new StringBuilder();
        int charpos;
        for(int i =0; i < text.length(); ++i){
            charpos = alphabet.indexOf(text.charAt(i));
            builder.append(shifted.charAt(charpos));
        }
        return builder.toString();
    }
    
    public String decode(String text){
        text = text.toUpperCase();
        StringBuilder builder = new StringBuilder();
        int pos;
        for(int i =0; i < text.length(); ++i){
            pos = shifted.indexOf(text.charAt(i));
            builder.append(alphabet.charAt(pos));
        }
        return builder.toString();
    }
    
    public void writeToFile(File path, String text) throws IOException{
        FileWriter pen = new FileWriter(path);
        pen.write(text);
        pen.close();
    }
    
    public String readFromFile(File pathname) throws FileNotFoundException, IOException{
        //Read from a file
        FileReader in = new FileReader(pathname);
        BufferedReader br = new BufferedReader(in);
        
//        //Copy to a file
//        File fl = new File("outputFile.txt");
//        FileWriter fw = new FileWriter(fl);        
//        PrintWriter pw = new PrintWriter(fw);
        
        ArrayList<String> arrList = new ArrayList<>();
        String line, text = "";
        
        while((line = br.readLine()) != null){
            //pw.println(line);
            //text += line;
            arrList.add(line);
        }
        br.close();
        //pw.close();
        return arrList.toString();
    }
    
}
