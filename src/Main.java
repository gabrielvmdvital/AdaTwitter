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
            System.out.println("---------- Bem-Vindo ao AdaTwitter! ----------");
            System.out.println("1 - Para cadastrar usuario!");
            System.out.println("2 - Para logar no sistema!");
            System.out.println("3 - Para ver a linha do tempo!");
            System.out.println("4 - para sair do programa!");
            System.out.println("O que deseja fazer? ");
            System.out.println("-----------------------------------------------");
            opcaoMenu = Integer.parseInt(sc.nextLine());
            if (opcaoMenu == 1) {
                String login;
                String mail;
                String password;
                String userName;
                String dataNasc;
                System.out.println("Informe o nome de usuario que deseja cadastrar: ");
                login = sc.nextLine();
                System.out.println("Informe a senha de usuario: ");
                password = sc.nextLine();
                System.out.println("Informe seu nome: ");
                userName = sc.nextLine();
                System.out.println("Informe o seu email: ");
                mail = sc.nextLine();
                System.out.println("Informe sua data de nascimeto: ");
                dataNasc = sc.nextLine();

                twInfra.cadastrarUsuario(login, password, userName, mail, dataNasc);
            }
            else if (opcaoMenu == 2) {
                String user;
                String password;
                System.out.println("Digite o login: ");
                user = sc.nextLine();
                System.out.println("Digite a senha: ");
                password = sc.nextLine();
                twInfra.loginSystem(user, password);
                if (twInfra.userLogado != null) {
                    int opcoesLogado;
                    loopUserLogged:
                    while(true) {
                        System.out.print("1 - Tweetar: \n");
                        System.out.print("2 - Ver a sua timeline: \n");
                        System.out.print("3 - Deletar um tweeter: \n");
                        System.out.print("4 - Ver  todos seus tweets: \n");
                        System.out.print("5 - Para deslogar: \n");
                        opcoesLogado = Integer.parseInt(sc.nextLine());
                        loopUserTweetar:
                        while (true) {

                             if (opcoesLogado == 1) {
                                String msg;
                                System.out.print("No que você está pensando? ou S para sair! ");
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
                                System.out.print("Informe qual twite deseja excluir (exemplo 1, 2, ...): ");
                                nTweete = Integer.parseInt(sc.nextLine());
                                twDeleted = twInfra.userLogado.deletarTwitter(nTweete);
                                if (twDeleted != null){
                                     twInfra.deletaTwiteOfTimeLine(twDeleted);
                                 }
                                else {
                                    System.out.println("Tweete não existe!");
                                }
                                System.out.println();
                                break loopUserTweetar;
                            } else if (opcoesLogado == 4) {
                                 twInfra.userLogado.timeline();
                                 System.out.println();
                                 break loopUserTweetar;

                             } else if (opcoesLogado == 5) {
                                 System.out.println();
                                break loopUserLogged;
                            }

                        }
                    }
                }
            } else if (opcaoMenu == 3) {
                twInfra.viewFullTimeLine();
                System.out.println();

            } else if (opcaoMenu == 4) {
                break loopMenu;
            }
        }
    }

}