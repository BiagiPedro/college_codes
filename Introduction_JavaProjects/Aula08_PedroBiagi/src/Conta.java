class Conta {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String sexo;
    private String numeroConta;
    private String senha;
    private String email;
    private boolean desejaReceberNoticias;

    public Conta(String nome, String cpf, String dataNascimento, String sexo, String numeroConta, String senha, String email, boolean desejaReceberNoticias) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.email = email;
        this.desejaReceberNoticias = desejaReceberNoticias;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean isDesejaReceberNoticias() {
        return desejaReceberNoticias;
    }
}