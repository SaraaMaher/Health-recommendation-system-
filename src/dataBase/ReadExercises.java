/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author mohamed mosaad
 */
public class ReadExercises {
    
    public static ArrayList<ExercisePlan> read_csv(String fileName) {
        ArrayList<ExercisePlan> Exercises = new ArrayList<>();
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

                ExercisePlan E = new ExercisePlan(attributes);

                // adding book into ArrayList
                Exercises.add(E);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return Exercises;
        
    }
    
}
