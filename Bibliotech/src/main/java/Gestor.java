//Gabriel Riul Perissé
//RA: 2064430

import java.util.ArrayList;

public final class Gestor {
    
    private static ArrayList<Livro> livros;
    private static ArrayList<Professor> professores;
    private static ArrayList<Aluno> alunos;
    
    private static Gestor gestorUnic; //1º passo
    
    private Gestor(){ //2º passo
        livros = new ArrayList<Livro>();
        professores = new ArrayList<Professor>();
        alunos = new ArrayList<Aluno>();
    }
    
    public static Gestor geraGestor(){ //3º passo
        if(gestorUnic == null){
            gestorUnic = new Gestor();
        }
        return gestorUnic;
    }
    
    //metodos
    public static ArrayList<Aluno> addAluno(ArrayList<Aluno> alunos, Leitura leitura) { 
        String nome = null;
        boolean nomeValido = true;
        while (nomeValido) {
            try {
                nome = leitura.entDados("Nome: ");
                nomeValido = false;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        String cpf = null;
        boolean cpfValido = true;
        while (cpfValido) {
            try {
                cpf = leitura.entDados("CPF: ");
                cpfValido = false;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage()); 
            }
        }
        
        Aluno a1 = new Aluno(
            nome,
            cpf,
            leitura.entDados("Endereco: "),
            leitura.entDados("Email: "),
            leitura.entDados("Telefone: "),
            leitura.entDados("Curso: "),
            leitura.entDados("RA: ")
        );
            
        alunos.add(a1);
        
        boolean vai = true;
        while(vai) {
            String s = leitura.entDados("Deseja cadastrar mais Alunos? s/n");
                                            
            if (s.equalsIgnoreCase("s")) {
                addAluno(alunos, leitura);
            } else if (s.equalsIgnoreCase("n")) {
                vai = false;
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        System.out.println("Nome: "+ a1.getNome() +" CPF: "+ a1.getCpf());
        return alunos;
    }

    public static ArrayList<Professor> addProfessor(ArrayList<Professor> professores, Leitura leitura) {
        String nome = null;
        boolean nomeValido = true;
        while (nomeValido) {
            try {
                nome = leitura.entDados("Nome: ");
                nomeValido = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String cpf = null;
        boolean cpfValido = true;
        while (cpfValido) {
            try {
                cpf = leitura.entDados("CPF: ");
                cpfValido = false;
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage()); 
            }
        }
        
        Professor p1 = new Professor(
            nome,
            cpf,
            leitura.entDados("Endereco: "),
            leitura.entDados("Email: "),
            leitura.entDados("Telefone: "),
            leitura.entDados("Cargo: "),
            leitura.entDados("Matricula: ")
        );  
        
        professores.add(p1);
        System.out.println("Nome: " + p1.getNome() + ", CPF: " + p1.getCpf()); // Mensagem de depuração
        System.out.println("Total de professores cadastrados: " + professores.size()); // Verifica o tamanho da lista

        boolean vai = true;
        while(vai) {
            String s = leitura.entDados("Deseja cadastrar mais Professores? s/n");
                                            
            if (s.equalsIgnoreCase("s")) {
                addProfessor(professores, leitura);
            } else if (s.equalsIgnoreCase("n")) {
                vai = false;
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        return professores;
    }

    public static ArrayList<Aluno> remAluno(ArrayList<Aluno> alunos, Leitura leitura) {
        String cpf = leitura.entDados("Digite o CPF do aluno que deseja remover: ");
        for(int i = 0; i < alunos.size(); i++) {
            if(alunos.get(i).getCpf().equals(cpf)) {
                alunos.remove(i);
                
                boolean vai = true;
                while(vai) {
                    String s = leitura.entDados("Deseja remover mais Alunos? s/n");
                                            
                    if (s.equalsIgnoreCase("s")) {
                        remAluno(alunos, leitura);
                    } else if (s.equalsIgnoreCase("n")) {
                        vai = false;
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                return alunos;
            }
        }
        return null;
    }

    public static ArrayList<Professor> remProfessor(ArrayList<Professor> professores, Leitura leitura) {    
        String cpf = leitura.entDados("Digite o CPF do professor que deseja remover: ");
        for(int i = 0; i < professores.size(); i++) {
            if(professores.get(i).getCpf().equals(cpf)) {
                professores.remove(i);
                
                boolean vai = true;
                while(vai) {
                    String s = leitura.entDados("Deseja remover mais Professores? s/n");
                                            
                    if (s.equalsIgnoreCase("s")) {
                        remProfessor(professores, leitura);
                    } else if (s.equalsIgnoreCase("n")) {
                        vai = false;
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                return professores;
            }
        }
        return null;
    }

    public static ArrayList<Aluno> editAluno(ArrayList<Aluno> alunos, Leitura leitura) {
        String cpf = leitura.entDados("Digite o CPF do aluno que deseja editar: ");

        for(int i = 0; i < alunos.size(); i++) {
            if(alunos.get(i).getCpf().equals(cpf)) {
                Aluno a = alunos.get(i);

                a.setNome(leitura.entDados("Nome: "));
                a.setEndereco(leitura.entDados("Endereco: "));
                a.setEmail(leitura.entDados("Email: "));
                a.setTelefone(leitura.entDados("Telefone: "));
                a.setCurso(leitura.entDados("Curso: "));
                a.setRa(leitura.entDados("RA: "));

                alunos.set(i, a);
                
                boolean vai = true;
                while(vai) {
                    String s = leitura.entDados("Deseja editar mais Alunos? s/n");
                                            
                    if (s.equalsIgnoreCase("s")) {
                        remAluno(alunos, leitura);
                    } else if (s.equalsIgnoreCase("n")) {
                        vai = false;
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                return alunos;
            }
        }
        return null;
    }

    public static ArrayList<Professor> editProfessor(ArrayList<Professor> professores, Leitura leitura) {
        String cpf = leitura.entDados("Digite o CPF do professor que deseja editar: ");

        for(int i = 0; i < professores.size(); i++) {
            if(professores.get(i).getCpf().equals(cpf)) {
                Professor p = professores.get(i);

                p.setNome(leitura.entDados("Nome: "));
                p.setEndereco(leitura.entDados("Endereco: "));
                p.setEmail(leitura.entDados("Email: "));
                p.setTelefone(leitura.entDados("Telefone: "));
                p.setCargo(leitura.entDados("Cargo: "));
                p.setMatricula(leitura.entDados("Matricula: "));

                professores.set(i, p);
                
                boolean vai = true;
                while(vai) {
                    String s = leitura.entDados("Deseja editar mais Professores? s/n");
                                            
                    if (s.equalsIgnoreCase("s")) {
                        remProfessor(professores, leitura);
                    } else if (s.equalsIgnoreCase("n")) {
                        vai = false;
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                return professores;
            }
        }
        return null;
    }

    public static ArrayList<Livro> addLivro(ArrayList<Livro> livros, Leitura leitura) {
        Livro l1 = new Livro(
            leitura.entDados("Titulo: "),
            leitura.entDados("ISBN: "),
            Integer.parseInt(leitura.entDados("Quantidade Total: ")),
            Integer.parseInt(leitura.entDados("Quantidade Disponivel: ")),
            leitura.entDados("Editora: ")
        );  

        livros.add(l1);
        
        boolean vai = true;
        while(vai) {
            String s = leitura.entDados("Deseja cadastrar mais livros? s/n");
                                            
            if (s.equalsIgnoreCase("s")) {
                addLivro(livros, leitura);
            } else if (s.equalsIgnoreCase("n")) {
                vai = false;
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        return livros;
    }

    public static ArrayList<Livro> remLivro(ArrayList<Livro> livros, Leitura leitura) {
        String isbn = leitura.entDados("Digite o ISBN do livro que deseja remover: ");
        for(int i = 0; i < livros.size(); i++) {
            if(livros.get(i).getISBN().equals(isbn)) {
                livros.remove(i);
                return livros;
            }
        }
        return null;
    }

    public static ArrayList<Livro> editLivro(ArrayList<Livro> livros, Leitura leitura) {
        String isbn = leitura.entDados("Digite o ISBN do livro que deseja editar: ");

        for(int i = 0; i < livros.size(); i++) {
            if(livros.get(i).getISBN().equals(isbn)) {
                Livro l = livros.get(i);

                l.setTitulo(leitura.entDados("Titulo: "));
                l.setQuantidadeTotal(Integer.parseInt(leitura.entDados("Quantidade Total: ")));
                l.setQuantidadeDisponivel(Integer.parseInt(leitura.entDados("Quantidade Disponivel: ")));
                l.setEditora(leitura.entDados("Editora: "));

                livros.set(i, l);
                return livros;
            }
        }
        return null;
    }
}//fim da classe