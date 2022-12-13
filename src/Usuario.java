import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {
   private String usuario;
   private String senha;

   public static int numUsuarios = 0;
   public String[] twitts = new String[100];
   public int nTwite = 0;

   public Usuario(){
   }

   public Usuario(String usuario, String senha){
       this.usuario = usuario;
       this.senha = senha;
       numUsuarios++;
   }

   public String getUsuario(){
       return this.usuario;
   }

   public void twitar(String msg){
       System.out.println("Tweet feito com sucesso!");
       DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
       twitts[nTwite] = dateTimeF.format(LocalDateTime.now()) +" "+ msg + " - " + this.usuario;
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
               System.out.println(this.usuario +" não possui tweetts em sua linha do tempo!");
       }


   }

   public void deletarTwitter(int nTwite){
       if (nTwite - 1 >=0) {
           if (twitts[nTwite - 1] != null) {
               twitts[nTwite - 1] = null;
               System.out.println("Tweet excluido com sucesso!");
           }
       }
       else{
            System.out.println("Falha! Tweet não existe!");
       }
   }


}
