public class Twitter {

    private static  Usuario[] usuarios = new Usuario[100];
    private static int nUser = 0;

    public static void cadastrarUsuario(String login, String senha){
        Usuario user = new Usuario(login, senha);
         nUser++;
    }

    public void addUser(Usuario user){

    }

}
