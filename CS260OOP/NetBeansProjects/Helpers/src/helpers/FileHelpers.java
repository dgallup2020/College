package helpers;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
public class FileHelpers 
{
    //standard, sequential text file operations 

    public static String selectFile()
    {
        String fileName;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue;
        File selectedFile = null;

        returnValue = fileChooser.showDialog(null, "Select File");
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileChooser.getSelectedFile();
            fileName = selectedFile.getName();
        }
        else
        {
            fileName = "File not found";
        }
        return selectedFile.getAbsolutePath();
    }
    public static Boolean writeData(String data, String fileName)
    {
        Boolean success = false;
        try
        {
            FileWriter dataFile = new FileWriter(fileName, true);
            PrintWriter output = new PrintWriter(dataFile);

            output.println(data);
            output.close();
            success = true;
        }
        catch (IOException ioe)
        {
            OutputHelpers.showStandardDialog(ioe.getMessage(), "File Write Error");
            success = false;
        }
        return success;
    }
    public static String readData(String fileName)
    {
        String str;
        StringBuffer contents = new StringBuffer();
        try
        {
            String file = checkFile(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((str = br.readLine()) != null)
            {
                    contents.append(str).append(System.getProperty("line.separator"));
            }
            br.close();
        }
        catch (IOException ioe)
        {
                OutputHelpers.showStandardDialog(ioe.getMessage(), "File Read Error");
                str = "No data";
        }
        return contents.toString();
    }
    public static ArrayList<String> readList(String fileName) {
        ArrayList<String> dataList = new ArrayList<String>();
        String str;
        try {
            //String file = checkFile(fileName);
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((str = br.readLine()) != null)
            {
                dataList.add(str);
            }
            br.close();
        }
        catch (IOException ioe)
        {
            //OutputHelpers.showStandardDialog(ioe.getMessage(), "File Read Error");
            dataList = null;
        }
        return dataList;
    }
    public static String checkFile(String fileName) {
        String aFile;
        File theFile = new File(fileName);
        if (theFile.exists()) {
            aFile = fileName;
        }
        else {
            aFile = selectFile();
        }
        return aFile;
    }

    //sequential binary, object file operations

    public static ObjectOutputStream openOutputFile(String fileName) {
        ObjectOutputStream output = null;
        try
        {
            output = new ObjectOutputStream(new FileOutputStream(fileName, true));
        }
        catch (IOException ioe)
        {
            OutputHelpers.showConsole("File Read Error");
        }
        return output;
    }
    public static void closeObjectOutputFile(ObjectOutputStream output)
    {
        try {
            if(output != null)
            {
                output.flush();
                output.close();
            }
        }
        catch (IOException ioe) {
            OutputHelpers.showConsole("Error closing ouput file");
        }
    }

    public static ObjectInputStream openInputFile(String fileName) {
        ObjectInputStream input = null;
        try {
            String file = checkFile(fileName);
            input = new ObjectInputStream(new FileInputStream(file));
        }
        catch (IOException ioe)
        {
            OutputHelpers.showConsole("File Read Error");
        }
        return input;
    }
    public static void closeObjectInputFile(ObjectInputStream input) {
        try {
            if (input != null)
                input.close();
        }
        catch (IOException ioe) {
            OutputHelpers.showConsole("Error closing input file");
        }
    }

}
