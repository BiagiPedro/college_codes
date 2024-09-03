package cliente;
public class Cliente {
    String nome;
    int cpf, idade, telefone;


    public Cliente(String nome , int cpf , int idade , int telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }


    void MostrarDadosClientes(){
        System.out.println(nome);
        System.out.println(cpf);
        System.out.println(idade);
        System.out.println(telefone);
    }




}
