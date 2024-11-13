package CodigoProjeto;

public class Aluno extends Usuario {

		private String curso;

		public Aluno(String nome, String email, String senha, String matricula, String curso){
			super(nome, email, senha, matricula);
			this.curso = curso;
		}

		public void verInformacoes(Usuario usuarioLogado){
			super.verInformacoes(usuarioLogado);
			System.out.println("Curso: "+curso);
			System.out.println("Cargo: Aluno");
		}

		//getters e setters
		public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}
}
