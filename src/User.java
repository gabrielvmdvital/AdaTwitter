import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
   private String user;
   private String password;

   private String name;
   private String mail;
   private String birth;

   public static int numUsuarios = 0;
   public String[] twitts = new String[1000];
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
    public String getName(){return this.name;}
    public String getMail(){return  this.mail;}
    public String getBirth(){return this.birth;}

   public void twitar(String msg){
       System.out.println("Tweet feito com sucesso!");
       DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
       twitts[nTwite] = dateTimeF.format(LocalDateTime.now()) +" "+ msg + " - " + this.user;
       nTwite++;
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

   public void deletarTwitter(int nTwite){
       String[] auxTweets = new String [twitts.length];
       if (nTwite - 1 >=0) {
           if (twitts[nTwite - 1] != null) {
               twitts[nTwite - 1] = null;
               System.out.println("Tweet excluido com sucesso!");
           }
           int notNull = 0;
           for(int numTwite = 0; numTwite < twitts.length; numTwite++){
               if(twitts[numTwite+1] != null){
                   if(notNull <= nTwite-1){
                       auxTweets[notNull] = twitts[numTwite];
                   }
               }
               notNull++;

           }
           twitts = auxTweets;
           if(nTwite > 0) {
               nTwite--;
           }
       }
       else{
            System.out.println("Falha! Tweet não existe!");
       }
   }


}
