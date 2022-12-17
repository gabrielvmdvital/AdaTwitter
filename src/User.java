import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
   private String user;
   private String password;

   private String name;
   private String mail;
   private String birth;

   public static int numUsuarios = 0;
   public String[] twitts = new String[1];
   public int nTwite = 0;

   public User(){

   }

   public User(String user, String password, String name, String mail, String birth){
       this.user = user;
       this.password = password;
       this.name = name;
       this.mail = mail;
       this.birth = birth;
       numUsuarios++;
   }

    public String getUser(){
       return this.user;
   }
    public String getPassword(){return this.password;}
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public String getName(){return this.name;}
    public void setName(String newName){
        this.name = newName;
    }
    public String getMail(){return  this.mail;}

    public String getBirth(){return this.birth;}
    public void setBirthDay(String newBirth){
       this.birth = newBirth;
    }

    public void getUserData(){
        System.out.println("Name: " + getName()+".");
        System.out.println("Birthday: " + getBirth()+".");


    }

    public String[] getTwitts(){
       return twitts;
    }

   public String twitar(String msg){
       System.out.println("Tweet feito com sucesso!");
       DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
       msg = "["+dateTimeF.format(LocalDateTime.now())+"] - " + "@" +this.user + " say: " + msg;
       expandTwittsArray();
       twitts[nTwite] = msg;
       nTwite++;
       return msg;
    }
   public void expandTwittsArray(){
       String[] auxTwittsArray = new String[twitts.length+1];
       for(int nTwitsAux = 0; nTwitsAux < nTwite; nTwitsAux++) {
           if (twitts[nTwitsAux] != null) {
               auxTwittsArray[nTwitsAux] = twitts[nTwitsAux];
           }
       }
       twitts = auxTwittsArray;

   }
   public void timeline(){
       if (nTwite != 0) {
           for (int twitt = nTwite; twitt >= 0; twitt--) {
               if (twitts[twitt] != null) {
                   System.out.println(twitts[twitt]);
               }
           }
       }
       else {
               System.out.println(this.user + " não possui tweetts em sua linha do tempo!");
       }


   }

   public String deletarTwitter(int nTwite){
       String stringIsDeleted=null;
       if (nTwite - 1 >=0 && nTwite -1 <= twitts.length) {
           if (twitts[nTwite - 1] != null) {
               stringIsDeleted = twitts[nTwite - 1];
               twitts[nTwite - 1] = null;
               System.out.println("Tweet excluido com sucesso!");
           }
           for(int numTwite = 0; numTwite < twitts.length-1; numTwite++){
                   if (twitts[numTwite + 1] != null && twitts[numTwite] == null) {
                       twitts[numTwite] = twitts[numTwite + 1];
                       twitts[numTwite + 1] = null;
                       break;
                   }
               }

           }

           if(nTwite > 0) {
               nTwite--;
           }


       else{
            System.out.println("Falha! Tweet não existe!");
       }
       return stringIsDeleted;
   }



}
