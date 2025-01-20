//Gabriel Riul Perissé
//RA: 2064430

public abstract class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    
    //construtor
    public Usuario(String nome, String cpf, String endereco, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    //getters()
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    //setters()
    public void setNome(String nome) throws IllegalArgumentException {
        if (!nome.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Nome inválido! O nome deve conter apenas letras e espaços.");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) throws IllegalArgumentException {
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido! O CPF deve conter 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}//fim da classe