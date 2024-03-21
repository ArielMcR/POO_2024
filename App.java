import java.util.Scanner;

public class App {
    static Turma[] turmas = new Turma[60];
    static Matricula[] matriculas = new Matricula[60];
    static Campus[] campim = new Campus[60];
    static Aluno[] alunos = new Aluno[60];
    static Curso[] cursos = new Curso[60];
    static Scanner sc = new Scanner(System.in);
    static int quantidadeTurma = 0;
    static int quantidadeMatricula = 0;
    static int quantidadeCampus = 0;
    static int quantidadeAluno = 0;
    static int quantidadeCurso = 0;

    public static void main(String[] args) throws Exception {
        int opc = 0;
        do {
            exibirMenu();
            opc = sc.nextInt();
            sc.nextLine();
            roteador(opc);

        } while (opc != 7);
    }

    public static void roteador(int opc) {
        switch (opc) {
            case 1:
                cadastarTurma();
                break;

            case 2:
                cadastarCampus();
                break;
            case 3:
                cadastrarCurso();
                break;
            case 4:
                cadastrarAluno();
                break;

            case 5:
                cadastarMatricula();
                break;

            case 6:
                gerarRelatorio();
                break;

            default:
                break;
        }
    }

    private static void cadastrarCurso() {
        Curso curso = new Curso();

        System.out.println("Digite o nome do Curso: ");
        curso.nome = sc.nextLine();
        System.out.println("Digite a duração do Curso: ");
        curso.duracao = sc.nextLine();
        System.out.println("Digite a modalidade do Curso: ");
        curso.modalidade = sc.nextLine();
        cursos[quantidadeCurso] = curso;
        quantidadeCurso++;
    }

    private static void cadastrarAluno() {
        Aluno aluno = new Aluno();

        System.out.println("Digite o nome do Aluno: ");
        aluno.nome = sc.nextLine();
        System.out.println("Digite o cpf do Aluno: ");
        aluno.cpf = sc.nextLine();
        System.out.println("Digite o telefone do Aluno: ");
        aluno.telefone = sc.nextLine();
        System.out.println("Digite o endereço do Aluno: ");
        aluno.endereco = sc.nextLine();
        System.out.println("Digite a data de nascimento: ");
        aluno.dataNascimento = sc.nextLine();
        System.out.println("Cadastrado com Sucesso!!!");

        alunos[quantidadeAluno] = aluno;
        quantidadeAluno++;


    }
    public static void gerarRelatorio() {
        int opcaoRelatorio;
        do{
            exibirMenuRelatorio();
            opcaoRelatorio = sc.nextInt();
            sc.nextLine();
            roteadorRelatorio(opcaoRelatorio);

        }while(opcaoRelatorio !=6);

        }

    private static void roteadorRelatorio(int opcaoRelatorio) {
        switch (opcaoRelatorio) {
            case 1:
                gerarRelatorioAluno();
                break;

            case 2:
                gerarRelatorioCampus();
                break;
            case 3:
                gerarRelatorioMatricula();
                break;
            case 4:
                gerarRelatorioCurso();
                break;

            case 5:
                gerarRelatorioTurma();
                break;
            default:
                break;
        }
    }

    private static void gerarRelatorioAluno() {
        System.out.println("\033[H\033[2J");

        for (int i = 0; i < quantidadeAluno; i++) {
        System.out.println("---------- Alunos ----------");
        System.out.println("Nome do aluno: " + alunos[i].nome);
        System.out.println("CPF do aluno: " + alunos[i].cpf);
        System.out.println("Endereço do aluno: " + alunos[i].endereco);
        System.out.println("Data de nascimento do aluno: " + alunos[i].dataNascimento);

        }
    }
    
    private static void gerarRelatorioTurma() {
        System.out.println("\033[H\033[2J");

        for (int i = 0; i < quantidadeTurma; i++) {
            System.out.println("---------- Turmas ----------");
            System.out.println("Nome turma: " + turmas[i].nome);
            System.out.println("Numero mínimo: " + turmas[i].numeroMinimo);
            System.out.println("Ano de ingresso: " + turmas[i].anoIngresso);
        }
    }

