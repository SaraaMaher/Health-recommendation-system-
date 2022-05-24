package dataBase;
/** Class Meal: represent an Observation from dataset 
 * @since 25/3/2020
 * @author Sahar
 */
public class meal {
    private String name;
    private double portion_amount;
    private String portion_name;
    private double grain, vegetable, fruit, milk, meat, alcohol, calories;
    public double BreakFastScore , LunchScore , DinnerScore ;

    public meal(String name,double portion_amount, String portion_name, double grain,double vegetable,double fruit,double milk,double meat,double alcohol,double calories,double BreakFastScore,double LunchScore,double DinnerScore) 
    {
        this.name = name;
        this.portion_amount = portion_amount;
        this.portion_name = portion_name;
        this.grain=grain ;
        this.vegetable =vegetable;
        this.fruit=fruit;
        this.milk=milk;
        this.meat=meat;
        this.alcohol=alcohol;
        this.calories=calories;
        this.BreakFastScore=(int) BreakFastScore;
        this.LunchScore=(int) LunchScore;
        this.DinnerScore=(int) DinnerScore;
    }
     public meal(String[] metadata) 
    {
        name = metadata[1];
        portion_amount  =  Double.parseDouble(metadata[2]);
        portion_name = metadata[3]; 
        grain =  Double.parseDouble(metadata[4]);
        vegetable =  Double.parseDouble(metadata[5]);
        fruit =  Double.parseDouble(metadata[6]);
        milk =  Double.parseDouble(metadata[7]);
        meat =  Double.parseDouble(metadata[8]);
        alcohol =  Double.parseDouble(metadata[9]);
        calories =  Double.parseDouble(metadata[10].substring(0,metadata[10].length() -1));
           
    }
    
    

    public String getName() {
        return name;
    }

    public double getPortion_amount() {
        return portion_amount;
    }

    public String getPortion_name() {
        return portion_name;
    }

    public double getGrain() {
        return grain;
    }

    public double getVegetable() {
        return vegetable;
    }

    public double getFruit() {
        return fruit;
    }

    public double getMilk() {
        return milk;
    }

    public double getMeat() {
        return meat;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public double getCalories() {
        return calories;
    }

   


}
