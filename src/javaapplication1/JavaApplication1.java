package javaapplication1;
import dataBase.*;
import java.io.IOException;
import java.util.ArrayList;

public class JavaApplication1 {
    
    public static void main(String[] args) throws IOException
    {
        // read baseData from file into program
        Manipulation M = new Manipulation();
        ArrayList<meal> baseData =readBaseData.read_csv("baseData.txt");
        ArrayList<ExercisePlan> ExerciseData = ReadExercises.read_csv("Exercises.txt");
    ArrayList<meal> CleanedData = M.DataCleaning(baseData);
         GainWeight G = new GainWeight() ;
         LoseWeight L = new LoseWeight() ;
        ArrayList <String> n = L.RecommendDinner(CleanedData);
        for(int i = 0 ; i < n.size() ; i++)
        {
            System.out.println(n.get(i));
        }
        L.SetMealType(CleanedData);
        for(int i = 0 ; i < 50 ; i++)
        {
            System.out.println(CleanedData.get(i).getMealType());
        }
        
        
        
        
        
        
        
    } 
}
