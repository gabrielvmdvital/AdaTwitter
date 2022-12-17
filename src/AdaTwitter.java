import java.sql.Array;

public class AdaTwitter {

    public static  User[] users = new User[2];
    public static int nUser = 0;

    public static String[] timeLineArray = new String[2];
    public static int nTweeteInTimeLine = 0;

    public User userLogado = null;

    public static int idUser = 0;

    public static User[] expandirArrayUser(){
        if(nUser == users.length - 1) {
            User[] auxArray = new User[users.length + 1];
            for(int nLength = 1; nLength <= nUser+1; nLength++){
                if(users[nLength-1] != null){
                    auxArray[nLength-1] = users[nLength-1];
                }
            }
            return auxArray;
        }
        return users;
    }

    public static String[] expandirTimeLineArray(){
            String[] auxArray = new String[timeLineArray.length + 1];
            for(int nLength = 0; nLength < nTweeteInTimeLine; nLength++){
                if(timeLineArray[nLength] != null){
                    auxArray[nLength] = timeLineArray[nLength];
                }
            }
            return auxArray;
    }

    public void saveNewTweete(String tweete){
        timeLineArray = expandirTimeLineArray();
        for(int position = 0; position < nTweeteInTimeLine+1; position++) {
            if (timeLineArray[position] == null) {
                timeLineArray[nTweeteInTimeLine] = tweete;
                break;
            }
        }
        nTweeteInTimeLine++;
    }

    public void viewFullTimeLine(){
        for(int twRecente = timeLineArray.length -1; twRecente >= 0; twRecente--) {
            if (timeLineArray[twRecente] != null) {
                System.out.println(timeLineArray[twRecente]);
            }
        }
    }

    public static void deletaTwiteOfTimeLine(String msgToDelete) {
        for (int numTwite = 0; numTwite < timeLineArray.length; numTwite++) {

            if (timeLineArray[numTwite] != null && timeLineArray[numTwite].equals(msgToDelete)) {
                timeLineArray[numTwite] = null;
            }
        }

        for (int numTwite = 0; numTwite < timeLineArray.length -1; numTwite++) {

            if (timeLineArray[numTwite + 1] != null && timeLineArray[numTwite] == null) {
                timeLineArray[numTwite] = timeLineArray[numTwite + 1];
                timeLineArray[numTwite + 1] = null;
            }
        }
    }
    public static void cadastrarUsuario(String login, String password, String name, String mail, String birth) {
        boolean userExist = false;
        for (User user : users) {
            if (user != null) {
                if (login.equals(user.getUser()) || mail.equals(user.getMail())) {
                    System.out.println("E-mail ou nome de usuário já existe!");
                    userExist = true;
                }
                else {
                    userExist = false;
                }
            }
        }
        if (!userExist) {
            User newUser = new User(login, password, name, mail, birth);

            if (users[nUser] == null) {
                users[nUser] = newUser;
                users = expandirArrayUser();
                nUser++;
            }
        }
    }

    public void loginSystem(String login, String password){
        boolean loginValidator = false;

        for(int numUser = 0; numUser < nUser; numUser++) {
            if (login.equals(users[numUser].getUser()) &&
                    password.equals(users[numUser].getPassword())) {
                loginValidator = true;
                idUser = numUser;
                break;
            }
        }

        if(loginValidator) {
            userLogado =  users[idUser];
            System.out.println("Bem-vindo ao AdaTweeter "+ userLogado.getUser() +"!");
            System.out.println();
        }
        else{
                System.out.println("Login ou Senha são invalidos, ou usuário não foi cadastrado!");
                userLogado = null;
            System.out.println();
        }

    }

    public void viewUserData(){
        if (userLogado !=null){
            userLogado.getUserData();
        }
    }

    public void userNameUpdate(String newUserName) {
        if (userLogado != null) {
            userLogado.setName(newUserName);
            System.out.println("Changed name!");
        }
        else{
            System.out.println("user is not logged in!");
        }
    }

    public void passwordUpdate(String newPassword){
        if(userLogado!=null) {
            userLogado.setPassword(newPassword);
            System.out.println("changed password!");
        }
        else{
            System.out.println("user is not logged in!");
        }
    }

    public void birthDayUpdate(String newBirthDay) {
        if(userLogado!=null){
            userLogado.setBirthDay(newBirthDay);
            System.out.println("Changed birthday!");
        }

        else{
            System.out.println("user is not logged in!");
        }
    }


}
