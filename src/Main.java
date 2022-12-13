public class Main {
    public static void main(String[] args) {
        Usuario[] usuarios = new Usuario[100];
        Usuario u1 = new Usuario("Gabriel", "123456");
        Usuario u2 = new Usuario("Rodolfo", "123456");

        u1.twitar("Meu nome não é Jhonny");
        u1.twitar("Meu nome não é rodolfo");
        u1.timeline();
        System.out.println(Usuario.numUsuarios);
        u1.deletarTwitter(2);
        u1.timeline();
        usuarios[0] = u1;
        usuarios[1] = u2;

        for(int nUser=0; nUser < Usuario.numUsuarios; nUser++){
            usuarios[nUser].timeline();
        }

    }
}