//Gabriel Riul Perissé
//RA: 2064430

public final class Aluno extends Usuario implements Multa {
    private String curso;
    private String ra;

    //construtor
    public Aluno(String nome, String cpf, String endereco, String email, String telefone, String curso, String ra) {
        super(nome, cpf, endereco, email, telefone);
        this.curso = curso;
        this.ra = ra;
    }

    //getters
    public String getCurso() {
        return curso;
    }

    public String getRa() {
        return ra;
    }

    //setters
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String calcularMulta() {
        return "Multa calculada";
    }
}//fim da classe