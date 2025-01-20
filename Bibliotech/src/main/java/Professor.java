//Gabriel Riul Perissé 
//RA: 2064430

//import java.time.LocalDate;
import java.util.ArrayList;

public final class Professor extends Usuario implements Multa {
    private String cargo;
    private String matricula;

    //Leitura leitura = new Leitura();
    //LocalDate dataEmprestimo;
    //LocalDate dataDevolucao;

    //construtor
    public Professor(String nome, String cpf, String endereco, String email, String telefone, String cargo, String matricula) {
        super(nome, cpf, endereco, email, telefone);
        this.cargo = cargo;
        this.matricula = matricula;
    }

    //getters
    public String getCargo() {
        return cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    //setters
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String calcularMulta() {
        return "Multa calculada";
    }

    public static ArrayList<Livro> emprestarLivro(ArrayList<Livro> livros, Leitura leitura) {
        System.out.println("Digite o ISBN do livro: ");
        String isbn = leitura.entDados("ISBN: ");
                                    
        for(int j = 0; j < livros.size(); j++) {
            if(livros.get(j).getISBN().equals(isbn)) {
                if(livros.get(j).getQuantidadeDisponivel() > 0) {
                    livros.get(j).setQuantidadeDisponivel(livros.get(j).getQuantidadeDisponivel() - 1);
                        System.out.println("Livro emprestado com sucesso!");
                        return livros;
                }
                else {
                    System.out.println("Livro indisponível!");
                    return emprestarLivro(livros, leitura);
                }
            } 
            else {
                System.out.println("Livro não encontrado!");
                return emprestarLivro(livros, leitura);
            }
        }
        //LocalDate dataEmprestimo = LocalDate.now();
        return null;
    }

    public static ArrayList<Livro> devolverLivro(ArrayList<Livro> livros, Leitura leitura) {
        System.out.println("Digite o ISBN do livro: ");
        String isbn = leitura.entDados("ISBN: ");
        
        for(int i = 0; i < livros.size(); i++) {
            if(livros.get(i).getISBN().equals(isbn)) {
                livros.get(i).setQuantidadeDisponivel(livros.get(i).getQuantidadeDisponivel() + 1);
                System.out.println("Livro devolvido com sucesso!");
                return livros;
            }
            else {
                System.out.println("Livro não encontrado!");
                return devolverLivro(livros, leitura);
            }
        }
        //LocalDate dataDevolucao = LocalDate.now();
        return null;
    }
}//fim da classe