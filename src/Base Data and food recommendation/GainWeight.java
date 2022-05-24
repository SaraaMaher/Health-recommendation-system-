/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mohamed mosaad
 */
public class GainWeight extends FoodRecommendation {
    
    @Override
    public void SetBreakFast(ArrayList<meal> CleanedData)
    {
        //BreakFast Variables weights for gaining weight
        double[] BreakFastWeight = new double[]{100,20,60,20,10,0.5}; 
        // Scoring the food Algorithm
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).BreakFastScore = (CleanedData.get(i).getGrain()* BreakFastWeight[0])+(CleanedData.get(i).getVegetable()* BreakFastWeight[1])+(CleanedData.get(i).getFruit()* BreakFastWeight[2])+(CleanedData.get(i).getMilk()* BreakFastWeight[3])+(CleanedData.get(i).getMeat()* BreakFastWeight[4])+(CleanedData.get(i).getCalories()* BreakFastWeight[5]);
        }
    }
    @Override
    public void SetLunch(ArrayList<meal> CleanedData)
    {
        //Lunch Variables weights for gaining weight
        double[] LunchWeight = new double[]{50,100,60,20,100,0.5}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).LunchScore = (CleanedData.get(i).getGrain()* LunchWeight[0])+(CleanedData.get(i).getVegetable()* LunchWeight[1])+(CleanedData.get(i).getFruit()* LunchWeight[2])+(CleanedData.get(i).getMilk()* LunchWeight[3])+(CleanedData.get(i).getMeat()* LunchWeight[4])+(CleanedData.get(i).getCalories()* LunchWeight[5]);
        }
       
    }
    @Override
    public void SetDinner(ArrayList<meal> CleanedData)
    {
        double[] DinnerWeight = new double[]{20,50,20,100,20,0.5}; 
        
        for (int i = 0 ; i < CleanedData.size() ; i++)
        {
            CleanedData.get(i).LunchScore =  (CleanedData.get(i).getGrain()* DinnerWeight[0])+(CleanedData.get(i).getVegetable()* DinnerWeight[1])+(CleanedData.get(i).getFruit()* DinnerWeight[2])+(CleanedData.get(i).getMilk()* DinnerWeight[3])+(CleanedData.get(i).getMeat()* DinnerWeight[4])+(CleanedData.get(i).getCalories()* DinnerWeight [5]);
        }
    }
    
    @Override
    // takes the ArrayList and return arraylist of strings contains breakfast meals name
    public ArrayList<String>  RecommendBreakFast(ArrayList<meal> CleanedData)
    {
       SetBreakFast(CleanedData);
       //sort the arraylist in descinding order of the breakfast score
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.BreakFastScore).compareTo(m1.BreakFastScore);
           }
       });
       // takes the higher 15 score of breakfast and puts their names in array
       for(int i = 0 ; i < 15 ; i++)
       {
           BreakFastArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return BreakFastArray;
    }
    
    @Override
    // takes the ArrayList and return arraylist of strings contains lunch meals name
    public ArrayList<String>  RecommendLunch(ArrayList<meal> CleanedData)
    {
       SetLunch(CleanedData);
        //sort the arraylist in descinding order of the lunch score
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.LunchScore).compareTo(m1.LunchScore);
           }
       });
       // takes the higher 15 score of lunch and puts their names in array
       for(int i = 0 ; i < 15 ; i++)
       {
           LunchArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return LunchArray;
    }
    @Override
    // takes the ArrayList and return arraylist of strings contains dinner meals name
    public ArrayList<String>  RecommendDinner(ArrayList<meal> CleanedData)
    {
       SetDinner(CleanedData);
       //sort the arraylist in descinding order of the dinner score
       Collections.sort(CleanedData , new Comparator<meal>()
       {
           @Override
           public int compare(meal m1 , meal m2)
           {
               return Double.valueOf(m2.DinnerScore).compareTo(m1.DinnerScore);
           }
       });
        // takes the higher 15 score of dinner and puts their names in array
       for(int i = 0 ; i < 15 ; i++)
       {
           DinnerArray.add(CleanedData.get(i).getPortion_amount() + "\t" + CleanedData.get(i).getPortion_name() + CleanedData.get(i).getName())  ;
       }
       
       return DinnerArray;
    }
    
    
}
