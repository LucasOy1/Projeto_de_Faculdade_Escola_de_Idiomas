package CodigoProjeto;

public class Admin extends Usuario {
    
    public Admin(String nome, String email, String senha, String matricula){
        super(nome, email, senha, matricula);

    }

    public void verInformacoes(Usuario usuarioLogado){
        super.verInformacoes(usuarioLogado);
        System.out.println("Cargo: Administrador");
    }

    

}
