
package dataBase;
import java.util.ArrayList;
import java.util.List;


public class Manipulation {
  //  static List<meal> baseData =readBaseData.read_csv("baseData.txt");
    
    private static void Alchol_remover(ArrayList<meal> baseData)
    {
        //loop until you find an object in the array list has alchol value greater than 0 then remove it 
        for (int i = 0 ; i < baseData.size() ; i++)
        {
            if(baseData.get(i).getAlcohol() > 0)
            { 
                baseData.remove(i);
                i--;
            }
        }
    }
    // The amount of junk food increase in data0base when calories value is 216 or greater 
    // removes the food that has calories greater than or equal 216
    private static void JunkFood_remover(ArrayList<meal> baseData)
    {
        for (int i = 0 ; i < baseData.size() ; i++)
        {
            if(baseData.get(i).getCalories() >= 216)
            {
                baseData.remove(i);
                i--;
            }
        }
    }
    private static void pork_remover(ArrayList<meal> baseData)
    {
        // if the object name contains the word "pork" remove the object from the database
        for (int i = 0 ; i < baseData.size() ; i++)
        {
            if(baseData.get(i).getName().contains("pork"))
            {
                baseData.remove(i);
                i--;
            }
        }
    }
    //function takes the database and run the cleaning methods on it then return the clean database
    public static ArrayList<meal> DataCleaning(ArrayList<meal> baseData)
    {
        Alchol_remover(baseData);
        JunkFood_remover(baseData);
        pork_remover(baseData);
        return baseData;
    }
    
    
} 
