import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileHandler {
    //Method to create a Scanner for any file. will be used for payroll.txt
    public static Scanner createInputScanner(String fileName){
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e){
            System.err.println("File not found");
        }
        return input;
    }


    //Method that creates a PrintWriter for any file. Will be used for payrollReport.txt and payrollError.txt
    public static PrintWriter createPrintWriter(String fileName){
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileOutputStream(fileName));
        }catch (FileNotFoundException e){
            System.err.println("File not found");
        }
        return output;
    }



}
