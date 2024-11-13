package CodigoProjeto;

import java.util.ArrayList;
import java.util.List;

public class SistemaRegistro {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private Usuario usuarioLogado;

    // Método para registrar novos usuários
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario autenticarUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario; 
            }
        }
        return null; 
    }

    //Método para listar todos os usuários
    public void listarUsuario(){
        if(usuarios.isEmpty()){
            System.out.println("\nNenhum usuário registrado.");
        } else {
            System.out.println("\n---- Lista de usuários registrados ----");
            for (Usuario usuario : usuarios) {
                usuario.verInformacoes(usuarioLogado);
            }
        }
    }

    //Método para listar os alunos registrados na disciplina de determinado professor.
    public void listarAlunosPorDisciplina() {
        boolean encontrouAlunos = false;

        if (usuarioLogado instanceof Professor) {
            Professor professor = (Professor) usuarioLogado;
            String disciplinaProfessor = professor.getDisciplina();

            if(usuarios.isEmpty()) {
                System.out.println("\nNenhum aluno registrado.");
            } else {
                System.out.println("\n---- Lista de Alunos da Disicplina de: "+disciplinaProfessor+ " ----");
                for (Usuario usuario : usuarios) {
                    if (usuario instanceof Aluno) {
                        Aluno aluno = (Aluno) usuario;
                        // Verifica se o curso do aluno corresponde à disciplina do professor
                        if (aluno.getCurso().equalsIgnoreCase(disciplinaProfessor)) {
                            aluno.verInformacoes(usuarioLogado);  // Chama verInformacoes() para o aluno
                            encontrouAlunos = true;
                        }
                    }
                }
                if (!encontrouAlunos) {
                    System.out.println("\nNenhum aluno foi registrado nesta disciplina.");
                }
            }
        } 
    }
    
    //Método para criar um novo curso.
    public void criarCurso(Curso curso) {
            cursos.add(curso);
    }

    public Curso getCurso(String nomeCurso) {
        for(Curso curso : cursos) {
            if(curso.getIdioma().equalsIgnoreCase(nomeCurso)) {
                return curso;
            }
        }
        return null;
    }

    // Método para listar os cursos registrados.
    public void listarCursos() {
        if(cursos.isEmpty()) {
            System.out.println("\nNenhum curso registrado.");
        } else {
            System.out.println("\n---- Lista de Cursos registrados ----");
            for(Curso curso : cursos) {
                System.out.println(curso);
            }
        }
    }

    public void setUsuarioLogado(Usuario usuario){
        this.usuarioLogado = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
