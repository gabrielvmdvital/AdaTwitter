import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdaTwitter twInfra = new AdaTwitter();

        printMenu(sc, twInfra);

    }

    private static void printMenu(Scanner sc, AdaTwitter twInfra){

        int opcao;
        loopMenu:
        while (true) {
            System.out.println("1 - Para cadastrar usuario!");
            System.out.println("2 - Para logar no sistema!");
            System.out.println("3 - Para sair do programa!");
            opcao = Integer.parseInt(sc.nextLine());
            if (opcao == 1) {
                String user;
                String password;
                System.out.println("Informe o usuario que deseja cadastrar: ");
                user = sc.nextLine();
                System.out.println("Informe a senha de usuario: ");
                password = sc.nextLine();
                twInfra.cadastrarUsuario(user, password);
            }
            else if (opcao == 2) {
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
                        System.out.print("4 - Para deslogar: \n");
                        opcoesLogado = Integer.parseInt(sc.nextLine());
                        loopUserTweetar:
                        while (true) {

                             if (opcoesLogado == 1) {
                                String msg;
                                System.out.print("No que você está pensando? ou S para sair! ");
                                msg = sc.nextLine();
                                if ("sair".equals(msg.toLowerCase()) || "s".equals(msg.toLowerCase())) {
                                    break loopUserTweetar;
                                } else {
                                    twInfra.userLogado.twitar(msg);
                                }

                            } else if (opcoesLogado == 2) {
                                twInfra.userLogado.timeline();
                                break loopUserTweetar;

                            } else if (opcoesLogado == 3) {
                                int nTweete;
                                System.out.print("Informe qual twite deseja excluir (exemplo 1, 2, ...): ");
                                nTweete = Integer.parseInt(sc.nextLine());
                                twInfra.userLogado.deletarTwitter(nTweete);
                            }

                            else if (opcoesLogado == 4) {
                                break loopUserLogged;
                            }

                        }
                    }
                }
            }
            else if (opcao == 3) {
                break loopMenu;
            }
        }
    }

}