    private static void gerarRelatorioMatricula() {
        System.out.println("\033[H\033[2J");

        for (int i = 0; i < quantidadeMatricula; i++) {
            System.out.println("---------- Matricula ----------");
            System.out.println("RA da matricula: " + matriculas[i].ra);
            System.out.println("Data da matricula" + matriculas[i].data);
            String ativo = "Situação do aluno ";
            if(matriculas[i].situacao == true){
                ativo += "ativa";
                System.out.println(ativo);
            }else{ 
                ativo += "desativada";
                System.out.println(ativo);
            }
        }
    }
    
    private static void gerarRelatorioCurso() {
        System.out.println("\033[H\033[2J");

        for (int i = 0; i < quantidadeCurso; i++) {
            System.out.println("---------- Curso ----------");
            System.out.println("Nome do curso: " + cursos[i].nome);
            System.out.println("Duração do curso: " + cursos[i].duracao);
            System.out.println("Modalidade do curso: " + cursos[i].modalidade +'\n');

        }
    }
    private static void gerarRelatorioCampus() {
        System.out.println("\033[H\033[2J");

        for (int i = 0; i < quantidadeCampus; i++) {
            System.out.println("---------- Campus ----------");
            System.out.println("Nome do campus: " + campim[i].nome);
            System.out.println("Endereço do campus" + campim[i].endereco);
            System.out.println("Cidade do campus: " + campim[i].cidade);
        }
    }


    public static void cadastarCampus() {
        Campus campus = new Campus();
        System.out.println("Qual o nome do campus: ");
        campus.nome = sc.nextLine();
        System.out.println("Qual o endereço do campus: ");
        campus.endereco = sc.nextLine();
        System.out.println("Qual a cidade do campus: ");
        campus.cidade = sc.nextLine();
        System.out.println("Cadastrado com Sucesso!!!");
        campim[quantidadeCampus] = campus;
        quantidadeCampus++;
    }

    public static void cadastarTurma(){
        Turma turma = new Turma();
        System.out.println("Qual o nome da turma: ");
        turma.nome = sc.nextLine();
        System.out.println("Qual o numero minimo: ");
        turma.numeroMinimo = sc.nextInt();
        System.out.println("Qual o ano de ingresso: ");
        turma.anoIngresso = sc.nextInt();
        System.out.println("Cadastrado com Sucesso!!!");
        System.out.println('\n');
        turmas[quantidadeTurma] = turma;
        quantidadeTurma++;

    }

    public static void cadastarMatricula() {
        Matricula matricula = new Matricula();
        System.out.println("Qual o RA do estudante: ");
        matricula.ra = sc.nextLine();
        System.out.println("Qual a data da matricula do estudante: ");
        matricula.data = sc.nextLine();
        System.out.println("Qual a situação do estudante(true/false): ");
        matricula.situacao = sc.nextBoolean();
        matriculas[quantidadeMatricula] = matricula;
        quantidadeMatricula++;
        System.out.println("Cadastrado com Sucesso!!!");

    }

    public static void exibirMenu() {
        System.out.print("##-- Menu --##\n\n");
        System.out.print("|--------------------------------|\n");
        System.out.print("| Opção 1 - Cadastros Turmas     |\n");
        System.out.print("| Opção 2 - Cadastros Campus     |\n");
        System.out.print("| Opção 3 - Cadastros Cursos     |\n");
        System.out.print("| Opção 4 - Cadastros Alunos     |\n");
        System.out.print("| Opção 5 - Cadastros Matriculas |\n");
        System.out.print("| Opção 6 - Gerar Relatórios     |\n");
        System.out.print("| Opção 7 - Sair                 |\n");
        System.out.print("|--------------------------------|\n");
        System.out.print("Digite uma opção: ");
    }
    
    public static void exibirMenuRelatorio() {

        System.out.print("##-- Relatório --##\n\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("| Opção 1 - Relatório Aluno       |\n");
        System.out.print("| Opção 2 - Relatório Campus      |\n");
        System.out.print("| Opção 3 - Relatório Matricula   |\n");
        System.out.print("| Opção 4 - Relatório Curso       |\n");
        System.out.print("| Opção 5 - Relatório Turma       |\n");
        System.out.print("| Opção 6 - Sair                  |\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("Digite uma opção: ");
    }

}
