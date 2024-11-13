package CodigoProjeto;

import java.time.LocalDateTime;

public class Professor extends Usuario {

	private String disciplina;

	public Professor(String nome, String email, String senha, String matricula, String disciplina){
		super(nome, email, senha, matricula);
		this.disciplina = disciplina;
	}

	public void agendarAula(Curso curso, String nomeAula, LocalDateTime dataHora) {
		Aula novaAula = new Aula(nomeAula, dataHora);
		curso.adicionarAula(novaAula);
		System.out.println("\nA Aula: " + nomeAula + " que acontecerá em " + dataHora+ " foi agendada.");
	}

	public void verInformacoes(Usuario usuarioLogado){
		super.verInformacoes(usuarioLogado);
		System.out.println("Disciplica ensinada: "+disciplina);
		System.out.println("Cargo: Professor");
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}