public class AdaTwitter {

    public static  Usuario[] users = new Usuario[2];
    public static int nUser = 0;

    public Usuario userLogado = null;

    public static Usuario[] expandirArrayUser(){
        if(nUser == users.length - 1) {
            Usuario[] auxArray = new Usuario[users.length + 1];
            for(int nLength = 1; nLength <= nUser+1; nLength++){
                if(users[nLength-1] != null){
                    auxArray[nLength-1] = users[nLength-1];
                }
            }
            return auxArray;
        }
        return users;
    }
    public static void cadastrarUsuario(String login, String password){
        Usuario newUser = new Usuario(login, password);
        if (users[nUser] == null) {
            users[nUser] = newUser;
            users = expandirArrayUser();
            nUser++;
        }
    }

    public void loginSystem(String login, String password){
        boolean loginValidator = false;
        boolean passwordInvalid = false;
        boolean loginInvalid = false;
        int idUser = 0;

        for(int numUser = 0; numUser < nUser; numUser++){
            if(!login.equals(users[numUser].getUsuario()) &&
                    !password.equals(users[numUser].getPassword())){
                loginValidator = false;
                passwordInvalid = true;
                loginInvalid = true;
                userLogado = null;
            }
            else if(login.equals(users[numUser].getUsuario()) &&
                    password.equals(users[numUser].getPassword())){
                loginValidator = true;
                idUser = numUser;
            }

            else {
                if (password.equals(users[numUser].getPassword()) &&
                        !login.equals(users[numUser].getUsuario())) {
                    loginValidator = false;
                    loginInvalid = true;
                    passwordInvalid = false;


                } else if (!password.equals(users[numUser].getPassword()) &&
                        login.equals(users[numUser].getUsuario())) {
                    loginValidator = false;
                    loginInvalid = false;
                    passwordInvalid = true;

                }
            }

            if(loginValidator) {
                userLogado =  users[idUser];
                System.out.println("Bem-vindo ao AdaTweeter"+ userLogado.getUsuario() +"!");
            }
            else{
                if(passwordInvalid && loginInvalid) {
                    System.out.println("Usuario não existe!");
                    System.out.println("Deseja cadastrar um usuário? ");
                    userLogado = null;
                } else if (passwordInvalid) {
                    System.out.println("Senha Invalida!");
                    userLogado = null;
                } else if (loginInvalid) {
                    System.out.println("Login Invalido!");
                    userLogado = null;
                }
            }
        }


    }

}
