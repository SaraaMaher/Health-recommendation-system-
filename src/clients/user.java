/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;
import dataBase.FoodRecommendation;
import dataBase.GainWeight;
import dataBase.LoseWeight;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author lenovo
 */
public class user extends person implements Serializable {
    
    /** Data Members*/
    private String id, pid, state,username;
    static int userno = 0;
    private int age;
    private double weight, height, bmi,goalM;
    private int goalT;
    private int xp ;
    private ArrayList<String> track=new ArrayList<String>();
    private boolean active = false;
    private chat currentchat;
    private double requiredWater;
    private double actualWater;
    private static final long serialVersionUID = 1L;
    private int weekNo = 0;    
    private FoodRecommendation foodPlan = null;
    
    public user(String firstN,String lastN,String username,String userpass,String mail,int age,double weight,double height,String gender){
      super(firstN,lastN,userpass,mail,gender);
      this.age = age;
      this.weight = weight;
      this.height = height;
      this.username=username;
      userno++;
      id = "U"+userno;
      track.add(String.valueOf(weight));
      requiredWater = weight/30;
      setBmi();
      setGoalT();
      setGoalM();
      setState();
      pid=" ";
    if (goalT == -1 )
        foodPlan =new GainWeight();
    else 
        foodPlan =new LoseWeight();

     }
     
    /** WATER PLAN*/
    public void water_Drink(double amount)    {
        actualWater += amount;
        incXp((int) (amount * 100));
    }
    public double water_Compare(){
        return (actualWater/requiredWater)*100;
    }
    public double water_exercise(){
        incXp(100);
         return requiredWater += 0.35;
         
    }
    public double getRequiredWater(boolean newDay) {
        if (newDay == true)
        {    actualWater = 0;
           return requiredWater = weight/30;
        }else 
            
            return requiredWater;
    }
    public double getActualWater() {
        return actualWater;
    }
    public void setActualWater(double actualWater) {
        this.actualWater = actualWater;
    }  

    /** EATING PLAN*/
    public int getWeekNo() {
        return weekNo;
    }
    public void incWeekNo() {
        weekNo++;
    }
    public FoodRecommendation getFoodPlan() {
        return foodPlan;
    }
    
    /** Chatting*/
    public void getchat(Vector<chat> Allchats){
        if(!Allchats.isEmpty())
         for(int i=0;i<Allchats.size();i++){
            if(Allchats.get(i).id.equals(id))
                currentchat=Allchats.get(i);
         }
        else{
            currentchat=new chat(id,pid);
            Allchats.add(currentchat);
        }
     }
    public chat getCurrentchat() {
        return currentchat;
    }
    
    
    /** Getters and setters*/
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public static int getUserno() {
        return userno;
    }
    public static void setUserno(int userno) {
        user.userno = userno;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setWeight(double weight) {
        this.weight = weight;
       track.add(String.valueOf(weight));
    }    
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getBmi() {
        return bmi;
    }
    public void setBmi() {
       double h=(height*height);
      bmi=(weight/h)*10000;
        
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public double getWeight() {
        return weight;
    }
    public double getGoalM() {
        return goalM;
    }
    public void setGoalM() {
      double temp;
      double h=(height*height);
        setGoalT();
       if(goalT==1)
          temp=bmi-25;
       else temp=25-bmi;
       goalM=(temp/10000)*h;
    }
    public int getGoalT() {
        return goalT;
    }
    public void setGoalT() {
        if(bmi > 25)
            goalT = 1;
        else if(bmi<20)
            goalT = -1;
        else goalT=0;
    }
    public boolean weekupdate(){
        double diff,thisweek,lastweek;
       if(track.size()>1)
       {
           thisweek=Double.valueOf(track.get(track.size()-1));
           lastweek=Double.valueOf(track.get(track.size()-2));
           diff =thisweek-lastweek;
           if(diff>0)
               return false;
           else return true;
       }
       else return true;
        
        
    }
    public int getXp() {
        return xp;
    }
    public void incXp(int x) {
        xp  += x;
    }
    public String getState(){
        return state;
    }
    public void setState(){
        if(bmi <20)
            state = "Underweight";
        else if(bmi<=25)
            state = "Fit";
        else if(bmi < 30)
            state = "Overweight";
        else if(bmi < 35)
            state = "Obese";
        else
            state = "Severely obese";
    } 
    public ArrayList<String> getTrack(){
        return track;
    }
    public void activate(){active = true;}   
   
}



