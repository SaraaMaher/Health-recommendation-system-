package clients;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;




public class admin extends person {
    private String id;
    private static Vector<user> users=new Vector<user>();
    private static Vector<physician> phys= new Vector<physician>();
    private static int adminno = 0;
    private static Vector<chat> u_phchats;
            
  public  admin(String firstN, String lastN, String userpass, String mail,String gender){
      super(firstN,lastN,userpass,mail,gender);
      adminno++;
      id = new String("A"+adminno);
    }
    public static Vector<chat> getU_phchats() {
        return u_phchats;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public static Vector getUsers() {
        return users;
    }
    public static void setUsers(Vector users) {
        admin.users = users;
    }
    public static Vector getPhys() {
        return phys;
    }
    public static void setPhys(Vector phys) {
        admin.phys = phys;
    }
    public static int getAdminno() {
        return adminno;
    }
    public static void setAdminno(int adminno) {
        admin.adminno = adminno;
    }
    public boolean addUser(user X){
       users.add(X);
       int min = phys.elementAt(0).getPatients().size();
       int minindex = 0;
       for(int i =0;i<phys.size();i++){
          if(phys.elementAt(i).getPatients().size() < min){
            min = phys.elementAt(i).getPatients().size();
            minindex=i;
          }
       }
       phys.elementAt(minindex).getPatients().add(X);
       X.setPid(phys.elementAt(minindex).getId());
       String ID = X.getId();
       return(isfound(ID,"user"));
    }
    public boolean addPhysician(physician X){
        phys.add(X);
        String ID = X.getId();
        return(isfound(ID,"physician"));
        
    }
    public void removeUser(String id){
        int uremoval = -1;
        int premoval = -1;
        int puremoval = -1;
        for(int i = 0;i<users.size();i++){
        if(users.elementAt(i).getId() == id)
            uremoval = i;
        }
        if(uremoval == -1)
            return;
         users.removeElementAt(uremoval);
        for(int i = 0;i<phys.size();i++){
          Vector<user> X = phys.elementAt(i).getPatients();
          for(int j = 0; j<X.size();j++){
              if(X.elementAt(j).getId()==id){
              premoval = i;    
              puremoval = j;
              }
                  
          }
        }
        if(premoval == -1 || puremoval == -1)
            return;
        phys.elementAt(premoval).getPatients().removeElementAt(puremoval);
       
      
    }
    public void removePhysician(String id){
       int removal = -1;
    for(int i=0;i<phys.size();i++){
        if(phys.elementAt(i).getId()==id)
            removal = i;
    }
    if(removal == -1)
        return;
    for(int i=0;i<phys.elementAt(removal).getPatients().size();i++){
       int min = phys.elementAt(0).getPatients().size();
       int minindex = 0;
       for(int j =0;j<phys.size();j++){
          if(phys.elementAt(j).getPatients().size() < min){
            min = phys.elementAt(j).getPatients().size();
            minindex=j;
          }
       }
       phys.elementAt(minindex).getPatients().addElement(phys.elementAt(removal).getPatients().elementAt(i));
       int x = phys.elementAt(minindex).getPatients().size();
       user added = (user)phys.elementAt(minindex).getPatients().elementAt(x-1);
       added.setPid(phys.elementAt(minindex).getId());
    }
    phys.removeElementAt(removal);
    
    }
    public void activate(String userid){
        for(int i=0;i<users.size();i++){
        if(users.elementAt(i).getId().equals(userid))
            users.elementAt(i).activate();
        }
    }
    public Vector<user> searchUsers(String n){
    Vector<user>target = new Vector();
    for(int i=0;i<users.size();i++){
        if(users.elementAt(i).getFirstN().contains(n)||users.elementAt(i).getLastN().contains(n))
            target.add(users.elementAt(i));
    }
    return(target);
    }
    public Vector<physician> searchPhys(String n){
     Vector<physician>target = new Vector();
    for(int i=0;i<phys.size();i++){
        if(phys.elementAt(i).getFirstN().contains(n)||phys.elementAt(i).getLastN().contains(n))
            target.add(phys.elementAt(i));
    }
    return(target);
    
    }
     public static boolean isfound(String id,String orin){
        if(orin.equals("user"))
        {
            for(int i=0;i<users.size();i++)
                if(users.elementAt(i).getId().equals(id))
                    return(true);
        }
        else
        {
            for(int j=0;j<phys.size();j++)
                if(phys.elementAt(j).getId().equals(id))
                    return(true);
        }  
        return(false);
    }
    public static boolean isreserved(String Case,String uname){
        for(int i =0;i<users.size();i++)
            if(users.elementAt(i).getUserpass().contains(Case)&&users.elementAt(i).getUsername().contains(uname))
                return(true);
        for(int i=0;i<phys.size();i++)
            if(phys.elementAt(i).getUserpass().contains(Case)&&phys.elementAt(i).getUname().contains(uname))
                return(true);
        return(false);
    }
    public static boolean isfoundN(String n){
         for(int i=0;i<users.size();i++)
        if(users.elementAt(i).getUserpass().contains(n))
            return true;
    
         for(int i=0;i<phys.size();i++)
             if(phys.elementAt(i).getUserpass().contains(n))
                 return true;
         
         
        return false;
    }
     public static Object getUserbyusername(String username){
        for(int i =0; i<users.size();i++){
            if(users.elementAt(i).getUsername().contains(username))
                return users.elementAt(i);
        }   
        return "Username doesn't exist !";
    }
   public static Object getbyPassword(String password, String orin){
        if(orin.equals("user")){
            for(int i=0;i<users.size();i++)
                if(users.elementAt(i).getUserpass().contains(password))
                    return users.elementAt(i);
        
        }else{
            for(int i=0;i<phys.size();i++)
                if(phys.elementAt(i).getUserpass().contains(password))
                    return phys.elementAt(i);
            
        }
        return "Password doesn't exist";
    
    }
   
    public  void sendMail(String Title, String Msg,  boolean toUsers)
    {
        final String username = "betterfitter.program@gmail.com";
        final String password = "fcisoopbio1";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            if (toUsers == true)
                for (int i = 0;i < users.size(); i++)
                {
                    message.setRecipients(
                            Message.RecipientType.TO,
                            InternetAddress.parse(users.get(i).getMail())
                    );
                }
            else 
                for (int i = 0;i < phys.size(); i++)
                {
                    message.setRecipients(
                            Message.RecipientType.TO,
                            InternetAddress.parse(phys.get(i).getMail())
                    );
                }
            
            message.setSubject(Title);
            
            message.setText(Msg);
            
            //message.setContent(htmlCode, "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
 
    }
}
