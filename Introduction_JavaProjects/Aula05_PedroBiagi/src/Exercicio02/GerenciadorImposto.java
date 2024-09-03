package Exercicio02;
public class GerenciadorImposto {
    private Cliente[] clientes = new Cliente[5];
    private int indiceCliente = 0;

    public void adicionarCliente(Cliente cliente) {
        if (indiceCliente < clientes.length) {
            clientes[indiceCliente++] = cliente;
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Limite de clientes atingido!");
        }
    }

    public Cliente getCliente(int indice) {
        if (indice >= 0 && indice < indiceCliente) {
            return clientes[indice];
        } else {
            System.out.println("Índice de cliente inválido.");
            return null;
        }
    }

    public double saldoDevedorTotal() {
        double saldoDevedorTotal = 0;
        for (int i = 0; i < indiceCliente; i++) {
            saldoDevedorTotal += clientes[i].getTaxas();
        }
        return saldoDevedorTotal;
    }
}