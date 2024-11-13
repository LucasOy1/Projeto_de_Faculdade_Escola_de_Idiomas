package CodigoProjeto;

import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    private static SistemaRegistro sistema = new SistemaRegistro();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializar();
        menuPrincipal();
    }

    // Método para limpar a tela.
    public static void limparTela() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    // Método para exibir as mensagens de confirmação e só passar para próxima página caso o usuário aperte Enter.
    public static void mensagemConfirmacao() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
        limparTela();
    }

    // Atributos inicializados
    private static void inicializar() {
        //Usuário Admin criado
        Admin admin = new Admin("ADM", "admin@gmail.com", "admin123", "0000001");
        sistema.registrarUsuario(admin);
        //Alunos criados
        Aluno aluno = new Aluno("José", "jose123@gmail.com", "jose1234", "0000002", "Ingles");
        sistema.registrarUsuario(aluno);
        Aluno aluno2 = new Aluno("Pedro", "pedro@gmail.com", "12345", "0000004", "Japones");
        sistema.registrarUsuario(aluno2);
        //Professores criados
        Professor professor = new Professor("Daniel", "daniel@gmail.com", "daniel123", "0000003", "Ingles");
        sistema.registrarUsuario(professor);
        Professor professor2 = new Professor("Naoto", "naotojp@gmail.com", "naoto123", "0000005", "Japones");
        sistema.registrarUsuario(professor2);

        //Cursos criados
        Curso curso1 = new Curso("Ingles");
        sistema.criarCurso(curso1);
        Curso curso2 = new Curso("Japones");
        sistema.criarCurso(curso2);

        //Aulas agendadas
        Aula aula1 = new Aula("Aula 01 - Gramática Básica", LocalDateTime.of(2024, 12, 16, 14, 0, 0));
        curso1.adicionarAula(aula1);
        Aula aula2 = new Aula("Aula 02 - Verbos", LocalDateTime.of(2024, 12, 16, 14, 0, 0));
        curso1.adicionarAula(aula2);

        Aula aula03 = new Aula("Aula 01 - Aprendendo Hiragana", LocalDateTime.of(2024, 12, 13, 14, 0, 0));
        curso2.adicionarAula(aula03);
        Aula aula04 = new Aula("Aula 02 - Aprendendo Katakana", LocalDateTime.of(2024, 12, 17, 14, 0, 0));
        curso2.adicionarAula(aula04);
    }

    // Menu Principal onde o usuário vai poder entrar no sistema da escola.
    private static void menuPrincipal() {
        limparTela();
        System.out.println("\n---- Escola de Idiomas ----");
        System.out.println("1. Login");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opçao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1: login();
            break;
            case 2: {
                System.out.println("Saindo...");
                System.exit(0);
                break;
            }
            default: System.out.println("\nOpçao inválida. Tente novamente"); 
                    menuPrincipal();
        }
    }

    // Aqui vão ser pedidos os dados do usuário para ele poder entrar no sistema.
    private static void login() {
        limparTela();
        System.out.println("\n---- Faça seu Login ----");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = sistema.autenticarUsuario(email, senha);
        if(usuario != null){
            sistema.setUsuarioLogado(usuario);
            if(usuario instanceof Admin){
                menuAdmin();
            } else if(usuario instanceof Professor){
                menuProfessor();
            } else if (usuario instanceof Aluno) {
                menuAluno();
            }
        } else {
            System.out.println("\nCredenciais inválidas. Tente novamente.");
            mensagemConfirmacao();
            login();
        }
    }

    // Menu em que o Admin vai poder registrar um novo usuário/curso, e também vai poder ver todos os usuários registrados no sistema.
    private static void menuAdmin() {
        limparTela();
        System.out.println("\n---- Menu Admin ----");
        System.out.println("1. Registrar Novo Usuário.");
        System.out.println("2. Registrar Novo Curso.");
        System.out.println("3. Listar usuários registrados.");
        System.out.println("4. Listar cursos registrados.");
        System.out.println("5. Sair.");
        System.out.print("Escolha uma opçao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao) {
            case 1: registrarUsuario(); //Vai mandar o admin para o preenchimento de dados para o novo usuário.
                break;
            case 2: registrarCurso(); //Vai mandar o admin para o preenchimento de dados do novo Curso.
                break;
            case 3: limparTela();
                sistema.listarUsuario(); // Vai mostrar a listagem de todos os usuários registrados no sistema.
                mensagemConfirmacao();
                menuAdmin();
            case 4: limparTela(); 
                sistema.listarCursos(); // Vai mostrar a listagem de todos os cursos registrados no sistema.
                mensagemConfirmacao();
                menuAdmin();
            case 5:
                sistema.setUsuarioLogado(null);
                menuPrincipal(); // Vai mandar o Admin para o Menu Principal
            default: System.out.println("\nOpçao inválida. Tente novamente.");
                menuAdmin(); // Vai mandar o Admin para o menu de Admin caso ele escolha uma opção inválida
        }
    }

    // Menu em que o Admin vai preencher os dados do novo usuário.
    private static void registrarUsuario() {
        limparTela();
        System.out.println("\n---- Registro de Usuários ----");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Tipo de usuário (1- Aluno, 2- Professor): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if(tipo == 1) { // Caso o novo usuário seja um Aluno, o Admin vai dizer aqui qual curso este aluno pertence.
            System.out.print("Curso: ");
            String curso = scanner.nextLine();
            Aluno aluno = new Aluno(nome, email, senha, matricula, curso);
            sistema.registrarUsuario(aluno);
            System.out.println("\nAluno "+nome+" registrado com sucesso.");
            mensagemConfirmacao();
        } else if (tipo == 2) { // E aqui caso o novo usuário seja um professor, o Admin vai dizer qual a disciplina ele pertence.
            System.out.print("Disciplina: ");
            String disciplina = scanner.nextLine();
            Professor professor = new Professor(nome, email, senha, matricula, disciplina);
            sistema.registrarUsuario(professor);
            System.out.println("\nProfessor "+nome+" registrado com sucesso.");
            mensagemConfirmacao();
        } else {
            System.out.println("Tipo inválido");
            mensagemConfirmacao();
        }

        menuAdmin();
    }

    // Menu em que o Admin vai registrar o novo curso.
    private static void registrarCurso() {
        limparTela();
        System.out.println("\n---- Registro de Novos Cursos");
        System.out.print("Nome do idioma do Curso: ");
        String nomeCurso = scanner.nextLine();
        Curso curso = new Curso(nomeCurso);
        sistema.criarCurso(curso);
        System.out.println("\nCurso registrado com sucesso.");
        mensagemConfirmacao();
        menuAdmin();
    }

    // Menu dos professores, aqui eles podem agendar as aulas e ver quantos alunos estão registrados em seus cursos.
    private static void menuProfessor() {
        limparTela();
        System.out.println("\n--- Menu Professor ---");
        System.out.println("1. Agendar Aula");
        System.out.println("2. Listar Alunos na Disciplina");
        System.out.println("3. Aulas agendadas.");
        System.out.println("4. Sair.");
        System.out.print("Escolha uma opçao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao) {
            case 1: agendarAula(); //Aqui vai mandar o professor para o menu de agendamento de aulas.
                break;
            case 2: limparTela();
                sistema.listarAlunosPorDisciplina();
                mensagemConfirmacao();
                menuProfessor();
            case 3: limparTela();
                verAulasAgendadasProfessor();
                mensagemConfirmacao();
            case 4: sistema.setUsuarioLogado(null);
                menuPrincipal();
            default: System.out.println("\nOpçao inválida. Tente novamente.");
                mensagemConfirmacao();
                menuProfessor();
        }
    }

    // Menu que vai permitir que o professor possa agendar suas aulas.
    public static void agendarAula() {
        limparTela();

        Professor professor = (Professor) sistema.getUsuarioLogado();
        Curso curso = sistema.getCurso(professor.getDisciplina());

        System.out.println("\n---- Agendamento da aula de "+ curso.getIdioma()+ " ----");
        System.out.print("Nome da Aula: ");
        String nomeAula = scanner.nextLine();
        System.out.print("Data e hora(ex: 2024-12-31T13:00:00): ");
        LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());

        ((Professor) sistema.getUsuarioLogado()).agendarAula(curso, nomeAula, dataHora);
        mensagemConfirmacao();
        
        menuProfessor();
    }

    // Menu em que o professor pode verificar as aulas agendadas.
    private static void verAulasAgendadasProfessor() {
        limparTela();

        Professor professor = (Professor) sistema.getUsuarioLogado();
        Curso curso = sistema.getCurso(professor.getDisciplina());
        System.out.println("\n---- Aulas Agendadas ----");
        ((Professor) sistema.getUsuarioLogado()).verAulas(curso);
        mensagemConfirmacao();

        menuProfessor();
    }

    //Menu do aluno, aqui ele pode verificar as aulas agendadas.
    private static void menuAluno(){
        limparTela();
        System.out.println("\n---- Menu Aluno ----");
        System.out.println("1. Ver Aulas Agendadas");
        System.out.println("2. Sair.");
        System.out.print("Escolha uma opçao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1: limparTela();
                verAulasAgendadasAluno();
                mensagemConfirmacao();
                break;
            case 2: sistema.setUsuarioLogado(null);
                menuPrincipal();
            default: System.out.println("\nOpcao inválida. Tente novamente.");
                mensagemConfirmacao();
                menuAluno();
        }
    }

    // Menu em que o aluno pode verificar as aulas agendadas.
    private static void verAulasAgendadasAluno() {
        limparTela();

        Aluno aluno = (Aluno) sistema.getUsuarioLogado();
        Curso curso = sistema.getCurso(aluno.getCurso());
        System.out.println("\n---- Aulas Agendadas ----");
        ((Aluno) sistema.getUsuarioLogado()).verAulas(curso);
        mensagemConfirmacao();

        menuAluno();
    }

}