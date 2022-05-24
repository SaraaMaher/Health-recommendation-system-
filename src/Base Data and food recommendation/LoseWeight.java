/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mohamed mosaad
 */
public class LoseWeight extends FoodRecommendation {
    
     @Override
    public void SetBreakFast(ArrayList<meal> CleanedData)
    {
        double[] BreakFastWeight = new double[]{30,20,60,200,10,-3}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).BreakFastScore = (CleanedData.get(i).getGrain()* BreakFastWeight[0])+(CleanedData.get(i).getVegetable()* BreakFastWeight[1])+(CleanedData.get(i).getFruit()* BreakFastWeight[2])+(CleanedData.get(i).getMilk()* BreakFastWeight[3])+(CleanedData.get(i).getMeat()* BreakFastWeight[4])+(CleanedData.get(i).getCalories()* BreakFastWeight[5]);
        }
    }
    @Override
    public void SetLunch(ArrayList<meal> CleanedData)
    {
        double[] LunchWeight = new double[]{5,200,20,20,50,-4}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).LunchScore = (CleanedData.get(i).getGrain()* LunchWeight[0])+(CleanedData.get(i).getVegetable()* LunchWeight[1])+(CleanedData.get(i).getFruit()* LunchWeight[2])+(CleanedData.get(i).getMilk()* LunchWeight[3])+(CleanedData.get(i).getMeat()* LunchWeight[4])+(CleanedData.get(i).getCalories()* LunchWeight[5]);
        }
       
    }
    @Override
    public void SetDinner(ArrayList<meal> CleanedData)
    {
        double[] DinnerWeight = new double[]{5,20,200,20,50,-3.5}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).DinnerScore = (CleanedData.get(i).getGrain()* DinnerWeight[0])+(CleanedData.get(i).getVegetable()* DinnerWeight[1])+(CleanedData.get(i).getFruit()* DinnerWeight[2])+(CleanedData.get(i).getMilk()* DinnerWeight[3])+(CleanedData.get(i).getMeat()* DinnerWeight[4])+(CleanedData.get(i).getCalories()* DinnerWeight [5]);
        }
    }
    
    @Override
    public ArrayList<String>  RecommendBreakFast(ArrayList<meal> CleanedData)
    {
       SetBreakFast(CleanedData);
       
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.BreakFastScore).compareTo(m1.BreakFastScore);
           }
       });
       
       for(int i = 0 ; i < 15 ; i++)
       {
           BreakFastArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return BreakFastArray;
    }
    
    @Override
    public ArrayList<String>  RecommendLunch(ArrayList<meal> CleanedData)
    {
       SetLunch(CleanedData);
       
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.LunchScore).compareTo(m1.LunchScore);
           }
       });
       
       for(int i = 0 ; i < 15 ; i++)
       {
           LunchArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return LunchArray;
    }
    @Override
    public ArrayList<String>  RecommendDinner(ArrayList<meal> CleanedData)
    {
       SetDinner(CleanedData);
       
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.DinnerScore).compareTo(m1.DinnerScore);
           }
       });
       
       for(int i = 0 ; i < 15 ; i++)
       {
           DinnerArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return DinnerArray;
    }
    
    
}
