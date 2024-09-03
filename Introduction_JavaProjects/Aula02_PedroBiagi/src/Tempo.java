public class Tempo {

    private int hora, minuto, segundo;
    private String pM = "PM";
    private String aM = "AM";


    public Tempo(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public void setHora(int hora) {
        if (hora > 0 && hora < 24)
            this.hora = hora;
        else {
            System.out.println("Hora invalida , valor inserido 0");
            this.hora = 0;
        }
    }

    public void setMinuto(int minuto) {
        if (minuto > 0 && minuto < 60)
            this.minuto = minuto;
        else {
            System.out.println("Minuto invalido , valor inserido 0");
        }
    }

    public void setSegundo(int segundo) {
        if (segundo > 0 && segundo < 60)
            this.segundo = segundo;
        else {
            System.out.println("segundo invalida , valor inserido 0");
            this.segundo = 0;
        }
    }

    public void mostraRelogio() {
        System.out.print(this.hora + "-");
        System.out.print(this.minuto + "-");
        System.out.print(this.segundo);

    }


    public void incrementaMinuto() {
        if (this.minuto > 0 && this.minuto < 59) {
            this.minuto = this.minuto +1;
        }
        else {
            this.minuto = 0;
            this.hora = this.hora + 1;
            setHora(this.hora);
        }
    }

    public  void decrementaMinuto(){
        if (this.minuto > 0 && this.minuto < 60) {
            this.minuto = this.minuto - 1;
        }
        else {
            this.minuto = 0;
            if(this.hora == 0){
                this.hora = 23;
            }else
            this.hora = this.hora - 1;
        }
    }

    public String horarioInternacional(){
        if( this.hora > 0 && this.hora < 12){
            return this.aM;
        }
        else
            return this.pM;
    }




}
