public class Reta {

    private int pontoX0;
    private int pontoY0;
    private int pontoX1;
    private int pontoY1;


    private float m = 0;

    private float l = 0;

    public Reta(int pontoX0, int pontoY0, int pontoX1, int pontoY1) {
        this.pontoX0 = pontoX0;
        this.pontoY0 = pontoY0;
        this.pontoX1 = pontoX1;
        this.pontoY1 = pontoY1;
        setarObjeto();
    }

    public void setarObjeto() {
        criarReta();
        coeficienteLinear();
    }

    private float criarReta() {
        this.m = (float) (pontoY0 - pontoY1) / (pontoX0 - pontoX1);
        return m;
    }

    private float coeficienteLinear() {
        this.l = pontoY0 - (m * pontoX0);
        return l;
    }

    public void stringEq() {
        System.out.println("y = " + this.m + "x + " + this.l);
    }


    public boolean intersecao(Reta Reta) {
        if (this.m == Reta.m) {
            System.out.println("Retas parelelas");
            return true;
        } else {
            float intersecaoX = (Reta.l - this.l) / (this.m - Reta.m);
            float intersecaoY = this.m * intersecaoX + this.l;
            System.out.println("As retas se intersectam no ponto (" + intersecaoY + ", " + intersecaoX + ")");
        }

        return true;
    }


    public boolean ehdaReta(int pontoX, int pontoY) {
        float valorY = this.m * pontoX + this.l;
        if (valorY == pontoY) {
            System.out.println("O ponto (" + pontoX + ", " + pontoY + ") pertence à reta.");
            return true;
        } else {
            System.out.println("O ponto (" + pontoX + ", " + pontoY + ") não pertence à reta.");
            return false;
        }
    }


}