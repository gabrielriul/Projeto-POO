//Gabriel Riul Perissé
//RA: 2064430

import java.util.ArrayList;

public class Principal {

    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    
    public static void consultarLivroTitulo(ArrayList<Livro> livros, Leitura leitura) {
        System.out.println("Digite o título do livro: ");
        String titulo = leitura.entDados("Título: ");
                                                
        for(int j = 0; j < livros.size(); j++) {
            if(livros.get(j).getTitulo().equals(titulo)) {
                System.out.println("Título: " + livros.get(j).getTitulo());
                System.out.println("ISBN: " + livros.get(j).getISBN());
                System.out.println("Quantidade Total: " + livros.get(j).getQuantidadeTotal());
                System.out.println("Quantidade Disponível: " + livros.get(j).getQuantidadeDisponivel());
                System.out.println("Editora: " + livros.get(j).getEditora());
            }
            else System.out.println("Livro não encontrado!");
        }
    }

    public static void consultarLivroISBN(ArrayList<Livro> livros, Leitura leitura) {
        System.out.println("Digite o ISBN do livro: ");
        String isbn = leitura.entDados("ISBN: ");
        for(int j = 0; j < livros.size(); j++) {
            if(livros.get(j).getISBN().equals(isbn)) {
                System.out.println("Título: " + livros.get(j).getTitulo());
                System.out.println("ISBN: " + livros.get(j).getISBN());
                System.out.println("Quantidade Total: " + livros.get(j).getQuantidadeTotal());
                System.out.println("Quantidade Disponível: " + livros.get(j).getQuantidadeDisponivel());
                System.out.println("Editora: " + livros.get(j).getEditora());
            }
            else System.out.println("Livro não encontrado!");
        }
    }

