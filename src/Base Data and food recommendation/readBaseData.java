package dataBase;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class readBaseData {
 /**
 * Read the dataset
 * read from .txt file contains the whole dataset, into the program.
 *
 * @return Array List of object meal contain the whole data
 * @param fileName fileName that contains the data
 * @return 
 */   
public static ArrayList<meal> read_csv(String fileName) {
        ArrayList<meal> baseData = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.UTF_8 )) {

            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read 
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split("\",\"");

                meal m = new meal(attributes);

                // adding book into ArrayList
                baseData.add(m);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return baseData;
        
    }
}
