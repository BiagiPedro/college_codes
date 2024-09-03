import java.util.Random;
public class NaveEspacial {
    Random random = new Random();
    private String nome;
    private int velocidade;
    private static int quantidade;


    public NaveEspacial(String nome){
        this.nome = nome;
        this.velocidade = random.nextInt(6) + 5;
        quantidade++;

    }

    public void mostraNave(){
        System.out.println(this.nome);
        System.out.println(this.velocidade);
    }

    public int testeVelocidade(){
        return this.velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
}