    public static void main(String arg[]) {

        System.out.println("\t\tAVISO: Os dados de aluno e professor não estão cadastrados!");
        System.out.println("\t\tEntrar como gestor para cadastrar os dados.");

        Leitura leitura = new Leitura();
        boolean continuarPrograma = true;

        while (continuarPrograma) {
            System.out.println("Bem-vindo ao sistema de biblioteca!");
            System.out.println("1 - Entrar como usuário");
            System.out.println("2 - Entrar como gestor");
            System.out.println("3 - Sair");

            int opcao = Integer.parseInt(leitura.entDados("Opção: "));

            switch(opcao) {
                case 1 -> { // Entrar como usuário
                    boolean continuarUsuario = true;
                    while (continuarUsuario) {
                        System.out.println("1 - Professor");
                        System.out.println("2 - Aluno");
                        System.out.println("3 - Voltar");

                        int opcao2 = Integer.parseInt(leitura.entDados("Opção: "));

                        switch(opcao2) {
                            case 1 -> { // Entrar como professor
                                //System.out.println("Professores cadastrados: "+professores.size());
                                String cpf = leitura.entDados("Digite o CPF: ");

                                boolean professorEncontrado = false;
                                for(int i = 0; i < professores.size(); i++) {
                                    if(professores.get(i).getCpf().equals(cpf)) {
                                        professorEncontrado = true;
                                        boolean continuarProfessor = true;
                                        while (continuarProfessor) {
                                            System.out.println("1 - Emprestar Livro");
                                            System.out.println("2 - Devolver Livro");
                                            System.out.println("3 - Consultar livros");
                                            System.out.println("4 - Consultar multas");
                                            System.out.println("5 - Voltar");

                                            int opcao5 = Integer.parseInt(leitura.entDados("Opção: "));

                                            switch(opcao5) {
                                                case 1 -> { // Emprestar Livro
                                                    Professor.emprestarLivro(livros, leitura);
                                                }
                                                case 2 -> { // Devolver Livro
                                                    Professor.devolverLivro(livros, leitura);
                                                }
                                                case 3 -> {
                                                    System.out.println("Procurar livro por título ou ISBN?");
                                                    System.out.println("1 - Título");
                                                    System.out.println("2 - ISBN");
                                                    System.out.println("3 - Voltar");

                                                    int consultarLivro = Integer.parseInt(leitura.entDados("Opção: "));

                                                    switch (consultarLivro) {
                                                        case 1 -> {
                                                            consultarLivroTitulo(livros, leitura);
                                                        }
                                                        case 2 -> {
                                                            consultarLivroISBN(livros, leitura);
                                                        }
                                                        case 3 -> {
                                                            continuarProfessor = false;
                                                            break;
                                                        }
                                                        default -> System.out.println("Opção inválida!");
                                                    }
                                                }
                                                case 4 -> { // Consultar multas
                                                    // Implementar lógica para consultar multas
                                                }
                                                case 5 -> { // Voltar
                                                    continuarProfessor = false;
                                                    break;
                                                }
                                                default -> System.out.println("Opção inválida!");
                                            }
                                        }
                                    }
                                }
                                if (!professorEncontrado) {
                                    System.out.println("Professor não encontrado!");
                                }
                            }
                            case 2 -> { // Entrar como aluno
                                String cpf = leitura.entDados("Digite o CPF: ");

                                boolean alunoEncontrado = false;
                                for(int i = 0; i < alunos.size(); i++) {
                                    if(alunos.get(i).getCpf().equals(cpf)) {
                                        alunoEncontrado = true;
                                        boolean continuarAluno = true;
                                        while (continuarAluno) {
                                            System.out.println("1 - Consultar Livros");
                                            System.out.println("2 - Consultar multas");
                                            System.out.println("3 - Voltar");

                                            int opcao6 = Integer.parseInt(leitura.entDados("Opção: "));

                                            switch(opcao6) {
                                                case 1 -> { // Consultar livro
                                                    System.out.println("Procurar livro por título ou ISBN?");
                                                    System.out.println("1 - Título");
                                                    System.out.println("2 - ISBN");
                                                    System.out.println("3 - Voltar");

                                                    int consultarLivro = Integer.parseInt(leitura.entDados("Opção: "));

                                                    switch (consultarLivro) {
                                                        case 1 -> {
                                                            consultarLivroTitulo(livros, leitura);
                                                        }
                                                        case 2 -> {
                                                            consultarLivroISBN(livros, leitura);
                                                        }
                                                        case 3 -> {
                                                            continuarAluno = false;
                                                            break;
                                                        }
                                                        default -> System.out.println("Opção inválida!");
                                                    }
                                                }
                                                case 2 -> { // Consultar multas
                                                    // Implementar lógica para consultar multas
                                                }
                                                case 3 -> { // Voltar
                                                    continuarAluno = false;
                                                    break;
                                                }
                                                default -> System.out.println("Opção inválida!");
                                            }
                                        }
                                    }
                                }
                                if (!alunoEncontrado) {
                                    System.out.println("Aluno não encontrado!");
                                }
                            }
                            case 3 -> { // Voltar
                                continuarUsuario = false;
                                break;
                            }
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 2 -> { // Entrar como gestor
                    boolean continuarGestor = true;
                    while (continuarGestor) {
                        System.out.println("1 - Cadastrar Livro");
                        System.out.println("2 - Cadastrar Usuário");
                        System.out.println("3 - Voltar");

                        int opcao3 = Integer.parseInt(leitura.entDados("Opção: "));

                        switch(opcao3) {
                            case 1 -> { // Cadastrar Livro
                                livros = GestorLivro.addLivro(livros, leitura);
                            }
                            case 2 -> { // Cadastrar Usuários
                                boolean continuarCadastro = true;
                                while (continuarCadastro) {
                                    System.out.println("1 - Cadastrar Professor");
                                    System.out.println("2 - Cadastrar Aluno");
                                    System.out.println("3 - Voltar");

                                    int opcao4 = Integer.parseInt(leitura.entDados("Opção: "));

                                    switch(opcao4) {
                                        case 1 -> { // Cadastrar Professor
                                            professores = GestorLivro.addProfessor(professores, leitura);
                                        }
                                        case 2 -> { // Cadastrar Aluno
                                            alunos = GestorLivro.addAluno(alunos, leitura);
                                        }
                                        case 3 -> { // Voltar
                                            continuarCadastro = false;
                                            break;
                                        }
                                        default -> System.out.println("Opção inválida!");
                                    }
                                }
                            }
                            case 3 -> { // Voltar
                                continuarGestor = false;
                                break;
                            }
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 3 -> { // Sair
                    System.out.println("Saindo...");
                    continuarPrograma = false;
                    break;
                }
                default -> System.out.println("Opção inválida!");
            } //fim do switch
        } //fim do while
    } //fim do main
} //fim da classe