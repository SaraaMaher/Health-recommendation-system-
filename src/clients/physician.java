/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;
import java.util.*;

/**
 *
 * @author lenovo
 */
public class physician extends person {
    private int age;
    String uname;
    private double salary;
    final static double baseSalary = 3000;
    private Vector<user> patients;
    private int numpatients;
    static int physno = 0;
    private String id;
    chat currentchat;
    
    
    public physician(String firstN, String lastN,String uname, String userpass, String mail,int age,String gender){
      super(firstN,lastN,userpass,mail,gender);
      physno ++;
      id = new String("P"+physno);
      salary = baseSalary;
      this.uname=uname;
      this.age = age;
      patients=new Vector<user>();
    } 

    public String getUname() {
        return uname;
    }
    public int getNumpatients() {
        return numpatients;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
       
    }

    public void raise(double raise){
        salary += raise;
    }
    public  Vector<user> getPatients() {
        return patients;
    }

    public void setPatients(Vector<user> patients) {
        this.patients = patients;
    }

    public static int getPhysno() {
        return physno;
    }

    public String getId() {
        return id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Object getUser(int index){
        return patients.elementAt(index);
    }
    public Vector<user> search(String n){
    Vector<user>target = new Vector();
    for(int i=0;i<patients.size();i++){
        if(patients.elementAt(i).getFirstN().contains(n)||patients.elementAt(i).getLastN().contains(n))
            target.add(patients.elementAt(i));
    }
    return(target);
    }
    public void getchat(Vector<chat> Allchats,String userid)
     {
         for(int i=0;i<Allchats.size();i++)
         {
            if(Allchats.get(i).pid.equals(id)&&Allchats.get(i).id.equals(userid))
                currentchat=Allchats.get(i);
         }
     }
}
