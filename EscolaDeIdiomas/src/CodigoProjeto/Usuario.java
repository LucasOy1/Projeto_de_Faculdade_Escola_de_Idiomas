package CodigoProjeto;

public class Usuario {
    
    public String nome;
    private String senha;
    private String email;
    private String matricula;


    public Usuario(String nome, String email, String senha, String matricula){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
    }

    public void verInformacoes(Usuario usuarioLogado) {
        System.out.println("\nNome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);

        if (!(usuarioLogado instanceof Professor)) { //forma para o professor não conseguir ver os dados pessoais do aluno
            System.out.println("Email: " + this.email);
            System.out.println("Senha: " + this.senha);
        }
    }

    public void verAulas(Curso curso) { //Método para ver as aulas agendadas
        if(curso.getAulas().isEmpty()) {
            System.out.println("\nNenhuma aula agendada para o curso " + curso.getIdioma());
        } else {
            System.out.println("\nAulas agendas para o curso " + curso.getIdioma() + ":");
            for(Aula aula : curso.getAulas()) {
                System.out.println(aula);
            }
        }
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return nome;
    }
}
