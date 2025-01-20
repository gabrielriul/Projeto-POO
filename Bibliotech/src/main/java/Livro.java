//Gabriel Riul Perissé
//RA: 2064430

public class Livro {
    private String titulo;
    private String ISBN;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    private String editora;

    //construtores
    public Livro(String titulo, String ISBN, int quantidadeTotal, int quantidadeDisponivel, String editora) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.editora = editora;
    }

    //getters
    public String getTitulo() {
        return titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public String getEditora() {
        return editora;
    }

    //setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}//fim da classe