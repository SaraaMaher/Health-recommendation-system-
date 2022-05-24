/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author mohamed mosaad
 */
public class WritingData {
    
     public static void main(String[] args) throws Exception 
    {
        Manipulation M = new Manipulation() ;
        LoseWeight L = new LoseWeight();
        
        ArrayList<meal> baseData =readBaseData.read_csv("baseData.txt");
        System.out.println(baseData.get(0).getName());

        
        try
        {
            File F = new File("NEWDATA.txt");

            PrintStream writer = new PrintStream(F);
            for(int i = 0 ; i < L.SetMealType(M.DataCleaning(baseData)).size();i++)
            {
                if(L.SetMealType(M.DataCleaning(baseData)).get(i) != null)
                {
                    writer.println(L.SetMealType(M.DataCleaning(baseData))
                            .get(i).getName()+','+L.SetMealType(M.DataCleaning(baseData))
                                    .get(i).getPortion_amount()+','+L.SetMealType(M.DataCleaning(baseData))
                                            .get(i).getPortion_name()+','+L.SetMealType(M.DataCleaning(baseData))
                                                    .get(i).getGrain()+','+L.SetMealType(M.DataCleaning(baseData))
                                                            .get(i).getVegetable()+','+L.SetMealType(M.DataCleaning(baseData))
                                                                    .get(i).getFruit()+','+L.SetMealType(M.DataCleaning(baseData))
                                                                            .get(i).getMeat()+','+L.SetMealType(M.DataCleaning(baseData))
                                                                                    .get(i).getCalories()+','+L.SetMealType(M.DataCleaning(baseData))
                                                                                            .get(i).getMealType());
                }
            }
            writer.close();
        } 
        catch (FileNotFoundException fnf) 
        {
            System.out.println("the file wasn't found");
        }
        LoseWeight l = new LoseWeight();
        ArrayList<String> breakfast = l.RecommendBreakFast();
                System.out.println(breakfast.get(0));


    }
    
    
    
}
