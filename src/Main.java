import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdaTwitter twInfra = new AdaTwitter();

        printMenu(sc, twInfra);

    }

    private static void printMenu(Scanner sc, AdaTwitter twInfra){

        int opcaoMenu;
        loopMenu:
        while (true) {
            System.out.println("*----------------------------------------------*");
            System.out.print("|               AdaTwitter Menu                |\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("| 0 - Exit:                                    |\n");
            System.out.print("| 1 - Register account:                        | \n");
            System.out.print("| 2 - Login:                                   | \n");
            System.out.print("| 3 - View a full timeline:                    |\n");
            System.out.println("*---------------------------------------------*");
            opcaoMenu = Integer.parseInt(sc.nextLine());
            if (opcaoMenu == 1) {
                String login;
                String mail;
                String password;
                String userName;
                String dataNasc;
                System.out.println("Enter the desired username: ");
                login = sc.nextLine();
                System.out.println("Enter the desired password: ");
                password = sc.nextLine();
                System.out.println("Enter your name: ");
                userName = sc.nextLine();
                System.out.println("Enter your email: ");
                mail = sc.nextLine();
                System.out.println("inform a new birthday (dd/MM/yyyy): ");
                dataNasc = sc.nextLine();

                twInfra.cadastrarUsuario(login, password, userName, mail, dataNasc);
            }
            else if (opcaoMenu == 2) {
                String user;
                String password;
                System.out.println("Enter User name: ");
                user = sc.nextLine();
                System.out.println("Enter passowrd: ");
                password = sc.nextLine();
                twInfra.loginSystem(user, password);
                System.out.println();
                if (twInfra.userLogado != null) {
                    int opcoesLogado;
                    loopUserLogged:
                    while(true) {
                        System.out.println("*----------------------------------------------*");
                        System.out.print("|                 User Options                 |\n");
                        System.out.print("|----------------------------------------------|\n");
                        System.out.print("| 0 - Logout:                                  |\n");
                        System.out.print("| 1 - Tweetar:                                 |\n");
                        System.out.print("| 2 - View a timeline:                         |\n");
                        System.out.print("| 3 - Delete a specific twite:                 |\n");
                        System.out.print("| 4 - View yours tweets:                       |\n");
                        System.out.print("| 5 - User data:                               |\n");
                        System.out.print("| 6 - Change user data:                        |\n");
                        System.out.println("*----------------------------------------------*");

                        opcoesLogado = Integer.parseInt(sc.nextLine());
                        loopUserTweetar:
                        while (true) {

                            if (opcoesLogado == 1) {
                                String msg;
                                System.out.print("What is on your mind? Press S to return to previous menu: ");
                                msg = sc.nextLine();
                                if ("sair".equals(msg.toLowerCase()) || "s".equals(msg.toLowerCase())) {
                                    System.out.println();
                                    break loopUserTweetar;
                                } else {
                                    twInfra.saveNewTweete(twInfra.userLogado.twitar(msg));
                                }

                            } else if (opcoesLogado == 2) {
                                twInfra.viewFullTimeLine();
                                System.out.println();
                                break loopUserTweetar;

                            } else if (opcoesLogado == 3) {
                                int nTweete;
                                String twDeleted;
                                System.out.print("let me know which tweete you want to delete (exemple 1, 2, ...): ");

                                nTweete = Integer.parseInt(sc.nextLine());
                                twDeleted = twInfra.userLogado.deletarTwitter(nTweete);
                                if (twDeleted != null) {
                                    System.out.println();
                                    twInfra.deletaTwiteOfTimeLine(twDeleted);
                                } else {
                                    System.out.println("Tweet does not exist!");
                                    System.out.println();
                                }
                                System.out.println();
                                break loopUserTweetar;
                            } else if (opcoesLogado == 4) {
                                twInfra.userLogado.timeline();
                                System.out.println();
                                break loopUserTweetar;

                            } else if (opcoesLogado == 5) {
                                twInfra.viewUserData();
                                break loopUserTweetar;

                            } else if (opcoesLogado == 6) {
                                int changeOption;
                                System.out.println("*----------------------------------------------*");
                                System.out.print("|               Account settings               |\n");
                                System.out.print("|----------------------------------------------|\n");
                                System.out.println("0 - Cancel action:                             |");
                                System.out.println("1 - Change your name:                          |");
                                System.out.println("2 - Change your password:                      |");
                                System.out.println("3 - Change your birthday:                      |");
                                System.out.println("4 - Change all listed user data:               |");
                                System.out.println("*---------------------------------------------*");

                                changeOption = Integer.parseInt(sc.nextLine());
                                if (changeOption == 1) {
                                    System.out.print("inform a new name: ");
                                    twInfra.userNameUpdate(sc.nextLine());
                                    System.out.println();

                                }
                                else if (changeOption == 2) {
                                    System.out.print("inform a new password: ");
                                    twInfra.passwordUpdate(sc.nextLine());
                                    System.out.println();

                                    //logout if password option is selected
                                    System.out.print("Want to logout? (S/N): ");
                                    if("S".equals(sc.nextLine().toUpperCase())){
                                        System.out.println();
                                        System.out.println(twInfra.userLogado.getUser() + " Logout...");
                                        twInfra.userLogado = null;
                                        break loopUserLogged;
                                    }

                                }
                                else if (changeOption == 3) {
                                    System.out.print("inform a new birthday (dd/MM/yyyy): ");
                                    twInfra.birthDayUpdate(sc.nextLine());
                                    System.out.println();

                                } else if (changeOption == 4) {
                                    System.out.print("inform a new name: ");
                                    twInfra.userNameUpdate(sc.nextLine());
                                    System.out.println();
                                    System.out.print("inform a new password: ");
                                    twInfra.passwordUpdate(sc.nextLine());
                                    System.out.println();
                                    System.out.print("inform a new birthday (dd/MM/yyyy): ");
                                    twInfra.birthDayUpdate(sc.nextLine());
                                    System.out.println();
                                    System.out.print("Want to relog? (S/N): ");
                                    if("S".equals(sc.nextLine().toUpperCase())){
                                        System.out.println();
                                        System.out.println(twInfra.userLogado.getUser() + " Logout...");
                                        twInfra.userLogado = null;
                                        break loopUserLogged;
                                    }

                                } else if (changeOption == 0) {
                                    System.out.println("Action canceled");
                                    break loopUserTweetar;

                                }

                                System.out.println();
                                break loopUserTweetar;



                            } else if (opcoesLogado == 0) {
                                System.out.println();
                                System.out.println(twInfra.userLogado.getUser() + " Logout...");
                                twInfra.userLogado = null;
                                break loopUserLogged;
                            }


                        }

                    }
                }
            } else if (opcaoMenu == 3) {
                twInfra.viewFullTimeLine();
                System.out.println();

            } else if (opcaoMenu == 0) {
                System.out.println("Exiting of program...");
                System.out.println();
                break loopMenu;
            }
        }
    }

}