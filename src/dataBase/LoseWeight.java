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
        double[] BreakFastWeight = new double[]{30,20,60,200,10,-3.5005}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).setBreakFastScore((CleanedData.get(i).getGrain()* BreakFastWeight[0])+(CleanedData.get(i).getVegetable()* BreakFastWeight[1])+(CleanedData.get(i).getFruit()* BreakFastWeight[2])+(CleanedData.get(i).getMilk()* BreakFastWeight[3])+(CleanedData.get(i).getMeat()* BreakFastWeight[4])+(CleanedData.get(i).getCalories()* BreakFastWeight[5]));
        }
    }
    @Override
    public void SetLunch(ArrayList<meal> CleanedData)
    {
        double[] LunchWeight = new double[]{10,200,20,30,60,-3.5}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).setLunchScore((CleanedData.get(i).getGrain()* LunchWeight[0])+(CleanedData.get(i).getVegetable()* LunchWeight[1])+(CleanedData.get(i).getFruit()* LunchWeight[2])+(CleanedData.get(i).getMilk()* LunchWeight[3])+(CleanedData.get(i).getMeat()* LunchWeight[4])+(CleanedData.get(i).getCalories()* LunchWeight[5]));
        }
       
    }
    @Override
    public void SetDinner(ArrayList<meal> CleanedData)
    {
        double[] DinnerWeight = new double[]{10,30,200,60,20,-3.5002}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).setDinnerScore((CleanedData.get(i).getGrain()* DinnerWeight[0])+(CleanedData.get(i).getVegetable()* DinnerWeight[1])+(CleanedData.get(i).getFruit()* DinnerWeight[2])+(CleanedData.get(i).getMilk()* DinnerWeight[3])+(CleanedData.get(i).getMeat()* DinnerWeight[4])+(CleanedData.get(i).getCalories()* DinnerWeight [5]));
        }
    }
    
    @Override
    public ArrayList<String>  RecommendBreakFast()
    {
       SetBreakFast(CleanedData);
       
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.getBreakFastScore()).compareTo(m1.getBreakFastScore());
           }
       });
       
       for(int i = 0 ; i < 16 ; i++)
       {
           BreakFastArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return BreakFastArray;
    }
    
    @Override
    public ArrayList<String>  RecommendLunch()
    {
       SetLunch(CleanedData);
       
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.getLunchScore()).compareTo(m1.getLunchScore());
           }
       });
       
       for(int i = 0 ; i < 16 ; i++)
       {
           LunchArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return LunchArray;
    }
    @Override
    public ArrayList<String>  RecommendDinner()
    {
       SetDinner(CleanedData);
       
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.getDinnerScore()).compareTo(m1.getDinnerScore());
           }
       });
       
       for(int i = 0 ; i < 16 ; i++)
       {
           DinnerArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return DinnerArray;
    }
    public ArrayList<meal> SetMealType(ArrayList<meal> CleanedData)
    {
        SetBreakFast(CleanedData);
        SetLunch(CleanedData);
        SetDinner(CleanedData);
        for(int i = 0 ; i < CleanedData.size() ; i++) 
        {
            if(CleanedData.get(i).getDinnerScore() > CleanedData.get(i).getLunchScore() && CleanedData.get(i).getDinnerScore() > CleanedData.get(i).getBreakFastScore())
            {
                CleanedData.get(i).setMealType("Dinner");
            }
            else if(CleanedData.get(i).getLunchScore() > CleanedData.get(i).getBreakFastScore() && CleanedData.get(i).getLunchScore() > CleanedData.get(i).getDinnerScore())
            {
                CleanedData.get(i).setMealType("Lunch");
            }
            else
            {
              CleanedData.get(i).setMealType("BreakFast");
            }
            
        }
      return CleanedData;  
    }
    
}
